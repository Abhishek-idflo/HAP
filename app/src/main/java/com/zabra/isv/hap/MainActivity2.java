package com.zabra.isv.hap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

//    ConstraintLayout mainlayout = (ConstraintLayout) findViewById( R.id.mainlayout);
    Button[] buttons= new Button[10];
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearlayout);

        Button addnew = (Button) findViewById(R.id.addnew);
        addnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewButton(linearLayout,++i);
            }
        });

        Button delete = (Button) findViewById(R.id.delete);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity= new MainActivity();

                mainActivity.deleteButton(linearLayout, i--);
            }
        });
    }


    public void addNewButton(LinearLayout linearLayout, int i){
//        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
       buttons[i]= new Button(this);
       buttons[i].setText("Button"+i);
       buttons[i].setId(i);
       buttons[i].setLayoutParams(new ConstraintLayout.LayoutParams(
               ConstraintLayout.LayoutParams.MATCH_PARENT,
               ConstraintLayout.LayoutParams.WRAP_CONTENT
       ));

        linearLayout.addView(buttons[i]);

        Toast.makeText(getApplicationContext(),Integer.toString(buttons[i].getId()) ,Toast.LENGTH_SHORT).show();
    }

}