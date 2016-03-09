package com.example.dkenn_000.pocketchange;

import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import java.io.*;

public class MainActivity extends AppCompatActivity {

    public byte[] currency = new byte[12];
    public double totalmoney;
    public double[] currencyvalues = new double[]{100.00, 50.00, 20.00, 10.00, 5.00, 2.00, 1.00, 1.00, 0.25, 0.10, 0.05, 0.01};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
         fab.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        .setAction("Action", null).show();
        }
        });**/
        readfromFile();
        savetoFile();
    }

    public void readfromFile()
    {
        File loc = Environment.getExternalStorageDirectory();
        File sdata = new File(loc,"wallet.txt");
        if(!sdata.exists())
            try
            {
                sdata.createNewFile();
            }
            catch(IOException e)
            {
                System.err.print("Whoops. Cannot create file!");
            }
        else
        {
            InputStream input = null;
            try
            {
                input = new FileInputStream(sdata);
                for(byte i = 0; i < 11; i++)
                {
                    try
                    {
                        currency[i] = (byte)input.read();
                    }
                    catch(IOException o) {
                        System.err.print("Error reading file!");
                    }
                }
            }
            catch(FileNotFoundException e)
            {
                System.err.print("File not found!");
            }
        }
        updateFields();
    }


    public void savetoFile()
    {
        File loc = Environment.getExternalStorageDirectory();
        System.out.println(loc);
        File sdata = new File(loc,"wallet.txt");
        if(!sdata.exists())
            System.err.print("Whoops. File not created!");

        else
        {
            OutputStream output = null;
            try
            {
                output = new FileOutputStream(sdata);
                //for(byte i = 0; i < 12; i++)
                //{
                    try {
                        output.write(currency);
                    }
                    catch(IOException err) {
                        System.err.print("Error writing to file!");
                    }
                //}
            }
            catch(FileNotFoundException e)
            {
                System.err.print("File not found!");
            }
        }

    }

    public void updateFields()
    {
        TextView Textfill = (TextView) this.findViewById(R.id.editText);
        Textfill.setText(String.valueOf(currency[0]));
        Textfill = (TextView) this.findViewById(R.id.editText2);
        Textfill.setText(String.valueOf(currency[1]));
        Textfill = (TextView) this.findViewById(R.id.editText3);
        Textfill.setText(String.valueOf(currency[2]));
        Textfill = (TextView) this.findViewById(R.id.editText4);
        Textfill.setText(String.valueOf(currency[3]));
        Textfill = (TextView) this.findViewById(R.id.editText5);
        Textfill.setText(String.valueOf(currency[4]));
        Textfill = (TextView) this.findViewById(R.id.editText6);
        Textfill.setText(String.valueOf(currency[5]));
        Textfill = (TextView) this.findViewById(R.id.editText7);
        Textfill.setText(String.valueOf(currency[6]));
        Textfill = (TextView) this.findViewById(R.id.editText8);
        Textfill.setText(String.valueOf(currency[7]));
        Textfill = (TextView) this.findViewById(R.id.editText9);
        Textfill.setText(String.valueOf(currency[8]));
        Textfill = (TextView) this.findViewById(R.id.editText10);
        Textfill.setText(String.valueOf(currency[9]));
        Textfill = (TextView) this.findViewById(R.id.editText11);
        Textfill.setText(String.valueOf(currency[10]));
        Textfill = (TextView) this.findViewById(R.id.editText12);
        Textfill.setText(String.valueOf(currency[11]));
        updateTotal();
    }
    public void updateTotal()
    {
        totalmoney = 0.00;
        for(int i = 0; i < 12; ++i)
        {
            double temphold = currency[i] * currencyvalues[i];
            totalmoney += temphold;
        }
        TextView TotalField = (TextView) this.findViewById(R.id.textView2);
        TotalField.setText(String.valueOf(totalmoney));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_settings) {
       //     return true;
        //}

        return super.onOptionsItemSelected(item);
    }

    public void onButtonPress(View view)
    {
        switch(view.getId())
        {
            case R.id.button:
                if(currency[0] < 120)
                    currency[0]++;
                break;
            case R.id.button2:
                if(currency[1] < 120)
                    currency[1]++;
                break;
            case R.id.button3:
                if(currency[2] < 120)
                    currency[2]++;
                break;
            case R.id.button4:
                if(currency[3] < 120)
                    currency[3]++;
                break;
            case R.id.button5:
                if(currency[4] < 120)
                    currency[4]++;
                break;
            case R.id.button6:
                if(currency[5] < 120)
                    currency[5]++;
                break;
            case R.id.button7:
                if(currency[6] < 120)
                    currency[6]++;
                break;
            case R.id.button8:
                if(currency[7] < 120)
                    currency[7]++;
                break;
            case R.id.button9:
                if(currency[8] < 120)
                    currency[8]++;
                break;
            case R.id.button10:
                if(currency[9] < 120)
                    currency[9]++;
                break;
            case R.id.button11:
                if(currency[10] < 120)
                    currency[10]++;
                break;
            case R.id.button12:
                if(currency[11] < 120)
                    currency[11]++;
                break;
            case R.id.button13:
                if(currency[0] > 0)
                    currency[0]--;
                break;
            case R.id.button14:
                if(currency[1] > 0)
                    currency[1]--;
                break;
            case R.id.button15:
                if(currency[2] > 0)
                    currency[2]--;
                break;
            case R.id.button16:
                if(currency[3] > 0)
                    currency[3]--;
                break;
            case R.id.button17:
                if(currency[4] > 0)
                    currency[4]--;
                break;
            case R.id.button18:
                if(currency[5] > 0)
                    currency[5]--;
                break;
            case R.id.button19:
                if(currency[6] > 0)
                    currency[6]--;
                break;
            case R.id.button20:
                if(currency[7] > 0)
                    currency[7]--;
                break;
            case R.id.button21:
                if(currency[8] > 0)
                    currency[8]--;
                break;
            case R.id.button22:
                if(currency[9] > 0)
                    currency[9]--;
                break;
            case R.id.button23:
                if(currency[10] > 0)
                    currency[10]--;
                break;
            case R.id.button24:
                if(currency[11] > 0)
                    currency[11]--;
                break;
        }
        savetoFile();
        updateFields();
    }
    public void resetButton(View v)
    {
        for(byte i =0; i < 12; ++i)
            currency[i] = 0;
        updateFields();
    }
}
