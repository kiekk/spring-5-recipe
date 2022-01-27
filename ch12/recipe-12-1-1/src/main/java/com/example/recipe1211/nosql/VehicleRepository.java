package com.example.recipe1211.nosql;


import java.util.List;

public interface VehicleRepository {

    long count();

    void save(Vehicle vehicle);

    void delete(Vehicle vehicle);

    List<Vehicle> findAll();

    Vehicle findByVehicleNo(String vehicleNo);

}
