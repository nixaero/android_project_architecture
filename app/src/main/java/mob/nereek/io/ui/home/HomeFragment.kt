package mob.nereek.io.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import mob.nereek.io.R
import mob.nereek.io.databinding.FragmentHomeBinding
import mob.nereek.io.tools.NetworkStateReceiver
import mob.nereek.io.tools.viewModelProvider
import mob.nereek.io.ui.MainActivity
import javax.inject.Inject
import javax.inject.Provider

class HomeFragment : Fragment() {

    private var mNetworkDemo = NetworkStateReceiver()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    private var mAdapter = HomeAdapter()


    @Inject
    lateinit var viewModelProvider: Provider<HomeViewModel>

    override fun onCreate(savedInstanceState: Bundle?,) {
        super.onCreate(savedInstanceState)

        (activity as MainActivity).mainComponent.inject(this)
        viewModel = this.viewModelProvider(viewModelProvider)

        // viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)



    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater)
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.homeRecyclerView.adapter = mAdapter

        binding.btnHome.setOnClickListener{
            binding.text.text = viewModel.getUpdatedCount().toString()

        }

        //mAdapter.notifyDataSetChanged()
        mAdapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
            override fun onChanged() {
                super.onChanged()
            }
        })

        with(viewModel) {
            demoData("1")
            demoDatalist.observe(viewLifecycleOwner) {
                if (it != null) {
                    mAdapter.data = it
                    binding.homeRecyclerView.adapter=mAdapter
                }
            }


            isLoading.observe(viewLifecycleOwner) {
                binding.homeProgressBar.visibility = if (it == true) View.VISIBLE else View.GONE
            }

        }

        return binding.root
    }

    override fun onDetach() {
        super.onDetach()
        viewModel.dispose()
    }

}