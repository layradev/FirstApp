package com.layra.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.layra.firstapp.databinding.FragmentPessoaBinding
import com.layra.firstapp.service.model.Pessoa
import com.layra.firstapp.viewmodel.PessoaViewModel
import java.time.LocalDateTime

class PessoaFragment : Fragment() {
    private val viewModel: PessoaViewModel by viewModels()


    private var _binding: FragmentPessoaBinding? = null
    private val binding: FragmentPessoaBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPessoaBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnEnviar.setOnClickListener {

            val nome = binding.edtNome.editableText.toString()
            val sexo = binding.edtSexo.editableText.toString()
            val anoNascimento = binding.edtAnoNascimento.editableText.toString()
            var faixa = ""

            if (nome != "" && anoNascimento != "") {



                val anoAtual = LocalDateTime.now().year
                val idade = anoAtual - anoNascimento.toInt()

                if (idade <12){
                    faixa = "infantil"
                } else if ( idade <18){
                    faixa = "adolescente"
                } else if (idade <64){
                    faixa = "adulto"
                } else if (idade >64){
                    faixa = "idoso"
                }


                val pessoa = Pessoa(
                    nome = nome,
                    sexo = sexo,
                    idade = idade,
                    faixa = faixa
                )
                viewModel.insert(pessoa)


                binding.edtNome.editableText.clear()
                binding.edtSexo.editableText.clear()
                binding.edtAnoNascimento.editableText.clear()
                findNavController().navigateUp()
            } else {
                Toast.makeText(requireContext(), "Digite os dados", Toast.LENGTH_LONG).show()
            }


        }
    }

}
