package lk.dinuka.doggomatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class IdentifyBreedActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int imagesOldEnglishSheep[] = {R.drawable.n02105641_764};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_breed);

        try
        {
            this.getSupportActionBar().hide();              // remove title bar of app
        }
        catch (NullPointerException e){}

        setContentView(R.layout.activity_identify_breed);



        // create the spinner
        Spinner spinner = findViewById(R.id.breed_spinner);

        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        // Create ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.breeds_array, android.R.layout.simple_spinner_item);


        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);             // used to check whether the correct spinner item was identified. <Can remove later>
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void displayToast(String message) {          // used to check whether the spinner works as expected
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }
}
