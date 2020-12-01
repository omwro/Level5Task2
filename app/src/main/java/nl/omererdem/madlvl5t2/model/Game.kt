package nl.OmerErdem.madlvl5t2.model

import androidx.room.*
import java.util.*

@Entity(tableName = "gameTable")
class Game (
    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "platform")
    var platform: String,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: Date,

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Long?
)