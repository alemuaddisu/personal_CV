package com.miu.aalemu.personal_cv

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.miu.aalemu.personal_cv.data.User
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    var user:ArrayList<User> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sign_in.setOnClickListener{



            val inputUserName = editTextTextEmailAddress.text.toString().trim();
            val inputPassword = editTextTextPassword.text.toString().trim();
            if(inputUserName == "" || inputPassword == "")
                alert("Please fill both user name and password")
            else {
                if(authenticateUser(inputUserName, inputPassword)){
                    goIn()
                }else{
                    alert("Username and/or password is not correct")
                }

            }
        }

        var resultContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result ->
            if(result.resultCode == Activity.RESULT_OK){
                alert("Registration completed !")
            }
            else
                alert("Registration aborted !!")

        }

        register.setOnClickListener{
            resultContract.launch(Intent(this,RegisterActivity::class.java))
        }



        textViewForgotPassword.setOnClickListener {
            var input_userName = editTextTextEmailAddress.text.toString().trim();

            if (input_userName == "")
                alert("Please enter the user namesssss")
            else {

                var foundPassword = findPassword(input_userName)
                if (foundPassword != null) {


                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "text/plain"
                    intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(input_userName))
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Your Username and Password")
                    intent.putExtra(
                        Intent.EXTRA_TEXT,
                        "Email: $input_userName\nPassword: $foundPassword"
                    )


                    if (intent.resolveActivity(packageManager) != null) {
                        startActivity(intent)
                    }

                } else {
                    alert("User name could not be found");
                }
            }
        }



    }


    private fun authenticateUser(inputUserName: String, inputPassword: String):Boolean{
        val spf = getSharedPreferences("userList", Context.MODE_PRIVATE)
        val password= spf.getString(inputUserName,"empty")
        if(password.equals(inputPassword))
            return true

        return false
    }

    private fun findPassword(inputUserName: String):String?{

        val spf = getSharedPreferences("userList", Context.MODE_PRIVATE)
        val password= spf.getString(inputUserName,"empty")
        if(password.equals("empty"))
            return null

        return password

    }

    private fun goIn() {
        var intent =  Intent(this,MainActivity::class.java)
        startActivity(intent)
    }



    private fun alert(message:String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}