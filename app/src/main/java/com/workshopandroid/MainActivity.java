package com.workshopandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar_main_activity);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_toggle_open, R.string.drawer_toggle_close);
        if (toggle != null) {
            drawerLayout.addDrawerListener(toggle);
        }
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu_main_activity, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Information:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

                alertDialogBuilder.setMessage(R.string.options_menu_message);
                alertDialogBuilder.setPositiveButton(R.string.alert_dialog_main_activity_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getBaseContext(), getResources().getString(R.string.alert_dialog_main_activity_ok), Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialogBuilder.setNegativeButton(R.string.alert_dialog_main_activity_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getBaseContext(), getResources().getString(R.string.alert_dialog_main_activity_cancel), Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialogBuilder.show();

                return true;
            case R.id.Toast:
                Toast.makeText(this, getResources().getString(R.string.options_menu_message), Toast.LENGTH_SHORT).show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        switch (menuItem.getItemId()) {
            case R.id.start_descendant1:
                drawerLayout.closeDrawer(GravityCompat.START);

                startActivity(new Intent(this, FirstDescendantActivity.class));

                return true;
            case R.id.start_descendant2:
                drawerLayout.closeDrawer(GravityCompat.START);

                startActivity(new Intent(this, SecondDescendantActivity.class));

                return true;
            case R.id.start_google_maps:
                drawerLayout.closeDrawer(GravityCompat.START);

                Uri gpsCoordinates = Uri.parse(getResources().getString(R.string.gps));
                Intent intent = new Intent(Intent.ACTION_VIEW, gpsCoordinates);
                intent.setPackage(getResources().getString(R.string.google_maps));

                startActivity(intent);

                return true;
            default:
                return false;
        }
    }
}