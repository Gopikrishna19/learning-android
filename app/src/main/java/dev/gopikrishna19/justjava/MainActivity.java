package dev.gopikrishna19.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private final int PRICE = 5;
    private int quantity = 0;
    private TextView txtPrice;
    private TextView txtQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPrice = (TextView) findViewById(R.id.txtPrice);
        txtQuantity = (TextView) findViewById(R.id.txtQuantity);

        displayQuantity(quantity);
        displayPrice(quantity * PRICE);
    }

    public void submitOrder(View view) {

        displayPrice(quantity * PRICE);
    }

    public void incrementQuantity(View view) {

        quantity += 1;

        displayQuantity(quantity);
    }

    public void decrementQuantity(View view) {

        quantity -= 1;

        if (quantity < 0) {
            quantity = 0;
        }

        displayQuantity(quantity);
    }

    private void displayPrice(int number) {

        txtPrice.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayQuantity(int number) {

        txtQuantity.setText(String.valueOf(number));
    }
}
