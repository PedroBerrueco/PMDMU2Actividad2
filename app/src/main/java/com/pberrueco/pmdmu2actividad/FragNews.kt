package com.pberrueco.pmdmu2actividad

import SimpleNewsAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.pberrueco.pmdmu2actividad.databinding.FragmentFragNewsBinding

class FragNews : Fragment() {

    private lateinit var _binding: FragmentFragNewsBinding
    private val binding: FragmentFragNewsBinding get() = _binding

    val args: FragNewsArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFragNewsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar el RecyclerView con las noticias iniciales
        val initialNewsList = getNewsList(args.nameRadio)
        setupRecyclerView(initialNewsList)

        // Configurar el BottomNavigationView
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.Sport -> {
                    val sportNewsList = getNewsList("Deportes")
                    setupRecyclerView(sportNewsList)
                    true
                }
                R.id.Tech -> {
                    val techNewsList = getNewsList("Tecnologia")
                    setupRecyclerView(techNewsList)
                    true
                }
                R.id.News -> {
                    val generalNewsList = getNewsList("Noticias")
                    setupRecyclerView(generalNewsList)
                    true
                }
                else -> false
            }
        }

        // Establecer el ítem predeterminado según la categoría seleccionada
        when (args.nameRadio) {
            "Deportes" -> binding.bottomNavigationView.selectedItemId = R.id.Sport
            "Tecnologia" -> binding.bottomNavigationView.selectedItemId = R.id.Tech
            "Noticias" -> binding.bottomNavigationView.selectedItemId = R.id.News
        }

        // Configurar el FloatingActionButton
        binding.fabShowAll.setOnClickListener {
            // Obtener y mostrar todas las noticias
            val allNewsList = getAllNews()
            setupRecyclerView(allNewsList)
        }
    }

    private fun setupRecyclerView(newsList: List<New>) {
        // Configurar el adapter
        val adapter = NewAdapter(newsList)

        // Configurar el RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        // Agregar el click listener al adapter
        adapter.setOnItemClickListener { selectedNew ->
            // Aquí se llama cuando el usuario hace clic en una noticia
            //val action = FragNewsDirections.actionFragNewsToFragDetalleNoticia(selectedNew.title ?: "")
            //findNavController().navigate(action)
            val action = FragNewsDirections.actionFragNewsToFragDetalleNoticia(selectedNew)
            findNavController().navigate(action)

        }
    }



    private fun getNewsList(name: String): List<New> {
        // Lógica para obtener la lista de noticias según el valor de name
        return when (name) {
            "Deportes" -> getSportNews()
            "Tecnologia" -> getTechNews()
            "Noticias" -> getGeneralNews()
            else -> emptyList()
        }
    }

    private fun getSportNews(): List<New> {
        return sportNews
    }

    private fun getTechNews(): List<New> {
        return techNews
    }

    private fun getGeneralNews(): List<New> {
        return generalNews
    }

    private fun getAllNews(): List<New> {
        // Obtener y retornar todas las noticias
        val allNewsList = mutableListOf<New>()
        allNewsList.addAll(getSportNews())
        allNewsList.addAll(getTechNews())
        allNewsList.addAll(getGeneralNews())
        return allNewsList
    }
}

