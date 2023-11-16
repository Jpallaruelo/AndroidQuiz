package com.example.myapplicationfinal
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class main : AppCompatActivity() {
    lateinit var totals:TextView;
    lateinit var quiz:TextView;
    lateinit var answer0:Button;
    lateinit var answer1:Button;
    lateinit var answer2:Button;
    lateinit var answer3:Button;
    lateinit var check: Button;
    override fun onCreate(savedInstanceState: Bundle?) {





        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        totals = findViewById(R.id.totals)
        quiz = findViewById(R.id.question)
        answer0 = findViewById(R.id.answer1)
        answer1 = findViewById(R.id.answer2)
        answer2 = findViewById(R.id.answer3)
        answer3 = findViewById(R.id.answer4)
        check = findViewById(R.id.check_andswer);

        QuizGame.InitGame();
        PrintQuiz()


    }




    fun PrintQuiz() //funcion para pintar las preguintas  y respuestas
    {
        answer0.setBackgroundColor(Color.WHITE)
        answer1.setBackgroundColor(Color.WHITE)
        answer2.setBackgroundColor(Color.WHITE)
        answer3.setBackgroundColor(Color.WHITE)

        var newQuiz: Quiz = QuizGame.GetCurrentQuiz();
        quiz.setText(newQuiz.question)
        answer0.setText(newQuiz.answers[0])
        answer1.setText(newQuiz.answers[1])
        answer2.setText(newQuiz.answers[2])
        answer3.setText(newQuiz.answers[3])
        totals.setText(QuizGame.score.toString()+"/"+QuizGame.total.toString())


    }
    public fun SelecAnswer ( view: View ) //funcion para selecionar respuesta y pintar el boton selecionado
    {
        answer0.setBackgroundColor(Color.WHITE)
        answer1.setBackgroundColor(Color.WHITE)
        answer2.setBackgroundColor(Color.WHITE)
        answer3.setBackgroundColor(Color.WHITE)
        var button: Button = view as Button
        button.setBackgroundColor(resources.getColor((R.color.orange)))
        QuizGame.answer = button.text.toString() //cada vez que toca un boton me cambia el answer



    }



    public fun CheckAnswer(view:View)
    {

        if(QuizGame.answer == "") return

        var finished:Boolean = QuizGame.checkAnswer()

        if(finished == false) PrintQuiz()// si es falso imprimo la pantalla otra vez

        else{

            //cambio de pantalla

            if (QuizGame.score > 5) {
                // El usuario ha acertado más de 5 preguntas, cambia a la actividad "Final"
                val intent = Intent(this, Final::class.java)
                startActivity(intent)
            }else {
                // El usuario no ha acertado al menos 5 preguntas, cambia a la actividad "MainActivity"
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

        }





    }


}