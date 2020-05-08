package com.raktikumandroid

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_game.*
import kotlin.random.Random

private const val BATU = 1
private const val GUNTING = 2
private const val KERTAS = 3

class GameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        var PilihanKomputer:Int
        var pilihanPlayer:Int

        buttonBatu.setOnClickListener{
            textPlayer.text = "BATU"
            pilihanPlayer = BATU
            PilihanKomputer = getPilihanKomputer()
            textKomputer.text = ""
            Handler().postDelayed({
                textHasil.text = suwit(pilihanPlayer, PilihanKomputer)
                showPilihanKomputer(PilihanKomputer)
            })

        }

        buttonGunting.setOnClickListener{
            textPlayer.text = "GUNTING"
            pilihanPlayer = GUNTING
            PilihanKomputer = getPilihanKomputer()
            textKomputer.text = ""
            Handler().postDelayed({
                textHasil.text = suwit(pilihanPlayer, PilihanKomputer)
                showPilihanKomputer(PilihanKomputer)
            })
            }

        buttonKertas.setOnClickListener{
            textPlayer.text = "KERTAS"
            pilihanPlayer = KERTAS
            PilihanKomputer = getPilihanKomputer()
            textKomputer.text = ""
            Handler().postDelayed({
                textHasil.text = suwit(pilihanPlayer, PilihanKomputer)
                showPilihanKomputer(PilihanKomputer)
            })
            }

    }

    fun getPilihanKomputer():Int{
        return Random().nextInt(3)+1;
    }

    fun suwit (pilihanPlayer: Int, PilihanKomputer: Int):String {
        var hasil: String = ""
        if (pilihanPlayer == PilihanKomputer) {
            hasil = "SERI"
            textHasil.setTextColor(Color.BLUE)
        }
        else if (pilihanPlayer == BATU && PilihanKomputer == KERTAS)
            (pilihanPlayer == GUNTING && PilihanKomputer == BATU)
        (pilihanPlayer == KERTAS && PilihanKomputer == GUNTING){
            hasil = "YOU LOSE"
            textHasil.setTextColor(Color.RED)
        }
        else
        run {
            hasil = "YOU WIN"
            textHasil.setTextColor(Color.GREEN)

        }


        return hasil
    }

    fun showPilihanKomputer(PilihanKomputer: Int){
        when (PilihanKomputer){
            1 -> textKomputer.text = "Komputer memilih BATU"
            2 -> textKomputer.text = "Komputer memilih GUNTING"
            3 -> textKomputer.text = "Komputer memilih KERTAS"
        }
    }

}