import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecipeManagerTest {
    private RecipeManager recipeManager;

    @BeforeEach
    void setUp() {
        this.recipeManager = new RecipeManager();
    }

    @Test
    void testAddRecipe() {
        RecipeType recipe = new RegularRecipe("Korvstroganoff", new ArrayList<>(), new HashMap<>(), MealCategory.LUNCH);
        RecipeType recipeVeg = new VegetarianRecipe("Linsgryta", new ArrayList<>(), new HashMap<>(), MealCategory.MIDDAG);

        this.recipeManager.addRecipe(recipe);
        this.recipeManager.addRecipe(recipeVeg);

        ArrayList<RecipeType> recipes = this.recipeManager.getRecipes();
        assertEquals(2, recipes.size(), "'recipes' listan borde innehålla två recept");
    }

    @Test
    void testRemoveRecipe() {
        RecipeType recipe = new RegularRecipe("Korvstroganoff", new ArrayList<>(), new HashMap<>(), MealCategory.LUNCH);
        RecipeType recipeVeg = new VegetarianRecipe("Linsgryta", new ArrayList<>(), new HashMap<>(), MealCategory.MIDDAG);
        this.recipeManager.addRecipe(recipe);
        this.recipeManager.addRecipe(recipeVeg);

        ArrayList<RecipeType> recipes = this.recipeManager.getRecipes();
        assertEquals(2, recipes.size(), "Listan ska innehålla två recept innan det tas bort");

        this.recipeManager.removeRecipe(recipe);
        this.recipeManager.removeRecipe(recipeVeg);

        assertEquals(0, recipes.size(), "Listan borde vara tom om");
    }

    @Test
    void testViewRecipes() {
        RecipeType recipe = new RegularRecipe("Korvstroganoff", new ArrayList<>(), new HashMap<>(), MealCategory.LUNCH);
        RecipeType recipeVeg = new VegetarianRecipe("Linsgryta", new ArrayList<>(), new HashMap<>(), MealCategory.MIDDAG);

        this.recipeManager.addRecipe(recipe);
        this.recipeManager.addRecipe(recipeVeg);

        ByteArrayOutputStream op = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(op);
        System.setOut(ps);

        this.recipeManager.viewRecipes();

        String output = op.toString().trim();

        assertTrue(output.contains("Korvstroganoff"), "'Korvstroganoff' ska skrivas ut");
        assertTrue(output.contains("Linsgryta"), "'Linsgryta' ska skrivas ut");

        System.setOut(System.out);
    }
}
