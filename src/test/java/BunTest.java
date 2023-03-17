import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Database;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private Database database;
    @Parameterized.Parameter(0)
    public int index;
    @Parameterized.Parameter(1)
    public String name;
    @Parameterized.Parameter(2)
    public float price;

    @Parameterized.Parameters(name = "Index: {0}, BunName: {1}, Price: {2}")
    public static Object[][] getBunData() {
        return new Object[][] {
                {0, "black bun", 100},
                {1, "white bun", 200},
                {2, "red bun", 300}
        };
    }

    @Before
    public void createDatabase() {
        database = new Database();
    }

    @Test
    public void testGetName() {
        var bun = database.availableBuns().get(index);
        assertEquals(name, bun.getName());
    }

    @Test
    public void testGetPrice() {
        var bun = database.availableBuns().get(index);
        assertEquals(price, bun.getPrice(), 0);
    }

}
