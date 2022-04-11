package com.miu.aalemu.personal_cv

import android.app.Activity
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

        createInitialUsers()
        sign_in.setOnClickListener{
            val inputUserName = editTextTextEmailAddress.text.toString().trim();
            val inputPassword = editTextTextPassword.text.toString().trim();
            if(inputUserName == "" || inputPassword == "")
                goIn()
//                alert("Please fill both user name and password")
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
                val new_user = result.data?.getSerializableExtra("user") as User
                user.add(new_user)
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
                alert("Please enter the user name")
            else {

                var foundPassword = findUser(input_userName)?.password
                if (foundPassword != null) {


                    val intent = Intent(Intent.ACTION_SEND)
                    intent.type = "text/plain"
                    intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("addisudalemu@gmail.com"))
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


    private fun createInitialUsers() {
        user.add(User("Addisu","Alemu","addisu@gmail.com","pass123"))
        user.add(User("Haailu","Geleta","haailu@gmail.com","pass345"))
        user.add(User("Teshom","Girma","teshome@gmail.com","abc123"))
        user.add(User("Sara","Shinika","sara@gmail.com","longpass234word"))
    }


    private fun authenticateUser(inputUserName: String, inputPassword: String):Boolean{
        for(currentUser in user){
            if(currentUser.userName.equals(inputUserName) && currentUser.userName.equals(inputUserName))
                return true;
        }
        return false
    }

    private fun findUser(inputUserName: String):User?{
        for(currentUser in user){
            if(currentUser.userName.equals(inputUserName))
                return currentUser
        }
        return null;
    }

    private fun goIn() {
        var intent =  Intent(this,MainActivity::class.java)
        startActivity(intent)
    }



    private fun alert(message:String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}