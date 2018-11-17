package demo.springframework.population.repository;

import java.util.List;

import demo.springframework.population.model.City;

public interface CityRepository {
	 
	  City save(City city);
	 
	  List<City> getAllCities();
}
