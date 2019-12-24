package com.example.happydatabase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat

class FeelingAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<FeelingAdapter.FeelingViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context) //show the layout
    private var feelings = emptyList<Feeling>() // Cached copy of feelings


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeelingViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return FeelingViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return feelings.size
    }

    override fun onBindViewHolder(holder: FeelingViewHolder, position: Int) {
        val feelingRec = feelings.get(position)

        holder.textViewMode.text = feelingRec.mode.toString()
        holder.textViewRemark.text = feelingRec.remarks
        holder.textViewDate.text = SimpleDateFormat("yyyy.MM.dd.HH.MM").format(feelingRec.created_at)
    }

    inner class FeelingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewMode: TextView = itemView.findViewById(R.id.textViewMode)
        val textViewRemark: TextView = itemView.findViewById(R.id.textViewRemark)
        val textViewDate: TextView = itemView.findViewById(R.id.textViewDate)

    }

    internal fun setFeeling(feelings : List<Feeling>){
        this.feelings = feelings

    }


}