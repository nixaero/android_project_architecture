package mob.nereek.io.model


import com.squareup.moshi.Json

data class Data(
    @Json(name = "avatar")
    var avatar: String,
    @Json(name = "email")
    var email: String,
    @Json(name = "first_name")
    var firstName: String,
    @Json(name = "id")
    var id: Int,
    @Json(name = "last_name")
    var lastName: String
)