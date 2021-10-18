package com.example.calculatorproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.lang.Math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hide(findViewById<TextView>(R.id.width1))
        hide(findViewById<TextView>(R.id.length1))
        hide(findViewById<EditText>(R.id.width2))
        hide(findViewById<EditText>(R.id.length2))
        hide(findViewById<Spinner>(R.id.spinner2))
        hide(findViewById<TextView>(R.id.side1))
        hide(findViewById<EditText>(R.id.side2))
        hide(findViewById<TextView>(R.id.side12))
        hide(findViewById<EditText>(R.id.side22))
        hide(findViewById<TextView>(R.id.side13))
        hide(findViewById<EditText>(R.id.side23))
        hide(findViewById<TextView>(R.id.base1))
        hide(findViewById<EditText>(R.id.base2))
        hide(findViewById<TextView>(R.id.height1))
        hide(findViewById<EditText>(R.id.height2))
        hide(findViewById<TextView>(R.id.answer))

        val shapes = arrayOf("Select a shape", "Rectangle", "Square", "Triangle", "Hexagon")
        val operations = arrayOf("Select an operation", "Perimeter", "Area")
        var shapeSelected = "Select a shape"
        var operationSelected = "Select an operation"

        val arrayAdapterShapes = ArrayAdapter(this, android.R.layout.simple_spinner_item, shapes)
        val arrayAdapterOperations = ArrayAdapter(this, android.R.layout.simple_spinner_item, operations)
        findViewById<Spinner>(R.id.spinner2).adapter = arrayAdapterOperations
        findViewById<Spinner>(R.id.spinner1).adapter = arrayAdapterShapes

        findViewById<Spinner>(R.id.spinner1).onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                findViewById<Spinner>(R.id.spinner2).setSelection(0, true)
                shapeSelected = shapes[p2]
                if (shapes[p2] == "Select a shape") {
                    hide(findViewById<ImageView>(R.id.imageView))
                    hide(findViewById<Spinner>(R.id.spinner2))
                } else {
                    if (shapes[p2] == "Rectangle") {
                        findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.rectangle)
                    } else if (shapes[p2] == "Square") {
                        findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.square)
                    } else if (shapes[p2] == "Triangle") {
                        findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.triangle)
                    } else if (shapes[p2] == "Hexagon") {
                        findViewById<ImageView>(R.id.imageView).setImageResource(R.drawable.hexagon)
                    }
                    show(findViewById<ImageView>(R.id.imageView))
                    show(findViewById<Spinner>(R.id.spinner2))
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        findViewById<Spinner>(R.id.spinner2).onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                operationSelected = operations[p2]
                hide(findViewById<TextView>(R.id.width1))
                hide(findViewById<TextView>(R.id.length1))
                hide(findViewById<EditText>(R.id.width2))
                hide(findViewById<EditText>(R.id.length2))
                hide(findViewById<TextView>(R.id.answer))
                hide(findViewById<TextView>(R.id.side1))
                hide(findViewById<EditText>(R.id.side2))
                hide(findViewById<TextView>(R.id.side12))
                hide(findViewById<EditText>(R.id.side22))
                hide(findViewById<TextView>(R.id.side13))
                hide(findViewById<EditText>(R.id.side23))
                hide(findViewById<TextView>(R.id.base1))
                hide(findViewById<EditText>(R.id.base2))
                hide(findViewById<TextView>(R.id.height1))
                hide(findViewById<EditText>(R.id.height2))
                if (operations[p2] == "Perimeter") {
                    if (shapeSelected == "Rectangle") {
                        show(findViewById<TextView>(R.id.length1))
                        show(findViewById<EditText>(R.id.length2))
                        show(findViewById<TextView>(R.id.width1))
                        show(findViewById<EditText>(R.id.width2))
                    } else if (shapeSelected == "Square" || shapeSelected == "Hexagon") {
                        show(findViewById<TextView>(R.id.side1))
                        show(findViewById<EditText>(R.id.side2))
                    } else if (shapeSelected == "Triangle") {
                        show(findViewById<TextView>(R.id.side1))
                        show(findViewById<EditText>(R.id.side2))
                        show(findViewById<TextView>(R.id.side12))
                        show(findViewById<EditText>(R.id.side22))
                        show(findViewById<TextView>(R.id.side13))
                        show(findViewById<EditText>(R.id.side23))
                    }
                } else if (operations[p2] == "Area") {
                    if (shapeSelected == "Rectangle") {
                        show(findViewById<TextView>(R.id.length1))
                        show(findViewById<EditText>(R.id.length2))
                        show(findViewById<TextView>(R.id.width1))
                        show(findViewById<EditText>(R.id.width2))
                    } else if (shapeSelected == "Square" || shapeSelected == "Hexagon") {
                        show(findViewById<TextView>(R.id.side1))
                        show(findViewById<EditText>(R.id.side2))
                    } else if (shapeSelected == "Triangle") {
                        show(findViewById<TextView>(R.id.base1))
                        show(findViewById<EditText>(R.id.base2))
                        show(findViewById<TextView>(R.id.height1))
                        show(findViewById<EditText>(R.id.height2))
                    }
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }


        findViewById<Button>(R.id.calculate).setOnClickListener {
            if (operationSelected == "Perimeter") {
                if (shapeSelected == "Rectangle") {
                    if (findViewById<EditText>(R.id.width2).text.toString().trim().isNotEmpty() &&
                        findViewById<EditText>(R.id.length2).text.toString().trim().isNotEmpty()) {
                        findViewById<TextView>(R.id.answer).setText(rectanglePerimeter(findViewById<EditText>(R.id.length2).text.toString().toInt(),findViewById<EditText>(R.id.width2).text.toString().toInt()).toString().plus(" units"))
                        show(findViewById<TextView>(R.id.answer))
                    }
                } else if (shapeSelected == "Square") {
                    if (findViewById<EditText>(R.id.side2).text.toString().trim().isNotEmpty()) {
                        findViewById<TextView>(R.id.answer).setText(squarePerimeter(findViewById<EditText>(R.id.side2).text.toString().toInt()).toString().plus(" units"))
                        show(findViewById<TextView>(R.id.answer))
                    }
                } else if (shapeSelected == "Triangle") {
                    if (findViewById<EditText>(R.id.side2).text.toString().trim().isNotEmpty() &&
                        findViewById<EditText>(R.id.side22).text.toString().trim().isNotEmpty() &&
                        findViewById<EditText>(R.id.side23).text.toString().trim().isNotEmpty()) {
                        findViewById<TextView>(R.id.answer).setText(trianglePerimeter(findViewById<EditText>(R.id.side2).text.toString().toInt(), findViewById<EditText>(R.id.side22).text.toString().toInt(), findViewById<EditText>(R.id.side23).text.toString().toInt()).toString().plus(" units"))
                        show(findViewById<TextView>(R.id.answer))
                    }
                } else if (shapeSelected == "Hexagon") {
                    if (findViewById<EditText>(R.id.side2).text.toString().trim().isNotEmpty()) {
                        findViewById<TextView>(R.id.answer).setText(hexagonPerimeter(findViewById<EditText>(R.id.side2).text.toString().toInt()).toString().plus(" units"))
                        show(findViewById<TextView>(R.id.answer))
                    }
                }
            } else if (operationSelected == "Area") {
                if (shapeSelected == "Rectangle") {
                    if (findViewById<EditText>(R.id.width2).text.toString().trim().isNotEmpty() &&
                        findViewById<EditText>(R.id.length2).text.toString().trim().isNotEmpty()) {
                        findViewById<TextView>(R.id.answer).setText(rectangleArea(findViewById<EditText>(R.id.length2).text.toString().toInt(),findViewById<EditText>(R.id.width2).text.toString().toInt()).toString().plus(" units"))
                        show(findViewById<TextView>(R.id.answer))
                    }
                } else if (shapeSelected == "Square") {
                    if (findViewById<EditText>(R.id.side2).text.toString().trim().isNotEmpty()) {
                        findViewById<TextView>(R.id.answer).setText(squareArea(findViewById<EditText>(R.id.side2).text.toString().toInt()).toString().plus(" units"))
                        show(findViewById<TextView>(R.id.answer))
                    }
                } else if (shapeSelected == "Triangle") {
                    if (findViewById<EditText>(R.id.base2).text.toString().trim().isNotEmpty() &&
                        findViewById<EditText>(R.id.height2).text.toString().trim().isNotEmpty()) {
                        findViewById<TextView>(R.id.answer).setText(triangleArea(findViewById<EditText>(R.id.base2).text.toString().toDouble(), findViewById<EditText>(R.id.height2).text.toString().toDouble()).toString().plus(" units"))
                        show(findViewById<TextView>(R.id.answer))
                    }
                } else if (shapeSelected == "Hexagon") {
                    if (findViewById<EditText>(R.id.side2).text.toString().trim().isNotEmpty()) {
                        findViewById<TextView>(R.id.answer).setText(hexagonArea(findViewById<EditText>(R.id.side2).text.toString().toDouble()).toString().plus(" units"))
                        show(findViewById<TextView>(R.id.answer))
                    }
                }
            }
        }
    }

    fun hide(view:View) {
        view.visibility = View.INVISIBLE
    }

    fun show(view:View) {
        view.visibility = View.VISIBLE
    }

    fun rectanglePerimeter(length:Int, width:Int): Int {
        return 2*(length+width)
    }

    fun rectangleArea(length:Int, width:Int): Int {
        return length*width
    }

    fun squarePerimeter(sides:Int): Int {
        return 4*sides
    }

    fun squareArea(sides:Int): Int {
        return sides*sides
    }

    fun trianglePerimeter(side1:Int, side2:Int, side3:Int): Int {
        return side1+side2+side3
    }

    fun triangleArea(height:Double, base:Double): Double {
        return (height*base)/2
    }

    fun hexagonPerimeter(sides:Int): Int {
        return sides*6
    }


    fun hexagonArea(sides:Double): Double {
        return (3.0 * sqrt(3.0))/2.0*sides*sides
    }
}