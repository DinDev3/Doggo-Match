package lk.dinuka.doggomatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SearchBreedActivity extends AppCompatActivity {

    public String allDogBreeds[] = {"Chihuahua", "Afghan Hound", "Basset", "Blood Hound", "Australian Terrier",
            "Golden Retriever", "Labrador Retriever", "Old English Sheepdog", "Rottweiler", "Greater Swiss Mountain Dog", "Dingo"};

    List<String> allBreeds = new ArrayList<>();

    // Arrays that reference to the dog images categorized as breed.
    String[] imagesChihuahua = {"n02085620_242", "n02085620_326", "n02085620_473", "n02085620_477", "n02085620_2887", "n02085620_4441", "n02085620_9654", "n02085620_10074", "n02085620_10976", "n02085620_11696"};
    String[] imagesAfghanHound = {"n02088094_522", "n02088094_791", "n02088094_913", "n02088094_3080", "n02088094_4352", "n02088094_5080", "n02088094_5150", "n02088094_7106", "n02088094_11584", "n02088094_11953"};
    String[] imagesBasset = {"n02088238_658", "n02088238_1454", "n02088238_9162", "n02088238_9257", "n02088238_11113", "n02088238_11511", "n02088238_11849", "n02088238_12555", "n02088238_12966", "n02088238_13908"};
    String[] imagesBloodHound = {"n02088466_1262", "n02088466_7731", "n02088466_7801", "n02088466_7868", "n02088466_8078", "n02088466_8156", "n02088466_8184", "n02088466_8320", "n02088466_8518", "n02088466_10545"};
    String[] imagesAustralianTerrier = {"n02096294_1653", "n02096294_1805", "n02096294_1926", "n02096294_3344", "n02096294_4137", "n02096294_5552", "n02096294_6450", "n02096294_7456", "n02096294_7804", "n02096294_8594"};
    String[] imagesGoldenRetriever = {"n02099601_10", "n02099601_14", "n02099601_67", "n02099601_146", "n02099601_447", "n02099601_2495", "n02099601_2691", "n02099601_7803", "n02099601_7916", "n02099601_7930"};
    String[] imagesLabradorRetriever = {"n02099712_311", "n02099712_475", "n02099712_511", "n02099712_610", "n02099712_619", "n02099712_3197", "n02099712_4133", "n02099712_5338", "n02099712_7133", "n02099712_7866"};
    String[] imagesOldEnglishSheep = {"n02105641_764", "n02105641_6270", "n02105641_523", "n02105641_534", "n02105641_918", "n02105641_1362", "n02105641_1411", "n02105641_3602", "n02105641_7902", "n02105641_9648"};
    String[] imagesRottweiler = {"n02106550_208", "n02106550_895", "n02106550_1742", "n02106550_4920", "n02106550_4962", "n02106550_7616", "n02106550_10555", "n02106550_10966", "n02106550_11002", "n02106550_12642"};
    String[] imagesGreaterSwissMountainDog = {"n02107574_266", "n02107574_306", "n02107574_380", "n02107574_402", "n02107574_988", "n02107574_1032", "n02107574_1387", "n02107574_1569", "n02107574_1952", "n02107574_2724"};
    String[] imagesDingo = {"n02115641_670", "n02115641_726", "n02115641_1228", "n02115641_1380", "n02115641_4563", "n02115641_4601", "n02115641_1154", "n02115641_3214", "n02115641_3862", "n02115641_7109"};


    List<String> shownImages = new ArrayList<>();           // holds all the images that have been displayed


    public String randomImageOfChosenBreed;     // the image id of the image
    private boolean stopHandler;                // checks whether the stop button has been pressed
    private long countdownTime;          // used to pass the remaining countdown time into the saved state when the device is rotated
    private String chosenBreed;
    private int randomImageIndex;           // the position of the image in the relevant array

    private EditText mBreedText;
    private ImageView mImgDisplay;
    private CountDownTimer mCountDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            this.getSupportActionBar().hide();              // remove title bar of app
        } catch (NullPointerException e) {
        }

        setContentView(R.layout.activity_search_breed);
        mImgDisplay = findViewById(R.id.search_random_image);


        allBreeds.addAll(Arrays.asList(allDogBreeds));              // adding all the array elements into an arraylist for convenience of checking 'contains'


        // restore the state
        if (savedInstanceState != null) {
            countdownTime = savedInstanceState.getLong("time_left");
            chosenBreed = savedInstanceState.getString("breed_name");
            randomImageIndex = savedInstanceState.getInt("displayed_index");

            shownImages = savedInstanceState.getStringArrayList("shown_images");

            displayRelevantImage(chosenBreed, randomImageIndex);             // get the id of the image that was already shown before rotating the device

            // display chosen random image
            int resource_id = getResources().getIdentifier(randomImageOfChosenBreed, "drawable", "lk.dinuka.doggomatch");
            mImgDisplay.setImageResource(resource_id);


            runTimer(countdownTime);            // run timer from the point it stopped when rotating the device

        } else {
            // if activity was created for the first time (opened)
            // User's input is required to continue
        }
    }

    @Override
    protected void onDestroy() {                // when going back to the main menu
        super.onDestroy();

        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();           // stopping the countdown running in the background
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("breed_name", chosenBreed);       // breed that was searched for
        outState.putStringArrayList("shown_images", (ArrayList<String>) shownImages);           // all images that were shown
        outState.putInt("displayed_index", randomImageIndex);

        outState.putLong("time_left", countdownTime);          // time left in countdown timer

    }

    public void submitBreed(View view) {
        mBreedText = findViewById(R.id.enter_breed_text);

        stopHandler = false;            // getting rid of the stop handler, to access the loop
        shownImages.clear();                // if images can be repeated after restarting, after pressing the Stop button

        closeKeyboard();            // to close the keyboard

        chosenBreed = mBreedText.getText().toString();

        if (allBreeds.contains(chosenBreed)) {
            // if available in the array of allDogBreeds, pass the string to showSlideShow() function.

            showSlideShow(chosenBreed);         // display initial image

            if (mCountDownTimer != null) {
                mCountDownTimer.cancel();           // resetting the countdown timer
            }


            runTimer(5000);     // run timer for 5 seconds

        } else {
            // Display Toast message to enter valid breed name/ images of entered breed name couldn't be found >>>>>>>>>>
        }
    }

    private void closeKeyboard() {      // to close the keyboard when submit button is clicked, to make it easier for the user
        View view = this.getCurrentFocus();         // getting whatever view that is currently focused on
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


    public void showSlideShow(String breedName) {            // display slide show operation

        do {            // making sure that the same images aren't repeated
            // this will run in an infinite loop once all the images are displayed.

            // shuffle images related to breed name and pass into resource
            randomImageIndex = getRandomImage();                // get a random image of a particular breed

            displayRelevantImage(breedName, randomImageIndex);
        } while (shownImages.contains(randomImageOfChosenBreed));

        shownImages.add(randomImageOfChosenBreed);          // to show unique images of a chosen breed

        int resource_id = getResources().getIdentifier(randomImageOfChosenBreed, "drawable", "lk.dinuka.doggomatch");
        mImgDisplay.setImageResource(resource_id);

    }

    public void displayRelevantImage(String randomBreed, int randomImageIndex) {         // display a chosen image
        switch (randomBreed) {
            case "Chihuahua":
                randomImageOfChosenBreed = imagesChihuahua[randomImageIndex];     // get a random image reference
                break;
            case "Afghan Hound":
                randomImageOfChosenBreed = imagesAfghanHound[randomImageIndex];     // get a random image reference
                break;
            case "Basset":
                randomImageOfChosenBreed = imagesBasset[randomImageIndex];     // get a random image reference
                break;
            case "Blood Hound":
                randomImageOfChosenBreed = imagesBloodHound[randomImageIndex];     // get a random image reference
                break;
            case "Australian Terrier":
                randomImageOfChosenBreed = imagesAustralianTerrier[randomImageIndex];     // get a random image reference
                break;
            case "Golden Retriever":
                randomImageOfChosenBreed = imagesGoldenRetriever[randomImageIndex];     // get a random image reference
                break;
            case "Labrador Retriever":
                randomImageOfChosenBreed = imagesLabradorRetriever[randomImageIndex];     // get a random image reference
                break;
            case "Old English Sheepdog":
                randomImageOfChosenBreed = imagesOldEnglishSheep[randomImageIndex];     // get a random image reference
                break;
            case "Rottweiler":
                randomImageOfChosenBreed = imagesRottweiler[randomImageIndex];     // get a random image reference
                break;
            case "Greater Swiss Mountain Dog":
                randomImageOfChosenBreed = imagesGreaterSwissMountainDog[randomImageIndex];     // get a random image reference
                break;
            case "Dingo":
                randomImageOfChosenBreed = imagesDingo[randomImageIndex];     // get a random image reference
        }
    }


    public int getRandomImage() {
        //get random number between 0-9 (index range for 10 image references in the array)
        Random r = new Random();
        return r.nextInt(10);
    }


    public void stopShow(View view) {           // when Stop button is clicked, the slideshow should be stopped
        stopHandler = true;
    }

    public void runTimer(long setTime) {

        mCountDownTimer = new CountDownTimer(setTime, 1000) {

            public void onTick(long millisUntilFinished) {
                int timeLeft = (int) (1 + (millisUntilFinished / 1000));
                System.out.println("Waiting for " + timeLeft + " secs...");
                countdownTime = millisUntilFinished;
            }

            public void onFinish() {
                if (!stopHandler) {         // if the Stop button hasn't been pressed
                    showSlideShow(chosenBreed);         // display new image after every  5 secs

                    start();            // this will get the CountDownTimer to repeat
                }
            }

        }.start();

    }

}


/*
References:

Hide soft-keyboard
https://www.youtube.com/watch?v=CW5Xekqfx3I


 */