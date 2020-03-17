package vegService.impl;

import domain.salad.Salad;
import org.testng.Assert;
import org.testng.annotations.Test;
import vegService.SaladService;
import vegService.ServiceProvider;

public class SaladTest {

    ServiceProvider provider = ServiceProvider.getInstance();
    SaladService saladService = provider.getSaladService();

    @Test
    public void testMakeSalad() {

        Salad salad = saladService.makeSalad();
        boolean result = false;
        if (salad!=null){
            result = true;
        }

        Assert.assertTrue(result);
    }
}
