package mob.nereek.io.repository

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import mob.nereek.io.model.Demo
import mob.nereek.io.network.api.APIResponse
import mob.nereek.io.network.api.APIService
import javax.inject.Inject

class DemoRepository @Inject constructor(
    private var apiService: APIService,
) {
    fun loadDemo(
        compositeDisposable: CompositeDisposable,
        input: String,
        onResponse: APIResponse<Demo>
        ): io.reactivex.rxjava3.disposables.Disposable {
        return apiService.getDemo(input)
            .subscribeOn(io.reactivex.rxjava3.schedulers.Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                onResponse.onSuccess(it)
            }, {
                onResponse.onError(it)
            }).also {
                compositeDisposable.add(it)
            }
    }
}
