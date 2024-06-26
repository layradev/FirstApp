package com.layra.firstapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.layra.firstapp.R
import com.layra.firstapp.databinding.FragmentAllPessoasBinding
import com.layra.firstapp.view.adapter.PessoaAdapter
import com.layra.firstapp.viewmodel.AllPessoasViewModel


class AllPessoasFragment : Fragment() {

    // Chamar a viewmodel

    private val viewModel: AllPessoasViewModel by viewModels()

    // Chamar o adapter
    private lateinit var adapter: PessoaAdapter

    // Criar o binding

    private var _binding: FragmentAllPessoasBinding? = null
    private val binding: FragmentAllPessoasBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // configurar o binding
        _binding = FragmentAllPessoasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Quando criar em algum item da lista
        adapter = PessoaAdapter(viewModel.pessoaList.value) {

        }

        //Configura Recycler
        val recycler = binding.rvPessoas
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        //Observa para adicionar um item a lista quando for adicionado
        viewModel.pessoaList.observe(viewLifecycleOwner) {
            adapter.updatePessoas(it)
        }

        // Navegar para a tela de cadastro de pessoa
        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.pessoaFragment)
        }

        // Carregar as pessoas cadastradas
        viewModel.loadPessoa()
    }

}