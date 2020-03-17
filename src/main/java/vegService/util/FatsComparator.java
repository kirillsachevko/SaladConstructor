package vegService.util;

import domain.veg.Vegetable;

import java.util.Comparator;

public class FatsComparator implements Comparator<Vegetable> {
    @Override
    public int compare(Vegetable veg1, Vegetable veg2) {
        return Double.compare(veg1.getFats(), veg2.getFats());
    }
}
