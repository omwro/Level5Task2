package nl.OmerErdem.madlvl5t2.model

import androidx.room.*
import java.util.*

@Entity(tableName = "gameTable")
data class Game (
    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "platform")
    var platform: String,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: Date
)