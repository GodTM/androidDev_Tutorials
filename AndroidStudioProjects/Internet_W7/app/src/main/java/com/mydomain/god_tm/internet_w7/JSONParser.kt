package com.mydomain.god_tm.internet_w7

import android.content.Context
import android.os.AsyncTask
import android.widget.TextView
import android.widget.Toast
import org.json.JSONArray
import org.json.JSONObject

class JSONParser(private var c: Context, private var jsonData:String , private var myTextView:TextView): AsyncTask<Void , Void ,Boolean>() {


    private var users = ArrayList<User>()

    override fun onPreExecute() {
        super.onPreExecute()
    }

    override fun doInBackground(vararg params: Void?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return parse()
    }

    override fun onPostExecute(isParsed: Boolean?) {
        super.onPostExecute(isParsed)
        if(isParsed!!){

            myTextView.text = "Parse success"+ users.size + " "+ users[users.size -1].getName() + users[users.size - 1].getEmail()+" " +
                    users[users.size -1].getUserName()
        }
        else{
            Toast.makeText(c , "unable to parse the text " , Toast.LENGTH_LONG).show()
            Toast.makeText(c , "this is the data we are trying to parse "+ jsonData , Toast.LENGTH_LONG).show()
        }
    }

    fun parse():Boolean{
        try{

            ja = JSONArray(jsonData)
            jo = JSONObject
        }
    }

}