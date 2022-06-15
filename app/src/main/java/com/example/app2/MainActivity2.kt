package com.example.app2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val texto = findViewById<TextView>(R.id.txtEjemplo)
        val url = "https://gorest.co.in/public/v1/users"

        val aux = Volley.newRequestQueue(this)

        val stringRequest: StringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                texto.text = "Respuesta JSON: ${response.substring(0, 800)}"
            },
            { error -> texto.text = "Error!!"
                error.printStackTrace()
            })

        aux.add(stringRequest)
    }
    fun botonRegresar(view: View){
        onBackPressed();
    }
}