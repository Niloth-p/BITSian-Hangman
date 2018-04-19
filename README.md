# Hang_BPHCian
Hangman game GUI implemented by a BPHCian for BPHCians
In progress.


Running:
Create a project Trial1 and store all the code files within trial1 package. Add the images to a folder named 'images'. Run!


About the code files:
The code is split into classes such a way that each class inherits from the JFrame class, and represents 1 screen each.
Trial1.java - is the started file that creates an object of the MainMenu class.

MainMenu.java - This is the class of the main menu screen, which leads to the Play Settings Menu, Badges, High Scores and Exit. It has the logo of BITS Pilani, and a picture of hangman. There is a mute button provided, but is not functioning yet.

Badges.java - This file creates the badges/achievements screen using a JFrame. It has the images of 8 badges currently. Initially, the grayed out images are displayed, and once the player unlocks the badges, they will be displayed in color.

PlayMenu.java - It provides JComboBoxes (drop down lists) for choosing Player Options like - Single Player/Multi Player; Classic/Timed; Categories - Faculties, Campus, Groups, Courses, Misc.

GameScreen.java - This file has the code for the main game screen. The alphabets are represented using buttons iwthout padding, that changes the color of text once clicked on.

InsertFileData.java - not yet used, will be used to enter the word list from WordList.txt into a SQL table


Improvements to be made: Pull requests are welcome.
-> Enter the wordlist into a SQL table, and query for random words.
-> Improve randomization algo, by adding a column called count to the table. Count should maintain the number of times the word has been called. Now the query should get the word with the given category with the least count.
-> Add stats to the badges screen. Stats like - Total played time; Total deaths; Total words guessed; % Finished; Personal Best Score. Create a table for maintaing that data.
-> Display animations/pop-ups when the player has won/lost/won a badge.
-> Attempt to keep the game running, instead of 1 word per game.
-> Use card layout, eliminate multiple JFrames.
-> Add music and activate the mute button.
-> Add sound effects.
-> Make all screens resizable, by using LayoutManager. Currently, only Play Settings Menu screen is resizable.
-> Implement timer - activated when Timer mode is chosen.
-> Implement SP and MP games.
-> Add words to the word list.
-> Add Categories feature i.e choose words only from the chosen category, by querying for a random word where category is given. Add a label at the bottom of the screen to display the Categories feature.
-> Add more badges and be able to scroll down that screen.
