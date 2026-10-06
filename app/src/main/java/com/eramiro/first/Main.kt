package com.eramiro.first

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.WebView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import kotlin.system.exitProcess

/**
 * The type Main.
 *
 * @author ernesto
 */
class Main : AppCompatActivity() {

    private var miVisorWeb: WebView? = null
    private var swipeLayout: SwipeRefreshLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mycontext: WebView? = findViewById(R.id.vistaweb)
        mycontext?.let { registerForContextMenu(it) }

        swipeLayout = findViewById(R.id.myswipe)
        swipeLayout?.setOnRefreshListener(mOnRefreshListener)

        miVisorWeb = findViewById(R.id.vistaweb)
        miVisorWeb?.loadUrl("https://thispersondoesnotexist.com")
    }

    /**
     * Show alert dialog button clicked.
     *
     * @param mainActivity the main activity
     */
    fun showAlertDialogButtonClicked(mainActivity: Main) {
        val builder = MaterialAlertDialogBuilder(this)
        builder.setTitle("Achtung!")
        builder.setMessage("Where do you go?")
        builder.setIcon(R.drawable.usericon)
        builder.setCancelable(true)

        builder.setPositiveButton("Scrolling") { _, _ ->
            val intent = Intent(this@Main, ScrollingActivity::class.java)
            startActivity(intent)
        }

        builder.setNegativeButton("Do nothing") { _, _ ->
        }

        builder.setNeutralButton("Other") { _, _ ->
            exitProcess(0)
        }

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    protected val mOnRefreshListener = SwipeRefreshLayout.OnRefreshListener {
        val mLayout: ConstraintLayout? = findViewById(R.id.myMainConstraint)
        mLayout?.let { layout ->
            val snackbar = Snackbar
                .make(layout, "fancy a Snack while you refresh?", Snackbar.LENGTH_SHORT)
                .setAction("UNDO") {
                    val snackbar1 = Snackbar.make(layout, "Action is restored!", Snackbar.LENGTH_SHORT)
                    snackbar1.show()
                }
            snackbar.show()
        }

        miVisorWeb?.reload()
        swipeLayout?.isRefreshing = false
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_appbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item1 -> {
                Toast.makeText(this, "Infecting", Toast.LENGTH_LONG).show()
                true
            }
            R.id.item2 -> {
                Toast.makeText(this, "Fixing", Toast.LENGTH_LONG).show()
                true
            }
            R.id.item3 -> {
                val intent = Intent(this@Main, MainBab::class.java)
                startActivity(intent)
                true
            }
            R.id.item4 -> {
                val intent = Intent(this, MainBn::class.java)
                startActivity(intent)
                true
            }
            R.id.item5 -> {
                showAlertDialogButtonClicked(this@Main)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_context, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item1 -> {
                Toast.makeText(this, "Item copied", Toast.LENGTH_LONG).show()
                true
            }
            R.id.item2 -> {
                Toast.makeText(this, "Downloading item...", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}
