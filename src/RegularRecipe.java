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
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstructions(HashMap<Integer, String> instructions) {
        this.instructions = instructions;
    }

    public void setMealCategory(MealCategory mealCategory) {
        this.mealCategory = mealCategory;
    }


}
