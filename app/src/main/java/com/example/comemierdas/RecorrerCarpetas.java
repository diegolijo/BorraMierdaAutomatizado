package com.example.comemierdas;

import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.io.File;


public class RecorrerCarpetas implements Runnable {
    private File path;
    private MainActivity activity;
    private int numCarpetas;
    private int numArchivos;
    private String texto;

    public RecorrerCarpetas(File path, MainActivity activity) {
        this.path = path;
        this.activity = activity;
        this.numArchivos = 0;
        this.numCarpetas = 0;
          }


    @Override
    public void run() {
        texto = "";
        numCarpetas=0;
        numArchivos=0;

        recorrerArchivos(path);
        setTexto();
    }


    private void recorrerArchivos(File path) {



        File[] lista = path.listFiles();
        for (File file : lista) {

            if (file.isDirectory()) {
                numCarpetas += 1;
                recorrerArchivos(file);
            } else {
                numArchivos += 1;
                texto += file.getName() + "\n";
            }
        }
    }


    private void setTexto() {


        TextView textView = activity.findViewById(R.id.textViewPath);
        String text =  "Carpetas: " + numCarpetas + "  -  Archivos: " + numArchivos;
        textView.setText(text);

        TextView textView2 = activity.findViewById(R.id.textViewScroll);
        textView2.setMovementMethod(new ScrollingMovementMethod());
        textView2.setText(texto);


    }

}
