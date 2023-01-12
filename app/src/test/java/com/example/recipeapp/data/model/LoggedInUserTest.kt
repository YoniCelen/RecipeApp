package com.example.recipeapp.data.model

import junit.framework.TestCase

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class LoggedInUserTest : TestCase() {

    @Test
    fun testGetUserIdRightIdReturnsTrue() {

        val user = LoggedInUser("1","Bob")
        assertThat(user.userId == "1").isTrue();

    }

    @Test
    fun testGetUserIdWrongIdReturnsFalse() {

        val user = LoggedInUser("1","Bob")
        assertThat(user.userId == "2").isFalse();

    }

    @Test
    fun testGetDisplayNameRightNameReturnsTrue() {

        val user = LoggedInUser("1","Bob")
        assertThat(user.displayName == "Bob").isTrue()

    }

    @Test
    fun testGetDisplayNameWrongNameReturnsFalse() {

        val user = LoggedInUser("1","Bob")
        assertThat(user.displayName == "Billy").isFalse()

    }
}