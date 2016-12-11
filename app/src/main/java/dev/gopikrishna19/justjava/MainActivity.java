package dev.gopikrishna19.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static final int PRICE = 5;
    private static final int CHOCOLATE_PRICE = 1;
    private static final int WHIPPED_CREAM_PRICE = 1;
    private int quantity = 1;
    private CheckBox cbChocolate;
    private CheckBox cbWhippedCream;
    private EditText editName;
    private TextView txtOrderSummary;
    private TextView txtOrderSummaryTitle;
    private TextView txtQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbChocolate = (CheckBox) findViewById(R.id.cbChocolate);
        cbWhippedCream = (CheckBox) findViewById(R.id.cbWhippedCream);
        editName = (EditText) findViewById(R.id.editName);
        txtOrderSummary = (TextView) findViewById(R.id.txtOrderSummary);
        txtOrderSummaryTitle = (TextView) findViewById(R.id.txtOrderSummaryTitle);
        txtQuantity = (TextView) findViewById(R.id.txtQuantity);

        txtOrderSummaryTitle.setVisibility(View.INVISIBLE);
        txtOrderSummary.setVisibility(View.INVISIBLE);

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
                "Hello, " + editName.getText() + "!\n" +
                        "Add whipped cream? " + hasWhippedCream + "\n" +
                        "Add chocolate? " + hasChocolate + "\n" +
                        "Quantity: " + quantity + "\n" +
                        "Total: " + NumberFormat.getCurrencyInstance().format(price) + "\n" +
                        "Thank you!";

        txtOrderSummary.setVisibility(View.VISIBLE);
        txtOrderSummaryTitle.setVisibility(View.VISIBLE);

        displayOrderSummary(orderSummary);
    }

    public void incrementQuantity(View view) {

        quantity -= 1;

        if (quantity == 101) {
            quantity = 100;
        }

        displayQuantity(quantity);
    }

    public void decrementQuantity(View view) {

        quantity -= 1;

        if (quantity == 0) {
            quantity = 1;
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
