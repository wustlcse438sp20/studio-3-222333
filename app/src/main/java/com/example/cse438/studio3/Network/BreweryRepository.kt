package com.example.cse438_rest_studio.Network

import androidx.lifecycle.MutableLiveData
import com.example.cse438_rest_studio.data.Brewery
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class BreweryRepository {
     val service= ApiClient.makeRetrofitService()

    //TODO #6: Create a function that launches a coroutine for searching by city
      fun searchbycity(resBody: MutableLiveData<Brewery>, city:String){
        CoroutineScope(Dispatchers.IO).launch {

            val response = service.searchbycity(city)
            withContext(Dispatchers.Main){
                try {
                    if (response.isSuccessful){
                        resBody.value=response.body()
                    }
                }catch (e:HttpException){
                    println("http error")
                }
            }
        }
    }
    //TODO #7: Create a function that launches a coroutine for searching by a generic term
     fun searchbyTerm(resBody: MutableLiveData<Brewery>, term:String){
        CoroutineScope(Dispatchers.IO).launch {

            val response = service.searchbyTerm(term)
            withContext(Dispatchers.Main){
                try {
                    if (response.isSuccessful){
                        resBody.value=response.body()
                    }
                }catch (e:HttpException){
                    println("http error")
                }
            }
        }

    }

}