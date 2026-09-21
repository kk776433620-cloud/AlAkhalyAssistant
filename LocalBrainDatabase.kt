package com.alakhaly.assistant

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Database
import androidx.room.RoomDatabase

@Entity(tableName = "user_memory")
data class UserMemory(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val key: String,
    val value: String,
    val timestamp: Long = System.currentTimeMillis()
)

@Dao
interface MemoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMemory(memory: UserMemory)

    @Query("SELECT * FROM user_memory WHERE key = :key LIMIT 1")
    suspend fun getMemory(key: String): UserMemory?

    @Query("SELECT * FROM user_memory ORDER BY timestamp DESC")
    suspend fun getAllMemories(): List<UserMemory>
}

@Database(entities = [UserMemory::class], version = 1, exportSchema = false)
abstract class LocalBrainDatabase : RoomDatabase() {
    abstract fun memoryDao(): MemoryDao
}
