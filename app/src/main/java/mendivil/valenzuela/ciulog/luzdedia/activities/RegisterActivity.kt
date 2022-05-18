package mendivil.valenzuela.ciulog.luzdedia.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import mendivil.valenzuela.ciulog.luzdedia.R

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        // Initialize Firebase Auth
        auth = Firebase.auth

        val btn_comenzar: Button = findViewById(R.id.btn_comenzar)
        val editTextName: EditText = findViewById(R.id.editTextName)
        val editTextLastName: EditText = findViewById(R.id.editTextLastName)
        val editTextMail: EditText = findViewById(R.id.editTextMail)
        val editTextPasword: EditText = findViewById(R.id.editTextPassword)
        val editTextConfirmPassword: EditText = findViewById(R.id.editTextConfirmPassword)

        btn_comenzar.setOnClickListener {
            var name: String = editTextName.text.toString().trim()
            var lastName: String = editTextLastName.text.toString().trim()
            var mail: String = editTextMail.text.toString().trim()
            var password: String = editTextPasword.text.toString().trim()
            var confirmPassword: String = editTextConfirmPassword.text.toString().trim()

            if(name.isNullOrEmpty() || lastName.isNullOrEmpty() || mail.isNullOrEmpty()
                || password.isNullOrEmpty() || confirmPassword.isNullOrEmpty()){
                Toast.makeText(this, "Los campos estan vacios...", Toast.LENGTH_SHORT).show()
            }else{
                if (password != confirmPassword){
                    Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                }else{
                    auth.createUserWithEmailAndPassword(mail, password)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                //Log.d(TAG, "createUserWithEmail:success")
                                val user = auth.currentUser
                                startActivity(Intent(this, MenuActivity::class.java))
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("Register", "createUserWithEmail:failure", task.exception)
                                Toast.makeText(baseContext, "La autenticación ha fallado...",
                                    Toast.LENGTH_SHORT).show()
                            }
                        }

                }
            }
            //val intent: Intent = Intent(this, LoginActivity::class.java)
            //startActivity(intent)
        }
    }
}