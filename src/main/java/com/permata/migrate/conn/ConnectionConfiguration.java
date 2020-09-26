package com.permata.migrate.conn;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionConfiguration {

    @Autowired
    AppProperties appProperties;

    public Connection getConnection(String url, String username, String password) {

        Connection connection = null;
        try {
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            connection = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
