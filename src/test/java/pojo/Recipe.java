package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @JsonProperty("dish_id")
    private int dishId;
    @JsonProperty("dish_name")
    private String dishName;
    @JsonProperty("quantity_of_ready_meals")
    private int quantityOfReadyMeals;
    @JsonProperty("calorie_content")
    private int calorieContent;
    @JsonProperty("have_lactose")
    private boolean haveLactose;
    private List<Ingredients> ingredients;

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public void setQuantityOfReadyMeals(int quantityOfReadyMeals) {
        this.quantityOfReadyMeals = quantityOfReadyMeals;
    }

    public void setCalorieContent(int calorieContent) {
        this.calorieContent = calorieContent;
    }

    public void setHaveLactose(boolean haveLactose) {
        this.haveLactose = haveLactose;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public Integer getDishId() {
        return dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public Integer getQuantityOfReadyMeals() {
        return quantityOfReadyMeals;
    }

    public Integer getCalorieContent() {
        return calorieContent;
    }

    public boolean getHaveLactose() {
        return haveLactose;
    }


}
