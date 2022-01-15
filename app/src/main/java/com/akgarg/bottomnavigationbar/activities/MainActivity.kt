package com.akgarg.bottomnavigationbar.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.akgarg.bottomnavigationbar.R
import com.akgarg.bottomnavigationbar.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener,
    NavigationBarView.OnItemReselectedListener {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_nav_view)
        bottomNavigationView.setOnItemSelectedListener(this)
        bottomNavigationView.setOnItemReselectedListener(this)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragments_container, HomeFragment()).commit()

        badges()
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragmentToRender: Fragment? = null

        when (item.itemId) {
            R.id.item_home -> fragmentToRender = HomeFragment()

            R.id.item_profile -> fragmentToRender = ProfileFragment()

            R.id.item_info -> fragmentToRender = InfoFragment()

            R.id.item_tips -> fragmentToRender = TipsFragment()

            R.id.item_logout -> fragmentToRender = LogoutFragment()
        }

        if (fragmentToRender != null) {
            supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.fade_in, R.anim.slide_out)
                .replace(R.id.fragments_container, fragmentToRender)
                .commit()

            return true
        }

        return false
    }


    private fun badges() {
        val homeBadge = bottomNavigationView.getOrCreateBadge(R.id.item_home)
        homeBadge.isVisible = true
        homeBadge.number = 21

        val tipsBadge = bottomNavigationView.getOrCreateBadge(R.id.item_tips)
        tipsBadge.isVisible = true
    }


    override fun onNavigationItemReselected(item: MenuItem) {
        // used to prevent the recreation of fragment if already on screen
    }


}