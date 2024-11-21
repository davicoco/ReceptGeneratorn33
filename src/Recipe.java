import java.util.ArrayList;
import java.util.HashMap;

public class Recipe {
    private String name;
    private ArrayList<Ingredient> ingredients;
    private HashMap<Integer,String> instructions;
    private MealCategory mealCategory;

    public Recipe(String name, ArrayList<Ingredient> ingredients, HashMap<Integer, String> instructions, MealCategory mealCategory) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.mealCategory = mealCategory;
    }
}
