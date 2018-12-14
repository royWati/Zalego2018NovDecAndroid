package com.zalego2018dec.icare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.zalego2018dec.icare.DataObjects.DashboardItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by folio on 12/11/2018.
 */

public class Dashboard extends AppCompatActivity {

    class xmlVariable{
        GridView gridView;
    }
    class storedVariables{
        List<DashboardItem> dashboardItemList;
    }
    //creating objects for xmlVariable and storedVariables
    // classes in order to access the variables inside
    xmlVariable xml = new xmlVariable();
    storedVariables store = new storedVariables();
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);


        //adding data to our list
        addDashBoardItems();

        // linking our xml varibles to our xml file
        xml.gridView = findViewById(R.id.gridview_dashboard);
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

    // THIS METHOD WILL BE RESPONSBLE FOR ADDING DATA TO OUR LIST
    public void addDashBoardItems(){
        /* anytime we call this method we need it to
            populate data afresh inorder to avoid redudant data
            thus we have to create a new object of the data
            everytime
         */
        // creating a fresh object of dashboardItemList
        store.dashboardItemList = new ArrayList<>();
        // anytime you want to add data you need to create a new
        // object for it
        DashboardItem data1 = new DashboardItem();
        data1.setIcon(R.mipmap.booking);
        data1.setText("Book Appointment");

        // we add data1 to our list
        store.dashboardItemList.add(data1);
        DashboardItem data2 = new DashboardItem();
        data2.setIcon(R.mipmap.booking);
        data2.setText("My Records");

        // add data2 to our list
        store.dashboardItemList.add(data2);



    }

}
