package xyz.jaybryantc.androidexam.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "person_table")
data class PersonEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    @ColumnInfo(name = "first_name")
    val firstName: String?,

    @ColumnInfo(name = "last_name")
    val lastName: String?,

    @ColumnInfo(name = "birthday")
    val birthday: Date?,

    @ColumnInfo(name = "email_address")
    val emailAddress: String?,

    @ColumnInfo(name = "mobile_number")
    val mobileNumber: String?,

    @ColumnInfo(name = "address")
    val address: String?,

    @ColumnInfo(name = "contact_person")
    val contactPerson: String?,

    @ColumnInfo(name = "contact_phone_number")
    val contactPhoneNumber: String?
)
