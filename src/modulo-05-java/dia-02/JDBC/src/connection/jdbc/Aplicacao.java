package connection.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class Aplicacao {

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        try{
            Connection conn = factory.getConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
