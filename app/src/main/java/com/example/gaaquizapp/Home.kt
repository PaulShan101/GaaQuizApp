package com.example.gaaquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction


import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

import kotlinx.android.synthetic.main.app_bar_home.*

import kotlinx.android.synthetic.main.homenav.*


class Home : AppCompatActivity(),
        NavigationView.OnNavigationItemSelectedListener {

    lateinit var ft: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homenav)
        setSupportActionBar(toolbar)

     /*   fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()
        }*/

        navView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        ft = supportFragmentManager.beginTransaction()

        /*val fragment = MainQuizActivity.newInstance()
        ft.replace(R.id.home, fragment)
        ft.commit()*/
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.nav_mainactivityquiz -> {
                val intent = Intent(this@Home, MainQuizActivity::class.java)
                startActivity(intent)
            }
            R.id.list -> {
                val intent = Intent(this@Home, MainGaaList::class.java)
                startActivity(intent)
            }
            R.id.nav_aboutus -> {
                val intent = Intent(this@Home, AboutUs::class.java)
                startActivity(intent)
            }

            R.id.nav_fragment -> {
                val intent = Intent(this@Home, MainFragment::class.java)
                startActivity(intent)
            }
            R.id.signup -> {
                val intent = Intent(this@Home, SignUp::class.java)
                startActivity(intent)
            }
            R.id.login -> {
                val intent = Intent(this@Home, Login::class.java)
                startActivity(intent)
            }
           /* R.id.nav_mainactivityquiz -> navigateTo(MainQuizActivity.newInstance())
            R.id.list -> navigateTo(MainGaaList.newInstance())
            R.id.nav_aboutus -> navigateTo(AboutUs)

            else -> toast("You Selected Something Else")*/
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }



   /* override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_donate -> toast("You Selected Donate")
            R.id.action_report -> toast("You Selected Report")
        }
        return super.onOptionsItemSelected(item)
    }*/

    override fun onBackPressed() {
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
                val intent = Intent(this@Home, MainGaaList::class.java)
                startActivity(intent)
            }

            R.id.quiz1 -> {
                val intent = Intent(this@Home, MainQuizActivity::class.java)
                startActivity(intent)
            }

            R.id.aboutus1 -> {
                val intent = Intent(this@Home, AboutUs::class.java)
                startActivity(intent)
            }
            R.id.nav_fragment -> {
                val intent = Intent(this@Home, MainFragment::class.java)
                startActivity(intent)
            }
            R.id.signup1 -> {
                val intent = Intent(this@Home, SignUp::class.java)
                startActivity(intent)
            }
            R.id.login1 -> {
                val intent = Intent(this@Home, Login::class.java)
                startActivity(intent)
            }


        }
        return super.onOptionsItemSelected(item)
    }



}
