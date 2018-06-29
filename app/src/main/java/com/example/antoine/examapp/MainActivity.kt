package com.example.antoine.examapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.antoine.examapp.fragment.FavoriteFragment
import com.example.antoine.examapp.fragment.QuestionsFragment
import com.example.antoine.examapp.fragment.UsersFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        var questionFragment = Fragment.instantiate(this@MainActivity, QuestionsFragment::class.java.name) as QuestionsFragment
        replaceFragment(questionFragment, R.id.content_frame)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.menu)
        }

        nav_view.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            when (menuItem.itemId) {
                R.id.nav_latest -> {
                    replaceFragment(questionFragment, R.id.content_frame)
                }
                R.id.nav_best_user -> {
                    replaceFragment(Fragment.instantiate(this@MainActivity, UsersFragment::class.java.name) as UsersFragment, R.id.content_frame)
                }
                R.id.nav_favorites -> {
                    replaceFragment(Fragment.instantiate(this@MainActivity, FavoriteFragment::class.java.name) as FavoriteFragment, R.id.content_frame)
                }
            }
            drawer_layout.closeDrawers()
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                drawer_layout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
        supportFragmentManager.inTransaction{replace(frameId, fragment)}
    }

    private inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
        beginTransaction().func().commit()
    }
}
