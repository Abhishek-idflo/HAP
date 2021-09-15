package com.zabra.isv.hap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button newButton;
    int counter=0;
    int[] viewIdArray=new int[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout layout=(LinearLayout) findViewById(R.id.rootlayout);
        Button add=(Button) findViewById(R.id.addbutton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter<10)
                {
                    addButton(layout,++counter);
                }else{
//                    Toast.makeText(getApplicationContext(),"Can't add more buttons.",Toast.LENGTH_SHORT).show();
                    onError("Can't add more buttons");
                }
            }
        });

        Button delete = (Button) findViewById(R.id.deletbutton);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(counter>0) {
                    deleteButton(layout, counter);
                    counter--;
                }else{
                    //Toast.makeText(getApplicationContext(),"No more Buttons to delete.",Toast.LENGTH_SHORT).show();
                    onError("No more Buttons to delete");
                }
            }
        });

        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }


    public void addButton(LinearLayout layout,int counter){
        newButton=new Button(this);
        newButton.setText("New button "+counter);
        int temp= counter;
        newButton.setId(counter);
        int buttonId = newButton.getId();
        layout.addView(newButton);
        OnclickListener(buttonId);

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
//                startActivity(intent);
//                Toast.makeText(getApplicationContext(),"Button"+counter +"Clicked",Toast.LENGTH_SHORT).show();
                onError("Button"+counter+"cliked");
//                View coordinatorLayout = new View(getApplicationContext());
//                Snackbar.make(coordinatorLayout, "Button is clicked", Snackbar.LENGTH_LONG).show();

            }
        });
    }

    public void OnclickListener(int buttonId){


    }

    public void deleteButton(LinearLayout layout, int i){
        Button myButton = (Button) findViewById(i);

        layout.removeView(myButton);
    }

    public void onError(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_LONG);
        View sbView = snackbar.getView();
        sbView.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBlackModern));
        TextView textView = (TextView) sbView
                .findViewById(R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.whiteModern));
        snackbar.show();
    }
}