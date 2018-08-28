package com.example.sql

import com.example.sql.repository.CashBackAirlineRepository
import groovy.util.logging.Slf4j
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner)
@SpringBootTest
@Slf4j
class SqlApplicationTestDao {

    @Autowired
    CashBackAirlineRepository cashBackAirlineRepository

    @Test
    void contextLoads() {
    }

    @Test
    void checkRepo() {
       log.warn( "***************** EG: " + cashBackAirlineRepository.findCashBackAirlineByActiveTrueAndCompanyId(2).size())

    }
}
