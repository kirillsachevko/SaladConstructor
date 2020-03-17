package vegDAO;

import domain.veg.Vegetable;

import java.util.List;

public interface VegetablesDAO {

    boolean isVegAvailable(String vegName) throws DAOException;

    Vegetable getVegPrepared(String vegName) throws DAOException;

    List<Vegetable> getListOfVegs() throws DAOException;

    List<Vegetable> sortedVegsByParameter(String parameter) throws DAOException;


}
