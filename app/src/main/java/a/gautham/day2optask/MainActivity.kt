package a.gautham.day2optask

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // Numbers
    private lateinit var seven: TextView
    private lateinit var eight: TextView
    private lateinit var nine: TextView

    private lateinit var four: TextView
    private lateinit var five: TextView
    private lateinit var six: TextView

    private lateinit var one: TextView
    private lateinit var two: TextView
    private lateinit var three: TextView

    private lateinit var dot: TextView
    private lateinit var zero: TextView
    //Numbers

    //Operators
    private lateinit var divide: TextView
    private lateinit var backspace: ImageView
    private lateinit var multiply: TextView
    private lateinit var subtract: TextView
    private lateinit var add: TextView
    private lateinit var equal: TextView
    //Operators

    private lateinit var console: TextView
    private lateinit var answer: TextView

    private var consoleArray = ArrayList<String>()
    private var p: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
    }

    private fun initUI() {

        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine  = findViewById(R.id.nine)

        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)

        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three= findViewById(R.id.three)

        dot = findViewById(R.id.dot)
        zero = findViewById(R.id.zero)
        //Numbers

        //Operators
        divide = findViewById(R.id.divide)
        backspace = findViewById(R.id.backspace)
        multiply = findViewById(R.id.multiply)
        subtract = findViewById(R.id.subtract)
        add = findViewById(R.id.add)
        equal = findViewById(R.id.equals)
        //Operators

        console = findViewById(R.id.operation_console)
        answer = findViewById(R.id.ans)

        seven.setOnClickListener(this)
        eight.setOnClickListener(this)
        nine.setOnClickListener(this)

        four.setOnClickListener(this)
        five.setOnClickListener(this)
        six.setOnClickListener(this)

        one.setOnClickListener(this)
        two.setOnClickListener(this)
        three.setOnClickListener(this)

        dot.setOnClickListener(this)
        zero.setOnClickListener(this)

        divide.setOnClickListener(this)
        backspace.setOnClickListener(this)

        multiply.setOnClickListener(this)
        subtract.setOnClickListener(this)
        add.setOnClickListener(this)

        equal.setOnClickListener(this)

        backspace.setOnLongClickListener{
            if (consoleArray.size>0)
                consoleArray.clear()
            console.text = consoleArray.joinToString(separator = "")
            answer.visibility = View.GONE
            true
        }

    }

    override fun onClick(view: View?) {

        when(view?.id){
            R.id.seven -> {
                consoleArray.add("7")
            }

            R.id.eight -> {
                consoleArray.add("8")
            }

            R.id.nine -> {
                consoleArray.add("9")
            }

            R.id.four -> {
                consoleArray.add("4")
            }

            R.id.five -> {
                consoleArray.add("5")
            }

            R.id.six -> {
                consoleArray.add("6")
            }

            R.id.one -> {
                consoleArray.add("1")
            }

            R.id.two -> {
                consoleArray.add("2")
            }

            R.id.three -> {
                consoleArray.add("3")
            }

            R.id.dot -> {
                consoleArray.add(".")
            }

            R.id.zero -> {
                consoleArray.add("0")
            }

            R.id.divide -> {
                consoleArray.add("÷")
            }

            R.id.backspace -> {

                if (consoleArray.size<=0)
                    return
                consoleArray.removeAt(consoleArray.lastIndex)
            }

            R.id.multiply -> {
                consoleArray.add("×")
            }

            R.id.subtract -> {
                consoleArray.add("-")
            }

            R.id.add -> {
                consoleArray.add("+")
            }

            R.id.equals -> {
                val nums = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "0")

                var one : String? = null
                var two : String? = null
                var operations : String? = null

                consoleArray.forEach{

                    if (nums.contains(it)){
                        if (operations==null) {
                            if (one!=null){
                                one += it
                            }else{
                                one = it
                            }
                        }
                        else{
                            if (two!=null){
                                two += it
                            }else{
                                two = it
                            }
                        }

                    }else if (operations==null) {
                        operations = it
                    }else if (operations!=null){

                        if (consoleArray[consoleArray.size-1]==it){
                            answer.visibility = View.VISIBLE
                            answer.text = getString(R.string.error)
                            p = null
                            return
                        }

                        one = p.toString()
                        two = null
                        operations = it

                        return@forEach

                    }

                    if (one!=null && two!=null){
                        if (operations == "+"){
                            p = one!!.toInt().plus(two!!.toInt())
                        }

                        if (operations == "-"){
                            p = one!!.toInt().minus(two!!.toInt())
                        }

                        if (operations == "÷"){
                            p = one!!.toInt().div(two!!.toInt())
                        }

                        if (operations == "×"){
                            p = one!!.toInt().times(two!!.toInt())
                        }
                    }

                }

                answer.visibility = View.VISIBLE
                answer.text = p.toString()

            }
        }
        console.text = consoleArray.joinToString(separator = "")

    }

}