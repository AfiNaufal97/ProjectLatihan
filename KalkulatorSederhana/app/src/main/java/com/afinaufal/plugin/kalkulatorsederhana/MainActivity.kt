package com.afinaufal.plugin.kalkulatorsederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var PILIHAN:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        validasiNilai()
        inputanNilai()
    }

    private fun inputanNilai(){
        btn_process.setOnClickListener {
            if(validasiNilai()){
                hasilPerhitungan(value1.text.toString().toInt(),
                    value2.text.toString().toInt()
                )
            }else{
                Toast.makeText(this, "Masukan Nilai dengan benar", Toast.LENGTH_SHORT).show()
            }

            rb_group.setOnCheckedChangeListener{group, checkedId ->
                val radioButton = findViewById<RadioButton>(group.checkedRadioButtonId)
                PILIHAN = radioButton.text.toString()
                tv_result.text = "Hasil"
            }
        }
    }

    private fun validasiNilai():Boolean{
        if(value1.text.isNullOrEmpty() || value2.text.isNullOrEmpty()){
            return false
        }else if(PILIHAN == null){
            return false
        }

        return true
    }


    private fun hasilPerhitungan(a:Int, b:Int){
        var nilai:Int = 0
        when(PILIHAN){
            "+" -> nilai = a + b
            "-" -> nilai = a - b
            ":" -> nilai = a / b
            "x" -> nilai = a * b
        }

        tv_result.text = nilai.toString()
    }
}