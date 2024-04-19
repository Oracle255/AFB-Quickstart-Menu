package com.example.afb_quickstart_menu.frontend.activity


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.afb_quickstart_menu.frontend.viewmodel.FileSelectorViewModel
import com.example.afb_quickstart_menu.backend.misc.LoremIpsum
import com.example.afb_quickstart_menu.databinding.ActivityFileSelectorBinding
import com.example.afb_quickstart_menu.backend.misc.DevTestSetting as dts

// fixed memory leak dari deklarasi lateinit :V

private val rCode1 = 404

class FileSelectorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFileSelectorBinding
    private lateinit var viewModel: FileSelectorViewModel
    private val rngText1 = LoremIpsum.loremWithLength(9123)
    private val hideUI = dts.hideDebugUI


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFileSelectorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[FileSelectorViewModel::class.java]

        // TODO : binding konten file ke displayTextContent
        binding.btnLoadFile.setOnClickListener{
            readFile()
        }
        binding.btnRemove.setOnClickListener{
            binding.displayTextContent.text = "please select your text file"
        }
        //
        binding.btnProcess.setOnClickListener{
            binding.apply {
                displayTextContent.text = rngText1
            }
        }

        // test button // TODO : fix null value crash : done
        binding.btnTestLorem.setOnClickListener{
            fun getEdtInt(): Int {
                val input = binding.edtLoremCount.text.toString()
                val inputInt = if (input.isNotEmpty()) {
                    input.toIntOrNull() ?: 1
                } else {
                    0
                }
                return inputInt
            }
            binding.apply {
                //binding.displayTextContent.text = LoremIpsum.loremWithLength(getEdtInt())
                binding.displayTextContent.text = LoremIpsum.sampahStringGenerator(getEdtInt())
            }
        }

    }

    private fun readFile() {
        binding.displayFileLoaded.text = ""
        startActivityForResult(intentRead(), 100)
    }

    private fun intentRead(): Intent {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "text/plain" // tipe file
        }
        return intent
    }

}