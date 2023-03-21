import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Database;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    @Parameterized.Parameter(0)
    public int index;
    @Parameterized.Parameter(1)
    public IngredientType type;
    @Parameterized.Parameter(2)
    public String name;
    @Parameterized.Parameter(3)
    public float price;

    @Parameterized.Parameters(name = "Index: {0}, IngredientType: {1}, IngredientName: {2}, Price: {3}")
    public static Object[][] getBunData() {
        return new Object[][] {
                {0, IngredientType.SAUCE, "hot sauce", 100},
                {1, IngredientType.SAUCE, "sour cream", 200},
                {2, IngredientType.SAUCE, "chili sauce", 300},

                {3, IngredientType.FILLING, "cutlet", 100},
                {4, IngredientType.FILLING, "dinosaur", 200},
                {5, IngredientType.FILLING, "sausage", 300},
        };
    }

    private Database database;

    @Before
    public void createDatabase() {
        database = new Database();
    }

    @Test
    public void testGetName() {
        var ingredient = database.availableIngredients().get(index);
        assertEquals(name, ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        var ingredient = database.availableIngredients().get(index);
        assertEquals(price, ingredient.getPrice(), 0);
    }

    @Test
    public void testGetType() {
        var ingredient = database.availableIngredients().get(index);
        assertEquals(type, ingredient.getType());
    }

}
