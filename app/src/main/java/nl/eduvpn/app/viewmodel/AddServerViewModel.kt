/*
 * This file is part of eduVPN.
 *
 * eduVPN is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * eduVPN is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with eduVPN.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package nl.eduvpn.app.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import nl.eduvpn.app.service.*
import javax.inject.Inject

class AddServerViewModel @Inject constructor(
    preferencesService: PreferencesService,
    context: Context,
    apiService: APIService,
    serializerService: SerializerService,
    historyService: HistoryService,
    connectionService: ConnectionService,
    eduVpnOpenVpnService: EduVPNOpenVPNService,
    wireGuardService: WireGuardService,
    vpnConnectionService: VPNConnectionService,
) : BaseConnectionViewModel(
    context,
    apiService,
    serializerService,
    historyService,
    preferencesService,
    connectionService,
    eduVpnOpenVpnService,
    wireGuardService,
    vpnConnectionService,
) {

    val serverUrl = MutableLiveData("")

    val addButtonEnabled = Transformations.map(serverUrl) { url ->
        url != null && url.contains(".") && url.length > 3
    }
}
