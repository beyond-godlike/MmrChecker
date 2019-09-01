package com.unava.dia.mmrchecker.data

data class Profile(
    var account_id: Int? = null,
    var personaname: String? = null,
    var name: String? = null,
    var cheese: Int? = null,
    var steamid: String? = null,
    var avatar: String? = null,
    var avatarmedium: String? = null,
    var avatarfull: String? = null,
    var profileurl: String? = null,
    var last_login: String? = null,
    var loccountrycode: String? = null,
    var is_contributor: Boolean? = false
) {
}