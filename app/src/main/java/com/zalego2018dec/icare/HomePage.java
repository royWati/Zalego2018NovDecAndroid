package com.zalego2018dec.icare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by folio on 12/4/2018.
 */

public class HomePage extends AppCompatActivity {

    /* since we have a button in the xml we need to call
    / the same button in java
        N/B the button in java is a class while the
        button in xml is a widget. we create an object
        of the button in java called btn_click which we
        will link together with the one in the xml
    */
    Button btn_click;
    Button btn_reg;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        // link out button object together with the
        // button in the xml
        btn_click=findViewById(R.id.btn_homepage);
        btn_reg= findViewById(R.id.btn_registration);

        inputEvents();
    }
    public void inputEvents(){
        /* this method will be used by the pogram
            to set up event listeners such as
            clicks and longPress clicks and many more
         */

        /* btn_click -> this is our input control
            clickListner ->this is our event listener
            a class called OnClickListener is used to perform
            the action/event that has been triggered by the
            event listener
         */
        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* we will set up a feedback mechanism
                    to show us that a click event has happened
                 */

                // we will use a Toast feedback mechanism
                Toast.makeText(HomePage.this,
                        "this button has been clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // the event we will set here will be provided
                // by the activityNavigation() which has the
                //intent
                activityNavigation();
            }
        });
    }

    public void activityNavigation(){
        // we will write some code to enable us move from
        // HomePage Activity to registration Activity
        // We will use the Intent Class
        Intent intentObj = new Intent(HomePage.this,
                Registration.class);
        startActivity(intentObj);

        /*
            intentObj takes 2 parameters
            ->active activity / context
            ->destination activity
        */

    }
}

