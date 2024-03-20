package com.example.cambarijanmidtermexamproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Batch_1 extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnRestart;
    public static boolean isX, isO, isWon = false;
    static char[] game = new char[9];
    public static ConstraintLayout bgColor;
    TextView txtPlayer;
    int cellCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batch1);
        List<Button> buttons = new ArrayList<>();
        int values = 1;

        Toast toastMsg = Toast.makeText(this,"Angel Sheinen O. Cambarijan - BATCH 1", Toast.LENGTH_LONG);
        toastMsg.show();

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnRestart = findViewById(R.id.btnRestart);

        txtPlayer = findViewById(R.id.txtPlayer);
        bgColor = findViewById(R.id.bgColor);

        buttons.add(btn1);
        buttons.add(btn2);
        buttons.add(btn3);
        buttons.add(btn4);
        buttons.add(btn5);
        buttons.add(btn6);
        buttons.add(btn7);
        buttons.add(btn8);
        buttons.add(btn9);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCell(btn1,1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCell(btn2,2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCell(btn3,3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCell(btn4,4);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCell(btn5,5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCell(btn6,6);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCell(btn7,7);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCell(btn8,8);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setCell(btn9,9);
            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for(Button btn : buttons) {
                    restartGame(btn);
                }
            }
        });


    }

    // 1 is O/player 1
    // 2 is X/player 2

    @SuppressLint("SetTextI18n")
    public void setCell(Button btn, int num) {

        if(isWon) {
            return;
        }

        if(isO) {
            if(btn.getText().toString().isEmpty()) {
                btn.setText("X");
                game[num-1] = 'X';
                bgColor.setBackgroundColor(Color.BLUE);
                isO = false;
            }
            txtPlayer.setText("Player O's Turn");
        } else {
            if(btn.getText().toString().isEmpty()) {
                btn.setText("O");
                game[num-1] = 'O';
                bgColor.setBackgroundColor(Color.RED);
                isO = true;
            }
            txtPlayer.setText("Player X's Turn");
        }

        cellCount++;
        checkCell();
    }

    public void checkCell() {
        Toast msg;

        if(
                game[0] == 'O' && game[1] == 'O' && game[2] == 'O' ||
                game[3] == 'O' && game[4] == 'O' && game[5] == 'O' ||
                game[6] == 'O' && game[7] == 'O' && game[8] == 'O' ||

                game[0] == 'O' && game[3] == 'O' && game[6] == 'O' ||
                game[1] == 'O' && game[4] == 'O' && game[7] == 'O' ||
                game[2] == 'O' && game[5] == 'O' && game[8] == 'O' ||

                game[0] == 'O' && game[4] == 'O' && game[8] == 'O' ||
                game[2] == 'O' && game[4] == 'O' && game[6] == 'O' ) {

            winMsg('O');
            isWon = true;
            return;
        } if(
                game[0] == 'X' && game[1] == 'X' && game[2] == 'X' ||
                game[3] == 'X' && game[4] == 'X' && game[5] == 'X' ||
                game[6] == 'X' && game[7] == 'X' && game[8] == 'X' ||

                game[0] == 'X' && game[3] == 'X' && game[6] == 'X' ||
                game[1] == 'X' && game[4] == 'X' && game[7] == 'X' ||
                game[2] == 'X' && game[5] == 'X' && game[8] == 'X' ||

                game[0] == 'X' && game[4] == 'X' && game[8] == 'X' ||
                game[2] == 'X' && game[4] == 'X' && game[6] == 'X' ) {

            winMsg('X');
            isWon = true;
            return;
        }

        if(cellCount == 9) {
            msg = Toast.makeText(this,"Stalemate", Toast.LENGTH_LONG);
            msg.show();
        }

    }

    public void winMsg(char c) {
        Toast msg;
        msg = Toast.makeText(this,"Player " + c + " Wins", Toast.LENGTH_LONG);
        msg.show();
    }

    public void restartGame(Button btn) {
        isX = true;
        isO = false;
        isWon = false;
        cellCount = 0;
        btn.setText("");
        txtPlayer.setText("Player O's Turn");
    }

}