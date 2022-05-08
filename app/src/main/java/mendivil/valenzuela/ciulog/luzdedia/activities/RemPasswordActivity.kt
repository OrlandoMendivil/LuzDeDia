package mendivil.valenzuela.ciulog.luzdedia.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import mendivil.valenzuela.ciulog.luzdedia.R

class RemPasswordActivity : AppCompatActivity()  {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.remember_password)
        // Initialize Firebase Auth
        auth = Firebase.auth



        val btnRemPassword: Button = findViewById(R.id.btnRemPassword)
        val et_email: EditText = findViewById(R.id.editTextEmail)

        btnRemPassword.setOnClickListener{
            var email: String = et_email.text.toString().trim()

            if(email.isNullOrEmpty()){
                Toast.makeText(this, "El campo esta vacio...", Toast.LENGTH_SHORT).show()
            }else{
                auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener{ task ->
                        if (task.isSuccessful){
                            Toast.makeText(this, "Se ha enviado la contraseña a su email...", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this, "Ha habido un problema...", Toast.LENGTH_SHORT).show()
                        }

                    }
            }

        }
    }
}