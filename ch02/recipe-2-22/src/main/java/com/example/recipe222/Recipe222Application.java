package com.example.recipe222;

import com.example.recipe222.calculator.CalculatorConfiguration;
import com.example.recipe222.calculator.Complex;
import com.example.recipe222.calculator.ComplexCalculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Recipe222Application {

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(CalculatorConfiguration.class);

        ComplexCalculator complexCalculator = context.getBean(ComplexCalculator.class);

        complexCalculator.add(new Complex(1, 2), new Complex(2, 3));
        complexCalculator.sub(new Complex(5, 8), new Complex(2, 3));
    }

}
