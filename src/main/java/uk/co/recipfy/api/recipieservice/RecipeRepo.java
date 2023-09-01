package uk.co.recipfy.api.recipieservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Recipe CRUD Repository
 * @author anwarkhalif
 * @version 1.0.0
 * Date: 20/05/2022
 */
@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Long>
{

    public Recipe findById(long id);

    public boolean deleteRecipeById(long id);

    public List<Recipe> findByName(String name);


    public List<Recipe> findByDescriptionContaining(String description);

    public List<Recipe> findByCategory(String category);

    public List<Recipe> findByCookingTimeLessThanEqual(long cookingTime);

    public List<Recipe> findByCookingTimeGreaterThan(long cookingTime);

    public void deleteByCategory(String category);
    public Recipe findByNameAndCategory(String name, String category);

}