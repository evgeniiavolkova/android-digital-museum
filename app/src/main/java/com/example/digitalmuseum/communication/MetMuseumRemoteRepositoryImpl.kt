package com.example.digitalmuseum.communication

import com.example.digitalmuseum.architecture.CommunicationError
import com.example.digitalmuseum.architecture.CommunicationResult
import com.example.digitalmuseum.models.Object
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class MetMuseumRemoteRepositoryImpl(private val api: MetMuseumApi) : IMetMuseumRemoteRepository {

    override suspend fun getObjects(): CommunicationResult<List<com.example.digitalmuseum.models.Object>> {
        try {
            val response = withContext(Dispatchers.IO) {
                api.getObjects()
            }
            if (response.isSuccessful) {
                if (response.body() != null) {
                    return CommunicationResult.Success(response.body()!!)
                } else {
                    return CommunicationResult.Error(
                        CommunicationError(response.code(), response.errorBody().toString())
                    )
                }
            } else {
                return CommunicationResult.Error(
                    CommunicationError(response.code(), response.errorBody().toString())
                )
            }

        } catch (ex: Exception) {
            return CommunicationResult.Exception(ex)
        }
    }

    override suspend fun getObject(objectId: Int): CommunicationResult<Object> {
        return try {
            processResponse(withContext(Dispatchers.IO){api.getObject(objectId)})
        } catch (timeoutEx: SocketTimeoutException) {
            CommunicationResult.Error(CommunicationError(0, "Timeout"))
        } catch (unknownHostEx: UnknownHostException) {
            CommunicationResult.Error(CommunicationError(0, "Unknown host"))
        }
    }
}