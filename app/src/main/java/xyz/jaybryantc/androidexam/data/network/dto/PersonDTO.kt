package xyz.jaybryantc.androidexam.data.network.dto

import com.google.gson.annotations.SerializedName
import java.util.Date

data class PersonDTO(
    @SerializedName("id")
    val id: Long,

    @SerializedName("firstName")
    val firstName: String?,

    @SerializedName("lastName")
    val lastName: String?,

    @SerializedName("birthday")
    val birthday: Date?,

    @SerializedName("emailAddress")
    val emailAddress: String?,

    @SerializedName("mobileNumber")
    val mobileNumber: String?,

    @SerializedName("address")
    val address: String?,

    @SerializedName("contactPerson")
    val contactPerson: String?,

    @SerializedName("contactPhoneNumber")
    val contactPhoneNumber: String?
)
