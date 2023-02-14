package mob.nereek.io.ui.home

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import mob.nereek.io.databinding.FragmentHomeBinding
import mob.nereek.io.model.Data
import mob.nereek.io.model.Demo
import mob.nereek.io.network.api.APIResponse
import mob.nereek.io.repository.DemoRepository
import mob.nereek.io.tools.NetworkStateReceiver
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val demoRepository: DemoRepository) : ViewModel() {

    val demoDatalist = MutableLiveData<List<Data>?>()
    val isLoading = MutableLiveData(false)


    private val compositeDisposable = CompositeDisposable()
    private var count = 0

    fun getCurrentCount():Int{
        return count
    }

    fun getUpdatedCount():Int{
        return ++count
    }


    fun demoData(page: String) {
        setLoading(true)
        demoRepository.loadDemo(
            compositeDisposable,
            page,
            object : APIResponse<Demo> {
                override fun onSuccess(result: Demo?) {
                    setLoading(false)
                    demoDatalist.value = result?.data
                }

                override fun onError(t: Throwable) {
                    setLoading(false)
                    t.printStackTrace()
                }
            })
    }

    private fun setLoading(b: Boolean) {
        isLoading.value=b
    }


    fun dispose() {
        if (compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}