package app.webview.errorpage.view;

import ItemAdapter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import app.webview.errorpage.R
import app.webview.errorpage.databinding.ActivityMainBinding
import app.webview.errorpage.viewmodel.ItemViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    /**
     * NOTE:
     * I originally intended to use RecyclerView here,
     * which is generally more efficient and customizable for dynamic lists.
     * But as per your request, I'm using a ListView instead.
     */

    private lateinit var binding: ActivityMainBinding
    private val itemViewModel: ItemViewModel by viewModel()
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        setupDrawer()
        initializeAdapter()
    }

    private fun setupDrawer() {
        val toggle = ActionBarDrawerToggle(
            this, binding.drawerLayout, binding.toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show()
                R.id.nav_about -> Toast.makeText(this, "About clicked", Toast.LENGTH_SHORT).show()
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

    }

    private fun initializeAdapter() {
        adapter = ItemAdapter(this, mutableListOf())
        binding.listView.adapter = adapter

        itemViewModel.items.observe(this) {
            adapter.updateData(it)
        }

        itemViewModel.loadItems()
    }
}
