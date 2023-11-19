// FragDetalleNoticia.kt
package com.pberrueco.pmdmu2actividad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.pberrueco.pmdmu2actividad.databinding.FragmentFragDetalleNoticiaBinding


class FragDetalleNoticia : Fragment() {

    private lateinit var _binding: FragmentFragDetalleNoticiaBinding
    private val binding: FragmentFragDetalleNoticiaBinding get() = _binding

    // Define los argumentos
    //private val args: FragDetalleNoticiaArgs by navArgs()
    //private val newsList: List<New> = args.newsList.toList()
    val args: FragDetalleNoticiaArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFragDetalleNoticiaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val selectedNew: New? = args.selectedNew
        // Mostrar los detalles de la noticia en la interfaz de usuario
        binding.tvTitle.text = selectedNew?.title
        binding.tvDescripcion.text = selectedNew?.description
        binding.tvAuthor.text = selectedNew?.author

        // Cargar la imagen usando Glide
        Glide.with(requireContext())
            .load(selectedNew?.image)
            .into(binding.ivNoticias)
    }

}
