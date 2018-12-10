package com.zalego2018dec.icare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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
        xml.ed_phone=findViewById(R.id.ed_phone);
        xml.ed_email_address=findViewById(R.id.ed_email);
        xml.ed_confirm_password=findViewById(R.id.ed_confim_password);
        xml.ed_password=findViewById(R.id.ed_password);
        xml.group_gender=findViewById(R.id.radio_group_gender);
        xml.radio_female=findViewById(R.id.radio_female);
        xml.radio_male=findViewById(R.id.radio_male);
        xml.btn_save=findViewById(R.id.btn_save);

        EventListeners();

    }

    public void EventListeners(){
        /* we are going to store the event listeners
            of the button together with that of the
            radio group and radio buttons
         */

        // we will start with the radio group
        /* radio groups use setonCheckedChangedListener
            because it need to update the value set
            based on the active radio button
         */
        xml.group_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup,
                                         int id) {
                // we need to check which radio button has been clicked
                // way one
                switch (id){
                    case R.id.radio_female:
                        stored.strGender="female";
                        break;
                    case R.id.radio_male:
                        stored.strGender="male";
                        break;
                    default:
                        stored.strGender="no gender selected";
                        break;
                }

                if(xml.radio_female.isChecked()){
                    stored.strGender="female";
                }else if(xml.radio_male.isChecked()){
                    stored.strGender="male";
                }
            }
        });

        /* WE NEED TO ADD AN ACTION LISTENER TO OUR BUTTON
            WHICH WE WILL USE TO CAPTURE INFORMATION
         */
        xml.btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* we want to be able to get the contents of what
                    the user has typed on the editTexts
                 */
                stored.strName=xml.ed_name.getText().toString();
                stored.strEmail=xml.ed_email_address.getText().toString();
                stored.strPassword=xml.ed_password.getText().toString();
                stored.strConfirmPassword=xml.ed_confirm_password.getText().toString();
                stored.strPhone=xml.ed_phone.getText().toString();

                //  check whether the passwords are matching
                boolean check = matchPassword(stored.strConfirmPassword,
                  stored.strPassword);
                if(check){
                    // passwords matched
                    Toast.makeText(Registration.this,
                            "user registered successfully",
                            Toast.LENGTH_SHORT).show();

                    // launch our dashboard activity
                    activityNavigation();
                }

            }
        });
    }

    // this methods will be used to compared if
    // password and confirm passwords match
    public boolean matchPassword(String a,String b){
        if(a.equals(b)){
            return true;
        }else{
            return false;
        }
    }

    public void activityNavigation(){
        /* once the user has registered we want to move
            to launch an activity for the dashboard
         */

    }


}
