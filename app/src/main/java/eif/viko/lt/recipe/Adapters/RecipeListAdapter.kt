package eif.viko.lt.recipe.Adapters

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.View.OnClickListener
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.squareup.picasso.Picasso
import eif.viko.lt.recipe.Models.Recipe
import eif.viko.lt.recipe.R
import kotlinx.android.synthetic.main.recipe_item.view.*

class RecipeListAdapter(private val interaction: Interaction? = null) :
    ListAdapter<Recipe, RecipeListAdapter.RecipeViewHolder>(RecipeDC()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RecipeViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.recipe_item, parent, false), interaction
    )

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) =
        holder.bind(getItem(position))

    fun swapData(data: List<Recipe>) {
        submitList(data.toMutableList())
    }

    inner class RecipeViewHolder(
        itemView: View,
        private val interaction: Interaction?
    ) : RecyclerView.ViewHolder(itemView), OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {

            if (adapterPosition == RecyclerView.NO_POSITION) return

            val clicked = getItem(adapterPosition)
        }

        fun bind(item: Recipe) = with(itemView) {
            // TODO: Bind the data with View
            title_recipe.text = item.name
            details_recipe.text=item.details
            Picasso.get().load(item.imageUrl).into(image_recipe);
        }
    }

    interface Interaction {

    }

    private class RecipeDC : DiffUtil.ItemCallback<Recipe>() {
        override fun areItemsTheSame(
            oldItem: Recipe,
            newItem: Recipe
        )= oldItem.details == newItem.details

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(
            oldItem: Recipe,
            newItem: Recipe
        ) = oldItem == newItem
    }
}