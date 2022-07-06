package com.example.tbctask7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.LinearLayoutCompat

class MainActivity : AppCompatActivity(),View.OnClickListener{
    private lateinit var txt : EditText
    private lateinit var addBtn: Button
    private lateinit var checkBox: CheckBox
    private lateinit var scrollView: ScrollView
    private lateinit var linearLayout : LinearLayout
    private lateinit var parentLinearLayoutCompat: LinearLayoutCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt = findViewById(R.id.txt)
        addBtn = findViewById(R.id.addBtn)
        checkBox = findViewById(R.id.checkBox)
        linearLayout = findViewById(R.id.linearLayout)
        scrollView = findViewById(R.id.scrollView)
        parentLinearLayoutCompat = findViewById(R.id.layout)

        val scrollView = ScrollView(this)
        val layoutParams = LinearLayoutCompat.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT)
        scrollView.layoutParams = layoutParams

        val linearLayout = LinearLayoutCompat(this)
        val linearParams = LinearLayoutCompat.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
        linearLayout.orientation = LinearLayoutCompat.VERTICAL
        linearLayout.layoutParams = linearParams

        scrollView.addView(linearLayout)

        findViewById<Button>(R.id.addBtn).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
       when(v!!.id){
           R.id.addBtn -> checker()
       }
    }

    private fun checker (){
        if(checkBox.isChecked){
            txt.inputType = InputType.TYPE_CLASS_NUMBER
        }else{
            txt.inputType = InputType.TYPE_CLASS_TEXT
        }
        createAndAddView()
    }

     private fun createAndAddView (){
        val textView = EditText(this)
         val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT)
         textView.layoutParams = params

         textView.setText("$txt")
         linearLayout.addView(textView)
    }


}