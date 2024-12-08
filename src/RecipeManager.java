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

    public ArrayList<RecipeType> getRecipes() {
        return this.recipes;
    }

    public void chooseRecipeToRemove() {
        if (this.recipes.isEmpty()) {
            System.out.println("Fel uppstod! Det finns inga recept att ta bort");
            return;
        }
        System.out.println("Ange siffran på receptet du vill ta bort:");
        int index = 1;
        for (RecipeType r : this.recipes) {
            System.out.println(index + ". " + r.getName());
            index++;
        }

        Scanner input = new Scanner(System.in);

        int choice;
        try {
            choice = input.nextInt() - 1;
            input.nextLine();
        } catch (Exception e) {
            System.out.println("Fel uppstod! Var snäll och skriv in en siffra");
            input.nextLine();
            return;
        }

        if (choice < 0 || choice >= this.recipes.size()) {
            System.out.println("Fel uppstod! Var snäll och välj ett av alternativen som visas");
            return;
        }

        RecipeType recipeToRemove = this.recipes.get(choice);
        removeRecipe(recipeToRemove);
        System.out.println("Receptet " + recipeToRemove.getName() + " har tagits bort.");
    }

    public void viewRegularRecipes(boolean skipDetails) {
        ArrayList<RecipeType> regularRecipes = new ArrayList<>();

        int index = 1;
        for (RecipeType r : this.recipes) {
            if (!r.isVegetarian()) {
                regularRecipes.add(r);
                System.out.println(index + ". " + r.getName());
                index++;
            }
        }

        if (regularRecipes.isEmpty()) {
            System.out.println("Fel uppstod! Det finn inga vanliga recept!");
            return;
        }

        if (!skipDetails) {
            showAllRecipeDetails(regularRecipes);
        }
    }

    public void viewVegetarianRecipes(boolean skipDetails) {
        ArrayList<RecipeType> vegetarianRecipes = new ArrayList<>();

        int index = 1;
        for (RecipeType r : this.recipes) {
            if (r.isVegetarian()) {
                vegetarianRecipes.add(r);
                System.out.println(index + ". " + r.getName());
                index++;
            }
        }

        if (vegetarianRecipes.isEmpty()) {
            System.out.println("Fel uppstod! Det finns inga vegetariska recept!");
            return;
        }

        if (!skipDetails) {
            showAllRecipeDetails(vegetarianRecipes);
        }

    }

    public void showAllRecipeDetails(ArrayList<RecipeType> recipes) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ange siffran på det recept du vill kolla på!");
        int choice = input.nextInt() - 1;
        input.nextLine();

        if (choice < 0 || choice >= recipes.size()) {
            System.out.println("Fel uppstod! Var snäll och välj ett av recepten");
            return;
        }

        RecipeType recipeToWatch = recipes.get(choice);
        System.out.println("Receptnamn: " + recipeToWatch.getName());
        System.out.println("Vegetariskt: " + (recipeToWatch.isVegetarian() ? "Ja" : "Nej"));
        System.out.println("Kategori: " + recipeToWatch.getMealCategory());
        System.out.println("Ingredienser: ");
        for (Ingredient ingredient : recipeToWatch.getIngredients()) {
            System.out.println(ingredient.getAmount() + " " + ingredient.getMeasure() + " " + ingredient.getName());
        }

        System.out.println("Instruktioner: ");
        recipeToWatch.getInstructions().forEach((stepNumber, instruction) ->
                System.out.println(stepNumber + ". " + instruction));
    }

    public ArrayList<Ingredient> createIngredient() {
        Scanner input = new Scanner(System.in);
        ArrayList<Ingredient> ingredients = new ArrayList<>();

        while (true) {
            System.out.println("1. Lägg till ingrediens");
            System.out.println("0. Färdig! Gå till nästa steg");
            int choice;
            try {
                choice = input.nextInt();
                input.nextLine();
            } catch (Exception e) {
                System.out.println("Fel uppstod! Var snäll och välj ett av alternativen");
                input.nextLine();
                continue;
            }
            if (choice == 1) {
                String ingredientName;
                while (true) {
                    System.out.println("Vilken ingrediens vill du lägga till?");
                    ingredientName = input.nextLine();
                    if (ingredientName.matches("[a-zA-ZåäöÅÄÖ ]+")) {
                        break;
                    } else {
                        System.out.println("Fel uppstod! Var snäll och skriv in endast bokstäver");
                    }
                }

                String ingredientMeasure;
                while (true) {
                    System.out.println("Vad är måttet på ingrediensen? (st,dl,ml,gram,skivor etc...)");
                    ingredientMeasure = input.nextLine();
                    if (ingredientMeasure.matches("[a-zA-ZåäöÅÄÖ ]+")) {
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
                System.out.println("La till " + ingredientAmount + " " + ingredientMeasure + " av " + ingredientName + " i ingredienslistan");
            } else if (choice == 0) {
                return ingredients;
            } else {
                System.out.println("Fel uppstod! Välj mellan alternativen 1 och 0");
            }
        }
    }

    public HashMap<Integer, String> createInstruction() {
        HashMap<Integer, String> instructions = new HashMap<>();
        Scanner input = new Scanner(System.in);
        int instructionKey = 1;
        while (true) {
            try {
                System.out.println("1. Lägg till instruktions steg");
                System.out.println("0. Färdigställ recept");
                int choice = input.nextInt();
                input.nextLine();
                if (choice == 1) {
                    String instruction;
                    while (true) {
                        System.out.println("Skriv steg: " + instructionKey + " för receptet");
                        instruction = input.nextLine();
                        if (instruction.matches("[a-zA-ZåäöÅÄÖ ]+")) {
                            break;
                        } else {
                            System.out.println("Fel uppstod! Var snäll och skriv in bokstäver");
                        }
                    }
                    instructions.put(instructionKey, instruction);
                    System.out.println("La till steg: " + instructionKey + " med instruktionen: '" + instruction + "' till " +
                            "Listan av instruktioner");
                    instructionKey++;
                } else if (choice == 0) {
                    return instructions;
                }else {
                    System.out.println("Fel uppstod! Välj mellan alternativen 1 och 0");
                }
            } catch (Exception e) {
                System.out.println("Fel uppstod! Välj mellan alternativen 1 och 0");
                input.nextLine();
            }
        }
    }

    public RecipeType createRecipe() {
        Scanner input = new Scanner(System.in);

        String recipeName;

        while (true) {
            System.out.println("Skriv namnet på receptet!");
            recipeName = input.nextLine();
            if (recipeName.matches("[a-zA-ZåäöÅÄÖ ]+")) {
                break;
            } else {
                System.out.println("Fel uppstod! Var snäll och skriv in endast bokstäver");
            }
        }

        boolean isVegetarian;
        while (true) {
            System.out.println("Är receptet vegetariskt?(Ja/Nej)");
            String isVegetarianAnswer = input.nextLine();
            if (isVegetarianAnswer.equalsIgnoreCase("ja")) {
                isVegetarian = true;
                break;
            } else if (isVegetarianAnswer.equalsIgnoreCase("nej")) {
                isVegetarian = false;
                break;
            } else {
                System.out.println("Svara ja eller nej på om recepetet är vegetariskt!");
            }
        }

        MealCategory mealCategory = null;
        while (mealCategory == null) {
            System.out.println("Är måltiden Frukost, Lunch eller Middag?");
            try {
                String inputMealCategory = input.nextLine();
                mealCategory = MealCategory.valueOf(inputMealCategory.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Måltiden kan endast vara i kategorierna: Frukost, Lunch och Middag");
            }
        }

        System.out.println("Gör listan med ingredienser!");
        ArrayList<Ingredient> ingredients = createIngredient();

        System.out.println("Skriv alla instruktioner!");
        HashMap<Integer, String> instructions = createInstruction();

        RecipeType newRecipeCreated;
        if (isVegetarian) {
            newRecipeCreated = new VegetarianRecipe(recipeName, ingredients, instructions, mealCategory);
        } else {
            newRecipeCreated = new RegularRecipe(recipeName, ingredients, instructions, mealCategory);
        }

        System.out.println("Receptet: " + recipeName + " har lagts till i listan för recept!");

        return newRecipeCreated;
    }
}
