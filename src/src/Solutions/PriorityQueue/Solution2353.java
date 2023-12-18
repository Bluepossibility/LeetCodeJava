package Solutions.PriorityQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Food implements Comparable<Food> {
    public int foodRating;
    public String foodName;

    public Food(int foodRating, String foodName){
        this.foodRating = foodRating;
        this.foodName = foodName;
    }

    @Override
    public int compareTo(Food other){
        if (foodRating == other.foodRating){
            return foodName.compareTo(other.foodName);
        }
        return -1 * Integer.compare(foodRating, other.foodRating);
    }
}

public class Solution2353 {

    // Map food with its rating.
    private Map<String, Integer> foodRatingMap;
    // Map food with the cuisine it belongs to.
    private Map<String, String> foodCuisineMap;
    private Map<String, PriorityQueue<Food>> cuisineFoodMap;

    public void FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRatingMap = new HashMap<>();
        foodCuisineMap = new HashMap<>();
        cuisineFoodMap = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            foodRatingMap.put(foods[i], ratings[i]);
            foodCuisineMap.put(foods[i], cuisines[i]);
            cuisineFoodMap.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>()).add(new Food(ratings[i], foods[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        foodRatingMap.put(food, newRating);
        // Insert the '(new food rating, food name)' element into the respective cuisine's priority queue.
        String cuisineName = foodCuisineMap.get(food);
        cuisineFoodMap.get(cuisineName).add(new Food(newRating, food));
    }

    public String highestRated(String cuisine) {
        Food highestRated = cuisineFoodMap.get(cuisine).peek();
        while (foodRatingMap.get(highestRated.foodName) != highestRated.foodRating) {
            cuisineFoodMap.get(cuisine).poll();
            highestRated = cuisineFoodMap.get(cuisine).peek();
        }

        return highestRated.foodName;
    }
}
