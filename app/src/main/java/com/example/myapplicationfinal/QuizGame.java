package com.example.myapplicationfinal;

import java.util.Random;







    //creamos la clase quizGame para controlar el juego
    public class QuizGame {

        //usamos la clase quiz para crear un array de quiz para poder jugar
        static public Quiz [] quiz =
                {
                        new Quiz("¿Qué crees que es más importante en una relación de pareja?", new String[]{"Comunicación abierta y honesta","Regalos y sorpresas constantes"," Pasar mucho tiempo juntos"},"Comunicación abierta y honesta"),
                        new Quiz("Los orgasmos múltiples son un mito", new String[]{"Depende de la edad.","No, son una realidad para algunas personas.","Sí, son un mito.","Solo ocurren en películas."},"No, son una realidad para algunas personas."),
                        new Quiz("¿Por qué a las mujeres les cuesta alcanzar el orgasmo solo con la penetración?", new String[]{"Estrés laboral.","Necesidad de estimulación del clítoris.","Falta de excitación.","Todas son ciertas"},"Todas son ciertas"),
                        new Quiz("Las jóvenes pueden utilizar el DIU como anticonceptivo", new String[]{"Depende de la estación del año.","Sí, es una buena opción para las jóvenes.","Solo si están casadas.","No, es solo para mujeres mayores."},"Sí, es una buena opción para las jóvenes."),
                        new Quiz("¿Usar un vibrador puede causar adicción?", new String[]{"Depende de la marca del vibrador.","No, no causa adicción.","Sí, es adictivo.","Solo si se usa en la ducha."},"No, no causa adicción."),
                        new Quiz("Tener fantasías sexuales con personas del mismo sexo te hace lesbiana", new String[]{"Sí, siempre.","Solo si lo haces en público.","No, depende de la capacidad de entablar relaciones amorosas.","Es un mito."},"No, depende de la capacidad de entablar relaciones amorosas."),
                        new Quiz("¿Es peligroso tomar la píldora del día después de forma repetitiva?",new String[]{"Sí, es peligroso para la salud.","No, no hay riesgo.","Solo si eres alérgica.","Depende del día de la semana."},"Sí, es peligroso para la salud."),
                        new Quiz("Un ginecólogo puede determinar si eres virgen",new String[]{"Sí, puede hacerlo con certeza.","No, no es su función y es poco preciso."," Solo si tienes un himen intacto.","Depende de la fase lunar."},"Sí, puede hacerlo con certeza."),
                        new Quiz("¿Deberías compartir tus fantasías sexuales con tu pareja?", new String[]{"Solo si son fantasías románticas.","Depende del clima.","No, es mejor mantenerlas en secreto.","Sí, la comunicación es importante."},"Sí, la comunicación es importante."),
                        new Quiz("¿El sexo oral implica los mismos riesgos que las relaciones vaginales?", new String[]{" No, solo hay riesgo de embarazo.","Depende de la posición.","Solo si se hace en una bañera.","Sí, los riesgos son idénticos."},"Sí, los riesgos son idénticos."),

                };


        //creamos las variables que necesitamos par el score , total y el current
        static public int score , total, current;
        static public String answer;

        static public int [] shuffles; //creamos un array de strings àra desordenar las preguntas

        static public void InitGame() //creamos una funcion para iniciar el juego
        {
            //iniciamos juego y desordenamos preguntas
            score = 0;
            current = 0;
            answer = "";
            total = quiz.length;
            shuffles = new int[total];

            for (int i = 0; i<total; i ++)  shuffles[i] = i;
            for (int i = 0; i<total; i ++)
            {
                int temp = shuffles[i];
                Random random = new Random();
                int randonNum = random.nextInt(total);
                shuffles[i] = shuffles[randonNum];
                shuffles[randonNum] = temp;

            }

        }
        // funcion para mandar preguntas aleatorias
        static public Quiz GetCurrentQuiz ()
        {


            return quiz[shuffles[current]];
        }


        //chequea si la pregunnta es correcta
        static public boolean checkAnswer (){

            if (answer == quiz[shuffles[current]].correct) score ++;

            current ++ ;
            answer = "";



            if(current>= total){

                return true;

            }
            else return false;

        }
    }


