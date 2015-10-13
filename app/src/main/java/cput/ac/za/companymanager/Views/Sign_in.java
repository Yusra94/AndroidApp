package cput.ac.za.companymanager.Views;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import cput.ac.za.companymanager.Model.Access;
import cput.ac.za.companymanager.R;
import cput.ac.za.companymanager.Services.ServiceImplementation.AccessServiceImpl;

public class Sign_in extends AppCompatActivity {

    private Button logIn;
    private EditText uName;
    private EditText pWord;
    private boolean isValid = false;
    private Access access;

    public Sign_in() {
    }

    public void callMainMenu(View view)
    {
        Intent intent = new Intent(this, Main_Menu.class);
        startActivity(intent);

    }

    public void finishActivity(View view)
    {
        //Intent intent = new Intent(this, Main_Menu.class);
        finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        logIn = (Button) findViewById(R.id.btnLogIn);
        uName = (EditText)findViewById(R.id.txtUsername);
        pWord = (EditText) findViewById(R.id.txtPassword);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((uName.getText().toString().equals("")) || (pWord.getText().toString().equals(""))) {

                    AlertDialog.Builder msg = new AlertDialog.Builder(Sign_in.this);

                    msg.setTitle("Alert!");
                    msg.setMessage("Username or password cannot be empty");

                    msg.show();
                }
                else {

                    uName.setText("");
                    pWord.setText("");
                    /*Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {

                            AccessServiceImpl accessService = new AccessServiceImpl();

                            if (accessService.userLogIn(uName.getText().toString(),pWord.getText().toString())) {

                                isValid = true;
                            }

                            else
                                isValid = false;

                        }

                    });

                    thread.start();

                    try
                    {
                        thread.join();

                    }catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }*/


                        Intent intent = new Intent(Sign_in.this, Main_Menu.class);
                        startActivity(intent);

                }


            }

        });




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_in, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
