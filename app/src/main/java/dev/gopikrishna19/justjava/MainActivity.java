package dev.gopikrishna19.justjava;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
    private TextView txtQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbChocolate = (CheckBox) findViewById(R.id.cbChocolate);
        cbWhippedCream = (CheckBox) findViewById(R.id.cbWhippedCream);
        editName = (EditText) findViewById(R.id.editName);
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

    public void summarizeOrder(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder
                .setMessage(getSummary())
                .setCancelable(false)
                .setTitle(getString(R.string.order_summary))
                .setPositiveButton(getString(R.string.okay), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.cancel();
                    }
                });

        builder.create().show();

    }

    public void submitOrder(View view) {

        String orderSummary = getSummary();

        Intent mailIntent = new Intent(Intent.ACTION_SENDTO);

        mailIntent.setData(Uri.parse("mailto:"));
        mailIntent.putExtra(Intent.EXTRA_EMAIL, "sandalblack19@gmail.com");
        mailIntent.putExtra(Intent.EXTRA_SUBJECT, R.string.order_summary_from_just_java);
        mailIntent.putExtra(Intent.EXTRA_TEXT, orderSummary);

        if (mailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mailIntent);
        }
    }

    private String getSummary() {

        boolean hasChocolate = cbChocolate.isChecked();
        boolean hasWhippedCream = cbWhippedCream.isChecked();
        int price = calculatePrice(quantity, hasWhippedCream, hasChocolate);

        return getString(R.string.order_summary_content, editName.getText(), hasWhippedCream, hasChocolate, quantity, NumberFormat.getCurrencyInstance().format(price));
    }

    public void incrementQuantity(View view) {

        quantity += 1;

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

    private void displayQuantity(int number) {

        txtQuantity.setText(String.valueOf(number));
    }
}
