package vegService;

import domain.salad.Salad;
import domain.veg.Vegetable;

import java.util.List;

public interface VegService {

    void addVegetableToSalad(String vegName, Salad salad) throws ServiceException;

    List<Vegetable> sortVegetablesByParameter(String parameter) throws ServiceException;
}
