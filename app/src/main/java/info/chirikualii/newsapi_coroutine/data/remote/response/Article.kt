package info.chirikualii.newsapi_coroutine.data.remote.response


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Article(
    @SerializedName("author")
    var author: String?,
    @SerializedName("content")
    var content: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("publishedAt")
    var publishedAt: String?,
    @SerializedName("source")
    var source: Source?,
    @SerializedName("title")
    var title: String?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("urlToImage")
    var urlToImage: String?
):Parcelable{

    override fun equals(other: Any?): Boolean {

        if(javaClass != other?.javaClass){
            return false
        }

        other as Article

        if(author != other.author){
            return false
        }

        if(content != other.content){
            return false
        }

        if(description != other.description){
            return false
        }

        if(publishedAt != other.publishedAt){
            return false
        }

        if(source != other.source){
            return false
        }

        if(title != other.title){
            return false
        }

        if(url != other.url){
            return false
        }

        if(urlToImage != other.urlToImage){
            return false
        }
        return true
    }
}