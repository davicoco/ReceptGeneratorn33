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
    
    public ArrayList<Ingredient> createIngredient() {
        Scanner input = new Scanner(System.in);
        ArrayList<Ingredient> ingredients = new ArrayList<>();

        while (true) {
            System.out.println("1. Lägg till ingrediens");
            System.out.println("0. Färdig! Gå till nästa steg");
            int choice = input.nextInt();
            input.nextLine();
            if (choice == 1) {
                try {

                    String ingredientName;
                    while (true) {
                        System.out.println("Vilken ingrediens vill du lägga till?");
                        ingredientName = input.nextLine();
                        if (ingredientName.matches("[a-zA-ZåäöÅÄÖ]+")) {
                            break;
                        } else {
                            System.out.println("Fel uppstod! Var snäll och skriv in endast bokstäver");
                        }
                    }

                    String ingredientMeasure;
                    while (true) {
                        System.out.println("Vad är måttet på ingrediensen? (st,dl,ml,gram,skivor etc...)");
                        ingredientMeasure = input.nextLine();
                        if (ingredientMeasure.matches("[a-zA-ZåäöÅÄÖ]+")) {
                            break;
                        } else {
                            System.out.println("Fel uppstod! Var snäll och skriv in endast bokstäver");
                        }
                    }

                    double ingredientAmount;
                    while (true) {
                        try {
                            System.out.println("Hur mycket av ingrediensen vill du lägga till?");
                            ingredientAmount = Double.parseDouble(input.nextLine());
                            if (ingredientAmount > 0) {
                                break;
                            } else {
                                System.out.println("Fel uppstod! Mängden måste vara större än 0");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Fel uppstod! Var snäll och skriv in endast siffror");
                        }
                    }

                    Ingredient ingredient = new Ingredient(ingredientName, ingredientMeasure, ingredientAmount);
                    ingredients.add(ingredient);
                    System.out.println("La till " + ingredientAmount +" "+ ingredientMeasure + " av " + ingredientName + " i ingredienslistan");
                } catch (Exception e) {
                    System.out.println("Fel uppstod!");
                    input.nextLine();
                }

            } else if (choice == 0) {
                return ingredients;
            }else {
                System.out.println("Fel uppstod! Välj mellan alternativen 1 och 0");
            }

        }

    }

    @TODO(description = "Skriva koden till metoden createInstruction()")
    public HashMap<Integer, String> createInstruction() {
        return null;
    }


}
