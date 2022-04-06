package mendivil.valenzuela.ciulog.luzdedia.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import mendivil.valenzuela.ciulog.luzdedia.R

class CalendarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calendario)

        val logros_btn: Button = findViewById(R.id.logros_btn)
        logros_btn.setOnClickListener {
            val intent: Intent = Intent(this, RendimientoActivity::class.java)

            startActivity(intent)
        }

        val notas_btn: Button = findViewById(R.id.notas_btn)
        notas_btn.setOnClickListener {
            val intent: Intent = Intent(this, Notas2Activity::class.java)

            startActivity(intent)
        }

        val back_calendario_btn: Button = findViewById(R.id.back_calendario_btn)
        back_calendario_btn.setOnClickListener {
            val intent: Intent = Intent(this, ParentRoomActivity::class.java)

            startActivity(intent)
        }
    }
}