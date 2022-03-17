package xyz.heydarrn.latihanactionbar

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import android.widget.Toast
import xyz.heydarrn.latihanactionbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindingMainActivity: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater=menuInflater
        inflater.inflate(R.menu.option_menu,menu)

        val searchManager=getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView= menu?.findItem(R.id.search_bar)?.actionView as SearchView

        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint=resources.getString(R.string.search_hint)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(this@MainActivity,query,Toast.LENGTH_SHORT).show()
                searchView.clearFocus()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })

        //return super.onCreateOptionsMenu(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //return super.onOptionsItemSelected(item)
        when(item.itemId){
            R.id.menu_1 -> {
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container,MenuFragment())
                    .addToBackStack(null)
                    .commit()
                return true

            }
            R.id.menu_2 -> {
                val bukaMenu=Intent(this,MenuActivity::class.java)
                startActivity(bukaMenu)
                return true
            }
            else -> return true
        }
    }
}