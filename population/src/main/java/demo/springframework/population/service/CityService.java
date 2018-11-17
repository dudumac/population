package demo.springframework.population.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import demo.springframework.population.model.City;
import demo.springframework.population.repository.CityRepository;

public class CityService {

	private CityRepository cityRepository;
	private PopulationService populationService;

	public CityService(CityRepository cityRepository, PopulationService populationService) {
		this.cityRepository = cityRepository;
		this.populationService = populationService;
	}

	public City enrichAndCreateCity(City city) {
		// Validation
		if (city.getId() != null) {
			throw new IllegalArgumentException("City (" + city.getName() + ") can't be created with a predefined ID");
		}
		// External service call
		final Optional<Integer> population = populationService.forCity(city.getName());
		// Enrichment
		final City enrichedCity = new City(city.getId(), city.getName(), population.orElse(null));
		// Storing in repository
		return cityRepository.save(enrichedCity);
	}

	public List<City> getAllValidCities() {
		// Retrieve from repository
		final List<City> storedCities = cityRepository.getAllCities();

		// Remove those with empty population, and sort them alphabetically
		return storedCities.stream().filter(city -> city.getPopulation() != null)
				.sorted(Comparator.comparing(City::getName)).collect(Collectors.toList());
	}

}
