package lk.dinuka.doggomatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    private Switch mSwitchCountdown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwitchCountdown = findViewById(R.id.switch_countdown);


        // Opening of Activities using button clicks

        Button identifyBreedButton = findViewById(R.id.button_identify_breed);
        identifyBreedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IdentifyBreedActivity.class);

                // letting the next activity know whether the countdown was toggled on/ off
                intent.putExtra("Countdown",mSwitchCountdown.isChecked());

                startActivity(intent);
            }
        });

        Button identifyDogButton = findViewById(R.id.button_identify_dog);
        identifyDogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IdentifyDogActivity.class);

                // letting the next activity know whether the countdown was toggled on/ off
                intent.putExtra("Countdown",mSwitchCountdown.isChecked());

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
