package com.burahan.doggydemo;

public class DoggoNotFoundException extends RuntimeException
{
    public DoggoNotFoundException(Long id)
    {
        super("Could not find Dog " + id + " :(");
    }
}
