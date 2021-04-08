package edu.spring.orm;

import edu.spring.orm.dao.Dao;
import edu.spring.orm.dao.Logic;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        final var context = new AnnotationConfigApplicationContext("edu.spring.orm");

        final var logic = context.getBean(Logic.class);

        logic.printAircrafts();


    }
}
