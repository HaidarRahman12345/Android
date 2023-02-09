package com.example.haidarapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mi_input_control_action:
                startActivity(new Intent(this, InputControl.class));
                break;

            case R.id.mi_list_view:
                startActivity(new Intent(this, ListView.class));
                break;

            case R.id.mi_recycle_view:
                startActivity(new Intent(this, RecyleView.class));
            case R.id.mi_quit:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    }

