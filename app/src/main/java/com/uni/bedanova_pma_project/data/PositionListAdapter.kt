package com.uni.bedanova_pma_project.data

import android.app.Person
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.uni.bedanova_pma_project.AboutActivity
import com.uni.bedanova_pma_project.GetLocationActivity
import com.uni.bedanova_pma_project.R
import com.uni.bedanova_pma_project.model.Position


class PositionListAdapter(private val list: ArrayList<Position>,
private val context: Context) : RecyclerView.Adapter<PositionListAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
    val view = LayoutInflater.from(context).inflate(R.layout.list_row, parent, false)
        return ViewHolder(view, context)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.bindItem(list[position])
                //holder.itemView
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View, context: Context) : RecyclerView.ViewHolder(itemView) {
    fun bindItem(position: Position){
        var pos: TextView = itemView.findViewById(R.id.text2) as TextView
        var timestamp: TextView = itemView.findViewById(R.id.text1) as TextView

        pos.text = "Position: " + position.lat.toString() +", "+ position.lon.toString()
        timestamp.text = "Date: " + position.date_time

        itemView.setOnClickListener {
            Toast.makeText(context,pos.text, Toast.LENGTH_LONG).show()

            val intent = Intent(context, GetLocationActivity::class.java)
            intent.putExtra("timestamp", position.date_time)
            intent.putExtra("lat", position.lat)
            intent.putExtra("lon", position.lon)

            context.startActivity(intent)
            }
        }
    }
}

