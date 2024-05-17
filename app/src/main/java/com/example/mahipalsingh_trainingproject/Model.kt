package com.example.mahipalsingh_trainingproject
data class Model(
    var page: Int = 0,
    var perPage: Int = 0,
    var total: Int = 0,
    var totalPages: Int = 0,
    var data: List<UserData> = listOf()
) {
    data class UserData(
        var id: Int = 0,
        var email: String? = null,
        var first_name: String? = null,
        var last_name: String? = null,
        var avatar: String? = null
    )
}
