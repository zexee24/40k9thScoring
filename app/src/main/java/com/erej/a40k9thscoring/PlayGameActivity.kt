package com.erej.a40k9thscoring

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class PlayGameActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //do something idk
        super.onCreate(savedInstanceState)

        setTheme(R.style.AppTheme_NoActionBar)
        //set contentView
        setContentView(R.layout.layout_battle_big)
        //Fetch the battle date from MainActivity
        val battleObject = intent.getSerializableExtra("battle") as Battle

        val secondaryList = SecondaryList()

        val firstFragment = AssassinateFragment(battleObject,secondaryList.getSecondaries()[battleObject.p1Secondary1] )

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,firstFragment)




            commit()
        }








        



    }

}