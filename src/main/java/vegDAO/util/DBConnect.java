package vegDAO.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vegDAO.DAOException;

import java.sql.*;

public class DBConnect {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/vegetables_db?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "Terrime83";
    private  static final Logger log = LogManager.getLogger(DBConnect.class);

    public static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static Connection getConnection() throws DAOException {
        Connection connect;
        try {
            connect = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("OK");
            log.error("No connection with DB", ex);
            throw new DAOException("No connection with DB");
        }
        return connection = connect;
    }

    public static void closeConnection() throws DAOException {
        try {
            connection.close();
        } catch (SQLException ex) {
            log.error("Error with closing connection to DB", ex);
            throw new DAOException("Error with closing connection to DB");
        }
    }

    public static Statement getStatement() throws DAOException {
        connection = getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            log.error("Error with creating statement", ex);
            throw new DAOException("Error with creating statement");
        }
        return statement;
    }

    public static void closeStatement() throws DAOException {
        try {
            statement.close();
        } catch (SQLException ex) {
            log.error("Error with closing statement", ex);
            throw new DAOException("Error with closing statement");
        }
    }

    public static ResultSet getResultSet(String sqlQuery) throws DAOException {
        statement = getStatement();
        try {
            resultSet = statement.executeQuery(sqlQuery);
        } catch (SQLException ex) {
            log.error("Error with getting ResultSet", ex);
            throw new DAOException("Error with getting ResultSet");
        }

        return resultSet;
    }

    public static void closeResultSet() throws DAOException {
        try {
            resultSet.close();
        } catch (SQLException e) {
            log.error("Error with closing ResultSet");
            throw new DAOException("Error with closing ResultSet");
        }
    }


}
