import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        RecipeManager rp = new RecipeManager();

        ArrayList<Ingredient> ingredients = rp.createIngredient();

        for (Ingredient i : ingredients) {
            System.out.println(i);
        }
        HashMap<Integer, String> instructions = rp.createInstruction();

        for (Integer i : instructions.keySet()) {
            System.out.println(i + instructions.get(i));

        }

    }
}
