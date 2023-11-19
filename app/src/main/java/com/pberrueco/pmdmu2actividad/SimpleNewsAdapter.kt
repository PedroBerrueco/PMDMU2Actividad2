import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pberrueco.pmdmu2actividad.New
import com.pberrueco.pmdmu2actividad.databinding.ItemNewsBinding

class SimpleNewsAdapter(private val newsList: List<New>, private val onItemClick: (String) -> Unit) : RecyclerView.Adapter<SimpleNewsAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(news: New) {
            binding.tvTitle.text = news.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentNew = newsList[position]
        holder.bind(currentNew)
        holder.itemView.setOnClickListener {
            onItemClick(currentNew.title ?: "") // Pasa el título cuando se hace clic
        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}
