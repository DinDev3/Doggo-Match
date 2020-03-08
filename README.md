# Doggo Match

### A MATCH MADE IN KENNEL!

Doggo Match is a game that tests a user&#39;s knowledge on various breeds of Dogs. The user can choose to either identify a breed from an image of a dog or identify a dog from the name of the breed. There&#39;s also an option to extend the user&#39;s knowledge on dog breeds by searching for a breed and viewing images of dogs related to that particular breed.
</br>The game was made for Android OS as part of the Mobile Application Development module that I followed in my 2<sup>nd</sup> year.

## Technology behind Doggo Match
1. Development IDE - Android Studio 3.5.3
2. Main development language – Java &amp; XML
3. Tested AVD - Nexus 5X
4. Tested API Level - API 29

## Home Screen of Doggo Match game
Displayed below is the Home screen of the **Doggo Match** game.
![main_screen](CW1/Doc/resources/main_screen.png)

The first screen (main screen) welcomes the user into the game with a cheerful, playful image of a dog with the logo of the game. This screen presents the user with 3 options which allows the user to choose the game that the user desires to move forward with. It also has a toggle Countdown option which the user can turn on, if the user wants the first two games to be more challenging with a countdown.

The 3 options shown in the main screen opens the following screens:
- **IDENTIFY THE BREED:** Identify the Breed of the Dog image displayed game.
- **IDENTIFY THE DOG:** Identify the Dog image when the Breed is displayed game.
- **SEARCH DOG BREEDS:** Lets the user search for images of a specific breed and view in a slideshow.

## Featured Screens of Doggo Match game
![featured_screens](CW1/Doc/resources/featured_screens.png)

### Identify the Breed Game

In this game, one random image of a dog of a random breed is displayed to the user. The user can use the spinner to choose a dog breed from a dropdown list which includes all the names of the breeds. When he clicks on the &quot;Submit&quot; button, the user will be displayed with the correctness of his answer. If incorrect, the name of the correct breed will be displayed below the result. The user will be displayed with a &quot;Next&quot; button to continue playing the game.
</br>If the countdown timer is turned on, the user will be allowed to choose a breed only till the timer is reaches 0.

### Identify the Dog Game

In this game, a random breed name is displayed together with the image of the breed and 2 other random dog images of random breeds. All 3 images displayed are of unique breeds. There&#39;s only one correct answer. The user is instructed to choose one image relevant to the breed displayed. The correctness of the chosen image will be notified to the user, below the name of the breed.
</br>When the countdown timer is turned on, if the user doesn&#39;t choose an image by the time the countdown timer reaches 0, the message &quot;Time&#39;s Up!&quot; will be displayed.

### Search Breed

The user can input a name of a dog breed into the text field displayed. When the Submit button is clicked, if the name entered exists in the app, a slideshow of images relevant to that breed will be shown to the user. This option is for the user to extend his/ her knowledge about dog breeds.
</br>The user can stop the slideshow by touching the &quot;Stop&quot; button.

## Basic functionalities developed in the game
- The CountDownTimer offered by Android OS was used for all countdown related events. The countdown timer was repeated whenever required by calling the start() method when the countdown timer finished ticking.
- The countdown timer ticks for 10 seconds in the first 2 games and for 5 seconds each in the &quot;Search Breeds&quot; slideshow. Every tick of the countdown timer occurs after 1 second.
- As soon as the countdown timer reaches 0, the result is displayed to the user.
- For the 2 and the slideshow, every single image displayed is unique.
- When the device is rotated from portrait to landscape and back to portrait, the application resumes from the exact same point (views &amp; data).
