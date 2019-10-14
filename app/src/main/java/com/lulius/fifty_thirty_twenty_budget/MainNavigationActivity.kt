package com.lulius.fifty_thirty_twenty_budget

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.view.View


class MainNavigationActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var navView: BottomNavigationView
    private lateinit var navController: NavController
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var toolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment? ?: return

        navController = host.navController
        bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav_view)
        toolbar = findViewById<Toolbar>(R.id.toolbar)

        setSupportActionBar(toolbar)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBar(navController, appBarConfiguration)
        setupBottomNavMenu(navController)
        setupNavigationHidingRules(navController)

    }

    private fun setupNavigationHidingRules(navController: NavController){
        navController.addOnDestinationChangedListener{
                controller, destination, arguments ->
                    if(destination.getId() == R.id.add_expense_dest){
                        toolbar.setVisibility(View.GONE)
                        bottomNav?.setVisibility(View.GONE)
                    } else {
                        bottomNav?.setVisibility(View.VISIBLE)
                        toolbar.setVisibility(View.VISIBLE)
                    }

        }
    }

    private fun setupBottomNavMenu(navController: NavController) {
        bottomNav?.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val retValue = super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.app_bar_actions, menu)
        return retValue
    }

    private fun setupActionBar(
        navController: NavController,
        appBarConfig: AppBarConfiguration
    ) {
        // This allows NavigationUI to decide what label to show in the action bar
        // By using appBarConfig, it will also determine whether to
        // show the up arrow or drawer menu icon
        setupActionBarWithNavController(navController, appBarConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(findNavController(R.id.nav_host_fragment))
                || super.onOptionsItemSelected(item)
//        navController.navigate(R.id.action_expensesListFragment_to_addExpence)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return navController.navigateUp();
    }
}
