package com.mfrancetic.numbershapesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private EditText numberEditText;
    private Button checkButton;

    private int enteredNumber;
    private String enteredText;

    private Number inputtedNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberEditText = findViewById(R.id.number_edit_text);
        checkButton = findViewById(R.id.check_button);

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkNumberShape();
                clearEditText();
            }
        });

    }

    private void checkNumberShape() {
        enteredText = numberEditText.getText().toString();

        inputtedNumber = new Number();
        if (!enteredText.isEmpty()) {
            inputtedNumber.numberValue = Integer.parseInt(enteredText);
            String message = " ";

            if (inputtedNumber.isTriangular()) {
                message = message + getString(R.string.toast_triangular) + " ";
            }

            if (inputtedNumber.isRectangular()) {
                message = message + getString(R.string.toast_rectangular) + " ";
            }

            if (inputtedNumber.isSquare()) {
                message = message + getString(R.string.toast_square);
            }

            if (!inputtedNumber.isSquare() && !inputtedNumber.isRectangular() && !inputtedNumber.isTriangular()) {
                Toast.makeText(this, getString(R.string.toast_none), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.toast_text) + message + " " + getString(R.string.toast_number), Toast.LENGTH_SHORT).show();

            }
        } else {
            Toast.makeText(this, getString(R.string.toast_empty_text), Toast.LENGTH_SHORT).show();
        }


    }

    private void clearEditText() {
        numberEditText.setText("");
    }

}
