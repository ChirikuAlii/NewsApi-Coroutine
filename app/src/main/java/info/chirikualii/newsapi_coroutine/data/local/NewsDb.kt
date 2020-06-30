package info.chirikualii.newsapi_coroutine.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


/**
 * Created by chirikuAlii on 26/06/2020.
 * github.com/chirikualii
 */

@Database(
    entities = [ArticleEnitity::class],
    version = 1
)
abstract class NewsDb :RoomDatabase(){

    abstract fun articleDao() :ArticleDao

    companion object{

        fun getInstance(context: Context): NewsDb?{
            return Room.databaseBuilder(context.applicationContext,
                NewsDb::class.java, "news.db")
                //.addMigrations(MIGRATION1_2, MIGRATION2_3, MIGRATION3_4, MIGRATION4_5, MIGRATION5_6)
                .build()

        }
    }
}