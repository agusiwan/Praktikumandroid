package com.raktikumandroid

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game.*
import kotlin.random.Random

private const val BATU = 1
private const val GUNTING = 2
private const val KERTAS = 3

class GameActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_USER = "username"
    }

    var username:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        username = intent.getStringExtra(EXTRA_USER)

        var PilihanKomputer:Int
        var pilihanPlayer:Int

        buttonBatu.setOnClickListener{
            textPlayer.text = "BATU"
            pilihanPlayer = BATU
            PilihanKomputer = getPilihanKomputer()
            textKomputer.text = ""
                textHasil.text = suwit(pilihanPlayer,pilihanKomputer = 1)
                showPilihanKomputer(getPilihanKomputer()
            )

        }

        buttonGunting.setOnClickListener{
            textPlayer.text = "GUNTING"
            pilihanPlayer = GUNTING
            PilihanKomputer = getPilihanKomputer()
            textKomputer.text = ""
                textHasil.text = suwit(pilihanPlayer,pilihanKomputer = 2)
                showPilihanKomputer(getPilihanKomputer()
            )

        }

        buttonKertas.setOnClickListener{
            textPlayer.text = "KERTAS"
            pilihanPlayer = KERTAS
            PilihanKomputer = getPilihanKomputer()
            textKomputer.text = ""
                textHasil.text = suwit(pilihanPlayer, pilihanKomputer = 3)
                showPilihanKomputer(getPilihanKomputer()
            )
        }


    }

    fun getPilihanKomputer():Int{
        return Random.nextInt(+ 3) + 1;
    }
    fun suwit (pilihanPlayer: Int, pilihanKomputer: Int):String{
        var hasil: String = ""
        if (pilihanPlayer == pilihanKomputer){
            hasil = "SERI"
            textHasil.setTextColor(Color.GRAY)
        }
        else if((pilihanPlayer == BATU && pilihanKomputer == KERTAS) ||
            (pilihanPlayer == GUNTING && pilihanKomputer == BATU) ||
            (pilihanPlayer == KERTAS && pilihanKomputer == GUNTING)){
            hasil = username +" LOSE"
            textHasil.setTextColor(Color.RED)
        }
        else{
            hasil =  username +" WIN"
            textHasil.setTextColor(Color.GREEN)
        }

        return hasil
    }

    fun showPilihanKomputer(pilihanKomputer: Int){
       when (pilihanKomputer){
           1 -> textKomputer.text = "Komputer memilih: BATU"
           2 -> textKomputer.text = "Komputer memilih: GUNTING"
           3 -> textKomputer.text = "Komputer memilih: KERTAS"
       }

    }
}