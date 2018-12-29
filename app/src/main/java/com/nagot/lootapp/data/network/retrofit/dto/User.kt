package com.nagot.lootapp.data.network.retrofit.dto

class User(val id: String, val name: String,
           val username: String, val email: String,
           val address: UserAddress, val phone: String,
           val website: String, val company: UserCompany) {

    class UserAddress(val street: String, val suite: String,
                      val city: String, val zipcode: String,
                      val geo: UserGeo) {

        class UserGeo(val lat: String, val lng: String)

    }

    class UserCompany(val name: String, val catchPhrase: String,
                      val bs: String)


}
