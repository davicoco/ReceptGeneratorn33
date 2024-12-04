import java.util.ArrayList;
import java.util.HashMap;

public interface RecipeType {
    String getName();
    MealCategory getMealCategory();
    ArrayList<Ingredient> getIngredients();
    HashMap<Integer,String> getInstructions();
    boolean isVegetarian();

}
