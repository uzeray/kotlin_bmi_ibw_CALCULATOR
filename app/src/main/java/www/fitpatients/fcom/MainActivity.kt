package www.fitpatients.fcom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // functions are works with imageView -> onClick Methods.

    // function for button to go Body_mass-index calculator page
    fun goBmi(view : View){
        var goToIt = Intent(applicationContext, BmrForm::class.java)
        startActivity(goToIt)
    }

    // funcion for to go Basal Metabolic Rate for man Calculator Screen via button
    fun goBmrMan(view: View){

    }

    // funcstion for go to Body mass index for woman secreen via button
    fun goBmrWoman(view: View){

    }

    // functions for go to diabetic values calculation screen, it contenc
    // bmi, ibw, bmr, insulin Resistance, bolus-bonus insulin doses, insulin cover factors
    // insulin karbohydrate cover factors...
    fun goDiabetics(view: View){

    }

}