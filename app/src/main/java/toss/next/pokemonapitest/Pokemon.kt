package toss.next.pokemonapitest

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
data class Pokemon(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name")val name: String,
    @ColumnInfo(name = "onImage")val onImage: String,
    @ColumnInfo(name = "offImage")val offImage: String,
    @ColumnInfo(name = "type")val type: String
)
