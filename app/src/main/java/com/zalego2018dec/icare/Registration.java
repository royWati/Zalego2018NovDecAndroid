package com.zalego2018dec.icare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by folio on 12/6/2018.
 */

public class Registration extends AppCompatActivity {

    class xmlVariables{
        /* this subclass contains all the Variable objects that we are
            going to link together with our xml file
         */
        EditText ed_name,ed_phone,ed_email_address,
                ed_password,ed_confirm_password;
        RadioGroup group_gender;
        RadioButton radio_male,radio_female;
        Button btn_save;
    }
    class storedVariables{
        /* this subclass contains primitives that we will
            use to store data from the xml varibles
         */
        String strName,strPhone,strEmail,strPassword,
                strConfirmPassword,strGender;
    }

    /* create global objects that can be
         access by all methods
    */
    xmlVariables xml = new xmlVariables();
    storedVariables stored = new storedVariables();
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        // we want to link our xml variables
        xml.ed_name=findViewById(R.id.ed_name);

    }


}
