/*
package tacos.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tacos.Ingredient;

import java.util.List;


public interface IngredientRepository
        extends CrudRepository<Ingredient, String> {

    @Query("select t from Ingredient t")
    List<Ingredient> findAllIngredient();

}*/
package tacos.data;

import tacos.Ingredient;

public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Ingredient findById(String id);

    Ingredient save(Ingredient ingredient);

}
