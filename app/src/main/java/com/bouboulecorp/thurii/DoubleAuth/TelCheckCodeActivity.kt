package com.bouboulecorp.thurii.DoubleAuth

import android.content.Context
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.addTextChangedListener
import com.bouboulecorp.thurii.R

class TelCheckCodeActivity : AppCompatActivity() {

    companion object {
        private const val TEST_VERIFY_CODE = "666768"
    }

    private val rootLayout: ConstraintLayout by lazy {
        findViewById(R.id.register_tel_layout)
    }
    private val editTextOne: EditText by lazy {
        findViewById(R.id.code_first)
    }
    private val editTextTwo: EditText by lazy {
        findViewById(R.id.code_second)
    }
    private val editTextThree: EditText by lazy {
        findViewById(R.id.code_third)
    }
    private val editTextFour: EditText by lazy {
        findViewById(R.id.code_fourth)
    }
    private val editTextFive: EditText by lazy {
        findViewById(R.id.code_fifth)
    }
    private val editTextSix: EditText by lazy {
        findViewById(R.id.code_sixth)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_tel_check)

        setListener()

        initFocus()
    }

    private fun setListener() {
        rootLayout.setOnClickListener {
            val inputManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(rootLayout.windowToken, 0)
        }

        setTextChangeListener(fromEditText = editTextOne, targetEditText = editTextTwo)
        setTextChangeListener(fromEditText = editTextTwo, targetEditText = editTextThree)
        setTextChangeListener(fromEditText = editTextThree, targetEditText = editTextFour)
        setTextChangeListener(fromEditText = editTextFour, targetEditText = editTextFive)
        setTextChangeListener(fromEditText = editTextFive, targetEditText = editTextSix)
        setTextChangeListener(fromEditText = editTextSix, done = {
            verifyOTPCode()
        })

        setKeyListener(fromEditText = editTextTwo, backToEditText = editTextOne)
        setKeyListener(fromEditText = editTextThree, backToEditText = editTextTwo)
        setKeyListener(fromEditText = editTextFour, backToEditText = editTextThree)
        setKeyListener(fromEditText = editTextFive, backToEditText = editTextFour)
        setKeyListener(fromEditText = editTextSix, backToEditText = editTextFive)
    }

    private fun initFocus() {
        editTextOne.isEnabled = true
        editTextOne.postDelayed({
            editTextOne.requestFocus()
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE)
                    as InputMethodManager
            inputMethodManager.showSoftInput(editTextOne, InputMethodManager.SHOW_FORCED)
        }, 500)
    }

    private fun reset() {
        editTextOne.isEnabled = false
        editTextTwo.isEnabled = false
        editTextThree.isEnabled = false
        editTextFour.isEnabled = false
        editTextFive.isEnabled = false
        editTextSix.isEnabled = false

        editTextOne.setText("")
        editTextTwo.setText("")
        editTextThree.setText("")
        editTextFour.setText("")
        editTextFive.setText("")
        editTextSix.setText("")

        initFocus()
    }

    private fun setTextChangeListener(
        fromEditText: EditText,
        targetEditText: EditText? = null,
        done: (() -> Unit)? = null
    ) {
        fromEditText.addTextChangedListener {
            it?.let { string ->
                if (string.isNotEmpty()) {
                    targetEditText?.let { editText ->
                        editText.isEnabled = true
                        editText.requestFocus()
                    } ?: run {
                        done ?.let { done ->
                            done()
                        }
                    }
                    fromEditText.clearFocus()
                    fromEditText.isEnabled = false
                }
            }
        }
    }

    private fun setKeyListener(fromEditText: EditText, backToEditText: EditText) {
        fromEditText.setOnKeyListener { _, _, event ->
            if (null != event && KeyEvent.KEYCODE_DEL == event.keyCode) {
                backToEditText.isEnabled = true
                backToEditText.requestFocus()
                backToEditText.setText("")

                fromEditText.clearFocus()
                fromEditText.isEnabled = false
            }

            false
        }
    }

    private fun verifyOTPCode() {
        val otpCode = "${editTextOne.text.toString().trim()}" +
            "${editTextTwo.text.toString().trim()}" +
            "${editTextThree.text.toString().trim()}" +
            "${editTextFour.text.toString().trim()}" +
            "${editTextFive.text.toString().trim()}" +
            "${editTextSix.text.toString().trim()}"

        if (6 != otpCode.length) {
            return
        }

        if (otpCode == TEST_VERIFY_CODE) {
            Toast.makeText(this, "success, go next", Toast.LENGTH_LONG).show()

            val inputManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(rootLayout.windowToken, 0)
            return
        }

        Toast.makeText(this, "Error, try again", Toast.LENGTH_LONG).show()
        reset()
    }
}