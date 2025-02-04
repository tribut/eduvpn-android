package nl.eduvpn.app.entity.v3

import ProfileV3API
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProfileV3APIList(
    @SerialName("profile_list")
    val profileList: List<ProfileV3API>
)
