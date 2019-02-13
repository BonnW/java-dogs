package com.burahan.doggydemo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoggoRepository extends JpaRepository<Doggo, Long>
{

}
