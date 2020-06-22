package com.example.mytictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;

import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;     // 0: cross , 1:dot, 2:blank

    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};

    int[] gameState = {2,2,2,2,2,2,2,2,2};

     boolean gameIsActive = true;

     Button playAgainButton;

     ImageView imageView0, imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8;


    public  void appear(View view){


       ImageView counter = (ImageView) view;

       int tappedCounter = Integer.parseInt(counter.getTag().toString());

       if(gameState[tappedCounter]==2 && gameIsActive==true ){

       gameState[tappedCounter] = activePlayer;

       counter.setTranslationY(-1500);

       if(activePlayer==0 ) {

           counter.setImageResource(R.drawable.cross);

           counter.animate().translationYBy(1500).setDuration(300);

           activePlayer=1;
       }

       else {

           counter.setImageResource(R.drawable.dot);

           counter.animate().translationYBy(1500).setDuration(300);

           activePlayer=0;


       }

       for(int[] winningPosition : winningPositions){

           if(gameState[winningPosition[0]] == gameState[winningPosition[1]] &&  gameState[winningPosition[1]] == gameState[winningPosition[2]]  && gameState[winningPosition[0]]!=2 ){

               //Toast.makeText(this, " Someone has won!" , Toast.LENGTH_SHORT).show();

               if(activePlayer==0){

                   Toast.makeText(this,"Dot has won!",Toast.LENGTH_SHORT).show();
               }

               else{

                   Toast.makeText(this,"Cross has won!",Toast.LENGTH_SHORT).show();
               }

               gameIsActive=false;

               playAgainButton.setVisibility(View.VISIBLE);


           }

       }
       if(gameIsActive && allFilled()){
           Toast.makeText(this,"Game Draw",Toast.LENGTH_SHORT).show();
           gameIsActive = false;
           playAgainButton.setVisibility(View.VISIBLE);
       }
       }

    }

    public boolean allFilled() {
        for (int i=0;i<gameState.length;i++){
            if(gameState[i]==2)
                return false;
        }
        return true;
    }

    public  void playAgain(View view){


        gameIsActive=true;

        playAgainButton.setVisibility(View.GONE);

       imageView0.setImageDrawable(null);
        imageView1.setImageDrawable(null);
        imageView2.setImageDrawable(null);
        imageView3.setImageDrawable(null);
        imageView4.setImageDrawable(null);
        imageView5.setImageDrawable(null);
        imageView6.setImageDrawable(null);
        imageView7.setImageDrawable(null);
        imageView8.setImageDrawable(null);

        for(int i=0;i<gameState.length;i++){

            gameState[i]=2;
        }
















    }










    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        playAgainButton = (Button) findViewById(R.id.playAgainButton);

        playAgainButton.setVisibility(View.GONE);

        imageView0 = (ImageView) findViewById(R.id.imageView0);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView7 = (ImageView) findViewById(R.id.imageView7);
        imageView8 = (ImageView) findViewById(R.id.imageView8);


    }
}
