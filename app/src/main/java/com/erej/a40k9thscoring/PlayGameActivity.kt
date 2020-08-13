package com.erej.a40k9thscoring

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
<<<<<<< HEAD
import kotlinx.android.synthetic.main.fragment_battle.*
=======
import kotlinx.android.synthetic.main.layout_battle_big.*
>>>>>>> 1fc6641... Merge remote-tracking branch 'origin/master'


class PlayGameActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //do something idk
        super.onCreate(savedInstanceState)
        //set contentView
        setContentView(R.layout.layout_battle_big)
        //Fetch the battle date from MainActivity
        val battleObject = intent.getSerializableExtra("battle") as Battle

<<<<<<< HEAD
        val firstFragment = BattleFragment(battleObject)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,firstFragment)
            intent.

=======
        //get a super ugly list of secondaries ... but it works ... for now
        val secondaryList = SecondaryList()

        //store fragments
        val p1Fragment1 = AssassinateFragment(battleObject,secondaryList.getSecondaries()[battleObject.p1Secondary1],1 )
        val p1Fragment2 = AssassinateFragment(battleObject,secondaryList.getSecondaries()[battleObject.p1Secondary2],2 )
        val p1Fragment3 = AssassinateFragment(battleObject,secondaryList.getSecondaries()[battleObject.p1Secondary2],3 )
>>>>>>> 1fc6641... Merge remote-tracking branch 'origin/master'

        val p2Fragment1 = AssassinateFragment(battleObject,secondaryList.getSecondaries()[battleObject.p2Secondary1],4 )
        val p2Fragment2 = AssassinateFragment(battleObject,secondaryList.getSecondaries()[battleObject.p2Secondary2],5 )
        val p2Fragment3 = AssassinateFragment(battleObject,secondaryList.getSecondaries()[battleObject.p2Secondary3],6 )


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
            startActivity(Intent(this,MainActivity::class.java))

        }









        



    }

}