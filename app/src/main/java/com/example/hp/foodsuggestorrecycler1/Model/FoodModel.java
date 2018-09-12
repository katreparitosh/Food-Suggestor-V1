package com.example.hp.foodsuggestorrecycler1.Model;

public class FoodModel
{
    public int foodRating;
    public String foodName,foodIngredients,foodType,foodTaste;

    public FoodModel(int foodRating, String foodName, String foodIngredients, String foodType, String foodTaste) {
        this.foodRating = foodRating;
        this.foodName = foodName;
        this.foodIngredients = foodIngredients;
        this.foodType = foodType;
        this.foodTaste = foodTaste;
    }

    public FoodModel()
    {

    }

    public int getFoodRating() {
        return foodRating;
    }

    public void setFoodRating(int foodRating) {
        this.foodRating = foodRating;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodIngredients() {
        return foodIngredients;
    }

    public void setFoodIngredients(String foodIngredients) {
        this.foodIngredients = foodIngredients;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getFoodTaste() {
        return foodTaste;
    }

    public void setFoodTaste(String foodTaste) {
        this.foodTaste = foodTaste;
    }
}
