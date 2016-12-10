package dev.gopikrishna19.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {

        displayPrice(quantity * 5);
    }

    public void incrementQuantity(View view) {

        quantity += 1;

        display(quantity);
    }

    public void decrementQuantity(View view) {

        quantity -= 1;

        if (quantity < 0) {
            quantity = 0;
        }

        display(quantity);
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
