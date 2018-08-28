/*
 * Copyright (c) 2017 by Indian Eagle LLC.
 * All rights reserved. These materials are confidential and proprietary to Indian Eagle LLC. No part of this code may be reproduced, published
 * in any form by any means (electronic or mechanical, including photocopy or any information storage or retrieval system), nor may the materials
 * be disclosed to third parties, or used in derivative works without the express written authorization of Indian Eagle LLC.
 */

package com.example.sql

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.JpaVendorAdapter
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

@SpringBootApplication
@EnableJpaRepositories(entityManagerFactoryRef = 'flightsEntityManagerFactory',
        transactionManagerRef = 'flightsTransactionManager',
        basePackages = ['com.example.sql'])
class FlightsRepositoryConfig {

    private static final String ENV = 'dev'

    @Autowired
    Environment environment

    @Bean
    DataSource flightsDataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource()
        driverManagerDataSource.with {
            url = environment.getProperty("${ENV}.flights.datasource.url")
            username = environment.getProperty("${ENV}.flights.datasource.username")
            password = environment.getProperty("${ENV}.flights.datasource.password")
            driverClassName = environment.getProperty("${ENV}.flights.datasource.driver-class-name")
        }
        driverManagerDataSource
    }

    @Bean
    EntityManager flightsEntityManager() {
        flightsEntityManagerFactory().createEntityManager()
    }

    @Bean
    EntityManagerFactory flightsEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean()
        emf.jpaPropertyMap['hibernate.dialect'] = 'org.hibernate.dialect.MySQL5Dialect'
        emf.jpaPropertyMap['hibernate.id.new_generator_mappings'] = 'false'
        emf.with {
            dataSource = flightsDataSource()
            jpaVendorAdapter = this.jpaVendorAdapter()
            packagesToScan = ['com.example.sql']
            persistenceUnitName = 'flights'
            afterPropertiesSet()
        }
        emf.object
    }

    @Bean
    PlatformTransactionManager flightsTransactionManager() {
        JpaTransactionManager tm = new JpaTransactionManager()
        tm.setEntityManagerFactory(flightsEntityManagerFactory())
        tm
    }

    @Bean
    JpaVendorAdapter jpaVendorAdapter() {
        new HibernateJpaVendorAdapter()
    }
    static void main(String[] args) {
        SpringApplication.run FlightsRepositoryConfig, args
    }
}