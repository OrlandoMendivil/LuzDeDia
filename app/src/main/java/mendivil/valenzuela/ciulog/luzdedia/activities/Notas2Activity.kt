package mendivil.valenzuela.ciulog.luzdedia.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import mendivil.valenzuela.ciulog.luzdedia.R

class Notas2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notas_2)

        val back_btn: Button = findViewById(R.id.back_btn)
        back_btn.setOnClickListener {
            val intent: Intent = Intent(this, CalendarioActivity::class.java)

            startActivity(intent)
        }

        val plus_btn: Button = findViewById(R.id.plus_btn)
        plus_btn.setOnClickListener {
            val intent: Intent = Intent(this, NotasActivity::class.java)

            startActivity(intent)
        }
    }
}