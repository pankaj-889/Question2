package com.pankaj.kotlinques2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private var finalItem : String = ""
    var itemsname: MutableList<String> = mutableListOf()
    var itemsListname: MutableList<String> = mutableListOf()
    var optionalname : String  = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        val orderBtn : MaterialButton = findViewById(R.id.order_btn)

        //CheckBox Initialization
        val checkbox_pizza : CheckBox = findViewById(R.id.checkbox_pizza)
        val checkbox_cheese : CheckBox = findViewById(R.id.checkbox_cheese)


        //RadioButton Initialization
        val radio_group : RadioGroup = findViewById(R.id.radio_group)
        val radio_extracheese : RadioButton = findViewById(R.id.radio_extracheese)
        val radio_drink : RadioButton = findViewById(R.id.radio_drink)

        val editText : TextInputEditText = findViewById(R.id.edit_text)

        orderBtn.setOnClickListener {

            if(itemsListname.size == 0 && itemsname.size == 0){
                Toast.makeText(this,"Please Add Some Items",Toast.LENGTH_SHORT).show()
            }

            if(checkbox_pizza.isChecked){
                itemsname.add("--> Extra Loaded Onion Pizza")
                checkbox_pizza.toggle()
            }
            if(checkbox_cheese.isChecked){
                itemsname.add("--> Cheese Sweet Corn Pan Pizza")
                checkbox_cheese.toggle()
            }


            radio_group.setOnCheckedChangeListener{
                    _, selected_id ->
                val radioBtn : RadioButton = findViewById(selected_id)
                when(radioBtn){
                    radio_extracheese->{
                        itemsListname.add("--> Extra cheese")

                    }
                    radio_drink->{
                        itemsListname.add("--> Cold Drink")
                    }

                }
            }
            if(editText.text.toString()!=""){
                optionalname  = editText.text.toString()
            }
            if(itemsListname.size != 0 && itemsname.size != 0){
                finalItem += "Your Order\n\n Selected Items : \n"
                for(items in itemsname){
                    finalItem += items + "\n"
                }
                finalItem += "\nAddon Item : \n"
                for(item in itemsListname){
                    finalItem += item + "\n"
                }
                if(optionalname!=""){
                    finalItem += "\nAdd on Items : " +  optionalname
                }

                Toast.makeText(this,finalItem,Toast.LENGTH_LONG).show()

                if(checkbox_pizza.isChecked){
                    checkbox_pizza.toggle()
                }
                if(checkbox_cheese.isChecked){
                    checkbox_cheese.toggle()
                }

                if(radio_extracheese.isChecked){
                    radio_extracheese.isChecked = false
                }
                if(radio_drink.isChecked){
                    radio_drink.isChecked = false
                }
                editText.setText("")
                itemsname.clear()
                itemsListname.clear()
                finalItem = ""
                optionalname = ""

            }

        }
    }
}