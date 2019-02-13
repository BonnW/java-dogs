package com.burahan.doggydemo;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.core.DummyInvocationUtils.methodOn;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
public class DoggoController
{
    private final DoggoRepository dogRepo;
    private final DoggoResourceAssembler assembler;

    public DoggoController(DoggoRepository dogRepo, DoggoResourceAssembler assembler)
    {
        this.dogRepo = dogRepo;
        this.assembler = assembler;
    }

    @GetMapping("/dogs")
    public Resources<Resource<Doggo>> all()
    {
        List<Resource<Doggo>> dogs = dogRepo.findAll().stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());

        return new Resources<>(dogs, linkTo(methodOn(DoggoController.class).all()).withSelfRel());
    }

    @GetMapping("/dogs/{id}")
    public Resource<Doggo> findOne(@PathVariable Long id)
    {
        Doggo foundDog = dogRepo.findById(id)
                .orElseThrow(() -> new DoggoNotFoundException(id));

        return assembler.toResource(foundDog);
    }

    @GetMapping("/dogs/breeds")
    public Resources<Resource<Doggo>> findAllByBreed(@PathVariable String breed)
    {
        List<Resource<Doggo>> dogs = dogRepo.findAll().stream()
                .filter(d -> d.getBreedName().toLowerCase().equals(breed))
                .map(assembler::toResource)
                .collect(Collectors.toList());
        return new Resources<>(dogs, linkTo(methodOn(DoggoController.class).findAllByBreed(breed)).withSelfRel());

    }

    @GetMapping("/dogs/breeds/{breed}")
    public Resource<Doggo> findByBreed(@PathVariable String breed)
    {
        List<Doggo> dogs = dogRepo.findAll();
        Doggo foundDoggo = new Doggo();
//        System.out.println(breed);
        for (Doggo dog : dogs)
        {
//            System.out.println(dog.getBreedName());
            if (dog.getBreedName().equals(breed))
            {
                foundDoggo = dog;
                System.out.println(dog);
            }
        }
        return assembler.toResource(foundDoggo);

    }
}
