package info.chirikualii.newsapi_coroutine.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import info.chirikualii.newsapi_coroutine.data.remote.response.Article


/**
 * Created by chirikuAlii on 26/06/2020.
 * github.com/chirikualii
 */

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addArticle(articleEnitity: ArticleEnitity)

    @Query("SELECT * FROM article")
    suspend fun getArticle() :List<ArticleEnitity>
}