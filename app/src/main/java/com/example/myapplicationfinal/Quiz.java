package com.example.myapplicationfinal;
import android.app.Activity;

//creamos una clase quiz que contiene la pregunta , un array de respuestas y un string de respuesta correcta + el constructor
public class Quiz extends Activity {

    public String question;
    public String [] answers;
    public String correct;



    public  Quiz (String question, String[] answers, String correct){


        this.question = question;
        this.answers = answers;
        this.correct = correct;
    }

}
