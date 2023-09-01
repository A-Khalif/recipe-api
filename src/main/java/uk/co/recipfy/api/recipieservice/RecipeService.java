package uk.co.recipfy.api.recipieservice;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Defines CRUD operations for recipe service
 * @version 1.0.0
 * @author anwarkhalif
 * Date: 20/05/2022
 */
@NoArgsConstructor
@Service
public class RecipeService
{
    @Autowired
    private RecipeRepo recipeRepo;

    public static final String ARGUMENT_CAN_NOT_BE_NULL = "Argument can not be null";
    public static final String ARGUMENT_NOT_LESS_THAN_ZERO = "Argument can not be less than zero";

    /**
     * @return retrieves list of recipes
     * {@link RecipeController#getAllRecipes(long)}
     */
    public List<Recipe> getAllRecipes()
    {
        return recipeRepo.findAll();
    }

    /**
     * @param recipe Receives a recipe object
     * @return The saved Recipe object
     * @throws IllegalArgumentException When the argument is null
     * {@link RecipeController#addRecipe(Recipe)}
     */
    public Recipe addRecipe(Recipe recipe)
    {
        if(recipe!=null)
        {
            return recipeRepo.save(recipe);
        }
        else
        {
        throw new IllegalArgumentException(ARGUMENT_CAN_NOT_BE_NULL) ;
        }
    }

    /**
     * Retrieving recipe by name
     * @param name  Refers to recipe name
     * @return  One or more recipe with the given name
     * @throws IllegalArgumentException When the argument is null
     * {@link RecipeController#getRecipeByName(String)}
     */
    public List<Recipe> getRecipeByName(String name)
    {
        if(name!=null)
        {
            return recipeRepo.findByName(name);
        }
        else
        {
            throw new IllegalArgumentException(ARGUMENT_CAN_NOT_BE_NULL);
        }
    }
    
    /**
     * @param category Refers to the recipe category
     * @return A list of recipes from the category
     * @throws IllegalArgumentException When the argument is null
     * {@link RecipeController#getRecipesByCategory(String)}
     */
    public List<Recipe> getRecipeByCategory(String category)
    {
        if (category != null)
        {
          return recipeRepo.findByCategory(category);
        }
        else
        {
            throw new IllegalArgumentException(ARGUMENT_CAN_NOT_BE_NULL);
        }
    }

    /**
     * Retrieves a recipe given its id
     * @param id Refers to the id of the recipe to be searched
     * @return A single recipe matching the id
     * @throws IllegalArgumentException When the argument is less than zero
     * {@link RecipeController#getRecipeById(int)}
     */
    public Recipe getRecipeById(long id)
    {
        if (id>0)
        {
            return recipeRepo.findById(id);
        }
        else
        {
            throw new IllegalArgumentException(ARGUMENT_CAN_NOT_BE_NULL);
        }
    }

    /**
     * Deletes a recipe using its id
     * @param id Refers to the id of the recipe
     * {@link RecipeController#deleteRecipeById(int)}
     */
    public void deleteRecipeById(long id)
    {
        if (id>0)
        {
            recipeRepo.deleteById(id);
        }
        else
        {
            throw new IllegalArgumentException(ARGUMENT_NOT_LESS_THAN_ZERO);
        }
    }

    /**
     * Deletes all recipes found in a given category
     * @param category Refers to the category
     * {@link RecipeController#deleteByCategory(String)}
     */
    public void deleteRecipesByCategory(String category)
    {
       if(category!=null)
       {
           recipeRepo.deleteByCategory(category);
       }
       else
       {
           throw new IllegalArgumentException(ARGUMENT_CAN_NOT_BE_NULL);
       }
    }

    /**
     * firstly, retrieve recipe using id then updates its description
     * @param id refers to the id of the recipe
     * @param description refers to the new description that will be updated
     *{@link RecipeController#updateRecipeDescriptionById(long, Recipe)}
     */
    public Recipe updateRecipeDescriptionById(long id, String description)
    {
       Recipe recipe= recipeRepo.findById(id);
       recipe.setDescription(description);
       return recipeRepo.save(recipe);
    }

    /**
     * Saves list of recipes
     * @param recipe receives a {@code List<Recipe>}
     * {@link RecipeController#addAllRecipes(List)}
     */
    public void addAllRecipe(List<Recipe> recipe)
    {
        recipeRepo.saveAll(recipe);
    }

    /**
     * Retrieves all recipes with given description keyword
     * @param keyword - Refers to the word that should be searched for in the descriptions of the recipes
     * @return - A list of recipes matching the keyword given
     * {@link RecipeController#getRecipesByDescription(String)}
     */
    public List<Recipe> getRecipesByDescriptionContaining(String keyword)
    {
        return recipeRepo.findByDescriptionContaining(keyword);

    }

    /**
     * Updates the category a recipe belongs to
     * @param id Refers to the id of the recipe in question
     * @param category Refers to the new category
     * {@link RecipeController#updateARecipeCategoryById(long, Recipe)}
     */
    public Recipe updateARecipeCategoryById(long id, String category)
    {
        if(id>0 && category!=null)
        {
            Recipe recipe = getRecipeById(id);
            recipe.setCategory(category);
            return recipeRepo.save(recipe);
        }
        else
        {
          throw new IllegalArgumentException("id must be greater than zero & category can not be null");
        }
    }

    /**
     * Retrieves all the recipes less than or equal to the given cooking time in minutes
     * @param maxCookingTime - Refers to the max cooking time in minutes
     * @return - Retrieving a list of recipes that have the cooking time provided or less
     * {@link RecipeController#getAllRecipes(long)}
     */
    public List<Recipe> getRecipesByCookingTimeLessThanOrEqual(long maxCookingTime)
    {
        if(maxCookingTime>0)
        {
            return recipeRepo.findByCookingTimeLessThanEqual(maxCookingTime);

        }
        else
        {
            throw new IllegalArgumentException(ARGUMENT_NOT_LESS_THAN_ZERO);
        }
    }

    /**
     * Given a recipe name and category, a single recipe should be returned
     * @param name  Refers to the recipe name
     * @param category  Refers to the recipe category
     * @return  A single recipe matching the given name and category
     * {@link RecipeController#getRecipeByCategoryAndName(String, String)}
     */
    public Recipe getRecipeByCategoryAndName(String name, String category)
    {
        return recipeRepo.findByNameAndCategory(name, category);
    }


}
