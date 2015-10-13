package cput.ac.za.companymanager.Views;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import cput.ac.za.companymanager.Model.Customer;
import cput.ac.za.companymanager.R;
import cput.ac.za.companymanager.Services.ServiceImplementation.CustomerServiceImpl;

public class Customer_page extends AppCompatActivity {

    List<Customer> customers;
    ArrayList<String> cusList;
    private GridView gridView;
    int pos;
    public static ArrayList<String> ArrayofName = new ArrayList<String>();

    public void openCustomerDetails(View view)
    {
        Intent intent = new Intent(Customer_page.this, Customer_Details.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_page);

        viewCustomers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_customer_page, menu);
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

    public void viewCustomers()
    {

        ListView customerList = (ListView) findViewById(R.id.ListCustomers);
       // Button dltButton = (Button) findViewById(R.id.btnDeleteCustomer);

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                try{

                    CustomerServiceImpl customerService = new CustomerServiceImpl();
                    customers = customerService.findAll();
                    cusList = new ArrayList<String>();
                    System.out.println("|"+customers);

                    for(Customer customer: customers)
                    {
                        System.out.println(customer.getEmail());
                        cusList.add(customer.getCustomerID() + " || " + customer.getName() + "  " + customer.getSurname());
                    }

                }
                catch(Exception e){}
            }
        };

        Thread t1 = new Thread(r1);
        t1.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*Thread thread = new Thread(new Runnable(){

            @Override
            public void run()
            {
                CustomerServiceImpl customerService = new CustomerServiceImpl();
                customers = customerService.findAll();
                cusList = new ArrayList<String>();
                System.out.println("|"+customers);

                for(Customer customer: customers)
                {
                    System.out.println(customer.getEmail());
                    cusList.add(customer.getCustomerID() + " || " + customer.getName() + "  " + customer.getSurname());
                }
            }

        });

        thread.start();

       // thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, cusList);

        customerList.setAdapter(adapter);

        //DELETE CUSTOMER


       /* dltButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {

                    AlertDialog.Builder adb = new AlertDialog.Builder(Customer_page.this);

                    adb.setTitle("Delete");
                    adb.setMessage("Are you sure you want to delete this customer?");

                    //final int pos = position;
                    adb.setNegativeButton("No", null);
                    adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {

                        public void onClick(DialogInterface dialogInterface, int selection) {
                            Thread thread2 = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    Long custID = customers.get(pos).getCustomerID();
                                    System.out.println("RECEIVED ID");
                                    CustomerServiceImpl service = new CustomerServiceImpl();
                                    Customer deletePatient = service.findById(custID);
                                    System.out.println("FIND BY ID");
                                    service.delete(deletePatient);
                                    System.out.println("DELETE");
                                }
                            });

                            thread2.start();

                            try {
                                thread2.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            customers.remove(pos);
                            adapter.notifyDataSetChanged();
                        }
                    });

                    adb.show();


                } catch (Exception e) {

                }
            }

        });*/

        customerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> a, View v, final int position, long id) {

                pos = position;

            }
        });
    }
}
