package xyz.jaybryantc.androidexam.model

import android.os.Parcelable
import java.util.Date
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    val id: Long,
    val firstName: String?,
    val lastName: String?,
    val birthday: Date?,
    val emailAddress: String?,
    val mobileNumber: String?,
    val address: String?,
    val contactPerson: String?,
    val contactPhoneNumber: String?
) : Parcelable
