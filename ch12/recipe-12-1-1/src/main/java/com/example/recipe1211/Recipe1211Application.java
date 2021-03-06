package com.example.recipe1211;

import com.example.recipe1211.nosql.MongoDBVehicleRepository;
import com.example.recipe1211.nosql.Vehicle;
import com.example.recipe1211.nosql.VehicleRepository;
import com.mongodb.MongoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Recipe1211Application {

    public static final String DB_NAME = "vehicledb";

    public static void main(String[] args) {
        // 기본 호스트 및 포트는 각각 localhost, 27017입니다.
        MongoClient mongo = new MongoClient();

        VehicleRepository repository = new MongoDBVehicleRepository(mongo, DB_NAME, "vehicles");

        System.out.println("Number of Vehicles: " + repository.count());

        repository.save(new Vehicle("TEM0001", "RED", 4, 4));
        repository.save(new Vehicle("TEM0002", "RED", 4, 4));

        System.out.println("Number of Vehicles: " + repository.count());

        Vehicle v = repository.findByVehicleNo("TEM0001");

        System.out.println(v);

        List<Vehicle> vehicleList = repository.findAll();

        System.out.println("Number of Vehicles: " + vehicleList.size());
        vehicleList.forEach(System.out::println);
        System.out.println("Number of Vehicles: " + repository.count());

        // DB를 삭제하고 인스턴스를 닫습니다.
        mongo.dropDatabase(DB_NAME);
        mongo.close();
    }

}
