package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Sandwich sandwich = new Sandwich();

        String mainName;
        String placeOfOrigin;
        String description;
        String image;
        ArrayList<String> ingredientsList = new ArrayList<>();
        ArrayList<String> alsoKnownAsList = new ArrayList<>();

        try {
            JSONObject sandwichJson = new JSONObject(json);

            JSONObject Object = sandwichJson.getJSONObject("name");
            mainName = Object.getString("mainName");

            placeOfOrigin = sandwichJson.getString("placeOfOrigin");
            description = sandwichJson.getString("description");
            image = sandwichJson.getString("image");

            JSONArray alsoKnownAs = Object.getJSONArray("alsoKnownAs");
            for (int i = 0; i < alsoKnownAs.length(); i++) {
                alsoKnownAsList.add(alsoKnownAs.getString(i));
            }

            JSONArray ingredients = sandwichJson.getJSONArray("ingredients");
            for (int i = 0; i < ingredients.length(); i++) {
                ingredientsList.add(ingredients.getString(i));
            }

            sandwich.setMainName(mainName);
            sandwich.setAlsoKnownAs(alsoKnownAsList);
            sandwich.setIngredients(ingredientsList);
            sandwich.setImage(image);
            sandwich.setPlaceOfOrigin(placeOfOrigin);
            sandwich.setDescription(description);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;
    }
}