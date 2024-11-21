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
        Recipe recipe = new Recipe("Korvstroganoff", new ArrayList<>(), new HashMap<>(), MealCategory.LUNCH);
        this.recipeManager.addRecipe(recipe);

        ArrayList<Recipe> recipes = this.recipeManager.getRecipes();
        assertEquals(1, recipes.size(), "'recipes' listan borde innehålla ett recept");
    }

    @Test
    void testRemoveRecipe() {
        Recipe recipe = new Recipe("Korvstroganoff", new ArrayList<>(), new HashMap<>(), MealCategory.LUNCH);
        this.recipeManager.addRecipe(recipe);

        ArrayList<Recipe> recipes = this.recipeManager.getRecipes();
        assertEquals(1, recipes.size(), "Listan ska innehålla ett recept innan det tas bort");

        this.recipeManager.removeRecipe(recipe);
        assertEquals(0, recipes.size(), "Listan borde vara tom om");
    }

    @Test
    void testViewRecipes() {
        Recipe recipe = new Recipe("Korvstroganoff", new ArrayList<>(), new HashMap<>(), MealCategory.LUNCH);
        Recipe recipe1 =new Recipe("Spaghetti bolognese", new ArrayList<>(),new HashMap<>(),MealCategory.MIDDAG);
        this.recipeManager.addRecipe(recipe);
        this.recipeManager.addRecipe(recipe1);

        ByteArrayOutputStream op = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(op);

        System.setOut(ps);

        this.recipeManager.viewRecipes();

        String output = op.toString().trim();

        assertTrue(output.contains("Korvstroganoff"),"'Korvstroganoff' ska skrivas ut");
        assertTrue(output.contains("Spaghetti bolognese"),"'Spaghetti bolognese' ska skrivas ut");

        System.setOut(System.out);
    }
}
