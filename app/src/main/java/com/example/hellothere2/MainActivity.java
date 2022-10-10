package com.example.hellothere2;


import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b;
    TextView t;
    private Vibrator vibrator;

    @Override
    protected void onStart() {
        super.onStart();
//        Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast toast= Toast.makeText(this, "Hola", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP,0,200);
        toast.show();

        t=findViewById(R.id.texto);
        b=findViewById(R.id.pulsador);
        vibrator=((Vibrator) getSystemService(VIBRATOR_SERVICE));
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!vibrator.hasVibrator()){
                    Toast.makeText(MainActivity.this, "No Vibrator", Toast.LENGTH_SHORT).show();
                }else {
                    vibrator.vibrate(500);
                }
                if (t.getText()==getString(R.string.texto1)){
                    t.setText(getString(R.string.texto2));
                }else {
                    t.setText(getString(R.string.texto1));
                }
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast toast= Toast.makeText(this, "Adios", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,200);
        toast.show();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
        super.onStop();
    }
}