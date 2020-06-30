package info.chirikualii.newsapi_coroutine.data.local

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import info.chirikualii.newsapi_coroutine.data.remote.response.Source
import kotlinx.android.parcel.Parcelize


/**
 * Created by chirikuAlii on 26/06/2020.
 * github.com/chirikualii
 */

@Parcelize
@Entity(tableName = "article")
data class ArticleEnitity(
    @PrimaryKey
    @SerializedName("publishedAt")
    var publishedAt: String,
    @SerializedName("author")
    var author: String?,
    @SerializedName("content")
    var content: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("urlToImage")
    var urlToImage: String?
) : Parcelable