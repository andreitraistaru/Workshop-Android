package com.workshopandroid;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void saveButton(View view) {
        StringBuilder message = new StringBuilder();

        RadioButton radioButton1 = findViewById(R.id.radioButton1_main_activity);
        RadioButton radioButton2 = findViewById(R.id.radioButton2_main_activity);
        RadioButton radioButton3 = findViewById(R.id.radioButton3_main_activity);

        if (radioButton1.isChecked()) {
            message.append(getResources().getString(R.string.radio_button1_main_activity));
            message.append(" selected\n");
        } else if (radioButton2.isChecked()) {
            message.append(getResources().getString(R.string.radio_button2_main_activity));
            message.append(" selected\n");
        } else if (radioButton3.isChecked()) {
            message.append(getResources().getString(R.string.radio_button3_main_activity));
            message.append(" selected\n");
        } else {
            message.append("No radioButton selected!\n");
        }

        CheckBox checkBox1 = findViewById(R.id.checkBox1_main_activity);
        CheckBox checkBox2 = findViewById(R.id.checkBox2_main_activity);

        if (checkBox1.isChecked()) {
            message.append(getResources().getString(R.string.checkbox1_main_activity));
            message.append(" selected\n");
        }

        if (checkBox2.isChecked()) {
            message.append(getResources().getString(R.string.checkbox2_main_activity));
            message.append(" selected\n");
        }

        if (!checkBox1.isChecked() && !checkBox2.isChecked()) {
            message.append("No checkBox selected!\n");
        }

        ToggleButton toggleButton = findViewById(R.id.toggleButton_main_activity);

        if (toggleButton.isChecked()) {
            message.append("ToggleButton on\n");
        } else {
            message.append("ToggleButton off\n");
        }

        EditText editText = findViewById(R.id.editText_main_activity);

        message.append("Text is: ");
        message.append(editText.getText());
        message.append("\n");

        Log.v("SAVE", message.toString());
    }

    public void actionButton(View view) {
        Snackbar.make(view, getResources().getString(R.string.snackbar_message), Snackbar.LENGTH_LONG).show();
    }
}