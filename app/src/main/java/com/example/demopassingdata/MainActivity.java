package com.example.demopassingdata;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnPassByString, btnPassBySerializable, btnPassByParcelable, btnPassByBundle, btnPassByArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnPassByString = findViewById(R.id.btnPassByString);
        btnPassBySerializable = findViewById(R.id.btnPassBySerializable);
        btnPassByParcelable = findViewById(R.id.btnPassByParcelable);
        btnPassByBundle = findViewById(R.id.btnPassByBundle);
        btnPassByArray = findViewById(R.id.btnPassByArray);

        btnPassByString.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            intent.putExtra("result", "Hello");

            startActivity(intent);
        });

        btnPassBySerializable.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            intent.putExtra("product", new Product(1, "Water", 30));

            startActivity(intent);
        });


        btnPassByParcelable.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            intent.putExtra("parcel", new ParcelableProduct(1, "Water", 30));

            startActivity(intent);
        });

        btnPassByBundle.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            Bundle bundle = new Bundle();

            bundle.putInt("id", 1);
            bundle.putString("name", "Water");
            bundle.putDouble("price", 30);

            intent.putExtras(bundle);

            startActivity(intent);
        });

        btnPassByArray.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);

            intent.putExtra("drinks", new String[]{"Cà phê", "Pepsi", "7Up"});

            startActivity(intent);
        });


    }
}