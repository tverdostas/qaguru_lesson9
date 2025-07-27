package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Ingredients {
    @JsonProperty("ingredient_name")
    private String ingredientName;
    private int weight;
    public String getIngredientName() {
        return ingredientName;
    }

    public Integer getWeight() {
        return weight;
    }
}
