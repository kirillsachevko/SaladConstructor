package vegService.impl;

import domain.salad.Salad;
import domain.veg.Vegetable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vegDAO.DAOException;
import vegDAO.DAOProvider;
import vegDAO.VegetablesDAO;
import vegDAO.impl.VegetablesDAOImpl;
import vegService.ServiceException;
import vegService.VegService;

import java.util.List;

public class VegServiceImpl implements VegService {

    private static final Logger log = LogManager.getLogger(VegetablesDAOImpl.class);

    DAOProvider provider = DAOProvider.getInstance();
    VegetablesDAO vegetablesDAO = provider.getVegsDao();


    @Override
    public void addVegetableToSalad(String vegName, Salad salad) throws ServiceException {
        try {
            if (vegetablesDAO.isVegAvailable(vegName)) {
                salad.getSaladIngredients().add(vegetablesDAO.getVegPrepared(vegName));
            } else {
                //Stub
                //Requires implementation changes when designing a layer "Controller"

                throw new ServiceException("Vegetable is not available");
            }
        } catch (DAOException ex) {
            log.error("Error with adding ingredients to salad", ex);
            throw new ServiceException("Error with adding ingredients to salad");
        }
    }

    @Override
    public List<Vegetable> sortVegetablesByParameter(String parameter) throws ServiceException {
        List<Vegetable> sortedVegetables;
        try {
            sortedVegetables = provider.getVegsDao().sortedVegsByParameter(parameter);
        } catch (DAOException ex) {
            log.error("Error with sorting vegetables", ex);
            throw new ServiceException("Error with sorting vegetables");
        }

        return sortedVegetables;
    }
}
