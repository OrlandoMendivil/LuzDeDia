package mendivil.valenzuela.ciulog.luzdedia.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import mendivil.valenzuela.ciulog.luzdedia.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val comenzar : Button = findViewById(R.id.btn_comenzar)
        comenzar.setOnClickListener{
            val intent: Intent = Intent(this, MenuActivity::class.java)

            startActivity(intent)
        }

        val btn_registrarte : Button = findViewById(R.id.btn_registrarte)
        btn_registrarte.setOnClickListener{
            val intent: Intent = Intent(this, RegisterActivity::class.java)

            startActivity(intent)
        }
    }
}