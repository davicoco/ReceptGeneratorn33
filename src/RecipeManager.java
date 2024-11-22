import java.util.ArrayList;

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



}
