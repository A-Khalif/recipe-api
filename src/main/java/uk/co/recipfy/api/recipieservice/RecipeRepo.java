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

     Recipe findById(long id);

     boolean deleteRecipeById(long id);

     List<Recipe> findByName(String name);


     List<Recipe> findByDescriptionContaining(String description);

     List<Recipe> findByCategory(String category);

     List<Recipe> findByCookingTimeLessThanEqual(long cookingTime);

     void deleteByCategory(String category);
     Recipe findByNameAndCategory(String name, String category);

}