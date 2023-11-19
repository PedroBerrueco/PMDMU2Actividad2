package com.pberrueco.pmdmu2actividad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.pberrueco.pmdmu2actividad.databinding.FragmentFragWelcomeBinding

class FragWelcome : Fragment() {

    private lateinit var _binding: FragmentFragWelcomeBinding
    private val binding: FragmentFragWelcomeBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFragWelcomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configura el botón y la navegación
        configureButtonAndNavigation()
    }

    private fun configureButtonAndNavigation() {
        val btnNavigate = binding.button
        btnNavigate.setOnClickListener {
            navigateToEdadFragment()
        }
    }

    private fun navigateToEdadFragment() {
        // Obtener el valor del nombre desde el EditText
        val name = binding.etName.text.toString()



        // Obtener el ID del RadioButton seleccionado
        val selectedOptionId = binding.rbNewsgroup.checkedRadioButtonId

// Determinar la opción seleccionada en base al ID del RadioButton
        var selectedOption: String = when (selectedOptionId) {
            R.id.rb_tech -> "Tecnologia"
            R.id.rb_news -> "Noticias"
            R.id.rb_sports -> "Deportes"
            else -> "General" // Puedes cambiar "Todas" por el valor por defecto que desees
        }

        // Navegar a FragEdad con ambos argumentos
        val action = FragWelcomeDirections.actionFragWelcomeToFragEdad(
            nameValue = arrayOf(name,selectedOption)
        )
        findNavController().navigate(action)


    }


}
