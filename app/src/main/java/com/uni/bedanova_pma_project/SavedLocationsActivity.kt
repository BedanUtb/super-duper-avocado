package com.uni.bedanova_pma_project

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.icu.text.Transliterator
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uni.bedanova_pma_project.data.PositionListAdapter
import com.uni.bedanova_pma_project.model.Position
import java.sql.Timestamp
import java.util.*
import kotlin.collections.ArrayList

class SavedLocationsActivity : AppCompatActivity() {

    private var adapter: PositionListAdapter? = null
    var positionList: ArrayList<Position>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved_locations)

        /*val button_get_location = findViewById<Button>(R.id.button_get_location)
        button_get_location.setOnClickListener{
            val intent = Intent(this, GetLocationActivity::class.java)
            startActivity(intent)
        }*/

        positionList = ArrayList<Position>()
        layoutManager = LinearLayoutManager(this)
        adapter=PositionListAdapter(positionList!!,this)

        // set the list

        val recycler_view :RecyclerView = findViewById(R.id.recycler_view) as RecyclerView
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = adapter



        readTextFile()

        // load data
        /*for(i in 0..9){
            val position = Position()
            position.lat = 9.9
            position.lon = 1.0
            position.date_time = "date time 10:00"
            positionList!!.add(position)
        }*/
        adapter!!.notifyDataSetChanged()

        val button_back = findViewById<Button>(R.id.button_back)
        button_back.setOnClickListener{
            onBackPressed()
        }

    }

    fun readTextFile() {

        val SHARED_PREFERENCES_FILE_NAME = "appFileInternal"
        val myIntKeyInternal = "myintkeyinternal"
        val myIntKeyInternalDefault = 1
        val myStringKeyInternal = "mystringkeyInternal"
        val myStringKeyInternalDefault = "N/A"

        val sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, MODE_PRIVATE)
        val output: String = sharedPreferences.getString(myStringKeyInternal, myStringKeyInternalDefault).toString().trim()
        Log.i("O O O", output)



        val list = output.split("\n")
        list.forEach {
            Log.i("TAGTAG", it)
            val list_splited = it.split(",")

            val position = Position()
            position.lat = list_splited.get(1).toDouble()
            position.lon = list_splited.get(2).toDouble()

            //val date= list_splited.get(0)
            //val newDate=getDateTime(date)

            //position.date_time = newDate
            position.date_time = list_splited.get(0)
            positionList!!.add(position)
        }
    }

   /* fun getDateTime(s: String): String? {
        try {
            val sdf = SimpleDateFormat("MM/dd/yyyy")
            val netDate = Date(s.toLong() * 1000)
            return sdf.format(netDate)
        } catch (e: Exception) {
            return e.toString()
        }
    }*/
}