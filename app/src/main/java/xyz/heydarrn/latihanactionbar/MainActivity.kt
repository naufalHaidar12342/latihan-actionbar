package xyz.heydarrn.latihanactionbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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