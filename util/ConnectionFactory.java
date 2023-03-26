// Classe responsável por criar uma conexão com o banco de daods.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ConnectionFactory {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/TodoApp";
    public static final String USER = "root";
    public static final String PASS = "";

    public static Connection getConnection(){ //abrir conexão com o banco de dados.
        try {
            Class.forName(DRIVER); //carregar o driver mysql.
            return DriverManager.getConnection(URL, USER, PASS); //fazer a conexão com os parâmetros URL, USER, PASS.
        } catch (Exception ex){
            throw new RuntimeException("Erro na conexão com o banco de dados", ex); //executado logo após o acontecimento do erro.
        }
    }

    public static void closeConnection (Connection connection){ //fechar a conexão com o banco de dados.
        try {
            if(connection != null){
                connection.close();
            }
        } catch(Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados", ex);
        }
    }

    public static void closeConnection (Connection connection, PreparedStatement statement){
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados");
        }
    }

    public static void closeConnection (Connection connection, PreparedStatement statement, ResultSet resultSet){
        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados");
        }
    }

}
