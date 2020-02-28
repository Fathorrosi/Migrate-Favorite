package com.permata.migrate;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Db2toMySqlApplication {

    public static void main(String[] args) {
        System.out.println("============================== Favorite and Alias Account Migration Tool =================================");
        SpringApplication.run(Db2toMySqlApplication.class, args);
    }

}
