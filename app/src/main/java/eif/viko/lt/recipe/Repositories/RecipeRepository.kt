package eif.viko.lt.recipe.Repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import eif.viko.lt.recipe.Models.Recipe

object RecipeRepository {
    private val db = mutableListOf<Recipe>()
    var updatedList = MutableLiveData<List<Recipe>>()

    fun getRecipes():LiveData<List<Recipe>>{
        db.clear()
        load()
        updatedList.value = db
        return updatedList
    }

    //webserviso ar kitu vietu duomenys
    fun load(){
        db.add(Recipe("Raspberry Ice Cream Delight","A fine sunday recipe for children and grown ups","https://loremflickr.com/320/240"))
        db.add(Recipe("Frozen Banana Split Pie","A nice creamy pie with bananas","https://loremflickr.com/320/240"))
        db.add(Recipe("Easy Four-Layer Chocolate Dessert","Nice chocolate desert with good flavour","https://loremflickr.com/320/240"))
        db.add(Recipe("Freezer Strawberry Shortbread Dessert","Good summer desert for hot summer days","https://loremflickr.com/320/240"))
        db.add(Recipe("Icebox Cookies","Nice cookies that have good taste and you can impress your partner with them","https://loremflickr.com/320/240"))
    }


}