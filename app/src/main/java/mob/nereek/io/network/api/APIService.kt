package mob.nereek.io.network.api

import io.reactivex.rxjava3.core.Observable
import mob.nereek.io.model.Demo
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("api/users")
    fun getDemo(@Query("page") page: String): Observable<Demo>

}

