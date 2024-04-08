package com.layra.firstapp.service.repository

import android.content.Context
import com.layra.firstapp.service.model.Pessoa
import com.layra.firstapp.service.repository.local.FirstAppDataBase

class PessoaRepository(context: Context) {
    private val firstAppDb = FirstAppDataBase.getDataBase(context).pessoaDAO()

    suspend fun insertPessoa(pessoa: Pessoa){
        firstAppDb.insert(pessoa)
    }

    suspend fun getPessoa(id: Int){
        firstAppDb.getPesoa(id)
    }

    suspend fun getPessoa(): List<Pessoa> {
        return firstAppDb.getALL()
    }

    suspend fun updatePessoa(pessoa: Pessoa){
        firstAppDb.update(pessoa)
    }

    suspend fun deletePessoa(id : Int){
        firstAppDb.delete(id)
    }
}