import java.util.ArrayList;
import java.util.HashMap;

public class RecipeManager {
    private ArrayList<RecipeType> recipes;

    public RecipeManager(){
        this.recipes = new ArrayList<>();
    }

    public void addRecipe(RecipeType recipe) {
        this.recipes.add(recipe);
    }

    public void removeRecipe(RecipeType recipe) {
        this.recipes.remove(recipe);
    }

    public void viewRecipes() {
        for(RecipeType r: this.recipes){
            System.out.println(r.getName());
        }
    }

    public ArrayList<RecipeType> getRecipes() {
        return this.recipes;
    }


    @TODO(description = "Skriva koden till metoden createIngredient() för att skapa en lista av ingredienser")
    public ArrayList<Ingredient> createIngredient(){
        return null;
    }

    @TODO(description = "Skriva koden till metoden createInstruction()")
    public HashMap<Integer,String> createInstruction(){
        return null;
    }


}
