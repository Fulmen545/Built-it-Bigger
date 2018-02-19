package com.riso.android.jokes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;

public class JimmyCarr extends AppCompatActivity {
    private static final String JOKE = "joke";
    private TextView jokeTextView;
    private String textJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jimmy_carr);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        jokeTextView = findViewById(R.id.jokeText);
        if (intent.hasExtra(JOKE)){
            textJoke = intent.getStringExtra(JOKE);
        }

        if (textJoke != null){
            jokeTextView.setText(textJoke);
        } else {
            jokeTextView.setText(R.string.block);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
