import java.util.ArrayList;
import java.util.HashMap;

public class RegularRecipe implements RecipeType {
    private String name;
    private ArrayList<Ingredient> ingredients;
    private HashMap<Integer,String> instructions;
    private MealCategory mealCategory;

    public RegularRecipe(String name, ArrayList<Ingredient> ingredients, HashMap<Integer, String> instructions, MealCategory mealCategory) {
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
        return this.mealCategory;
    }

    @Override
    public ArrayList<Ingredient> getIngredients() {
        return this.ingredients;
    }

    @Override
    public HashMap<Integer,String> getInstructions() {
        return this.instructions;
    }

    @Override
    public boolean isVegetarian() {
        return false;
    }

}
