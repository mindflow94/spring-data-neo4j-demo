package com.example.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;

/**
 * Created on 2022/3/15.
 *
 * 自定义配置属性
 *  必须配置@EnableNeo4jRepositories
 *
 * @author MariaCarrie
 */
//@Configuration
//@ComponentScan("com.example")
//@EnableNeo4jRepositories("com.example.repository")
public class Neo4jConfig {

    @Value("${neo4j.uri}")
    private String uri;

    @Value("${neo4j.username}")
    private String username;

    @Value("${neo4j.password}")
    private String password;

    @Value("${neo4j.connection.pool.size}")
    private Integer connectionPoolSize;

    @Bean
    public SessionFactory getSessionFactory() {
        return new SessionFactory(configuration(),"com.example.domain");
    }

    @Bean
    public Neo4jTransactionManager transactionManager(){
        return new Neo4jTransactionManager(getSessionFactory());
    }

    @Bean
    public org.neo4j.ogm.config.Configuration configuration() {
        return new org.neo4j.ogm.config.Configuration.Builder()
                .uri(uri)
                // 默认50
                .connectionPoolSize(connectionPoolSize)
                .credentials(username,password)
                // 默认为NONE
                .autoIndex("update")
                .build();
    }
}
