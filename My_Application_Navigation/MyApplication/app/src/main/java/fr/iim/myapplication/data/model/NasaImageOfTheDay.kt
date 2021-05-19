package fr.iim.myapplication.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NasaImageOfTheDay(

    @PrimaryKey(autoGenerate = true)
    var id: Int,

    var copyright : String?,
    var date : String?,
    var explanation : String?,
    var hdurl : String?,
    var media_type : String?,
    var service_version : String?,
    var title : String?,
    var url : String?,
)
