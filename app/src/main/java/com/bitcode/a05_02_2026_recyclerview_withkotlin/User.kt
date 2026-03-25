package com.bitcode.a05_02_2026_recyclerview_withkotlin

import java.io.Serializable

class User (
    var userId : Int,
    var userName : String,
    var userCity : String
) : Serializable{
    override fun toString(): String {
        return "user id : $userId , username : $userName , usercity : $userCity"
    }
}