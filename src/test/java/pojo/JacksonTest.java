package pojo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JacksonTest {

    @Test
    void jsonFileToListOfPojos() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/test/resources/random_order.json");
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Recipe recipe = objectMapper.readValue(file, Recipe.class);

        assertEquals(1020, recipe.getDishId());

        assertEquals("сырники",
                recipe.getDishName());

        assertEquals(4, recipe.getQuantityOfReadyMeals());

        assertEquals(300, recipe.getCalorieContent());

        assertEquals(true, recipe.getHaveLactose());

        assertEquals("творог", recipe.getIngredients().get(0).getIngredientName());
        assertEquals(400, recipe.getIngredients().get(0).getWeight());

        assertEquals("манка", recipe.getIngredients().get(1).getIngredientName());
        assertEquals(80, recipe.getIngredients().get(1).getWeight());

        assertEquals("сахар", recipe.getIngredients().get(2).getIngredientName());
        assertEquals(50, recipe.getIngredients().get(2).getWeight());

        assertEquals(3, recipe.getIngredients().size());
    }
}
