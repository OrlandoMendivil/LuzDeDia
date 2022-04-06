package mendivil.valenzuela.ciulog.luzdedia.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import mendivil.valenzuela.ciulog.luzdedia.R

class NotasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notas)

        val back_btn: Button = findViewById(R.id.back_btn)
        back_btn.setOnClickListener {
            val intent: Intent = Intent(this, Notas2Activity::class.java)

            startActivity(intent)
        }
    }
}