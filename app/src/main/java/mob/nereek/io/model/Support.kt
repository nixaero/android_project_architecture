package mob.nereek.io.model


import com.squareup.moshi.Json

data class Support(
    @Json(name = "text")
    var text: String,
    @Json(name = "url")
    var url: String
)