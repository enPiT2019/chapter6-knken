package npaka.net.mysize

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editNeck = pref.getString("KUBI", "")
        val editSleeve = pref.getString("YUKITAKE", "")
        val editWaist = pref.getString("DOU", "")
        val editInseam = pref.getString("MATASHITA", "")

        neck.setText(editNeck)
        sleeve.setText(editSleeve)
        waist.setText(editWaist)
        inseam.setText(editInseam)

        save.setOnClickListener { ost() }

        heightButton.setOnClickListener{
            val intent = Intent(this, HeightAcitivity::class.java)
            startActivity(intent)
        }
    }

    private fun ost(){
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()
        editor.putString("KUBI", neck.text.toString())
        editor.putString("YUKITAKE", sleeve.text.toString())
        editor.putString("DOU", waist.text.toString())
        editor.putString("MATASHITA", inseam.text.toString())
    }
}
