package com.layra.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.layra.firstapp.R
import com.layra.firstapp.databinding.FragmentCalculoBinding
import com.layra.firstapp.databinding.FragmentVerificaBinding

class VerificaFragment : Fragment() {
    private var _binding: FragmentVerificaBinding? = null
    private val binding: FragmentVerificaBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentVerificaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnEnviar.setOnClickListener{
            var email = binding.edtEmail.editableText.toString()



            if (email.contains("@") && email.contains(".com")) {
                binding.tvEmail.text = "Email: ${email}"
            }
            else{
                binding.tvEmail.text = "Email Inválido"
            }

            var telefone = binding.edtTelefone.editableText.toString()
            if ( telefone.length == 11){
                binding.tvTelefone.text = "Telefone: ${telefone}"
            }else{
                binding.tvTelefone.text = "Telefone: o número está incorreto"
            }
        }
    }
}