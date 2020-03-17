package vegService.impl;

import domain.salad.Salad;
import domain.veg.Vegetable;
import org.testng.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import vegService.SaladService;
import vegService.ServiceException;
import vegService.ServiceProvider;
import vegService.VegService;

import java.util.List;


public class SaladServiceImplTest {

    ServiceProvider provider = ServiceProvider.getInstance();
    SaladService saladService = provider.getSaladService();
    VegService vegService = provider.getVegsService();
    List<String> vegetableList = List.of("Tomato", "Corn", "Green onion", "Cucumber", "Tomato");
    Salad salad;

    @BeforeTest
    void setUp() throws ServiceException {
        salad = saladService.makeSalad();

        for (String vegName : vegetableList
        ) {
            vegService.addVegetableToSalad(vegName, salad);
        }
    }


    @Test
    public void testCountCaloriesInSalad() {

        double result = saladService.countCaloriesInSalad(salad);

        Assert.assertEquals(result, 131.0);

    }

    @Test
    public void testGetListOfVegsWithCertainCalories() {

        List<Vegetable> vegetablesInSaladWithCertainCalories
                = saladService.getListOfVegsWithCertainCalories(salad, 15, 20);

        StringBuilder result = new StringBuilder();

        for (Vegetable veg : vegetablesInSaladWithCertainCalories
        ) {
            result.append(veg.getName()).append(", ");
        }

        Assert.assertEquals(result.toString(), "Tomato, Green onion, Tomato, ");
    }

    @Test
    public void testSortVegsInSaladByParameters() throws ServiceException {

        List<Vegetable> sortedListOfVegsInSalad = saladService.sortVegsInSaladByParameters(salad, "fats");

        StringBuilder result = new StringBuilder();

        for (Vegetable veg : sortedListOfVegsInSalad
        ) {
            result.append(veg.getName()).append(", ");
        }

        Assert.assertEquals(result.toString(), "Green onion, Cucumber, Tomato, Tomato, Corn, ");
    }
}