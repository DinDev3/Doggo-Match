package lk.dinuka.doggomatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button identifyBreedButton = findViewById(R.id.button_identify_breed);
        identifyBreedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IdentifyBreedActivity.class);

                startActivity(intent);
            }
        });

        Button identifyDogButton = findViewById(R.id.button_identify_dog);
        identifyDogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IdentifyDogActivity.class);

                startActivity(intent);
            }
        });

        Button searchBreedButton = findViewById(R.id.button_search_breed);
        searchBreedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchBreedActivity.class);

                startActivity(intent);
            }
        });
    }
}
