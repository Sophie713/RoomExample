package com.sophie.miller.roomwithlivedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

import com.sophie.miller.roomwithlivedata.database.ProductDatabase;
import com.sophie.miller.roomwithlivedata.databinding.ActivityMainBinding;
import com.sophie.miller.roomwithlivedata.objects.Product;
import com.sophie.miller.roomwithlivedata.utils.AppExecutors;
import com.sophie.miller.roomwithlivedata.utils.DatabaseAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainActivityBinding;
    ProductDatabase database;
    DatabaseAdapter databaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainActivityBinding.getRoot());

        database = ProductDatabase.getInstance(this);
        databaseAdapter = new DatabaseAdapter(this);

        mainActivityBinding.mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainActivityBinding.mainRecyclerView.setAdapter(databaseAdapter);
        mainActivityBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product product = new Product(mainActivityBinding.productName.getText().toString(), mainActivityBinding.description.getText().toString(), Double.parseDouble(mainActivityBinding.price.getText().toString()));
                ProductDatabase database = ProductDatabase.getInstance(MainActivity.this);
                database.productDao().insertProduct(product);
                databaseAdapter.setItems(database.productDao().loadAllProducts());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppExecutors.getInstance().getDatabaseExecutor().execute(new Runnable() {
            @Override
            public void run() {
                final List<Product> products = database.productDao().loadAllProducts();
                runOnUiThread(
                        new Runnable() {
                            @Override
                            public void run() {
                                databaseAdapter.setItems(products);
                            }
                        }
                );
            }
        });

    }
}
