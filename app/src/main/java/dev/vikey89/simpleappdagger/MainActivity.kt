package dev.vikey89.simpleappdagger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.vikey89.categories.ui.CategoriesActivity
import dev.vikey89.retailers.ui.RetailersActivity
import kotlinx.android.synthetic.main.activity_main.go_to_categories
import kotlinx.android.synthetic.main.activity_main.go_to_retailers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        go_to_categories.setOnClickListener {
            val intent = Intent(this, CategoriesActivity::class.java)
            startActivity(intent)
        }

        go_to_retailers.setOnClickListener {
            val intent = Intent(this, RetailersActivity::class.java)
            startActivity(intent)
        }
    }
}
