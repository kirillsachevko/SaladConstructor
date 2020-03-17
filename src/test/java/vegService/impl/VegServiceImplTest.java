package vegService.impl;

import domain.salad.Salad;
import domain.veg.Vegetable;
import org.testng.Assert;
import org.testng.annotations.Test;
import vegService.SaladService;
import vegService.ServiceException;
import vegService.ServiceProvider;
import vegService.VegService;

import java.util.List;


public class VegServiceImplTest {

    ServiceProvider provider = ServiceProvider.getInstance();
    VegService vegService = provider.getVegsService();
    SaladService saladService = provider.getSaladService();


    @Test
    public void testAddVegetableToSalad() throws ServiceException {

        Salad salad = saladService.makeSalad();
        vegService.addVegetableToSalad("Olives", salad);
        String result = salad.getSaladIngredients().get(0).getName();

        Assert.assertEquals(result, "Olives");

    }

    @Test
    public void testSortVegetablesByParameter() throws ServiceException {

        List<Vegetable> listOfSortedVeg = vegService.sortVegetablesByParameter("Proteins");
        String result = listOfSortedVeg.get(10).getName();

        Assert.assertEquals(result, "Letucce");
    }
}