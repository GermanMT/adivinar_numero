package com.mis.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int result;
    static int getRandomNumber(int max, int min)
    {
        return (int)((Math.random()
                * (max - min)) + min);
    }

    public void makeToast(String str)
    {
        Toast.makeText(
                MainActivity.this,
                str,
                Toast.LENGTH_SHORT)
                .show();
    }
    public void clickFunction(View view)
    {
        try{
            int userGuessing;
            EditText variable
                    = (EditText)findViewById(
                    R.id.editId);
            userGuessing
                    = Integer.parseInt(
                    variable
                            .getText()
                            .toString());
            if (userGuessing > 100 || userGuessing < 0) {
                makeToast("El número debe estar entre 1  y 100.");
            } else if (userGuessing < result) {

                makeToast("Piensa un número más grande.");
            }
            else if (userGuessing > result) {
                makeToast("Piensa un número más pequeño.");
            }
            else {
                makeToast(
                        "¡Acertaste!");
            }
        } catch(Exception e) {
            makeToast("No has introducido un número o es demasiado grande.");
        }
    }

    @Override
    protected void onCreate(
            Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int min = 1;
        int max = 100;
        result = getRandomNumber(min, max);
    }
}
