package com.example.cse438.studio3

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cse438_rest_studio.Network.BreweryRepository
import com.example.cse438_rest_studio.data.Brewery


class BreweryViewModel(application: Application): AndroidViewModel(application) {

    //TODO #8: Create a livedata object for tracking breweries
    public var breweriesList:MutableLiveData<Brewery> = MutableLiveData()
    public var breweryRepository: BreweryRepository = BreweryRepository()
    //TODO #9: Write functions to access the two brewery API calls from the repository
   fun getBreweryByCity(city:String){
        breweryRepository.searchbycity(breweriesList,city)
    }

    fun getBreweryByTerm(Term : String){
        breweryRepository.searchbyTerm(breweriesList,Term)
    }
}