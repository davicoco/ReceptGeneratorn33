import java.util.ArrayList;
import java.util.HashMap;

public class VegetarianRecipe implements RecipeType{
    private String name;
    private ArrayList<Ingredient> ingredients;
    private HashMap<Integer,String> instructions;
    private MealCategory mealCategory;

    public VegetarianRecipe(String name, ArrayList<Ingredient> ingredients, HashMap<Integer, String> instructions, MealCategory mealCategory) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.mealCategory = mealCategory;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public MealCategory getMealCategory() {
        return null;
    }

    @Override
    public ArrayList<Ingredient> getIngredients() {
        return null;
    }

    @Override
    public HashMap<String, Integer> getInstructions() {
        return null;
    }

    @Override
    public boolean isVegetarian() {
        return true;
    }
}
