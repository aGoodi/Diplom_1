import org.junit.Before;
import org.junit.Test;
import praktikum.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BurgerTest {
    private Database database;

    @Before
    public void createDatabase() {
        database = new Database();
    }

    @Test
    public void testSetBuns() {
        var bun = database.availableBuns().get(0);

        var burger = new Burger();
        burger.setBuns(bun);

        assertEquals(bun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        var sauce = database.availableIngredients().get(0);
        List<Ingredient> ingredients = Arrays.asList(sauce);

        var burger = new Burger();
        burger.addIngredient(sauce);

        assertEquals(ingredients, burger.ingredients);
    }
    @Test
    public void testRemoveIngredient() {
        var sauce = database.availableIngredients().get(0);
        List<Ingredient> ingredients = List.of();

        var burger = new Burger();
        burger.addIngredient(sauce);
        burger.removeIngredient(0);

        assertEquals(ingredients, burger.ingredients);
    }

    @Test
    public void testMoveIngredient() {
        var sauce = database.availableIngredients().get(0);
        var filling = database.availableIngredients().get(3);
        List<Ingredient> ingredients = Arrays.asList(filling, sauce);

        var burger = new Burger();
        burger.addIngredient(sauce);
        burger.addIngredient(filling);
        burger.moveIngredient(0, 1);

        assertEquals(ingredients, burger.ingredients);
    }

    @Test
    public void testGetPrice() {
        var sauce = database.availableIngredients().get(0);
        var filling = database.availableIngredients().get(3);
        var bun = database.availableBuns().get(0);

        var burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        float price = 400; // 100 * 2 + 100 + 100

        assertEquals(price, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
        var bun = database.availableBuns().get(0);
        var sauce = database.availableIngredients().get(0);
        var filling = database.availableIngredients().get(3);

        var burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);


        StringBuilder receipt = new StringBuilder(
                String.format("(==== %s ====)%n", "black bun"));
        receipt.append(String.format("= %s %s =%n", "sauce",
                "hot sauce"));
        receipt.append(String.format("= %s %s =%n", "filling",
                "cutlet"));
        receipt.append(String.format("(==== %s ====)%n", "black bun"));
        receipt.append(String.format("%nPrice: %f%n", 400.0));
        receipt.toString();

        assertEquals(receipt.toString(), burger.getReceipt());
    }
}
