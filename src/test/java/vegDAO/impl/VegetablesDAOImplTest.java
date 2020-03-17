package vegDAO.impl;

import domain.veg.Vegetable;
import org.testng.Assert;
import org.testng.annotations.Test;
import vegDAO.DAOException;
import vegDAO.DAOProvider;
import vegDAO.VegetablesDAO;

import java.util.List;


public class VegetablesDAOImplTest {

    DAOProvider provider = DAOProvider.getInstance();
    VegetablesDAO vegetablesDAO = provider.getVegsDao();


    @Test
    public void testIsVegAvailable() throws DAOException {

        vegetablesDAO.isVegAvailable("Eggplant");

        Assert.assertTrue(true);
    }

    @Test
    public void testGetVegPrepared() throws DAOException {

        Vegetable veg = vegetablesDAO.getVegPrepared("Tomato");
        double result = veg.getCalories();

        Assert.assertEquals(result, 18.0);

    }

    @Test
    public void testGetListOfVegs() throws DAOException {

        List<Vegetable> listOfVegs = vegetablesDAO.getListOfVegs();
        String result = listOfVegs.get(0).getName() + ", " + listOfVegs.get(2).getName();

        Assert.assertEquals(result, "Artichoke, Broccoli");

    }

    @Test
    public void testSortedVegsByParameter() throws DAOException {

        List<Vegetable> listOfVeg = vegetablesDAO.sortedVegsByParameter("Calories");
        String result = listOfVeg.get(5).getName();

        Assert.assertEquals(result, "Eggplant");
    }
}