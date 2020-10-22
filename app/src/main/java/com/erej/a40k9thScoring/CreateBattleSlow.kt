package com.erej.a40k9thScoring

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.erej.a40k9thScoring.classes.Battle
import com.erej.a40k9thScoring.classes.PrimaryList
import com.erej.a40k9thScoring.createBattleFragments.FragmentSelectBattleSize
import kotlinx.android.synthetic.main.create_battle_slow.*
import java.lang.NullPointerException

private lateinit var battleObject :Battle


class CreateBattleSlow :AppCompatActivity(){

    private fun getFragment(): Fragment{
        return when(battleObject.createCounter){
            -1 -> FragmentSelectBattleSize(battleObject)
            0 -> FragmentSelectBattleSize(battleObject)
            else -> throw error("Error in fragment state indexing.")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_battle_slow)

        battleObject = try{
            intent.getSerializableExtra("battle") as Battle
        } catch (e: TypeCastException){
            val battle = Battle(null)
            battle.primaryMission = PrimaryList().missions[0]
            battle.primaryMissionP1 = PrimaryList().missions[0]
            battle.primaryMissionP2 = PrimaryList().missions[0]
            battleViewModel.insert(battle)
            battle
        }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flCreateBattleFragment, getFragment())
        }.commit()

        buttonNext2.setOnClickListener {
            battleObject.createCounter++
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flCreateBattleFragment, getFragment())
            }.commit()
            battleViewModel.update(battleObject)
        }

        buttonPrevious2.setOnClickListener {
            battleObject.createCounter--
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flCreateBattleFragment, getFragment())
            }.commit()
            battleViewModel.update(battleObject)
        }

        buttonExit2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }




    }
}