package com.jayasri.studentdisplay
enum class LivingType{
    HOSTELLER,
    DAYSCHOLAR
}
enum class Gender{
    FEMALE,
    MALE,
    OTHER
}

data class StudentData(
    val fname: String,
    val lname: String,
    val department:String,
    val cgpa:Float,
    val livingType:LivingType=LivingType.HOSTELLER,
    val photo:String,
    val gender:Gender=Gender.FEMALE

){
    private val _id:Int=count++
    val id: String
        get():String{
            return "GCT-20260000{$id}"
        }
    companion object{
        private var count:Int=1
    }
}
