package com.permata.migrate.conn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@Component
public class UpdateFavorite {

    @Autowired
    AppProperties appProperties;

    ConnectionConfiguration connectionConfiguration = new ConnectionConfiguration();

    public void update(String idFav, String whenIdfavImg, String whenIsMigrate) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connectionConfiguration.getConnection(appProperties.getUrl(), appProperties.getUsername(), appProperties.getPassword());

            preparedStatement = connection.prepareStatement("UPDATE PERMATA_FAVORITE_SIMULATE SET ID_FAV_IMAGE = CASE ID_FAV "+whenIdfavImg+" END, \n" +
                    "STATUS = CASE ID_FAV "+whenIsMigrate+" END WHERE ID_FAV IN ("+idFav+")");
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
