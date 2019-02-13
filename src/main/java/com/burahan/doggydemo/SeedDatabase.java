package com.burahan.doggydemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class SeedDatabase
{
    @Bean
    public CommandLineRunner initDB(DoggoRepository dogRepo)
    {
        return args ->
        {
            log.info("Seeding " + dogRepo.save(new Doggo("Labrador", 70, true)));
            log.info("Seeding " + dogRepo.save(new Doggo("German Shepherd", 80, true)));
            log.info("Seeding " + dogRepo.save(new Doggo("Husky", 60, true)));
            log.info("Seeding " + dogRepo.save(new Doggo("Tibetan Mastiff", 120, false)));
            log.info("Seeding " + dogRepo.save(new Doggo("Springer", 50, false)));
            log.info("Seeding " + dogRepo.save(new Doggo("Bulldog", 50, true)));
            log.info("Seeding " + dogRepo.save(new Doggo("Collie", 50, false)));
            log.info("Seeding " + dogRepo.save(new Doggo("Boston Terrier", 35, true)));
            log.info("Seeding " + dogRepo.save(new Doggo("Corgie", 35, true)));
        };
    }
}
