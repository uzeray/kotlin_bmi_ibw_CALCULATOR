package www.fitpatients.fcom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_bmi_result_screen.*

class BmiResultScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_result_screen)

        // values for get to Intent objects =>
        var bmiResult = intent.getDoubleExtra("bmi", 0.0)
        var ibwResult = intent.getDoubleExtra("ibw", 0.0)


        // values will write on textViews =>
        bmiResText.text = "${bmiResult.toString()}   Body Mass Index "
        ibwResText.text = "${ibwResult.toString()}     Ideal Body Weight "
    }

    // home button will bring to user home Page by onClick function =>
    fun goHome(view : View){
        var goHome = Intent(applicationContext, MainActivity::class.java)
        startActivity(goHome)
    }
}