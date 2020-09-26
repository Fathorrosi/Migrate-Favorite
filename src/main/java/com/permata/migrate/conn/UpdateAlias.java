package com.permata.migrate.conn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@Component
public class UpdateAlias {

    @Autowired
    AppProperties appProperties;

    ConnectionConfiguration connectionConfiguration = new ConnectionConfiguration();

    public void update(String custRefId, String categoryAlias, String AccountNumber) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionConfiguration.getConnection(appProperties.getUrl(), appProperties.getUsername(), appProperties.getPassword());

            preparedStatement = connection.prepareStatement("UPDATE PERMATA_ALIAS_ACCOUNT SET  \n" +
                    "STATUS = 'Y'\n" +
                    "WHERE GCN IN ("+custRefId+") and \n" +
                    " CATEGORY_ALIAS in ("+categoryAlias+") and \n" +
                    " ACCOUNT_NUMBER in ("+AccountNumber+")");
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
