package vegService.util;

import domain.veg.Vegetable;

import java.util.Comparator;

public class NameComparator implements Comparator<Vegetable> {
    @Override
    public int compare(Vegetable veg1, Vegetable veg2) {
        return veg1.getName().compareTo(veg2.getName());
    }
}
