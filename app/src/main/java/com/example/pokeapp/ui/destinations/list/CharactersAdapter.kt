package com.example.pokeapp.ui.destinations.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pokeapp.commons.getPicUrl
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
    }
    private fun clearList() {
        val emptyList = listOf<Pokemon>()
        pokemon = emptyList
        notifyItemRangeRemoved(0, 0)
    }
}
