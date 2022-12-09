package com.example.pokeapp.ui.destinations.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokeapp.commons.getPicUrl
import com.example.pokeapp.data.model.ConverterTypes
import com.example.pokeapp.data.model.Pokemon
import com.example.pokeapp.databinding.CharacterModelBinding

class CharactersAdapter (private var pokemon: List<Pokemon>?,
                         private val lifecycleOwner: LifecycleOwner): RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    private lateinit var binding: CharacterModelBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersAdapter.ViewHolder {
        binding = CharacterModelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: CharactersAdapter.ViewHolder, position: Int) {
        pokemon?.let {
            holder.characterNAME.text = it[position].name

            /*val pokeTypeFirst = it[position].types[0].type.name
            if (it[position].types.size > 1) {
                ConverterTypes.values().forEach {convType ->
                    if (convType.name == pokeTypeFirst) {
                        holder.characterTYPE.text = pokeTypeFirst
                        holder.characterTYPE.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, convType.colorType))
                    }
                    if (convType.name == it[position].types[1].type.name) {
                        holder.characterTYPE2.text = it[position].types[1].type.name
                        holder.characterTYPE2.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, convType.colorType))
                    }
                }
            } else {
                ConverterTypes.values().forEach {
                    if (it.name == pokeTypeFirst){
                        holder.characterTYPE.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, it.colorType))
                        holder.characterTYPE.text = pokeTypeFirst
                        holder.characterTYPE2.visibility = View.GONE
                    }
                }
            }*/

            val picture = it[position].url.getPicUrl()

            Glide.with(holder.itemView.context)
                .load(picture)
                .into(holder.characterIMG)

        } ?: clearList()
    }

    override fun getItemCount(): Int {
        return pokemon?.size ?: 0
    }

    inner class ViewHolder (mView: View): RecyclerView.ViewHolder(mView){
        val characterIMG = binding.pokemonIMG
        val characterNAME = binding.pokemonNAME
        val characterTYPE = binding.pokemonTYPE
        val characterTYPE2 = binding.pokemonTYPE2
    }
    private fun clearList() {
        val emptyList = listOf<Pokemon>()
        pokemon = emptyList
        notifyItemRangeRemoved(0, 0)
    }
}
