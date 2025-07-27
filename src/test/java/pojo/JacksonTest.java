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

        String dishNameFromJson = objectMapper.readTree(file).get("dish_name").asText();
        recipe.setDishName(dishNameFromJson);

        int dishIdFromJson = objectMapper.readTree(file).get("dish_id").asInt();
        recipe.setDishId(dishIdFromJson);

        int dishQuantityOfReadyMealsFromJson = objectMapper.readTree(file).get("quantity_of_ready_meals").asInt();
        recipe.setQuantityOfReadyMeals(dishQuantityOfReadyMealsFromJson);

        int dishCalorieContentFromJson = objectMapper.readTree(file).get("calorie_content").asInt();
        recipe.setCalorieContent(dishCalorieContentFromJson);

        boolean dishHaveLactoseFromJson = objectMapper.readTree(file).get("have_lactose").asBoolean();
        recipe.setHaveLactose(dishHaveLactoseFromJson);

        assertEquals(1020, recipe.getDishId());

        assertEquals("сырники",
                recipe.getDishName());

        assertEquals(4, recipe.getQuantityOfReadyMeals());

        assertEquals(300, recipe.getCalorieContent());

        assertEquals(true, recipe.getHaveLactose());
    }
}
