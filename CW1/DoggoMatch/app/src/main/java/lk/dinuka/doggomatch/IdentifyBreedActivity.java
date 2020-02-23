package lk.dinuka.doggomatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Random;

public class IdentifyBreedActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public String allDogBreeds[] = {"Chihuahua", "Afghan Hound", "Basset", "Blood Hound", "Australian Terrier",
            "Golden Retriever", "Labrador Retriever", "Old English Sheepdog", "Rottweiler", "Greater Swiss Mountain Dog", "Dingo"};


    // Arrays that reference to the dog images categorized as breed.
    String imagesOldEnglishSheep[] = {"n02105641_764", "n02105641_6270"};


    public String randomBreed;
    public String randomImageOfChosenBreed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_breed);

        try {
            this.getSupportActionBar().hide();              // remove title bar of app
        } catch (NullPointerException e) {
        }

        setContentView(R.layout.activity_identify_breed);


        //----------Display random image
//        System.out.println(Arrays.toString(imagesOldEnglishSheep));          //--------------check what the array contains
        displayRandomImage();

        //---------Spinner

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


    public void displayRandomImage(){           // method used to display a random image of a random breed
//        randomBreed = allDogBreeds[getRandomBreed()];           // get a random breed
        randomBreed = "Old English Sheepdog";           // get a random breed

        ImageView imageDog = findViewById(R.id.random_dog_image);




        switch (randomBreed) {
            case "Chihuahua":
                break;
            case "Afghan Hound":
                break;
            case "Basset":
                break;
            case "Blood Hound":
                break;
            case "Australian Terrier":
                break;
            case "Golden Retriever":
                break;
            case "Labrador Retriever":
                break;
            case "Old English Sheepdog":
                randomImageOfChosenBreed = imagesOldEnglishSheep[getRandomImage()];     // get a random image reference
                int resource_id = getResources().getIdentifier(randomImageOfChosenBreed, "drawable", "lk.dinuka.doggomatch");
                // have the project name properly in defPackage(= package). Won't work otherwise.

                imageDog.setImageResource(resource_id);
                break;
            case "Rottweiler":
                break;
            case "Greater Swiss Mountain Dog":
                break;
            case "Dingo":
        }


    }



    public int getRandomBreed() {
        //get random number between 0-10 (index range for 11 breeds in the array)
        Random r = new Random();
//        displayToast(Integer.toString(getRandomBreed()));         // not needed. generates another random number
        return r.nextInt(11);
    }

    public int getRandomImage() {
        //get random number between 0-9 (index range for 10 breeds in the array)
        Random r = new Random();
//        return r.nextInt(10);
        return r.nextInt(2);            // to test
    }


}
