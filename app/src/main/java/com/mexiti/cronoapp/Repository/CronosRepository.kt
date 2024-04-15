package com.mexiti.cronoapp.Repository

import android.view.KeyEvent.DispatcherState
import com.mexiti.cronoapp.model.Cronos
import com.mexiti.cronoapp.room.CronosDatabasesDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CronosRepository @Inject constructor(private val cronosDatabasesDao: CronosDatabasesDao){
    suspend fun addCrono(crono: Cronos)=cronosDatabasesDao.insert(crono)
    suspend fun updateCrono(crono: Cronos)=cronosDatabasesDao.update(cronos =crono)
    suspend fun deleteCrono(crono: Cronos)=cronosDatabasesDao.delete(cronos = crono)

    fun getAllCronos(): Flow<List<Cronos>> =cronosDatabasesDao
        .getCronos()
        .flowOn(Dispatchers.IO)
        .conflate()
    fun getCronByID(id:Long): Flow<Cronos> =cronosDatabasesDao
        .getCronosById(id)
        .flowOn(Dispatchers.IO)
        .conflate()
}