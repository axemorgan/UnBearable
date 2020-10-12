package com.alex.morgan.bearlist.list

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alex.morgan.bearlist.Bear
import com.alex.morgan.bearlist.R
import com.squareup.picasso.Picasso
import java.util.*

class BearAdapter(private val selectionListener: (Bear) -> Unit) :
    RecyclerView.Adapter<BearAdapter.BearViewHolder>() {

    private val bearList: ArrayList<Bear>

    inner class BearViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imageView: ImageView
        var name: TextView

        init {
            name = itemView.findViewById(R.id.name)
            imageView = itemView.findViewById(R.id.profile_image)
        }
    }

    init {
        this.setHasStableIds(true)
        this.bearList = ArrayList()
    }

    fun setBears(bears: Collection<Bear>) {
        this.bearList.clear()
        this.bearList.addAll(bears)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BearViewHolder {
        return BearViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.bear_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BearViewHolder, position: Int) {
        val bear = bearList[position]

        holder.name.text = bear.name
        holder.itemView.setOnClickListener {
            selectionListener.invoke(bear)
        }
        val pablo = Picasso.Builder(holder.itemView.context)
            .listener { picasso, uri, exception -> Log.e("PICASSO", "Image failed", exception) }
            .build()

        pablo.load(bear.profileImageUrl)
            .error(android.R.drawable.ic_dialog_alert)
            .placeholder(R.drawable.grey_bear)
            .resize(200, 200)
            .centerCrop()
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return bearList.size
    }

    override fun getItemId(position: Int): Long {
        return bearList[position].hashCode().toLong()
    }
}
