package uk.co.recipfy.api.recipieservice;

import jakarta.persistence.*;
import lombok.*;
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tab_recipe")
public class Recipe
{
    @Id
    @GeneratedValue(generator ="recipe_id",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name= "recipe_id", sequenceName = "recipe_id", initialValue = 1)
    @Column(name = "rec_id")
    private   Long id;
    @Column(name = "rec_name")
    private   String name;

    @Column(name = "rec_description")
    private  String description;

    @Column(name = "rec_category")
    private   String category;

    @Column(name = "rec_cookingtime")
    private  Long cookingTime;

    public Recipe(String name, String description, String category, Long cookingTime)
    {
       this.name = name;
       this.description = description;
       this.category = category;
       this.cookingTime = cookingTime;
    }

}
