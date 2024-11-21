import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

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

    }


}
