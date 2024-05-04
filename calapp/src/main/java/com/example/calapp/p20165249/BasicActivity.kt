package com.example.calapp.p20165249

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.calapp.p20165249.R
import net.objecthunter.exp4j.ExpressionBuilder

class BasicActivity : AppCompatActivity() {

    // 뷰들을 참조할 변수들을 선언합니다.
    private lateinit var textview1: TextView
    private lateinit var textview2: TextView
    private lateinit var buttonClear: Button
    private lateinit var buttonBackspace: Button
    private lateinit var buttonPercent: Button
    private lateinit var buttonDivide: Button
    private lateinit var button9: Button
    private lateinit var button8: Button
    private lateinit var button7: Button
    private lateinit var buttonMultiply: Button // 곱하기 버튼을 추가합니다.
    private lateinit var button6: Button // 6 버튼을 추가합니다.
    private lateinit var button5: Button // 5 버튼을 추가합니다.
    private lateinit var button4: Button // 4 버튼을 추가합니다.
    private lateinit var buttonSubtract: Button // 빼기 버튼을 추가합니다.
    private lateinit var button3: Button // 3 버튼을 추가합니다.
    private lateinit var button2: Button // 2 버튼을 추가합니다.
    private lateinit var button1: Button // 1 버튼을 추가합니다.
    private lateinit var buttonPlus: Button // 더하기 버튼을 추가합니다.
    private lateinit var button0: Button // 0 버튼을 추가합니다.
    private lateinit var buttonDot: Button // 소수점 버튼을 추가합니다.
    private lateinit var buttonEqual: Button // 등호 버튼을 추가합니다.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)

        // 뷰들을 아이디로 찾아서 변수들에 할당합니다.
        textview1 = findViewById(R.id.textview1)
        textview2 = findViewById(R.id.textview2)
        buttonClear = findViewById(R.id.buttonClear)
        buttonBackspace = findViewById(R.id.buttonBackspace)
        buttonPercent = findViewById(R.id.buttonPercent)
        buttonDivide = findViewById(R.id.buttonDivide)
        button9 = findViewById(R.id.button9)
        button8 = findViewById(R.id.button8)
        button7 = findViewById(R.id.button7)
        buttonMultiply = findViewById(R.id.buttonMultiply) // 곱하기 버튼을 할당합니다.
        button6 = findViewById(R.id.button6) // 6 버튼을 할당합니다.
        button5 = findViewById(R.id.button5) // 5 버튼을 할당합니다.
        button4 = findViewById(R.id.button4) // 4 버튼을 할당합니다.
        buttonSubtract = findViewById(R.id.buttonSubtract) // 빼기 버튼을 할당합니다.
        button3 = findViewById(R.id.button3) // 3 버튼을 할당합니다.
        button2 = findViewById(R.id.button2) // 2 버튼을 할당합니다.
        button1 = findViewById(R.id.button1) // 1 버튼을 할당합니다.
        buttonPlus = findViewById(R.id.buttonPlus) // 더하기 버튼을 할당합니다.
        button0 = findViewById(R.id.button0) // 0 버튼을 할당합니다.
        buttonDot = findViewById(R.id.buttonDot) // 소수점 버튼을 할당합니다.
        buttonEqual = findViewById(R.id.buttonEqual) // 등호 버튼을 할당합니다.

        // 숫자 버튼들에 클릭 리스너를 설정합니다. 클릭하면 텍스트뷰2에 숫자가 추가됩니다.
        button9.setOnClickListener { appendOnExpression("9", true) }
        button8.setOnClickListener { appendOnExpression("8", true) }
        button7.setOnClickListener { appendOnExpression("7", true) }
        button6.setOnClickListener { appendOnExpression("6", true) } // 6 버튼에 클릭 리스너를 설정합니다.
        button5.setOnClickListener { appendOnExpression("5", true) } // 5 버튼에 클릭 리스너를 설정합니다.
        button4.setOnClickListener { appendOnExpression("4", true) } // 4 버튼에 클릭 리스너를 설정합니다.
        button3.setOnClickListener { appendOnExpression("3", true) } // 3 버튼에 클릭 리스너를 설정합니다.
        button2.setOnClickListener { appendOnExpression("2", true) } // 2 버튼에 클릭 리스너를 설정합니다.
        button1.setOnClickListener { appendOnExpression("1", true) } // 1 버튼에 클릭 리스너를 설정합니다.
        button0.setOnClickListener { appendOnExpression("0", true) } // 0 버튼에 클릭 리스너를 설정합니다.

        // 연산자 버튼들에 클릭 리스너를 설정합니다. 클릭하면 텍스트뷰2에 연산자가 추가됩니다.
        buttonDivide.setOnClickListener { appendOnExpression("/", false) }
        buttonMultiply.setOnClickListener { appendOnExpression("*", false) } // 곱하기 버튼에 클릭 리스너를 설정합니다.
        buttonSubtract.setOnClickListener { appendOnExpression("-", false) } // 빼기 버튼에 클릭 리스너를 설정합니다.
        buttonPlus.setOnClickListener { appendOnExpression("+", false) } // 더하기 버튼에 클릭 리스너를 설정합니다.

        // AC 버튼에 클릭 리스너를 설정합니다. 클릭하면 텍스트뷰1과 텍스트뷰2를 모두 비웁니다.
        buttonClear.setOnClickListener {
            textview1.text = ""
            textview2.text = ""
        }

        // <- 버튼에 클릭 리스너를 설정합니다. 클릭하면 텍스트뷰2의 마지막 글자를 지웁니다.
        buttonBackspace.setOnClickListener {
            val string = textview2.text.toString()
            if (string.isNotEmpty()) {
                textview2.text = string.substring(0, string.length - 1)
            }
            textview1.text = ""
        }

        // % 버튼에 클릭 리스너를 설정합니다. 클릭하면 텍스트뷰2의 값을 100으로 나눕니다.
        buttonPercent.setOnClickListener {
            val string = textview2.text.toString()
            if (string.isNotEmpty()) {
                val value = string.toDouble() / 100
                textview2.text = value.toString()
            }
            textview1.text = ""
        }

        // . 버튼에 클릭 리스너를 설정합니다. 클릭하면 텍스트뷰2에 소수점이 추가됩니다.
        // 단, 이미 소수점이 있으면 추가하지 않습니다.
        buttonDot.setOnClickListener {
            val string = textview2.text.toString()
            if (string.isNotEmpty() && !string.contains(".")) {
                textview2.append(".")
            }
        }

        // = 버튼에 클릭 리스너를 설정합니다. 클릭하면 텍스트뷰2의 수식을 계산하고 결과를 텍스트뷰1에 보여줍니다.
        // exp4j 라이브러리를 사용해서 수식을 파싱하고 계산합니다.
        buttonEqual.setOnClickListener {
            try {
                val expression = ExpressionBuilder(textview2.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()) {
                    textview1.text = longResult.toString()
                } else {
                    textview1.text = result.toString()
                }
            } catch (e: Exception) {
                // 수식이 잘못되었을 경우 예외를 처리합니다.
                textview1.text = "오류"
            }
        }
    }

    // 텍스트뷰2에 글자를 추가하는 함수입니다.
    // canClear 파라미터는 텍스트뷰1을 비울지 여부를 결정합니다.
    private fun appendOnExpression(string: String, canClear: Boolean) {
        if (textview1.text.isNotEmpty()) {
            textview2.text = ""
        }
        if (canClear) {
            textview1.text = ""
            textview2.append(string)
        } else {
            textview2.append(textview1.text)
            textview2.append(string)
            textview1.text = ""
        }
    }
}