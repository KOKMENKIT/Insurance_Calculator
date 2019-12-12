package com.example.insurancecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var myData: PremiumMdl
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myData= ViewModelProviders.of(this).get(PremiumMdl::class.java)

        lblresult.text = "RM 0.0"
        btnCal.setOnClickListener(){
            Calculate()
        }

        btnreset.setOnClickListener(){
            Reset()
        }
    }

    fun Calculate(){
        val cost: Double
        val extra: Double
        val male: Double
        val total: Double
        val female : Double  = 0.0

        if(spinner.selectedItemPosition == 0){
            cost = 60.00
            lblresult.text = "RM " + cost.toString()

        } else if (spinner.selectedItemPosition == 1){
            cost = 70.00
            male = 50.00
            extra = 100.00
            lblresult.text = "RM " + cost.toString()

            if(rdmale.isChecked == true && chkyes.isChecked == false){
                total = male + cost
                lblresult.text = "RM " + total.toString()
                myData.premiumAmount = total


            } else if (chkyes.isChecked == true && rdmale.isChecked == false){
                total = cost + extra
                lblresult.text = "RM " + total.toString()
                myData.premiumAmount = total

            } else if (chkyes.isChecked == true && rdmale.isChecked == true) {
                total =  cost + male + extra
                lblresult.text = "RM " + total.toString()
                myData.premiumAmount = total
            }

        } else if (spinner.selectedItemPosition == 2){
            cost = 90.00
            male = 100.00
            extra = 150.00
            lblresult.text = "RM " + cost.toString()

            if(rdmale.isChecked == true && chkyes.isChecked == false){
                total = male + cost
                myData.premiumAmount = total
                lblresult.text = "RM " + total.toString()


            } else if (chkyes.isChecked == true && rdmale.isChecked == false){
                total = cost + extra
                myData.premiumAmount = total
                lblresult.text = "RM " + total.toString()


            } else if (chkyes.isChecked == true && rdmale.isChecked == true) {
                total =  cost + male + extra
                myData.premiumAmount = total
                lblresult.text = "RM " + total.toString()

            }


        } else if (spinner.selectedItemPosition == 3){
            cost = 120.00
            male = 150.00
            extra = 200.00
            lblresult.text = "RM " + cost.toString()

            if(rdmale.isChecked == true && chkyes.isChecked == false){
                total = male + cost
                lblresult.text = "RM " + total.toString()
                myData.premiumAmount = total

            } else if (chkyes.isChecked == true && rdmale.isChecked == false){
                total = cost + extra
                lblresult.text = "RM " + total.toString()
                myData.premiumAmount = total

            } else if (chkyes.isChecked == true && rdmale.isChecked == true) {
                total =  cost + male + extra
                lblresult.text = "RM " + total.toString()
                myData.premiumAmount = total

            }



        } else if (spinner.selectedItemPosition == 4){
            cost = 150.00
            male = 200.00
            extra = 250.00
            lblresult.text = "RM " + cost.toString()

            if(rdmale.isChecked == true && chkyes.isChecked == false){
                total = male + cost
                lblresult.text = "RM " + total.toString()
                myData.premiumAmount = total

            } else if (chkyes.isChecked == true && rdmale.isChecked == false){
                total = cost + extra
                lblresult.text = "RM " + total.toString()
                myData.premiumAmount = total

            } else if (chkyes.isChecked == true && rdmale.isChecked == true) {
                total =  cost + male + extra
                lblresult.text = "RM " + total.toString()
                myData.premiumAmount = total
            }

        } else if (spinner.selectedItemPosition == 4) {
            cost = 150.00
            male = 200.00
            extra = 300.00
            lblresult.text = "RM " + cost.toString()
            if(rdmale.isChecked == true && chkyes.isChecked == false){
                total = male + cost
                lblresult.text = "RM " + total.toString()
                myData.premiumAmount = total

            } else if (chkyes.isChecked == true && rdmale.isChecked == false){
                total = cost + extra
                lblresult.text = "RM " + total.toString()
                myData.premiumAmount = total

            } else if (chkyes.isChecked == true && rdmale.isChecked == true) {
                total =  cost + male + extra
                lblresult.text = "RM " + total.toString()
                myData.premiumAmount = total
            }

        }

    }

    fun Reset(){
        lblresult.text = "RM 0.0"
        spinner.selectedItemPosition
        spinner.setSelection(0)
        radioGroup2.clearCheck()
        chkyes.isChecked = false
        myData.premiumAmount = 0.0
    }
}
