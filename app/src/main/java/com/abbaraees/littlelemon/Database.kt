package com.abbaraees.littlelemon

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query
import androidx.room.RoomDatabase



@Entity(tableName="menu", primaryKeys = ["id"])
data class MenuItemRoom(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val category: String
)

@Dao
interface MenuDao {
    @Query("SELECT * FROM menu")
    suspend fun getAllMenus(): List<MenuItemRoom>

    @Insert
    suspend fun insertAll(vararg menu: MenuItemRoom)

    @Query("SELECT (SELECT COUNT (*) FROM menu) == 0")
    suspend fun isEmpty(): Boolean
}

@Database(entities = [MenuItemRoom::class], version = 1)
abstract class MenuDatabase: RoomDatabase() {
    abstract fun menuDao(): MenuDao
}