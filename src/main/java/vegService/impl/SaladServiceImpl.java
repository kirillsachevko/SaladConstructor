package vegService.impl;

import domain.salad.Salad;
import domain.veg.Vegetable;
import vegService.SaladService;
import vegService.ServiceException;
import vegService.util.SortedVegetables;

import java.util.ArrayList;
import java.util.List;

public class SaladServiceImpl implements SaladService {

    Salad salad;

    @Override
    public Salad makeSalad() {
        salad = new Salad(new ArrayList<>());
        return salad;
    }

    @Override
    public double countCaloriesInSalad(Salad salad) {
        double sumOfCalories = 0;
        for (Vegetable veg : salad.getSaladIngredients()
        ) {
            sumOfCalories += veg.getCalories();
        }
        return sumOfCalories;
    }

    @Override
    public List<Vegetable> getListOfVegsWithCertainCalories(Salad salad, int minCalories, int maxCalories) {
        List<Vegetable> listOfVegsWithCertainCalories = new ArrayList<>();

        for (Vegetable veg : salad.getSaladIngredients()
        ) {
            if (veg.getCalories() >= minCalories && veg.getCalories() <= maxCalories) {
                listOfVegsWithCertainCalories.add(veg);
            }
        }

        return listOfVegsWithCertainCalories;
    }

    @Override
    public List<Vegetable> sortVegsInSaladByParameters(Salad salad, String parameter) throws ServiceException {

        return SortedVegetables.sortedVegByComparator(salad.getSaladIngredients(), parameter);
    }
}
