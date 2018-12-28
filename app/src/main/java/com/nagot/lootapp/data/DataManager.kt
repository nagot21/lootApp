package com.nagot.lootapp.data

import com.nagot.lootapp.data.db.DbHelper
import com.nagot.lootapp.data.network.NetworkManager
import com.nagot.lootapp.data.sharedprefs.SharedPrefsHelper

/**
 *   Created by IanNagot on 28/12/2018
 */
interface DataManager: DbHelper, SharedPrefsHelper, NetworkManager {
}