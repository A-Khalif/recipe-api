package uk.co.recipfy.api.recipieservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/service/recipe")
public class RecipeController
{

  @Autowired
   private RecipeService service;

  @GetMapping("/all")
  public List<Recipe> getAllRecipes(@RequestParam(required = false, defaultValue = "0") long cookingTime )
  {
    return cookingTime <= 0 ? service.getAllRecipes() : service.getRecipesByCookingTimeLessThanOrEqual(cookingTime);
  }

  @GetMapping("/{name}")
  public List<Recipe> getRecipeByName(@PathVariable String name)
  {
    return service.getRecipeByName(name);
  }

  @GetMapping("/{category}/{name}")
  public Recipe getRecipeByCategoryAndName(@PathVariable String name, @PathVariable String category)
  {
    return service.getRecipeByCategoryAndName(name,category);
  }

  @GetMapping("/desc/all/{keyword}")
  public List<Recipe> getRecipesByDescription(@PathVariable String keyword)
  {

    return service.getRecipesByDescriptionContaining(keyword);
  }

  @GetMapping("/id")
  public Recipe getRecipeById(@RequestParam int id)
  {
    return service.getRecipeById(id);
  }

  @GetMapping("category/{name}")
  public List<Recipe> getRecipesByCategory(@PathVariable String name)
  {
    return service.getRecipeByCategory(name);
  }

  @PostMapping("/save")
  public void addRecipe(@RequestBody Recipe recipe)
  {
    service.addRecipe(recipe);
  }

  @PostMapping("/save-all")
  public void addAllRecipes(@RequestBody List<Recipe> recipe)
  {
    service.addAllRecipe(recipe);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteRecipeById(@PathVariable int id)
  {
    service.deleteRecipeById(id);
  }

  @DeleteMapping("/delete")
  public void deleteByCategory(@RequestParam String category)
  {
    service.deleteRecipesByCategory(category);
  }

  @PutMapping("/update")
  public void updateRecipeDescriptionById(@RequestParam long id, @RequestBody() Recipe request)
  {
    service.updateRecipeDescriptionById(id, request.getDescription());
  }

  @PutMapping("/update/category")
  public void updateARecipeCategoryById(@RequestParam long id, @RequestBody Recipe request)
  {
    service.updateARecipeCategoryById(id,request.getCategory());
  }

}
