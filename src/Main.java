import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RecipeManager rp = new RecipeManager();

        Scanner input = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("1. Lägg till recept");
            System.out.println("2. Visa vegetariska recept");
            System.out.println("3. Visa vanliga recept");
            System.out.println("4. Ta bort recept");
            System.out.println("0. Avsluta program");

            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1 -> {
                    RecipeType newRecipe = rp.createRecipe();
                    rp.addRecipe(newRecipe);
                }
                case 2 -> rp.viewVegetarianRecipes(false);

                case 3 -> rp.viewRegularRecipes(false);

                case 4 -> rp.chooseRecipeToRemove();

                case 0 -> running = false;

                default -> System.out.println("Var snäll och välj ett av alternativen!");

            }
        }
    }
}
