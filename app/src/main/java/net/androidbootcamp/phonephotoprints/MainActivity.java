package net.androidbootcamp.phonephotoprints;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double numOfPrints;
    double cost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText numPrints = (EditText)findViewById(R.id.txtNumPrints);
        final RadioButton rad19Cents = (RadioButton)findViewById(R.id.rad19Cents);
        final RadioButton rad49Cents = (RadioButton)findViewById(R.id.rad49Cents);
        final RadioButton rad79Cents = (RadioButton)findViewById(R.id.rad79Cents);
        final TextView result = (TextView) findViewById(R.id.txtResult);

        Button orderPrints = (Button)findViewById(R.id.btnOrder);

        orderPrints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOfPrints = Double.parseDouble(numPrints.getText().toString());
                DecimalFormat hundredth = new DecimalFormat(("##.##"));
                if(numOfPrints > 50){
                    Toast.makeText(MainActivity.this, "There is a limit of up to 50 prints", Toast.LENGTH_LONG ).show();
                }
                else{
                    if(rad19Cents.isChecked()){
                        cost = numOfPrints * 0.19;
                    }
                    else if (rad49Cents.isChecked()){
                        cost = numOfPrints * 0.49;
                    }
                    else if (rad79Cents.isChecked()){
                        cost = numOfPrints * 0.79;
                    }
                    result.setText("The order cost is $ " + hundredth.format(cost));
                }
            }
        });

    }
}
