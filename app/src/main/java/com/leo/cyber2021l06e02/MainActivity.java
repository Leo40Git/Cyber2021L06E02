package com.leo.cyber2021l06e02;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgColor = findViewById(R.id.rgColor);
    }

    public void onClick_btnApply(View view) {
        int col = 0;
        switch (rgColor.getCheckedRadioButtonId()) {
            case R.id.rbColorRed:
                col = android.R.color.holo_red_light;
                break;
            case R.id.rbColorGreen:
                col = android.R.color.holo_green_light;
                break;
            case R.id.rbColorBlue:
                col = android.R.color.holo_blue_light;
                break;
            default:
                Toast.makeText(this, "Invalid selection, somehow???", Toast.LENGTH_SHORT).show();
                return;
        }
        setBackColor(col);
    }

    public void onClick_btnClear(View view) {
        setBackColor(android.R.color.background_light);
    }

    private void setBackColor(int colId) {
        int color;
        if (Build.VERSION.SDK_INT < 23)
            color = getResources().getColor(colId);
        else
            color = getResources().getColor(colId, getTheme());
        getWindow().getDecorView().setBackgroundColor(color);
    }
}
