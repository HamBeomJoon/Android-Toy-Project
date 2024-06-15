package com.example.app.data.repository

import android.util.Log
import com.example.app.data.mapper.UserMapper
import com.example.app.data.remote.RetrofitClient
import com.example.app.data.remote.api.UserService
import com.example.app.domain.model.UserEntity
import com.example.app.domain.repository.UserRepository
import org.json.JSONObject

class UserRepositoryImpl : UserRepository {
    private val service = RetrofitClient.getInstance().create(UserService::class.java)
    override suspend fun searchUsers(username: String): Int {
        val res = service.searchUsers(username)
        Log.d("TAG", res.toString())
        return 0
//        return if (res.isSuccessful) {
//            val data = res.body()!!
//            Result.success(UserMapper.mapperToResponseEntity(data))
//        } else {
//            val errorMsg = JSONObject(res.errorBody()!!.string()).getString("msg")
//            Result.failure(Exception(errorMsg))
//    }
    }
}