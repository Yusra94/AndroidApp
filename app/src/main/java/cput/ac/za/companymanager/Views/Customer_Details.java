package cput.ac.za.companymanager.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.ParseException;

import cput.ac.za.companymanager.Model.Customer;
import cput.ac.za.companymanager.R;
import cput.ac.za.companymanager.Services.CustomerService;
import cput.ac.za.companymanager.Services.ServiceImplementation.CustomerServiceImpl;

public class Customer_Details extends AppCompatActivity {

    Button saveBtn;
    Button cancelBtn;
    Customer customer;
    CustomerServiceImpl custImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer__details);

        addEditCustomer();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_customer__details, menu);
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

    public void addEditCustomer()
    {
        saveBtn = (Button) findViewById(R.id.btnSaveCustomerDetails);
        cancelBtn = (Button) findViewById(R.id.btnCancelCustomerDetails);

        cancelBtn.setOnClickListener(new View.OnClickListener(){

            @Override
        public void onClick(View v){

                finish();
            }

        });

        saveBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                EditText name = (EditText) findViewById(R.id.ptCustName);
                EditText surname = (EditText) findViewById(R.id.ptCustSurname);
                EditText phone = (EditText) findViewById(R.id.ptPhoneNumber);
                EditText email = (EditText) findViewById(R.id.ptEmail);
                EditText address = (EditText) findViewById(R.id.ptAddress);

                customer = new Customer("Schalk","Burger","0213711632", "wadadaa","55fhfdjkd");

                name.setText("");
                surname.setText("");
                phone.setText("");
                email.setText("");
                address.setText("");


                Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {

                           // customer = new Customer(name.getText().toString(),surname.getText().toString(),phone.getText().toString(), email.getText().toString(),address.getText().toString());

                            CustomerService custImpl = new CustomerServiceImpl();
                            System.out.println(customer.getName());
                            custImpl.save(customer);
                        }
                    });

                    thread.start();

                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                finish();

            }
        });
    }
}
