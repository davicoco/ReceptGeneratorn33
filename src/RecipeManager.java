import java.util.ArrayList;

public class RecipeManager {
    private ArrayList<Recipe> recipes;

    public RecipeManager(){
        this.recipes = new ArrayList<>();
    }

    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }

    public void removeRecipe(Recipe recipe) {
        this.recipes.remove(recipe);
    }

    public void viewRecipes() {
        for(Recipe r: this.recipes){
            System.out.println(r.getName());
        }
    }

    public ArrayList<Recipe> getRecipes() {
        return this.recipes;
    }



}
