package com.quokkaman.android.app

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.quokkaman.android.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)


        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_alarm, R.id.navigation_world_clock, R.id.navigation_stopwatch, R.id.navigation_timer
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_alarm, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_add ->
                Toast.makeText(this, getString(R.string.add), Toast.LENGTH_SHORT).show()
            R.id.menu_edit ->
                Toast.makeText(this, getString(R.string.edit), Toast.LENGTH_SHORT).show()
            R.id.menu_sort ->
                Toast.makeText(this, getString(R.string.sort), Toast.LENGTH_SHORT).show()
            R.id.menu_inquire ->
                Toast.makeText(this, getString(R.string.inquire), Toast.LENGTH_SHORT).show()
            R.id.menu_setting ->
                Toast.makeText(this, getString(R.string.setting), Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}