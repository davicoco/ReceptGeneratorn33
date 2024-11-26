import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class RecipeManager {
    private ArrayList<RecipeType> recipes;

    public RecipeManager() {
        this.recipes = new ArrayList<>();
    }

    public void addRecipe(RecipeType recipe) {
        this.recipes.add(recipe);
    }

    public void removeRecipe(RecipeType recipe) {
        this.recipes.remove(recipe);
    }

    public void viewRecipes() {
        for (RecipeType r : this.recipes) {
            System.out.println(r.getName());
        }
    }

    public ArrayList<RecipeType> getRecipes() {
        return this.recipes;
    }


    @TODO(description = "Skriva koden till metoden createIngredient() för att skapa en lista av ingredienser")
    public ArrayList<Ingredient> createIngredient() {
        Scanner input = new Scanner(System.in);
        ArrayList<Ingredient> ingredients = new ArrayList<>();

        while (true) {
            System.out.println("1. Lägg till ingrediens");
            System.out.println("0. Färdig! Gå till nästa steg");
            int choice = input.nextInt();
            if(choice==1){
                System.out.println("Vilken ingrediens vill du lägga till?");

            }
            return null;
        }

    }

    @TODO(description = "Skriva koden till metoden createInstruction()")
    public HashMap<Integer, String> createInstruction() {
        return null;
    }


}
