package com.example.recipeapp.data

import android.content.Context
import com.example.recipeapp.MainActivity
import com.example.recipeapp.MyDatabaseHelper
import com.example.recipeapp.data.model.LoggedInUser
import java.io.IOException
import com.example.recipeapp.ui.login.LoginActivity
import java.lang.Exception

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String, context: Context): Result<LoggedInUser> {
        try {
            // TODO: handle loggedInUser authentication
            var myDB = MyDatabaseHelper(context)
            var userRow = myDB.readUser(username, password)
            var user: LoggedInUser

            if (userRow != null) {
                user = LoggedInUser(userRow.getString(0), userRow.getString(1))
            } else if (myDB.checkUsername(username) == null) {
                myDB.addUser(username, password)
                userRow = myDB.readUser(username, password)
                user = LoggedInUser(userRow.getString(0), userRow.getString(1))
            } else {
                return Result.Error(Exception("Wrong password"))
            }
            //val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "Jane Doe")

            return Result.Success(user)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}