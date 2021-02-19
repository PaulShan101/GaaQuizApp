package com.example.gaaquizapp

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.app_bar_home.*
import kotlinx.android.synthetic.main.homenav.*


class AboutUs : AppCompatActivity()  {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aboutus)
        setSupportActionBar(toolbar)

    }




    /* override fun onOptionsItemSelected(item: MenuItem): Boolean {

         when (item.itemId) {
             R.id.action_donate -> toast("You Selected Donate")
             R.id.action_report -> toast("You Selected Report")
         }
         return super.onOptionsItemSelected(item)
     }*/

  /*  override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }

    private fun navigateTo(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.home, fragment)
                .addToBackStack(null)
                .commit()
    }*/

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main, menu)
        return true
    }

    //when u click on a menu item the next activity shows
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.list1 -> {
                val intent = Intent(this@AboutUs, MainGaaList::class.java)
                startActivity(intent)
            }

            R.id.quiz1 -> {
                val intent = Intent(this@AboutUs, MainQuizActivity::class.java)
                startActivity(intent)
            }

            R.id.aboutus1 -> {
                val intent = Intent(this@AboutUs, AboutUs::class.java)
                startActivity(intent)
            }
            R.id.nav_fragment -> {
                val intent = Intent(this@AboutUs, MainFragment::class.java)
                startActivity(intent)
            }
            R.id.signup1 -> {
                val intent = Intent(this@AboutUs, SignUp::class.java)
                startActivity(intent)
            }
            R.id.login1 -> {
                val intent = Intent(this@AboutUs, Login::class.java)
                startActivity(intent)
            }


        }
        return super.onOptionsItemSelected(item)
    }





}
