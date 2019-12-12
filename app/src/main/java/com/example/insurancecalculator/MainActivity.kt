package com.example.insurancecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myData: PremiumMdl
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myData= ViewModelProviders.of(this)
            .get(PremiumMdl::class.java)

        display()

        btnCal.setOnClickListener(){
            myData.premiumAmount = getPremium()
            display()
        }

        btnreset.setOnClickListener(){
            lblresult.setText("")
            radioGroup2.clearCheck()
            spinner.setSelection(0)
            chkyes.setChecked(false)
            myData.premiumAmount = 0.0
        }

        if(savedInstanceState != null){
            myData.premiumAmount = savedInstanceState.getDouble("Total")
            lblresult.text = "RM " + myData.premiumAmount.toString()
        }
    }

    fun display(){
        lblresult.setText("RM " + getPremium().toString())
    }

    fun getPremium():Double{
        return when(spinner.selectedItemPosition){
            0 -> 60.00
            1 -> 70.00 + (if(rdmale.isChecked) 50.00 else 0.0) + (if(chkyes.isChecked) 100.00 else 0.0)
            2 -> 90.00 + (if(rdmale.isChecked) 100.00 else 0.0) + (if(chkyes.isChecked) 150.00 else 0.0)
            3 -> 90.00 + (if(rdmale.isChecked) 150.00 else 0.0) + (if(chkyes.isChecked) 200.00 else 0.0)
            4 -> 90.00 + (if(rdmale.isChecked) 200.00 else 0.0) + (if(chkyes.isChecked) 250.00 else 0.0)
            else -> 90.00 + (if(rdmale.isChecked) 200.00 else 0.0) + (if(chkyes.isChecked) 300.00 else 0.0)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putDouble("Total",myData.premiumAmount)
        super.onSaveInstanceState(outState)

    }

}
