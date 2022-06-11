package com.udacity.vehicles.api;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.udacity.vehicles.domain.car.Car;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

/**
 * Maps the CarController to the Car class using HATEOAS
 */
@Component
public class CarResourceAssembler implements ResourceAssembler<Car, Resource<Car>> {

  @Override
  public Resource<Car> toResource(Car car) {
    return new Resource<>(car,
        linkTo(methodOn(CarController.class).get(car.getId())).withSelfRel(),
        linkTo(methodOn(CarController.class).list()).withRel("cars"));

  }
}
