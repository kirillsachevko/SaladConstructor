package vegService.util;

import domain.veg.Vegetable;
import vegService.ServiceException;

import java.util.List;

public class SortedVegetables {
    public static List<Vegetable> sortedVegByComparator(List<Vegetable> vegList, String parameter) throws ServiceException {
        switch (parameter) {
            case "name":
                NameComparator nameComparator = new NameComparator();
                vegList.sort(nameComparator);
                break;
            case "calories":
                CaloriesComparator caloriesComparator = new CaloriesComparator();
                vegList.sort(caloriesComparator);
                break;
            case "proteins":
                ProteinsComparator proteinsComparator = new ProteinsComparator();
                vegList.sort(proteinsComparator);
                break;
            case "fats":
                FatsComparator fatsComparator = new FatsComparator();
                vegList.sort(fatsComparator);
                break;
            case "carbohydrates":
                CarbohydratesComparator carbohydratesComparator = new CarbohydratesComparator();
                vegList.sort(carbohydratesComparator);
                break;
            default:
                throw new ServiceException("Wrong parameter!");

        }

        return vegList;
    }
}
