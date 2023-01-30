package mob.nereek.io.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import mob.nereek.io.R
import mob.nereek.io.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var mNetworkDemo = NetworkStateReceiver()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnHome.

    }

}