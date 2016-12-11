package dev.gopikrishna19.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static final int PRICE = 5;
    private static final int CHOCOLATE_PRICE = 1;
    private static final int WHIPPED_CREAM_PRICE = 1;
    private int quantity = 0;
    private CheckBox cbChocolate;
    private CheckBox cbWhippedCream;
    private TextView txtOrderSummary;
    private TextView txtQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbChocolate = (CheckBox) findViewById(R.id.cbChocolate);
        cbWhippedCream = (CheckBox) findViewById(R.id.cbWhippedCream);
        txtOrderSummary = (TextView) findViewById(R.id.txtOrderSummary);
        txtQuantity = (TextView) findViewById(R.id.txtQuantity);

        displayQuantity(quantity);
    }

    private int calculatePrice(int quantity, boolean hasWhippedCream, boolean hasChocolate) {

        int price = PRICE;

        if (hasWhippedCream) {

            price += WHIPPED_CREAM_PRICE;

        }

        if (hasChocolate) {

            price += CHOCOLATE_PRICE;

        }

        return quantity * price;
    }

    public void submitOrder(View view) {

        boolean hasChocolate = cbChocolate.isChecked();
        boolean hasWhippedCream = cbWhippedCream.isChecked();
        int price = calculatePrice(quantity, hasWhippedCream, hasChocolate);

        String orderSummary =
                "Add whipped cream? " + hasWhippedCream + "\n" +
                        "Add chocolate? " + hasChocolate + "\n" +
                        "Price " + NumberFormat.getCurrencyInstance().format(price) + "\n" +
                        "Thank you!";

        displayOrderSummary(orderSummary);
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

    private void displayOrderSummary(String orderSummary) {

        txtOrderSummary.setText(orderSummary);
    }

    private void displayQuantity(int number) {

        txtQuantity.setText(String.valueOf(number));
    }
}
