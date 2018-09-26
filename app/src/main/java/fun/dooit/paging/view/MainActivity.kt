package `fun`.dooit.paging.view

import `fun`.dooit.paging.R
import `fun`.dooit.paging.logd
import `fun`.dooit.paging.net.MarvelService
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    var disposable: Disposable? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edtInput: EditText? = findViewById(R.id.edt_input)
        findViewById<Button>(R.id.btn_search).setOnClickListener { view -> startSearch(edtInput?.text?.trim().toString()) }


    }

    fun startSearch(input: String) {
//        println("input = [${input}]")
        logd("startSearch:$input")
        if (input.isNullOrEmpty()) return

        if (disposable != null) disposable?.dispose()


        //Marvel API
        disposable = MarvelService.create().getCharacter(nameStartsWith = input)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { next -> println("next=${next.data.results.size}") },
                        { error -> println("error:$error") },
                        { println() }
                )


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
