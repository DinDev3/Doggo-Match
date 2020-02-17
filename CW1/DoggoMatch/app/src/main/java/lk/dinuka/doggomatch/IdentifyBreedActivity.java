package lk.dinuka.doggomatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Random;

public class IdentifyBreedActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public String allDogBreeds[] = {"Chihuahua", "Afghan Hound", "Basset", "Blood Hound", "Australian Terrier",
            "Golden Retriever", "Labrador Retriever", "Old English Sheepdog", "Rottweiler", "Greater Swiss Mountain Dog", "Dingo"};


    // Arrays that reference to the dog images categorized as breed.
    int imagesOldEnglishSheep[] = {R.drawable.n02105641_764, R.drawable.n02105641_6270};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_breed);

        try {
            this.getSupportActionBar().hide();              // remove title bar of app
        } catch (NullPointerException e) {
        }

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
//        displayToast(spinnerLabel);             // used to check whether the correct spinner item was identified. <Can remove later>
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void displayToast(String message) {          // used to check whether the spinner works as expected
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }


    public int getRandomBreed() {
        //get random number between 0-10 (index range for 11 breeds in the array)
        Random r = new Random();
        displayToast(Integer.toString(getRandomBreed()));
        return r.nextInt(11);
    }

}
