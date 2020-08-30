package com.mrspd.alarmapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")
        Button1.setOnClickListener {



            myRef.setValue("B")
        }
        Button2.setOnClickListener {
            val database = FirebaseDatabase.getInstance()
            myRef.setValue("A")
        }

        // Read from the database

        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value =
                    dataSnapshot.getValue(String::class.java)!!
                if (value =="A"){
                        Toast.makeText(this@MainActivity, "Ringed A", Toast.LENGTH_LONG).show()
                    }
                else{
                    Toast.makeText(this@MainActivity, "Ringed B", Toast.LENGTH_LONG).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
            }
        })
    }
}