package com.example.demopassingdata;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;

public class SecondActivity extends AppCompatActivity {

    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtResult = (TextView) findViewById(R.id.txtResult);

        Intent intent = getIntent();

        String result = intent.getStringExtra("result");

        if (result != null && !result.isEmpty()) {
            txtResult.setText(result);
            return;
        }

        Product product = (Product) intent.getSerializableExtra("product");

        if (product != null) {
            txtResult.setText(product.toString());
            return;
        }

        ParcelableProduct parcelableProduct = (ParcelableProduct) intent.getParcelableExtra("parcel");

        if (parcelableProduct != null) {
            txtResult.setText(parcelableProduct.toString());
            return;
        }

        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            int id = bundle.getInt("id");
            String name = bundle.getString("name");
            double price = bundle.getDouble("price");

            txtResult.setText(String.format("id: %d %s %.2f", id, name, price));
            return;
        }

        String[] drinks = intent.getStringArrayExtra("drinks");

        if (drinks != null && drinks.length > 0) {
            txtResult.setText(Arrays.toString(drinks));
            return;
        }


    }
}