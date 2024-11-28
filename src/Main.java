import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        RecipeManager rp = new RecipeManager();

        ArrayList<Ingredient> ingredients = rp.createIngredient();

        for (Ingredient i : ingredients) {
            System.out.println(i);
        }
    }
}
