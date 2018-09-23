package `fun`.dooit.paging

import android.app.Activity
import android.app.Fragment
import android.util.Log

fun Activity.logd(text: String) {
    `fun`.dooit.paging.logd(this, text)
}

fun Fragment.logd(text: String) {
    `fun`.dooit.paging.logd(this, text)
}

private inline fun <reified E> logd(instance: E, text: String) {
    Log.d(E::class.simpleName, text)
}