package domain.salad;

import domain.veg.Vegetable;

import java.util.List;
import java.util.Objects;

public class Salad {

    private List<Vegetable> saladIngredients;

    public List<Vegetable> getSaladIngredients() {
        return saladIngredients;
    }

    public void setSaladIngredients(List<Vegetable> saladIngredients) {
        this.saladIngredients = saladIngredients;
    }

    public Salad(List<Vegetable> saladIngredients) {
        this.saladIngredients = saladIngredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salad)) return false;

        Salad salad = (Salad) o;

        return Objects.equals(saladIngredients, salad.saladIngredients);
    }

    @Override
    public int hashCode() {
        return saladIngredients != null ? saladIngredients.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Salad{" +
                "saladIngredients=" + saladIngredients +
                '}';
    }
}
