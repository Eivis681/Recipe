package eif.viko.lt.recipe.ViewModels

import androidx.lifecycle.ViewModel
import eif.viko.lt.recipe.Repositories.RecipeRepository

class RecipeViewModel:ViewModel(){
    val recipeRepository = RecipeRepository

    fun getRecipes() = recipeRepository.getRecipes()

}