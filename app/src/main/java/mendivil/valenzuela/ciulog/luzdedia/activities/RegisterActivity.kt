package mendivil.valenzuela.ciulog.luzdedia.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import mendivil.valenzuela.ciulog.luzdedia.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        val btn_comenzar: Button = findViewById(R.id.btn_comenzar)
        btn_comenzar.setOnClickListener {
            val intent: Intent = Intent(this, LoginActivity::class.java)

            startActivity(intent)
        }
    }
}