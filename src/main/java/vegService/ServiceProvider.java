package vegService;

import vegService.impl.SaladServiceImpl;
import vegService.impl.VegServiceImpl;

public class ServiceProvider {
    private static final ServiceProvider instance = new ServiceProvider();

    private final VegService vegService = new VegServiceImpl();
    private final SaladService saladService = new SaladServiceImpl();

    public static ServiceProvider getInstance() {
        return instance;
    }

    private ServiceProvider() {
    }

    public VegService getVegsService() {
        return vegService;
    }

    public SaladService getSaladService() {
        return saladService;
    }
}
