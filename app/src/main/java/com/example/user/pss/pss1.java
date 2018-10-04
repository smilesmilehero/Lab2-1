package com.example.user.pss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Button;
import android.widget.TextView;

public class pss1 extends AppCompatActivity {

    EditText gamer;
    TextView status;
    RadioButton radioButton;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioGroup radioGroup;
    Button play;
    TextView name;
    TextView winner;
    TextView myMora;
    TextView computerMora;

    int mora_gamer = -1;
    String[] MoraString = {"剪刀", "石頭", "布"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pss1);
        gamer = (EditText) findViewById(R.id.editText);
        status = (TextView) findViewById(R.id.textView);
        radioButton = (RadioButton) findViewById(R.id.radioButton4);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton5);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton6);
        play = (Button) findViewById(R.id.button);
        name = (TextView) findViewById(R.id.textView8);
        winner = (TextView) findViewById(R.id.textView9);
        myMora = (TextView) findViewById(R.id.textView10);
        computerMora = (TextView) findViewById(R.id.textView11);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radioButton4:
                        mora_gamer=0;
                        break;
                    case R.id.radioButton5:
                        mora_gamer=1;
                        break;
                    case R.id.radioButton6:
                        mora_gamer=2;
                        break;
                }
                }

        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gamer.getText().toString().equals(""))
                    status.setText("請選擇玩家名稱");
                else if (mora_gamer == -1)
                    status.setText("請選擇出拳種類");
                else{
                    name.setText(gamer.getText());
                    myMora.setText(MoraString[mora_gamer]);
                    int mora_computer = (int)(Math.random() * 3 );
                    computerMora.setText(MoraString[mora_computer]);
                    if((mora_gamer == 0 && mora_computer ==1)||(mora_gamer == 1 && mora_computer ==2)||(mora_gamer ==2 && mora_computer ==0)) {
                        winner.setText("電腦");
                        status.setText("可惜，電腦獲勝了");
                    } else if (mora_computer == mora_gamer) {
                        winner.setText("平局");
                        status.setText("平局!在試一場看看");
                    } else {
                        winner.setText(gamer.getText());
                        status.setText("恭喜你獲勝了");
                    }

                }

            }
        });
    }
}
