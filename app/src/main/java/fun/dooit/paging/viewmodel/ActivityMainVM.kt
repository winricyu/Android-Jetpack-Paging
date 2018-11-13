package `fun`.dooit.paging.viewmodel

import `fun`.dooit.paging.databinding.ActivityMainBinding
import `fun`.dooit.paging.net.MarvelService
import android.view.View
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import io.reactivex.schedulers.Schedulers
import java.util.function.Consumer

class ActivityMainVM(val binding: ActivityMainBinding) : ViewModel() {


    override fun onCleared() {
        super.onCleared()
        println("ActivityMainVM.onCleared")
    }


    fun onClickSearch(view: View) {
        println("ActivityMainVM.onClickSearch, view = [${view}]")
        startSearch(binding.edtInput.text.trim().toString())
    }


    //泛型
    fun <T : Any> getClassName(obj: T): String {
        return obj.javaClass.simpleName
    }

    //泛型
    fun <T : Number> List<T>.total(): T? {
        var num: T? = 0
        for (t in this) {
            num = t

        }
        return num
    }


    fun startSearch(input: String?) {
        println("ActivityMainVM.startSearch, input = [${input}]")
        if (input.isNullOrEmpty()) return
        //test

        println("getClassName(this) = ${getClassName(this)}")
        val priceList = listOf(55, 66, 77)
        priceList.total()

        val list = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

        list.toObservable() // extension function for Iterables
                .filter { it.contains(input ?: "", true) }
                .subscribeBy(  // named arguments for lambda Subscribers
                        onNext = {
                            println(it)
                        },
                        onError = { it.printStackTrace() },
                        onComplete = { println("Done!") }
                )

//        Observable.just(3,4,5,1)
//                .map {  }


//        if (disposable != null) disposable?.dispose()


        //Marvel API
        /* disposable = MarvelService.create().getCharacter(nameStartsWith = input)
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(
                         { next -> println("next=${next.data?.results?.size}") },
                         { error -> println("error:$error") },
                         { println() }
                 )*/


        //Yolo API
        /*YoloService.create().suggestion()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { next -> println("next=${next.data.size}") },
                        { error -> println("error:$error") }

                )*/

    }

}