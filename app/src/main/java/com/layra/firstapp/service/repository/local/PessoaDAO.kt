package com.layra.firstapp.service.repository.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.layra.firstapp.service.model.Pessoa


@Dao
interface PessoaDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pessoa: Pessoa)


    @Query("SELECT * FROM pessoa WHERE id = :id")
    suspend fun getPesoa(id : Int):Pessoa

    @Query("SELECT * FROM pessoa")
    suspend fun getALL(): List<Pessoa>


    @Update
    suspend fun update(pessoa: Pessoa)

    @Query("DELETE FROM pessoa WHERE id = :id")
    suspend fun delete(id : Int)
}