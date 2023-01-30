package mob.nereek.io.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Demo(
    @Json(name = "data")
    var data: List<Data>,
    @Json(name = "page")
    var page: Int,
    @Json(name = "per_page")
    var perPage: Int,
    @Json(name = "support")
    var support: Support,
    @Json(name = "total")
    var total: Int,
    @Json(name = "total_pages")
    var totalPages: Int
)