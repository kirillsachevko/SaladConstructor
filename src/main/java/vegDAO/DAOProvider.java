package vegDAO;

import vegDAO.impl.VegetablesDAOImpl;

public class DAOProvider {
    private static final DAOProvider instance = new DAOProvider();

    public static DAOProvider getInstance() {
        return instance;
    }

    private DAOProvider() {

    }

    private VegetablesDAO vegetablesDao = new VegetablesDAOImpl();

    public VegetablesDAO getVegsDao() {
        return vegetablesDao;
    }

}
