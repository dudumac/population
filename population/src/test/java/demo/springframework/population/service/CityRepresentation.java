package demo.springframework.population.service;

import org.assertj.core.presentation.StandardRepresentation;

import demo.springframework.population.model.City;

public class CityRepresentation extends StandardRepresentation {
 
  @Override
  protected String fallbackToStringOf(Object object) {
    if (object instanceof City) {
      final City city = (City) object;
      return "{id:" + city.getId() + ", name:" + city.getName() + ", population:" + city.getPopulation() + "}";
    }
    return super.fallbackToStringOf(object);
  }
}
