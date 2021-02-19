package com.example.gaaquizapp


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
//import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.app_bar_home.*


class MainQuizActivity : AppCompatActivity() {

    private var txtHighScore: TextView? = null

    private var mhighscore: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        txtHighScore = findViewById(R.id.highscore)
        loadHighScore()


        val startQuiz = findViewById<Button>(R.id.startButton)
        startQuiz.setOnClickListener {
            startActivityForResult(Intent(applicationContext, MainActivity::class.java), REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val score = data!!.getIntExtra(MainActivity.FINAL_SCORE, 0)
                if (score > mhighscore) {
                    updateScore(score)
                }
            }
        }
    }

    private fun updateScore(score: Int) {
        mhighscore = score
        txtHighScore!!.text = "My High Score:- $mhighscore"

        val preferences = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putInt(HIGH_SCORE, mhighscore)
        editor.apply()

    }

    private fun loadHighScore() {
        val preferences = getSharedPreferences(PREFS, Context.MODE_PRIVATE)
        mhighscore = preferences.getInt(HIGH_SCORE, 0)
        txtHighScore!!.text = "My High Score:- $mhighscore"

    }

    companion object {

        private val REQUEST_CODE = 1
        val PREFS = "shared_prefs"
        val HIGH_SCORE = "high_score"
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
                val intent = Intent(this@MainQuizActivity, MainGaaList::class.java)
                startActivity(intent)
            }

            R.id.homepage -> {
                val intent = Intent(this@MainQuizActivity, Home::class.java)
                startActivity(intent)
            }

            R.id.aboutus1 -> {
                val intent = Intent(this@MainQuizActivity, AboutUs::class.java)
                startActivity(intent)
            }
            R.id.nav_fragment -> {
                val intent = Intent(this@MainQuizActivity, MainFragment::class.java)
                startActivity(intent)
            }
            R.id.signup1 -> {
                val intent = Intent(this@MainQuizActivity, SignUp::class.java)
                startActivity(intent)
            }
            R.id.login1 -> {
                val intent = Intent(this@MainQuizActivity, Login::class.java)
                startActivity(intent)
            }


        }
        return super.onOptionsItemSelected(item)
    }





}