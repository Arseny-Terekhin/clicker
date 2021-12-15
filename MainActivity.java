package com.example.newproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Integer counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        resetUI();
    }
    @Override
    protected void onSaveInstanceState(Bundle outstate) {
        super.onSaveInstanceState(outstate);
        outstate.putInt("txt_counter", counter);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null &&
                savedInstanceState.containsKey("txt_counter")) {
            counter = savedInstanceState.getInt("txt_counter");
        }
    }

    public void onClickBtnAddStudents(View view) {
        counter++;
        TextView counterView = (TextView)findViewById(R.id.txt_counter);
        counterView.setText(counter.toString());
        if (counter > 99){
            counterView.setTextSize(35);
        }
        if (counter > 999){
            counterView.setTextSize(25);
        }
        if (counter > 9999){
            counterView.setTextSize(15);
        }

    }
    private void resetUI() {
        TextView counterView = (TextView)findViewById(R.id.txt_counter);
        counterView.setText(""+  counter);
    }
}
