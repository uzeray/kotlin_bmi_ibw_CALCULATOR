package www.fitpatients.fcom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.green
import kotlinx.android.synthetic.main.activity_bmr_form.*
import kotlin.math.round

class BmrForm : AppCompatActivity() {
    private val idealBmi : Double = 23.0 // ideal healthy Bodyy mass index for everyone.
    private var userAge : Int? = 0 // nullable integer variable for get user age.
    private  var userWeight : Int? = 0 // nullable variable for get user body weight
    private var userLenght : Int? = 0 // nullable variable for get user lenght with "CM"

    // all variables is equal to "0" for block to empty field from user


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmr_form)

    }

    fun calculate(view : View){

        userAge = ageText.text.toString().toIntOrNull() // user age will change by user on textView
        userWeight = weightText.text.toString().toIntOrNull() // user body weight will change by user on textView
        userLenght = lenghtText.text.toString().toIntOrNull() // user lenght will change by user on textView

        // if statement for control to any values on textViews or Not!
        // if user has no entered any value and user clict to calculate button =>
        if (userAge == null && userWeight == null && userLenght == null){
            Toast.makeText(this@BmrForm, "Fields are cannot Left Empty!!", Toast.LENGTH_LONG).show()
        }

        // if user entered an value but it can not calculate something =>
        else if (userAge!! < 10 && userLenght!! < 100 && userWeight!! < 30){
            Toast.makeText(this@BmrForm, "Age must be >10, Weight Must Be > 30, Lenght must be > 100!", Toast.LENGTH_LONG).show()
        }

        // if user has everything correct =>
        else {
            //BMI (BODY MASS INDEX) CALCULATION MATH
            // bmi will calculate =>
            val lenght2 : Double = userLenght!!/100.0 * userLenght!!/100.0
            val bmi : Double = userWeight!!.div(lenght2)
            val bmiRes = Math.round(bmi*100.0) / 100.0


            //IDEAL BODY WEIGHT CALCULATION MATH
            // ibw will calculate =>
            val bmiDifference : Double = bmiRes - idealBmi
            val loseFact : Double = bmiDifference * lenght2
            val idealBodyWeight : Double = userWeight!! - loseFact
            val IBW : Double = Math.round(idealBodyWeight * 100.0) / 100.0


            // values will put inside to an INTENT
            // Intent object will carry up values to next page by CALCULATE button =>
            var pick_up = Intent(applicationContext, BmiResultScreen::class.java)
            pick_up.putExtra("ibw", IBW)
            pick_up.putExtra("bmi", bmiRes)
            startActivity(pick_up)

        }

    }
}