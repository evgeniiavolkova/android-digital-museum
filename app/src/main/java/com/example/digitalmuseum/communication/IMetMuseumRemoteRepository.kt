package com.example.digitalmuseum.communication

import com.example.digitalmuseum.architecture.CommunicationResult
import com.example.digitalmuseum.architecture.IBaseRemoteRepository

interface IMetMuseumRemoteRepository: IBaseRemoteRepository {
    suspend fun getObjects(): CommunicationResult<List<com.example.digitalmuseum.models.Object>>
    suspend fun getObject(objectId: Int): CommunicationResult<com.example.digitalmuseum.models.Object>
}