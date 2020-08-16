package com.erej.a40k9thscoring

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_battle_big.*


class PlayGameActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //do something idk
        super.onCreate(savedInstanceState)

        setTheme(R.style.AppTheme_NoActionBar)
        //set contentView
        setContentView(R.layout.layout_battle_big)
        //Fetch the battle date from MainActivity
        val battleObject = intent.getSerializableExtra("battle") as Battle

        //get a super ugly list of secondaries ... but it works ... for now
        val secondaryList = SecondaryList()

        //store fragments
        val p1Fragment1 = FragmentSecondaryCounter(battleObject,secondaryList.getSecondaries()[battleObject.p1Secondary1],battleObject.p1Secondary1Counter )
        val p1Fragment2 = FragmentSecondaryCounter(battleObject,secondaryList.getSecondaries()[battleObject.p1Secondary2],battleObject.p1Secondary2Counter )
        val p1Fragment3 = FragmentSecondaryCounter(battleObject,secondaryList.getSecondaries()[battleObject.p1Secondary2],battleObject.p1Secondary3Counter )

        val p2Fragment1 = FragmentSecondaryCounter(battleObject,secondaryList.getSecondaries()[battleObject.p2Secondary1],battleObject.p2Secondary1Counter )
        val p2Fragment2 = FragmentSecondaryCounter(battleObject,secondaryList.getSecondaries()[battleObject.p2Secondary2],battleObject.p2Secondary2Counter )
        val p2Fragment3 = FragmentSecondaryCounter(battleObject,secondaryList.getSecondaries()[battleObject.p2Secondary3],battleObject.p2Secondary3Counter )


        //set fragments
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFirstFragment,p1Fragment1)
            replace(R.id.flSecondFragment,p1Fragment2)
            replace(R.id.flThirdFragment,p1Fragment3)

            replace(R.id.flFourthFragment,p2Fragment1)
            replace(R.id.flFifthFragment,p2Fragment2)
            replace(R.id.flSixthFragment,p2Fragment3)
            commit()
        }


        buttonNext.setOnClickListener{

            //update data from fragments
            battleObject.p1Secondary1Counter = p1Fragment1.secondaryCounter
            battleObject.p1Secondary2Counter = p1Fragment2.secondaryCounter
            battleObject.p1Secondary3Counter = p1Fragment3.secondaryCounter

            battleObject.p2Secondary1Counter = p2Fragment1.secondaryCounter
            battleObject.p2Secondary2Counter = p2Fragment2.secondaryCounter
            battleObject.p2Secondary3Counter = p2Fragment3.secondaryCounter

            battleViewModel.update(battleObject)


            startActivity(Intent(this,MainActivity::class.java))

        }









        



    }

}