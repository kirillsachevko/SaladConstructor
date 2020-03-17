package vegDAO.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vegDAO.DAOException;
import vegDAO.VegetablesDAO;
import vegDAO.util.DBConnect;
import domain.veg.ConservedVegetable;
import domain.veg.FreshVegetable;
import domain.veg.Vegetable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VegetablesDAOImpl implements VegetablesDAO {

    private static final String SQL_QUERY = "SELECT * FROM vegetables_db.vegetables";
    private static final Logger log = LogManager.getLogger(VegetablesDAOImpl.class);

    @Override
    public boolean isVegAvailable(String vegName) throws DAOException {
        boolean result = false;
        ResultSet resultSet;
        try {
            resultSet = DBConnect.getResultSet(SQL_QUERY);
            while (resultSet.next()) {
                if (resultSet.getString(1).equals(vegName)) {
                    result = true;
                }
            }

        } catch (SQLException ex) {
            log.error("Error with ResultSet iteration", ex);
            throw new DAOException("Error with ResultSet iteration");
        }

        DBConnect.closeConnection();

        return result;
    }

    @Override
    public Vegetable getVegPrepared(String vegName) throws DAOException {
        String name;
        double calories;
        double proteins;
        double fats;
        double carbohydrates;
        int type;
        Vegetable veg;
        ResultSet resultSet = DBConnect.getResultSet(SQL_QUERY + " WHERE VegNAme=" + "'" + vegName + "'");

        try {
            resultSet.next();
            name = resultSet.getString(1);
            calories = resultSet.getDouble(2);
            proteins = resultSet.getDouble(3);
            fats = resultSet.getDouble(4);
            carbohydrates = resultSet.getDouble(5);
            type = resultSet.getInt(6);
        } catch (SQLException ex) {
            log.error("Error with getting data from DB", ex);
            throw new DAOException("Error with getting data from DB");
        }

        if (type == 1) {
            veg = new FreshVegetable(name, calories, proteins, fats, carbohydrates);
        } else {
            veg = new ConservedVegetable(name, calories, proteins, fats, carbohydrates);
        }

        DBConnect.closeConnection();

        return veg;
    }

    @Override
    public List<Vegetable> getListOfVegs() throws DAOException {
        List<Vegetable> listOfVegs = new ArrayList<>();
        List<String> listOfVegName = new ArrayList<>();

        ResultSet resultSet = DBConnect.getResultSet(SQL_QUERY);

        try {
            while (resultSet.next()) {
                listOfVegName.add(resultSet.getString(1));
            }
        } catch (SQLException ex) {
            log.error("Error with getting data from DB", ex);
            throw new DAOException("Error with getting data from DB");
        }

        for (String vegName : listOfVegName
        ) {
            listOfVegs.add(getVegPrepared(vegName));
        }

        DBConnect.closeConnection();

        return listOfVegs;
    }

    @Override
    public List<Vegetable> sortedVegsByParameter(String parameter) throws DAOException {
        List<Vegetable> sortedListOfVegsByParams = new ArrayList<>();
        ResultSet resultSet = DBConnect.getResultSet(SQL_QUERY + " ORDER BY " + parameter);

        try {
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                sortedListOfVegsByParams.add(getVegPrepared(name));
            }
        } catch (SQLException ex) {
            log.error("Error with getting data from DB", ex);
            throw new DAOException("Error with getting data from DB");
        }

        DBConnect.closeConnection();

        return sortedListOfVegsByParams;
    }
}
