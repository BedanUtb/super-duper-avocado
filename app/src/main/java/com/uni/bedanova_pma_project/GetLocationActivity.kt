package com.uni.bedanova_pma_project


import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.android.gms.tasks.Task
import org.json.JSONObject
import java.io.*

class GetLocationActivity : AppCompatActivity(), OnMapReadyCallback {



    var mGoogleMap: GoogleMap? = null

    var iss_latitude :Double? = 40.730610
    var iss_longitude :Double? = -73.935242
    var iss_timestamp :String? = "time"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_location)

        val bundle: Bundle? = intent.extras
        if (bundle!=null){
            iss_timestamp=bundle.getString("timestamp")
            iss_latitude=bundle.getDouble("lat")
            iss_longitude=bundle.getDouble("lon")
        }

        Log.i("Recieved: ", iss_latitude.toString())

        val url = "http://api.open-notify.org/iss-now.json"
        val url2 = "http://raw.githubusercontent.com/pdichone/UIUX-Android-Course/master/Quotes.json%20"


        val button_back = findViewById<Button>(R.id.button_back)
        button_back.setOnClickListener{
            onBackPressed()
            Toast.makeText(this, "Clicked.", Toast.LENGTH_LONG).show()
        }
        val button_save = findViewById<Button>(R.id.button_save)
        button_save.setOnClickListener{

            getInputString(iss_timestamp.toString(), iss_latitude.toString(),iss_longitude.toString())

            Toast.makeText(this, "Saved.", Toast.LENGTH_LONG).show()
        }


       /* val button_show_map = findViewById<Button>(R.id.button_show_map)
        button_show_map.setOnClickListener{
            //readFile()
            readTextFile()
        }*/


        // getData()
        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapview) as SupportMapFragment
        mapFragment.getMapAsync(this)


    }


    fun getInputString(timestamp: String,lan: String, lon: String){
        val stringBuilder: StringBuilder = StringBuilder()
        stringBuilder.append(timestamp + "," + lan + "," + lon)
        val message = stringBuilder.toString()
        if(message.equals("")) {
            Log.i("Nothing saved.", message)
        }else{
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            writeInputToFile(message)
        }
    }

    fun writeInputToFile(message: String){
        val SHARED_PREFERENCES_FILE_NAME = "appFileInternal"
        val myIntKeyInternal = "myintkeyinternal"
        val myStringKeyInternal = "mystringkeyInternal"
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putInt(myIntKeyInternal, 1)
        val output: String? = sharedPreferences.getString(myStringKeyInternal, "")

        editor.putString(myStringKeyInternal, output+message+"\n")
        editor.apply()

    }

    /*
    fun readTextFile(){

        val SHARED_PREFERENCES_FILE_NAME = "appFileInternal"
        val myIntKeyInternal = "myintkeyinternal"
        val myIntKeyInternalDefault = 1
        val myStringKeyInternal = "mystringkeyInternal"
        val myStringKeyInternalDefault = "N/A"

        val sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_FILE_NAME, MODE_PRIVATE)
        val output: String = sharedPreferences.getString(myStringKeyInternal, myStringKeyInternalDefault).toString()
        Log.i("O O O",output)

        val list = output.split("\n")
        list.forEach{
            Log.i("TAGTAG",it)
        }
    }


    private fun loadData()
    {
        var myExternalFile:File = File(getExternalFilesDir(null), "saved_locations.txt")
        val filename = "saved_locations.txt"
        myExternalFile = File(getExternalFilesDir(null),filename)
        var fileInputStream =FileInputStream(myExternalFile)
        var inputStreamReader: InputStreamReader = InputStreamReader(fileInputStream)
        val bufferedReader: BufferedReader = BufferedReader(inputStreamReader)
        val stringBuilder: StringBuilder = StringBuilder()
        var text: String? = null
        while ({ text = bufferedReader.readLine(); text }() != null) {
            stringBuilder.append(text)
        }
        fileInputStream.close()
        Log.i("O O O O O O O O",stringBuilder.toString())
    }

    fun storeData(store :Boolean) {
        val path = this.getExternalFilesDir(null)
        val letDirectory = File(path, "SAVED")
        letDirectory.mkdirs()
        val file = File(letDirectory, "Records.txt")
        if(store==true) {
            val record: String = ""
            file.appendText("record goes not here")
            //val inputAsString = FileInputStream(file).bufferedReader().use { it.readText() }
            //Log.i("OOOOOOOOOOoo XXX : ", inputAsString)
        }
        else{
            val inputAsString = FileInputStream(file).bufferedReader().use { it.readText() }
            Log.i("OOOOOOOOOOoo XXX : ", inputAsString)
        }
    }

    fun readStored(){

       // Toast.makeText(baseContext, "File saved successfully!", Toast.LENGTH_SHORT).show()
    }
*/
    /*

    private fun saveList(list: List<Int>) {
        try {
            val file: File = Environment.getDataDirectory()
            val filename = File(file, "saved_pos.xml")
            val fos = FileOutputStream(filename)
            val  out = ObjectOutputStream(fos)
            out.writeObject(list)
            out.close()
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
    }

    private fun readList() {
        try {
            val file = Environment.getDataDirectory()
            val filename = File(file, "saved_pos.xml")
            val fis = FileInputStream(filename)
            val ins = ObjectInputStream(fis)
            val list = ins.readObject() as List<Int>
            Toast.makeText(this, "Saved.", Toast.LENGTH_LONG).show()
            ins.close()
        } catch (ex: IOException) {
            ex.printStackTrace()
            Toast.makeText(this, "no!." , Toast.LENGTH_LONG).show()
        } catch (ex: ClassNotFoundException) {
            ex.printStackTrace()
            Toast.makeText(this, "no2", Toast.LENGTH_LONG).show()
        }
    }
    */

    override fun onMapReady(googlemap: GoogleMap?) {
        mGoogleMap = googlemap

        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapview) as SupportMapFragment

        val latitude :Double? = iss_latitude
        val longitude :Double? = iss_longitude
        val position = LatLng(latitude!!, longitude!!)

        mGoogleMap!!.moveCamera(CameraUpdateFactory.newLatLng(position))

        mGoogleMap?.addMarker(MarkerOptions().position(position).title("My Name"))


        Toast.makeText(
                this,
                "My Location: " + latitude.toString() + "," + longitude.toString(),
                Toast.LENGTH_LONG
        ).show()
    }

    fun addTask(t: Task<*>?) {

    }



    fun generateSmallIcon(): Bitmap {
        val height = 100
        val width = 100
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.ic_launcher)
        return Bitmap.createScaledBitmap(bitmap, width, height, false)
    }

    fun getData(v: View?) {

        val textView = findViewById<View>(R.id.text_header) as TextView
        var reply : String = "" // try

        val queue = Volley.newRequestQueue(this)
        val url = "http://api.open-notify.org/iss-now.json"

        val stringRequest = StringRequest(
                Request.Method.GET, url,
                //Response.Listener<String> { response ->
                { response -> // Display result of the response to string.

                    val jresponse = JSONObject(response.toString())

                    val pos = jresponse.getString("iss_position")
                    val posit = JSONObject(pos.toString())
                    val lat = posit.getString("latitude")
                    val lon = posit.getString("longitude")
                    val time = jresponse.getString("timestamp")


                    iss_latitude = lat.toDouble()
                    iss_longitude = lon.toDouble()
                    iss_timestamp = time.toString()

                    val position = LatLng(iss_latitude!!, iss_longitude!!)
                    if (mGoogleMap != null) { //prevent crashing if the map doesn't exist yet (eg. on starting activity)
                        //
                        //
                        mGoogleMap?.clear()

                        mGoogleMap?.addMarker(

                                MarkerOptions()
                                        .position(position)
                                        .title("Melbourne")
                                        .snippet("Population: 4,137,400")
                                        .icon(BitmapDescriptorFactory.fromBitmap(generateSmallIcon()))
                        )
                        mGoogleMap!!.moveCamera(CameraUpdateFactory.newLatLng(position))
                        // add markers from database to the map
                    }

                    Log.i("Recieved: ", response.toString())

                    Log.i("pos: ", pos.toString() + "timestamp:" + time.toString())
                    //Log.i("lat: ", jsonArray[0].toString() + jsonArray[1].toString())
                    Log.i("lat: ", lat.toString() + "lon:" + lon.toString())
                    //textView.text = response.toString()
                },
                {
                    Log.i("Error", "Did not work")
                })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }
}