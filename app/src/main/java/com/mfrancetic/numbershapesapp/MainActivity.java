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

    private NumberComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        component = DaggerNumberComponent.create();

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

        inputtedNumber = component.getNumber();

        if (!enteredText.isEmpty()) {
            inputtedNumber.numberValue = Integer.parseInt(enteredText);
            String message = " ";

            if (!inputtedNumber.isSquare() && !inputtedNumber.isRectangular() && !inputtedNumber.isTriangular()) {
                Toast.makeText(this, inputtedNumber.numberValue + " " + getString(R.string.toast_none), Toast.LENGTH_SHORT).show();
                return;
            } else if (inputtedNumber.isTriangular() && inputtedNumber.isRectangular() && inputtedNumber.isSquare()) {
                message = message + getString(R.string.toast_triangular) + ", " + getString(R.string.toast_rectangular) + " " + getString(R.string.toast_and) + " " + getString(R.string.toast_square);
            } else if (inputtedNumber.isTriangular() && inputtedNumber.isRectangular() && !inputtedNumber.isSquare()) {
                message = message + getString(R.string.toast_triangular) + " " + getString(R.string.toast_and) + " " + getString(R.string.toast_rectangular);
            } else if (inputtedNumber.isTriangular() && !inputtedNumber.isRectangular() && inputtedNumber.isSquare()) {
                message = message + getString(R.string.toast_triangular) + " " + getString(R.string.toast_and) + " " + getString(R.string.toast_square);
            } else if (!inputtedNumber.isTriangular() && inputtedNumber.isRectangular() && inputtedNumber.isSquare()) {
                message = message + getString(R.string.toast_rectangular) + " " + getString(R.string.toast_and) + " " + getString(R.string.toast_square);
            } else if (!inputtedNumber.isTriangular() && !inputtedNumber.isRectangular() && inputtedNumber.isSquare()) {
                message = message + getString(R.string.toast_square);
            } else if (!inputtedNumber.isTriangular() && inputtedNumber.isRectangular() && !inputtedNumber.isSquare()) {
                message = message + getString(R.string.toast_rectangular);
            } else if (inputtedNumber.isTriangular() && !inputtedNumber.isRectangular() && !inputtedNumber.isSquare()) {
                message = message + getString(R.string.toast_triangular);
            }
            Toast.makeText(this, inputtedNumber.numberValue + " " + getString(R.string.toast_text) + message + " " + getString(R.string.toast_number), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.toast_empty_text), Toast.LENGTH_SHORT).show();
        }
    }

    private void clearEditText() {
        numberEditText.setText("");
    }

}
