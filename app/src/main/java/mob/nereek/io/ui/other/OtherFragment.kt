package mob.nereek.io.ui.other

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import mob.nereek.io.R

class OtherFragment : Fragment() {

    companion object {
        fun newInstance() = OtherFragment()
    }

    private lateinit var viewModel: OtherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_other, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(OtherViewModel::class.java)
        // TODO: Use the ViewModel
    }

}