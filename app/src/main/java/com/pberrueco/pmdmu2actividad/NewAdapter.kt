package com.pberrueco.pmdmu2actividad

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pberrueco.pmdmu2actividad.databinding.ItemNewsBinding
import com.bumptech.glide.Glide

class NewAdapter(private val newsList: List<New>) : RecyclerView.Adapter<NewAdapter.NewViewHolder>() {

    private var onItemClickListener: ((New) -> Unit)? = null
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.tv_title)
        val imageView: ImageView = itemView.findViewById(R.id.iv_noticias)
        val authorTextView: TextView = itemView.findViewById(R.id.tv_author)
        val descriptionTextView: TextView = itemView.findViewById(R.id.tv_descripcion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    fun updateData(newsList: List<New>) {

    }

    fun setOnItemClickListener(listener: (New) -> Unit) {
        this.onItemClickListener = listener
    }

    inner class NewViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(news: New) {
            // Configura los datos del ViewHolder usando View Binding
            binding.tvTitle.text = news.title
            // Cargar la imagen usando Glide
            Glide.with(binding.root.context)
                .load(news.image)
                .into(binding.ivNoticias)
            binding.tvDescripcion.text = news.description
            binding.tvAuthor.text = news.author

            // Configurar el clic en el ViewHolder
            binding.root.setOnClickListener {
                onItemClickListener?.invoke(news)
            }
        }
    }
}

