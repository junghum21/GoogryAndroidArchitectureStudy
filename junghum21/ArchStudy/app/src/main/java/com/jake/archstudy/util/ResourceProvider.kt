package com.jake.archstudy.util

import android.content.Context
import androidx.annotation.StringRes
import javax.inject.Inject

interface ResourceProvider {

    fun getString(
        @StringRes
        stringResId: Int
    ): String
}

class ResourceProviderImpl @Inject constructor(
    private val context: Context
) : ResourceProvider {

    override fun getString(stringResId: Int): String = context.getString(stringResId)
}