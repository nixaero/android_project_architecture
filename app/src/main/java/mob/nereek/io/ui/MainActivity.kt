package mob.nereek.io.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import mob.nereek.io.MainApplication
import mob.nereek.io.R
import mob.nereek.io.databinding.ActivityMainBinding
import mob.nereek.io.di.component.MainComponent

class MainActivity : AppCompatActivity() {

    lateinit var mainComponent: MainComponent
    private lateinit var binding: ActivityMainBinding
    private var currentNavController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        // Creation of the main graph using the application graph
        mainComponent = (applicationContext as MainApplication).provideAppComponent().mainComponent().create()

        // Make Dagger instantiate @Inject fields in MainActivity
        mainComponent.inject(this)

    }
}