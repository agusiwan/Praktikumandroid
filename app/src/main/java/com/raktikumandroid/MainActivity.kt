package com.raktikumandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.app.AlertDialog
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView1 = findViewById<TextView>(R.id.Panjang)
        val button1 =  findViewById<Button>(R.id.button1)


        textView1.setOnClickListener {

            Toast.makeText(this, "hai",Toast.LENGTH_LONG).show()
        }


        button1.setOnClickListener{
            val intent  =   Intent(this@MainActivity,HitungActivity::class.java)
            startActivity(intent)
        }

        buttonGunting.setOnClickListener{
            var alerts : AlertDialog.Builder = AlertDialog.Builder(this)
            val editUser = EditText(this)
            alerts.setTitle("Username")
            alerts.setMessage("Hai")
            alerts.setView(editUser)

            alerts.setPositiveButton("Yes"){dialog, which ->
                var username = editUser.text.toString()
                val intent  =   Intent(this@MainActivity,GameActivity::class.java)
                intent.putExtra(GameActivity.EXTRA_USER, username)
                startActivity(intent)

            }

            alerts.setNegativeButton("No"){dialog, which ->

            }

            alerts.show()

        }
    }

}
