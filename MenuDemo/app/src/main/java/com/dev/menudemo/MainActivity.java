package com.dev.menudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        switch (itemId) {
            case R.id.new_game:
                Toast.makeText(this, "New Game selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.save_game:
                Toast.makeText(this, "Save Game selected", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Invalid Selection", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}