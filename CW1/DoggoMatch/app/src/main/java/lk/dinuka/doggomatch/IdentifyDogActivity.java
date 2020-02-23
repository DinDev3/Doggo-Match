package lk.dinuka.doggomatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IdentifyDogActivity extends AppCompatActivity {

    public String allDogBreeds[] = {"Chihuahua", "Afghan Hound", "Basset", "Blood Hound", "Australian Terrier",
            "Golden Retriever", "Labrador Retriever", "Old English Sheepdog", "Rottweiler", "Greater Swiss Mountain Dog", "Dingo"};

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

    List<String> allDisplayedImages = new ArrayList<>();        // all the displayed images are added here. To make sure that images aren't repeated
    private List<String> displayingBreeds = new ArrayList<>();        // the 3 displayed breeds will be here. To make sure that multiple images of the same breed won't be shown together

    public String randomBreed;
    public String randomImageOfChosenBreed;
    private String questionBreed;

    private TextView mBreedNameLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_dog);

        try {
            this.getSupportActionBar().hide();              // remove title bar of app
        } catch (NullPointerException e) {
        }

        setContentView(R.layout.activity_identify_dog);
        mBreedNameLabel = /*(TextView)*/ findViewById(R.id.breed_name_label);         // Connecting TextView to variable

        showImageSet();


    }



    public void showImageSet(){
        ImageView imageDogFirst = findViewById(R.id.first_dog_image);
        ImageView imageDogSecond = findViewById(R.id.second_dog_image);
        ImageView imageDogThird = findViewById(R.id.third_dog_image);


        imageDogFirst.setImageResource(displayRandomImage());
        imageDogSecond.setImageResource(displayRandomImage());
        imageDogThird.setImageResource(displayRandomImage());

        chooseBreedToBeIdentified();            // display breed to be identified
    }


    public int displayRandomImage() {           // method used to display a random image of a random breed

        do {            // making sure that the same images aren't repeated & images of the same breed aren't shown together
            // this will run in an infinite loop once all the images are displayed.

            randomBreed = allDogBreeds[getRandomBreed()];           // get a random breed
            int randomImageIndex = getRandomImage();                // get a random image of a particular breed

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
//            System.out.println(allDisplayedImages);         // to check whether the arrayList is getting updated

        } while (allDisplayedImages.contains(randomImageOfChosenBreed) || displayingBreeds.contains(randomBreed));

        allDisplayedImages.add(randomImageOfChosenBreed);           // to make sure that the image isn't repeated
        displayingBreeds.add(randomBreed);                          // to make sure that images of the same breed aren't shown at once

        // display chosen random image
        return getResources().getIdentifier(randomImageOfChosenBreed, "drawable", "lk.dinuka.doggomatch");
    }


    public int getRandomBreed() {
        //get random number between 0-10 (index range for 11 breeds in the array)
        Random r = new Random();
//        displayToast(Integer.toString(getRandomBreed()));         // not needed. generates another random number
        return r.nextInt(11);
    }

    public int getRandomImage() {
        //get random number between 0-9 (index range for 10 image references in the array)
        Random r = new Random();
        return r.nextInt(10);
    }

    private void chooseBreedToBeIdentified(){           // used to pick the breed to be identified
        Random r = new Random();
        int questionBreedIndex=r.nextInt(3);

        questionBreed = displayingBreeds.get(questionBreedIndex);
        mBreedNameLabel.setText(questionBreed);

    }

    public void showNextImageSet(View view) {       // when "Next" button is clicked, shows new set of images
        displayingBreeds.clear();           // for a new set of image breeds
        showImageSet();
    }


//    public void checkAnswerFirst(View view) {            // when the first image is clicked, checks if the answer is correct
//        ImageView imageDogFirst = findViewById(R.id.first_dog_image);
////        String resourceName = imageDogFirst.getDrawable();
//
//        displayResult();
//    }
//
//    public void checkAnswerSecond(View view) {            // when the second image is clicked, checks if the answer is correct
//
//        displayResult();
//    }
//
//    public void checkAnswerThird(View view) {            // when the third image is clicked, checks if the answer is correct
//
//        displayResult();
//    }
//
//    public void displayResult(){
//        if (){
//
//        } else {
//
//        }
//    }
}
