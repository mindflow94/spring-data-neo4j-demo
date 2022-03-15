package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

/**
 * Created on 2022/3/9.
 *
 * @author MariaCarrie
 */
@SpringBootApplication(scanBasePackages = "com.example")
@EnableNeo4jRepositories
public class Neo4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(Neo4jApplication.class, args);
    }
}
