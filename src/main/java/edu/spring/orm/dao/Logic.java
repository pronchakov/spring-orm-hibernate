package edu.spring.orm.dao;

import edu.spring.orm.entity.Aircraft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class Logic {

    private static final Logger log = LoggerFactory.getLogger(Logic.class);

    @Autowired
    private Dao dao;

    public void setDao(Dao dao) {
        this.dao = dao;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void printAircrafts() {
        final var aircrafts = dao.listAircraft();
        log.info("");
        log.info("");
        log.info("");
        log.info("");
        for (Aircraft aircraft : aircrafts) {
            log.info("Aircraft: {}", aircraft);
        }
    }
}
