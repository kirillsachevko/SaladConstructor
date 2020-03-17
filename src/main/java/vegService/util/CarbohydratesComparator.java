package vegService.util;

import domain.veg.Vegetable;

import java.util.Comparator;

public class CarbohydratesComparator implements Comparator<Vegetable> {
    @Override
    public int compare(Vegetable veg1, Vegetable veg2) {
        return Double.compare(veg1.getCarbohydrates(), veg2.getCarbohydrates());
    }
}
