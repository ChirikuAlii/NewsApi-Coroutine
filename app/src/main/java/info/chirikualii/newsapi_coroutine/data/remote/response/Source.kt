package info.chirikualii.newsapi_coroutine.data.remote.response


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Source(
    @SerializedName("id")
    var id: String?,
    @SerializedName("name")
    var name: String?
): Parcelable