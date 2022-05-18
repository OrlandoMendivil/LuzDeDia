package mendivil.valenzuela.ciulog.luzdedia.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import mendivil.valenzuela.ciulog.luzdedia.R

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        // Initialize Firebase Auth
        auth = Firebase.auth

        val comenzar : Button = findViewById(R.id.btn_comenzar)
        val editTextMail: EditText = findViewById(R.id.editTextMail)
        val editTextPassword: EditText = findViewById(R.id.editTextPassword)

        comenzar.setOnClickListener{
            var email: String = editTextMail.text.toString().trim()
            var password: String = editTextPassword.text.toString().trim()

            if ( email.isNullOrEmpty() || password.isNullOrEmpty() ){
                Toast.makeText(this, "Los campos estan vacios...", Toast.LENGTH_SHORT).show()
            }else{
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "signInWithEmail:success")
                            val user = auth.currentUser
                            startActivity(Intent(this, MenuActivity::class.java))
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("login", "signInWithEmail:failure", task.exception)
                            Toast.makeText(baseContext, "La autenticación ha fallado...",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
            }

            //val intent: Intent = Intent(this, MenuActivity::class.java)
            //startActivity(intent)
        }

        val btn_registrarte : Button = findViewById(R.id.btn_registrarte)
        btn_registrarte.setOnClickListener{
            val intent: Intent = Intent(this, RegisterActivity::class.java)

            startActivity(intent)
        }

        val btnRemPassword: Button = findViewById(R.id.btnRemPassword)
        btnRemPassword.setOnClickListener{
            val remPa: Intent = Intent(this, RemPasswordActivity::class.java)
            startActivity(remPa)
        }
    }
}