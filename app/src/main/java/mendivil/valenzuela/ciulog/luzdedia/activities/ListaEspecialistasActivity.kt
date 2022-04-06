package mendivil.valenzuela.ciulog.luzdedia.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import mendivil.valenzuela.ciulog.luzdedia.R

class ListaEspecialistasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_especialistas)

        val back: Button = findViewById(R.id.btn_back)
        back.setOnClickListener {
            val intent: Intent = Intent(this, ParentRoomActivity::class.java)

            startActivity(intent)
        }
    }
}