package com.example.badal.firstassign;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MathsQuiz extends AppCompatActivity {
    private static final String TAG="MathsQuiz";
    private Button tbutton;
    private Button fbutton;
    private Button nbutton;
    private TextView textView;
    private Random random=new Random();
    private int[] t = new int[1];
    int m,p,m1,flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths_quiz);
        tbutton=(Button) findViewById(R.id.true_btn);
        fbutton=(Button) findViewById(R.id.false_button);
        nbutton=(Button) findViewById(R.id.next_button);
        textView=(TextView) findViewById(R.id.questions);




        nbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t[0] = random.nextInt(1000) + 1;
                textView.setText("Is "+String.valueOf(t[0])+ " a prime number");
                setValue(t[0]);

            }
        });

        tbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m = getValue();
                if (m == 0) {
                    Context context = getApplicationContext();
                    CharSequence text = "Correct!!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                } else {
                    Context context = getApplicationContext();
                    CharSequence text = "Incorrect!!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
        fbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m1=getValue();
                if(m1==0){
                    Context context=getApplicationContext();
                    CharSequence text="Incorrect!!";
                    int duration= Toast.LENGTH_SHORT;
                    Toast toast=Toast.makeText(context,text,duration);
                    toast.show();

                }
                else {
                    Context context=getApplicationContext();
                    CharSequence text="Correct!!";
                    int duration= Toast.LENGTH_SHORT;
                    Toast toast=Toast.makeText(context,text,duration);
                    toast.show();
                }
            }
        });
    }

    private void setValue(int t1){
        p=t1;

    }
    private int getValue() {
        flag=0;
        for(int i=2;i<p;i++)
        {
            if(p%i==0){
                flag=1;
                break;
            }
        }
        return flag;
    }




    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG, "Inside OnStart");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG,"Inside OnPause");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Inside OnREsume");

    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Inside OnSTop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Inside OnDestroy");
    }
}
