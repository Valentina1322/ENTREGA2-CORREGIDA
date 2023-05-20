package com.example.entrega;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    public EditText editTextEstudiantes, editTextNota1, editTextNota2, editTextNota3, editTextNota4;
    public TextView textViewNotaFinal, textViewReprobado;
    public Button buttonIngresarE, buttonCalcular;
    public RadioButton valor1, valor2, valor3, valor4;

    public double nota1, nota2, nota3, nota4, notaFinal;
    public int numReprobados = 0;
    public int numEstudiantes;
    public double porcentaje1 = 0.2, porcentaje2 = 0.3, porcentaje3 = 0.15, porcentaje4 = 0.35;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEstudiantes = findViewById(R.id.editTextEstudiantes);
        editTextNota1 = findViewById(R.id.editTextNota1);
        editTextNota2 = findViewById(R.id.editTextNota2);
        editTextNota3 = findViewById(R.id.editTextNota3);
        editTextNota4 = findViewById(R.id.editTextNota4);
        valor1 = findViewById(R.id.radioButtonNot1);
        valor2 = findViewById(R.id.radioButtonNot2);
        valor3 = findViewById(R.id.radioButtonNot3);
        valor4 = findViewById(R.id.radioButtonNot4);
        textViewNotaFinal = findViewById(R.id.textViewNotaFinal);
        textViewReprobado = findViewById(R.id.textViewReprobado);
        buttonIngresarE = findViewById(R.id.buttonIngresarE);
        buttonCalcular = findViewById(R.id.buttonCalcular);

    }

    public void CantidadEstudiante(View view) {
        numEstudiantes = Integer.parseInt(editTextEstudiantes.getText().toString());
        Toast.makeText(this, "Se ha registrado la cantidad de estudiantes", Toast.LENGTH_SHORT).show();
        editTextEstudiantes.setText("");
        buttonIngresarE.setEnabled(false);

        if (numEstudiantes == 0) {
            Toast.makeText(this, "La cantidad de estudiantes es 0", Toast.LENGTH_SHORT).show();
            editTextEstudiantes.setText("");
        }
    }

    public boolean Valido(double val) {
        return val >= 0.0 && val <= 5.0;
    }


    public void Calcular(View view) {

        nota1 = Double.parseDouble(editTextNota1.getText().toString());
        nota2 = Double.parseDouble(editTextNota2.getText().toString());
        nota3 = Double.parseDouble(editTextNota3.getText().toString());
        nota4 = Double.parseDouble(editTextNota4.getText().toString());

        boolean opcion = ((MaterialButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioButtonNot1:
                if (opcion)
                    porcentaje1 = 0.2;
                break;
            case R.id.radioButtonNot2:
                if (opcion)
                    porcentaje2 = 0.3;
                break;
            case R.id.radioButtonNot3:
                if (opcion)
                    porcentaje3 = 0.15;
                break;
            case R.id.radioButtonNot4:
                if (opcion)
                    porcentaje4 = 0.35;
                break;
        }

        if (Valido(nota1) && Valido(nota2) && Valido(nota3) && Valido(nota4) && numEstudiantes > 0) {
            nota1 = nota1 * porcentaje1;
            nota2 = nota2 * porcentaje2;
            nota3 = nota3 * porcentaje3;
            nota4 = nota4 * porcentaje4;

            notaFinal = nota1 + nota2 + nota3 + nota4;
            textViewNotaFinal.setText(String.valueOf(notaFinal));


            if (notaFinal < 3.0) {
                numReprobados++;
            }

            numEstudiantes--;
            editTextNota1.setText("");
            editTextNota2.setText("");
            editTextNota3.setText("");
            editTextNota4.setText("");

            if (numEstudiantes == 0) {
                textViewReprobado.setText("Estudiantes Reprobados: " + numReprobados);
                buttonCalcular.setEnabled(false);
            }
        } else {
            Toast.makeText(this, "Ingrese notas válidas", Toast.LENGTH_SHORT).show();
        }
    }
}


    /*public void CantidadEstudiante(View view){
        numEstudiantes=Integer.parseInt(editTextEstudiantes.getText().toString());
        Toast.makeText(this, "La cantidad de estudiantes a sido registrada", Toast.LENGTH_SHORT).show();
        editTextEstudiantes.setText("");

        if (numEstudiantes==0){
            Toast.makeText(this, "La cantidad de estudiantes es 0", Toast.LENGTH_SHORT).show();
            editTextEstudiantes.setText("");
        }
    }*/

   /* public void ConvertirN(){
        nota1=Double.parseDouble(editTextNota1.getText().toString());
        nota2=Double.parseDouble(editTextNota2.getText().toString());
        nota3=Double.parseDouble(editTextNota3.getText().toString());
        nota4=Double.parseDouble(editTextNota4.getText().toString());

    }*/

    /*public boolean Valido(double val){
        if(val>0 && val<=5){
            return true;
        }else{
            return false;
        }
    }

    public boolean Validar(int val2){
        if(val2>0){
            return true;
        }else{
            return false;
        }
    }/*

    /*public void  (View view){
        ConvertirN();

        if(Valido(nota1)&& Valido(nota2)&&Valido(nota3)&& Valido(nota4)&&Validar(numEstudiantes)){
            nota1 =(nota1*porcentaje1);
            nota2 =(nota2*porcentaje2);
            nota3 =(nota3*porcentaje3);
            nota4 =(nota4*porcentaje4);

            notaFinal=nota1+nota2+nota3+nota4;
            textViewNotaFinal.setText(String.valueOf(notaFinal));

            numEstudiantes--;

        }else{

            if(notaFinal<3){
                numRepr++;
                textViewReprobado.setText(String.valueOf(numRepr));
            }

        }*/