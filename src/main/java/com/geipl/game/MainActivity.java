package com.geipl.game;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.gridlayout.widget.GridLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    EditText editText;
    TextView textView4;
    EditText textView2;
    Button button7;

    int correctAnswer;
    int score=0;
    int result;
    int noOfQuestions=0;
    EditText textView3;
    GridLayout gridLayout;


    public void generateQuestion(){
        ArrayList<Integer> answer= new ArrayList<>();
        Random rand=new Random();
        int a=rand.nextInt(21);
        int b= rand.nextInt(21);
        result=a+b;
        textView4.setText(Integer.toString(a) + "+ " + Integer.toString(b));

        correctAnswer =rand.nextInt(4);
        int incorrect;
        for(int i=0;i<4;i++){
            if(i==correctAnswer) {
                answer.add(a+b);
            }
            else{
                incorrect=rand.nextInt(41);
                while((a+b)==incorrect){
                    incorrect=rand.nextInt(41);
                }
                answer.add(incorrect);
            }
        }
        button3.setText(Integer.toString(answer.get(0)));
        button4.setText(Integer.toString(answer.get(1)));
        button5.setText(Integer.toString(answer.get(2)));
        button6.setText(Integer.toString(answer.get(3)));

    }
    public void playAgain(View view){
        score=0;
        noOfQuestions=0;
        textView2.setText("30s");
        textView3.setText("0/0");
        editText.setText("");
        button7.setVisibility(View.INVISIBLE);
        generateQuestion();

        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView2.setText(String.valueOf(millisUntilFinished/1000)+ "s");
            }

            @Override
            public void onFinish() {
                button7.setVisibility(View.VISIBLE);
                textView2.setText("0s");
                editText.setText("your result is: "+ Integer.toString(score) + "/" + Integer.toString(noOfQuestions));

            }
        }.start();
    }

    public void goClick(View view){
        try {
            button.setVisibility(View.INVISIBLE);
            gridLayout.setVisibility(GridLayout.VISIBLE);
            button3.setVisibility(GridLayout.VISIBLE);
            button4.setVisibility(GridLayout.VISIBLE);
            button5.setVisibility(GridLayout.VISIBLE);
            button6.setVisibility(GridLayout.VISIBLE);

            new CountDownTimer(30000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    textView2.setText(String.valueOf(millisUntilFinished/1000)+ "s");
                }

                @Override
                public void onFinish() {
                    button7.setVisibility(View.VISIBLE);
                    textView2.setText("0s");
                    editText.setText("your result is: "+ Integer.toString(score) + "/" + Integer.toString(noOfQuestions));

                }
            }.start();

        }
        catch(Exception e){
            Log.i("exception", "gridlayout problem ");
        }
    }
    public void clickButton(View view){
        try {
            Button b = (Button)view;
            if (b.getText().toString().equals(Integer.toString(result))) {
                score++;
                editText.setText("CORRECT!!!!!");
            }
            else {
                editText.setText("WRONG ANSWER!!");
            }
            noOfQuestions++;
            textView3.setText(Integer.toString(score)+ "/" + Integer.toString(noOfQuestions));
            generateQuestion();

        }
        catch(Exception e){
            Log.i("exception", "this is huge mistake");
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button =(Button) findViewById(R.id.button);
        button3 =(Button) findViewById(R.id.button3);
        button4=(Button) findViewById(R.id.button4);
        button5=(Button) findViewById(R.id.button5);
        button6=(Button) findViewById(R.id.button6);
        editText=(EditText) findViewById(R.id.editText);
        textView3=(EditText) findViewById(R.id.textView3);
        textView4=(TextView) findViewById(R.id.textView4);
        textView2=(EditText) findViewById(R.id.textView2);
        button7=(Button) findViewById(R.id.button7);
        gridLayout=(GridLayout) findViewById(R.id.gridLayout);


        playAgain(findViewById(R.id.button7));







    }
}