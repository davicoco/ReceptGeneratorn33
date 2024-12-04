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
        return this.mealCategory;
    }

    @Override
    public ArrayList<Ingredient> getIngredients() {
        return this.ingredients;
    }

    @Override
    public HashMap<Integer, String> getInstructions() {
        return this.instructions;
    }

    @Override
    public boolean isVegetarian() {
        return true;
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

    @Override
    public String toString() {
        return "VegetarianRecipe{" +
                "name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", instructions=" + instructions +
                ", mealCategory=" + mealCategory +
                '}';
    }

}
