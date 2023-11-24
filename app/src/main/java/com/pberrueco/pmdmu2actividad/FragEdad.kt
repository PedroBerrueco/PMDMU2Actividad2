package com.pberrueco.pmdmu2actividad

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.pberrueco.pmdmu2actividad.databinding.FragmentFragEdadBinding
import androidx.navigation.fragment.navArgs
import com.pberrueco.pmdmu2actividad.databinding.FragmentFragWelcomeBinding

class FragEdad : Fragment() {

    private lateinit var _binding: FragmentFragEdadBinding
    private val binding: FragmentFragEdadBinding get() = _binding

    val args: FragEdadArgs by navArgs()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFragEdadBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button2.isEnabled = false


        // Configura el Switch
        configureSwitch()
        // Rellena el nombre en el TextView
        fillName()
        // Configurar evento al pulsar botón
        configureButtonAndNavigation()

    }


    private fun configureSwitch() {
        // Agrega un listener al Switch
        binding.switchAdult.setOnCheckedChangeListener { _, isChecked ->
            // Deshabilita o habilita el Button según el estado del Switch
            binding.button2.isEnabled = isChecked
        }
    }

    private fun fillName() {
        // Guarda el dato que recibes del primer fragmento
        val name: String = args.nameValue[0]
        // Mete el nombre en el TextView
        binding.tvHola.text = "$name"
    }

    private fun configureButtonAndNavigation() {
        val btnNavigate = binding.button2
        btnNavigate.setOnClickListener {
            navigateToFragNews()
        }
    }


    private fun navigateToFragNews() {

        val radio: String = args.nameValue[1]
        // Navegar a FragNews con ambos argumentos
        val action = FragEdadDirections.actionFragEdadToFragNews(
            radio
        )
        findNavController().navigate(action)
    }

}
