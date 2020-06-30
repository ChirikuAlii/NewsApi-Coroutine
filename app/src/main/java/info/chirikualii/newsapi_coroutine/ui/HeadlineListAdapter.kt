package info.chirikualii.newsapi_coroutine.ui

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import info.chirikualii.newsapi_coroutine.R
import info.chirikualii.newsapi_coroutine.data.local.ArticleEnitity
import info.chirikualii.newsapi_coroutine.data.remote.response.Article
import info.chirikualii.newsapi_coroutine.utils.timeMillisToDateTime
import info.chirikualii.newsapi_coroutine.utils.view.OnItemClicked
import kotlinx.android.synthetic.main.item_article.view.*
import java.text.SimpleDateFormat
import java.time.Instant


/**
 * Created by chirikuAlii on 26/06/2020.
 * github.com/chirikualii
 */
class HeadlineListAdapter(val onItemClicked: OnItemClicked) : RecyclerView.Adapter<HeadlineListAdapter.HeadlineHolder>(){

    var items : ArrayList<ArticleEnitity> = arrayListOf()
    var listDataFiltered : ArrayList<ArticleEnitity> = arrayListOf()

    class HeadlineHolder(view: View) : RecyclerView.ViewHolder(view)


    fun addList(listData :ArrayList<ArticleEnitity>){
        val oldList = items
        val diffResult : DiffUtil.DiffResult =DiffUtil.calculateDiff(HeadlineListDiffCallback(
            oldList,listData
        ))

        items = listData
        listDataFiltered = listData
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlineHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article,parent,false)
        return HeadlineHolder(view)
    }

    override fun getItemCount(): Int {
       return listDataFiltered.size
    }

    override fun onBindViewHolder(holder: HeadlineHolder, position: Int) {
        val data = listDataFiltered[position]
        val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(data.publishedAt)

        holder.itemView.tv_title_article.text = data.title
        holder.itemView.tv_date.text = "Published at ${date.time.timeMillisToDateTime()}"


        Glide.with(holder.itemView.context)
            .load(data.urlToImage)
            .into(holder.itemView.iv_article)

        holder.itemView.setOnClickListener { onItemClicked.onArticleClicked(data) }

    }

    class HeadlineListDiffCallback(
        var oldList : ArrayList<ArticleEnitity>,
        var newList : ArrayList<ArticleEnitity>
    ):DiffUtil.Callback(){
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return (oldList[oldItemPosition].title == newList[newItemPosition].title)
        }

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].equals(newList[newItemPosition])
        }

    }
}