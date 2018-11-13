package `fun`.dooit.paging.view

import `fun`.dooit.paging.R
import `fun`.dooit.paging.databinding.ActivityMainBinding
import `fun`.dooit.paging.viewmodel.ActivityMainVM
import `fun`.dooit.paging.model.Hero
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: ActivityMainVM


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel=ActivityMainVM(binding)
        binding.hero = Hero(copyright = "COOK")
        binding.viewModel = viewModel

    }


}
