package com.example.pickerfortime;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * Creates the view.
     * @param savedInstanceState    The saved instance state bundle.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) getSupportActionBar().setTitle("Picker For Time");
    }

    /**
     * Handles the button click to create a new time picker fragment and
     * show it.
     *
     * @param view View that was clicked
     */
    public void showTimePicker(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(),
                getString(R.string.timepicker));
    }

    /**
     * Process the time picker result into strings that can be displayed in
     * a Toast.
     *
     * @param hourOfDay Chosen hour
     * @param minute Chosen minute
     */
    public void processTimePickerResult(int hourOfDay, int minute) {
        // Convert time elements into strings.
        String hour_string = Integer.toString(hourOfDay);
        String minute_string = Integer.toString(minute);
        // Assign the concatenated strings to timeMessage.
        String timeMessage = (hour_string + ":" + minute_string);

        Toast.makeText(this,getString(R.string.time_toast)
                + timeMessage, Toast.LENGTH_SHORT).show();
    }
}