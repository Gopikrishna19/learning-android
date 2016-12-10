package dev.gopikrishna19.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {

        int numberOfCoffees = 2;

        display(numberOfCoffees);
        displayPrice(numberOfCoffees * 5);
    }

    public void incrementQuantity(View view) {

        int numberOfCoffees = 3;

        display(numberOfCoffees);
        displayPrice(numberOfCoffees * 5);
    }

    public void decrementQuantity(View view) {

        int numberOfCoffees = 1;

        display(numberOfCoffees);
        displayPrice(numberOfCoffees * 5);
    }

    private void displayPrice(int number) {

        TextView txtPrice = (TextView) findViewById(R.id.txtPrice);
        txtPrice.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void display(int number) {

        TextView txtQuantity = (TextView) findViewById(R.id.txtQuantity);
        txtQuantity.setText("" + number);
    }
}
