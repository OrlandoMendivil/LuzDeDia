package mendivil.valenzuela.ciulog.luzdedia.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import mendivil.valenzuela.ciulog.luzdedia.R

class ForoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.foro)

        val back_foro_btn: Button = findViewById(R.id.back_foro_btn)
        back_foro_btn.setOnClickListener {
            val intent: Intent = Intent(this, ParentRoomActivity::class.java)

            startActivity(intent)
        }
    }
}