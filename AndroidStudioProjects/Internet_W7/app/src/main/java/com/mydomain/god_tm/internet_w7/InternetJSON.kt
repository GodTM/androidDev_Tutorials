package com.mydomain.god_tm.internet_w7

import android.content.Context
import android.os.AsyncTask
import android.widget.TextView
import android.widget.Toast
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException

class InternetJSON(private var context: Context, private var isOnUrl: String , private var myTextView:TextView):

        AsyncTask<Void , Void , String >() {

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg params: Void?): String {

        return donwload()

    }


    // trying the not nullable approach 1st
    override fun onPostExecute(jsonData: String) {
        super.onPostExecute(jsonData)
        if(jsonData.startsWith("URL ERROR")){

            val error = jsonData
            Toast.makeText(context , error , Toast.LENGTH_LONG).show()
            Toast.makeText(context , " Connection problem : Wrong URL" , Toast.LENGTH_LONG).show()


        }
        else if(jsonData.startsWith("CONNECT ERROR")){

            val error = jsonData
            Toast.makeText(context , error , Toast.LENGTH_LONG).show()
            Toast.makeText(context , "Connection problem : cannot connect", Toast.LENGTH_LONG).show()
        }
        else{

            JSONParser(context , )
        }
    }


    private fun connect(jsonURL:String):Any{

            try{

                val url = URL(jsonURL)
                val con = url.openConnection() as HttpURLConnection

                con.requestMethod = "GET"
                con.connectTimeout = 15000
                con.readTimeout = 15000
                con.doInput = true

                return con
            }catch (e:MalformedURLException){
                e.printStackTrace()
                return "Connect Error" + e.message
            }catch ()
    }


    private fun download():String{

        val connection = connect(jsonURL)
        if(connection.toString().startsWith("ERROR")){
            return connection.toString()
        }

        try{
            val con = connection as HttpURLConnection
            if(con.responseCode==200){
                val bis = BufferedInputStream(con.inputStream)
                val br = BufferedReader(InputStreamReader(bis))
                val jsonData = StringBuffer()
                var line:String?

                do{

                    line
                }
            }
        }catch ()
    }

}