package mob.nereek.io.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import mob.nereek.io.R
import mob.nereek.io.databinding.HolderHomeBinding
import mob.nereek.io.model.Data
import mob.nereek.io.model.Demo
import kotlin.properties.Delegates

class HomeAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    var data: List<Data> by Delegates.observable(emptyList()) { property, oldValue, newValue ->
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderHomeBinding = HolderHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(holderHomeBinding)
    }

    private fun getItem(position: Int): Data{
        return data[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as HomeViewHolder).onBind(getItem(position))
    }


    private inner class HomeViewHolder(private val binding: HolderHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Data) {

            binding.photo.adjustViewBounds=false
            binding.photo.load(data.avatar)

            binding.email.text = data.email
            binding.identifiant.text = data.id.toString()
            binding.name.text = data.firstName
            binding.lastName.text = data.lastName


        }
    }
}