package vegService;

import domain.salad.Salad;
import domain.veg.Vegetable;

import java.util.List;

public interface SaladService {

    Salad makeSalad();

    double countCaloriesInSalad(Salad salad);

    List<Vegetable> getListOfVegsWithCertainCalories(Salad salad, int minCalories, int maxCalories);

    List<Vegetable> sortVegsInSaladByParameters(Salad salad, String parameter) throws ServiceException;
}
