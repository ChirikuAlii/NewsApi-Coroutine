package info.chirikualii.newsapi_coroutine.data.remote.response


import com.google.gson.annotations.SerializedName

data class HeadlineResponse(
    @SerializedName("articles")
    var articles: List<Article>?,
    @SerializedName("status")
    var status: String?,
    @SerializedName("totalResults")
    var totalResults: Int?
)