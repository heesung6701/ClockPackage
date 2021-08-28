package com.quokkaman.android.app

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.quokkaman.android.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var toolbar: Toolbar
    private lateinit var collapsingToolbarLayout: CollapsingToolbarLayout

    private val navChangeListener =
        NavController.OnDestinationChangedListener { _, destination, _ ->
            collapsingToolbarLayout.title = destination.label
            Log.d("HSSS", "DestinationChanged : " + destination.label)
            when (destination.id) {
                R.id.navigation_alarm -> {
                    toolbar.menu.clear()
                    toolbar.inflateMenu(R.menu.menu_alarm)
                }
                R.id.navigation_world_clock -> {
                    toolbar.menu.clear()
                }
                R.id.navigation_stopwatch -> {
                    toolbar.menu.clear()
                }
                R.id.navigation_timer -> {
                    toolbar.menu.clear()
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(binding.toolbar)
        toolbar = binding.toolbar
        collapsingToolbarLayout = binding.toolbarLayout

        val navView: BottomNavigationView = binding.navView

        navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_alarm,
                R.id.navigation_world_clock,
                R.id.navigation_stopwatch,
                R.id.navigation_timer
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener(navChangeListener)
    }

    override fun onPause() {
        navController.removeOnDestinationChangedListener(navChangeListener)
        super.onPause()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        navChangeListener.onDestinationChanged(navController, navController.currentDestination!!, null)
        return true
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