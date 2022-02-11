package io.github.sb689.summationlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController

import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.AppBarConfiguration
import io.github.sb689.summationlib.R
import io.github.sb689.summationlib.databinding.ActivityMainBinding
import java.util.concurrent.locks.Lock

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout : DrawerLayout
    private lateinit var appBarConfig : AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val navController = this.findNavController(R.id.nav_host_fragment_title)

        drawerLayout = binding.layoutDrawer
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        appBarConfig = AppBarConfiguration(navController.graph, drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)

        setupActionBarWithNavController(navController, appBarConfig)
        navController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, args: Bundle? ->

            if (nd.id == R.id.gameCompleteFragment || nd.id == R.id.gameFragment ) {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
            }
            else {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_title)
        return NavigationUI.navigateUp(navController, drawerLayout)

    }
}