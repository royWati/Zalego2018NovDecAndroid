package com.zalego2018dec.icare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * Created by folio on 12/11/2018.
 */

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    /* we will call the method responsible for
        creating our options menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        /* we will call a class called a MenuInflater
            which will be responsible for adding the
            dashboard_menu.xml to our app_bar i.e toolbar
         */
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.dashboard_menu,menu);
        return true;
    }

    /* we add a method that will enable us add click events
        to our created dashboard_menu.xml
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.mi_calender){
            Toast.makeText(Dashboard.this,
                    "calender selected",Toast.LENGTH_SHORT)
                    .show();
        }else if (item.getItemId()==R.id.mi_logout){
            Toast.makeText(Dashboard.this,
                    "logout selected",Toast.LENGTH_SHORT)
                    .show();
        }else if (item.getItemId()==R.id.mi_my_profile){
            Toast.makeText(Dashboard.this,
                    "my profile selected",Toast.LENGTH_SHORT)
                    .show();
        }else if (item.getItemId()==R.id.mi_sync){
            Toast.makeText(Dashboard.this,
                    "Sync selected",Toast.LENGTH_SHORT)
                    .show();
        }
        return true;
    }


}
