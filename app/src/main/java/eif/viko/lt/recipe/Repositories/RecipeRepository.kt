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
        db.add(Recipe("Raspberry Ice Cream Delight","A fine sunday recipe for children and grown ups","https://www.tasteofhome.com/wp-content/uploads/2018/01/exps33194_MT163844D03_16_1b-696x696.jpg"))
        db.add(Recipe("Frozen Banana Split Pie","A nice creamy pie with bananas","https://www.tasteofhome.com/wp-content/uploads/2018/01/Frozen-Banana-Split-Pie_EXPS_BDSMZ17_40581_D03_03_4b-696x696.jpg"))
        db.add(Recipe("Easy Four-Layer Chocolate Dessert","Nice chocolate desert with good flavour","https://www.tasteofhome.com/wp-content/uploads/2018/01/exps187568_SD153320D12_05_1b-2-696x696.jpg"))
        db.add(Recipe("Freezer Strawberry Shortbread Dessert","Good summer desert for hot summer days","https://www.tasteofhome.com/wp-content/uploads/2018/01/Freezer-Strawberry-Shortbread-Dessert_EXPS_BDSMZ17_48992_B03_03_4b-696x696.jpg"))
        db.add(Recipe("Icebox Cookies","Nice cookies that have good taste and you can impress your partner with them","https://www.tasteofhome.com/wp-content/uploads/2018/01/Icebox-Cookies_EXPS_CBZ16_1023_A05_20_1b-696x696.jpg"))
    }


}