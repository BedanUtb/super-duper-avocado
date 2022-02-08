package com.uni.bedanova_pma_project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.gms.auth.api.signin.GoogleSignInOptions


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_sec = findViewById<Button>(R.id.button_login)
        button_sec.setOnClickListener{
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)

        }

        val button_fir = findViewById<Button>(R.id.button_register)
        button_fir.setOnClickListener{
            val text = findViewById<TextView>(R.id.text_welcome)
            text.text = "Damn look at it!"

        }

        //val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
          //      .requestEmail()
            //    .build()
        /*val button_try = findViewById<Button>(R.id.button_try)
        button_try.setOnClickListener{
           //getData()
            Toast.makeText(this, "Clicked.", Toast.LENGTH_LONG).show()
        }*/



        /*val button_fir = findViewById<Button>(R.id.button_first)
        button_fir.setOnClickListener{
            val text = findViewById<TextView>(R.id.text_welcome)
            text.text = "Damn look at it!"
        }

        val button_sec = findViewById<Button>(R.id.button_second)
        button_sec.setOnClickListener{
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }*/
    }
    fun getData(v: View?) {
    //fun getData() {
        val textView = findViewById<View>(R.id.text_welcome) as TextView

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "http://api.open-notify.org/iss-now.json"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
                Request.Method.GET, url,
                { response -> // Display result of the response to string.
                    //textView.text = "Response is: $response"
                    Log.i("Recieved: ", response.toString())
                    textView.text = response.toString()
                },
                {
                    Log.i("Error", "Did not work")
                })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }

}
fun main(args: Array<String>){
    var first =20
    println("The sum is ${first + first}")

}



