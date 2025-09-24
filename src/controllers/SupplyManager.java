package controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import contracts.ManagerHandler;
import models.Ingredient;
import utils.*;


public class SupplyManager implements ManagerHandler {
    private static SupplyManager self;
    private Displayer displayer = Displayer.getDisplayer();
    //private UserInputHandler inputHandler = UserInputHandler.getUserInputHandler();

    private List<Ingredient> ingredients;

    // Show available functions
    @Override
    public void showGeneralInfo() {
        String[] message = {
            "Day la trinh quan ly nguon cung thuc pham 100% sieu sach",
            "Trinh quan ly gom cac tinh nang nhu:",
            "1. Kiem tra nguon cung thuc pham, co so luong nhung ko co chat luong ;)",
            "2. add/remove them nguyen lieu nhanh gon va sieu muot",
            "Va dat biet la cac mon an cua chung ta duoc lam boi sieu dau bep ratatouille"
        };
        displayer.displayMessage(message);
    }

    // Print report of all ingredients
    @Override
    public void createReport() {
        System.out.println("Danh sach nguyen lieu trong kho:");
        for (Ingredient ing : ingredients) {
            System.out.println("Name: " + ing.getName() + ", Quantity: " + ing.getQuantity());
        }
    }

    // Load ingredients from file
    private void loadIngredientsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\resources\\Ingredients.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    ingredients.add(new Ingredient(line));
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading ingredients from file: " + e.getMessage());
        }
    }

    // Private constructor to enforce singleton
    private SupplyManager() {
        ingredients = new ArrayList<>();
        loadIngredientsFromFile();
    }

    // Public method to get the single self
    public static SupplyManager getManager() {
        if (self == null) {
            self = new SupplyManager();
        }
        return self;
    }
    

    // Add ingredient to the list
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public Ingredient getIngredient(String name, int amount) {
        for (Ingredient ing : ingredients) {
            if (ing.getName().equalsIgnoreCase(name)) {
                int retrievedAmount = ing.decreaseQuantity(amount);
                if (retrievedAmount > 0) {
                    Ingredient result = new Ingredient(name);
                    result.increaseQuantity(retrievedAmount);
                    return result;
                }
                break; // Found but not enough quantity
            }
        }
        return null; // Not found or insufficient quantity
    }

}
