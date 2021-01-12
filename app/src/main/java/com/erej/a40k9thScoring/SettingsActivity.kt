package com.erej.a40k9thScoring

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_settings.*

class SettingsActivity : AppCompatActivity() {

    private fun onClickListeners(){

        buttonSave.setOnClickListener{
            Settings(applicationContext).writeSetting("default_name", editTextDefaultName.text.toString())
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }


        switchAutoIncrementCp.setOnClickListener{
            Settings(applicationContext).writeSetting("auto_increment_cp", switchAutoIncrementCp.isChecked)
        }

        switchAutoGenerateNames.setOnClickListener{
            Settings(applicationContext).writeSetting("auto_generate_names", switchAutoGenerateNames.isChecked)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_settings)

        //set ui to settings
        editTextDefaultName.setText(Settings(applicationContext).getSetting("default_name"))
        switchAutoIncrementCp.isChecked = Settings(applicationContext).getSettingBool("auto_increment_cp")!!
        switchAutoGenerateNames.isChecked = Settings(applicationContext).getSettingBool("auto_generate_names")!!

        //setup all onClickListeners
        onClickListeners()
    }

}