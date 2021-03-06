package com.example.recipe1234;

import com.example.recipe1234.nosql.Character;
import com.example.recipe1234.nosql.Neo4jStarwarsRepository;
import com.example.recipe1234.nosql.Planet;
import com.example.recipe1234.nosql.StarwarsRepository;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Recipe1234Application {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new SessionFactory("com.example.recipe1234.nosql");

        StarwarsRepository repository = new Neo4jStarwarsRepository(sessionFactory);

        // Planets
        Planet dagobah = new Planet();
        dagobah.setName("Dagobah");

        Planet alderaan = new Planet();
        alderaan.setName("Alderaan");

        Planet tatooine = new Planet();
        tatooine.setName("Tatooine");

        dagobah = repository.save(dagobah);
        repository.save(alderaan);
        repository.save(tatooine);

        // Characters
        Character han = new Character();
        han.setName("Han Solo");

        Character leia = new Character();
        leia.setName("Leia Organa");
        leia.setLocation(alderaan);
        leia.addFriend(han);

        Character luke = new Character();
        luke.setName("Luke Skywalker");
        luke.setLocation(tatooine);
        luke.addFriend(han);
        luke.addFriend(leia);

        Character yoda = new Character();
        yoda.setName("Yoda");
        yoda.setLocation(dagobah);
        yoda.setApprentice(luke);

        repository.save(han);
        repository.save(luke);
        repository.save(leia);
        repository.save(yoda);

        repository.printAll();

        sessionFactory.close();
    }

}
