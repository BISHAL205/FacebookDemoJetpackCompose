package com.example.jetpackcomposetest.utils

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.example.jetpackcomposetest.config.UserLocalDbConstraints
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton
import androidx.core.content.edit

@Singleton
class EncryptedUserCheckingManager @Inject constructor(@ApplicationContext context: Context) {
    private val prefs = EncryptedSharedPreferences.create(
        context,
        UserLocalDbConstraints.dbName,
        MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build(),
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun saveUser(userJson: String) = prefs.edit {
        putString(UserLocalDbConstraints.userDataKey, userJson)
    }
    fun getUser(): String? = prefs.getString(UserLocalDbConstraints.userDataKey, null)

    fun isLoggedIn(): Boolean = getUser() != null

    fun clearUser() = prefs.edit {
        remove(UserLocalDbConstraints.userDataKey)
    }

}