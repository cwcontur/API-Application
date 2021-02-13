import org.json.JSONObject;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.*;

public class RecipeAPI {
    public static void getRecipe(){
        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/random?number=1&tags=vegetarian%2Cdessert"))
                    .header("x-rapidapi-key", "a6cbc6ab34msh459b9886cba4d90p1e7b77jsn102d04105826")
                    .header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject obj = new JSONObject(response.body());

            String recipe = obj.getString("title");

            System.out.println(response.body());

            System.out.println(recipe);
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void main(String args[]){
        RecipeAPI recipeapi = new RecipeAPI();
        recipeapi.getRecipe();
    }
}
