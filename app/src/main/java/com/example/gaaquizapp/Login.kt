package com.example.gaaquizapp

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.app_bar_home.*


class Login : AppCompatActivity() {



    private var user_email: EditText? =null
    private var user_password:EditText? = null
    private var login_btn: Button? = null
    private var firebaseAuth:FirebaseAuth? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(toolbar)

        user_email = findViewById(R.id.user_email_login)
        user_password = findViewById(R.id.user_password_login)
        login_btn = findViewById(R.id.login_btn_activity)
        firebaseAuth = FirebaseAuth.getInstance()



        login_btn?.setOnClickListener {


            LoginUser()

        }





    }



    private fun LoginUser() {




        var email_text = user_email?.text.toString().trim()
        var password_text = user_password?.text.toString().trim()




        if (TextUtils.isEmpty(email_text)) {

            Toast.makeText(applicationContext,"This Field can not be Empty",Toast.LENGTH_SHORT).show()

        }


        else if (TextUtils.isEmpty(password_text)) {

            Toast.makeText(applicationContext,"This Field can not be Empty",Toast.LENGTH_SHORT).show()
        }


        else {


            firebaseAuth?.signInWithEmailAndPassword(email_text,password_text)?.addOnCompleteListener(object : OnCompleteListener<AuthResult> {
                override fun onComplete(task: Task<AuthResult>) {


                    if (task.isSuccessful){


                        Toast.makeText(applicationContext,"Your are Logined Successfly ",Toast.LENGTH_SHORT).show()
                        val user: FirebaseUser = firebaseAuth?.currentUser!!
                        startActivity(Intent(this@Login,MainQuizActivity::class.java))

                        if (user.isEmailVerified) {

                            startActivity(Intent(this@Login,MainQuizActivity::class.java))
                        }
                        else {


                          //  Toast.makeText(applicationContext,"Account Not Verified",Toast.LENGTH_SHORT).show()

                        }


                    }
                    else {

                        val error = task.exception?.message

                        Toast.makeText(applicationContext,"Error " + error,Toast.LENGTH_SHORT).show()
                    }






                }


            })
        }






    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main, menu)
        return true
    }

    //when u click on a menu item the next activity shows
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.list1 -> {
                val intent = Intent(this@Login, MainGaaList::class.java)
                startActivity(intent)
            }

            R.id.quiz1 -> {
                val intent = Intent(this@Login, MainQuizActivity::class.java)
                startActivity(intent)
            }

            R.id.aboutus1 -> {
                val intent = Intent(this@Login, AboutUs::class.java)
                startActivity(intent)
            }
            R.id.nav_fragment -> {
                val intent = Intent(this@Login, MainFragment::class.java)
                startActivity(intent)
            }
            R.id.homepage -> {
                val intent = Intent(this@Login, Home::class.java)
                startActivity(intent)
            }
            R.id.homepage -> {
                val intent = Intent(this@Login, Home::class.java)
                startActivity(intent)
            }


        }
        return super.onOptionsItemSelected(item)
    }

}