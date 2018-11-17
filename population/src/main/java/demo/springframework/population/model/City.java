package demo.springframework.population.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class City {
	private Long id;
	private String name;
	private Integer population;

	public City(Long id, String name, Integer population) {
		this.id = id;
		this.name = name;
		this.population = population;
	}

	public City copyWithId(Long id) {
		return new City(id, name, population);
	}
}
