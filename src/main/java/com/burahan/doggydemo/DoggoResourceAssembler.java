package com.burahan.doggydemo;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class DoggoResourceAssembler implements ResourceAssembler<Doggo, Resource<Doggo>>
{
    @Override
    public Resource<Doggo> toResource(Doggo doggo)
    {
        return new Resource<Doggo>(doggo,
                linkTo(methodOn(DoggoController.class).findOne(doggo.getId())).withSelfRel(),
                linkTo(methodOn(DoggoController.class).all()).withRel("doggos"),
                linkTo(methodOn(DoggoController.class).findByBreed(doggo.getBreedName())).withRel("doggos"),
                linkTo(methodOn(DoggoController.class).findAllByBreed(doggo.getBreedName())).withSelfRel()
        );
    }
}
