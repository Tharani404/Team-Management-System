package com.example.cricketapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPlayer extends AppCompatActivity {
  EditText Name,EditTxtNumber,EditTxtNO2,EditTxtNO4,EditTxtNO5,EditTxtNO7;
  Button button_add;
  Double rate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);
        Name=findViewById(R.id.Name);
        EditTxtNumber=findViewById(R.id.EditTxtNumber);
        EditTxtNO2=findViewById(R.id.EditTxtNO2);
        EditTxtNO4=findViewById(R.id.EditTxtNO4);
        EditTxtNO5=findViewById(R.id.EditTxtNO5);
        EditTxtNO7=findViewById(R.id.EditTxtNO7);

        button_add=findViewById(R.id.button_add);

        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MydatabaseHelper myDB = new MydatabaseHelper(AddPlayer.this);
                myDB.addplayer(
                        Name.getText().toString().trim(),
                        Integer.valueOf(EditTxtNumber.getText().toString().trim()),
                        Integer.valueOf(EditTxtNO2.getText().toString().trim()),
                        Integer.valueOf(EditTxtNO4.getText().toString().trim()),
                        Integer.valueOf(EditTxtNO5.getText().toString().trim()),
                        //rate.toString().trim()
                        EditTxtNO7.getText().toString().trim()


                );

                finish();
            }
        });

    }

    public void CalRate(){
        double runs = Double.parseDouble(EditTxtNumber.getText().toString());
        double matches = Double.parseDouble(EditTxtNO2.getText().toString());
        rate = runs / matches;

    }
}