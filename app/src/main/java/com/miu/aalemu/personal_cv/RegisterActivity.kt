package com.miu.aalemu.personal_cv

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        create_account.setOnClickListener{
            val inputUserName = editTextTextEmailAddress.text.toString()
            val inputPassword = editTextTextPassword.text.toString()

            if(inputUserName == "" || inputPassword == "")
                alert("Please fill both user name and password")
            else {
                if(userExist(inputUserName)){
                    alert("Username already exist")
                }else{
                    val spf = getSharedPreferences("userList", Context.MODE_PRIVATE)
                    val spe = spf.edit()
                    spe.putString(inputUserName,inputPassword)
                    spe.apply();
                    finish()
                }

            }
        }
    }
    private fun userExist(inputUserName: String):Boolean{
        val spf = getSharedPreferences("userList", Context.MODE_PRIVATE)
        val password= spf.getString(inputUserName,"empty")
        if(password.equals("empty"))
            return false

        return true
    }

    private fun alert(message:String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}