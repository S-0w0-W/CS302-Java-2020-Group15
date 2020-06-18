# ItemBrowsingApp_AndroidApp

## App Background
Due to the shut down of the biggest Japanese comics hosting platform shutting down due to copyright, fellow readers are unable to access them. Our app "Weeb Haven" is an alternative that will provide a platform where users are able to access a large range of Mangas(Japanese comics) and purchase them. This allows users to still have full access to their favorites while promoting the authors by paying for them. This Mobile/tablet application allows a user to purchase japanese comic books (Manga).

## App Details:
Included Content: "main" folder -java -res -manifesto

Due to Github file size/number upload limitations the entire project folder was not able to be put in

Java file contains all the java file that are used for the project to function as intended. For our app there are in total of 9 java files which is a mixure of activities that are paired with an adapter, as well as the Dataprovider and "Manga" object that is used to store all information.

-(MainActivity, MainAdapter) : Main activity provides information that will then be sent directly to the MainAdapter which will then populate the side scrolling gallery(recycler view) in which our case provides the user with "top picks". Here users are able to tap/click onto one of the "top pick" items and it will take them to a more detailed page on the item that was selected.

MainActivity also contain 3 categories that can be taped leading the user to a ListView where all the different items associated to the selected category can be scrolled and browsed(recycler view).

Finally it also has a search bar at the very top of the screen. Upone selected it will then bring the user to the search screen where a specific item can be searched for.

-(ListActivity, ListActivityAdapter): ListActivity file functions very similarly to Main Activity as it is also paired together with an adapter which is in charge of populating the the scrollable list of items. There is only one present for all 3 of the categories to share as the format is the same acrosss all the list views. Depending on the extra information from the intent that is passed in from MainActivity ListActivity will pass through the appropiate items into the list.

-(DetailsActivity, ImageAdapter): Again functioning very silimar to the other pairs again, the adapter will populate the horizontal scrollable picture area inside the DetailsActivity. Here the user can see more information on the specific item that has been selected(stored in each item object).

-(SearchActivity): This activity is not paired with it's own adapter as the scrollable list is identical to the ListActivity, hence it uses the same adapter as ListActivity uses.

Here the activity is able to take in a user input from a query keyboard and filter out by title name of the item. Upon knowing what items match up with the current search string, it uses the ListActivityAdapter to populate only the filtered items.

-(Manga, DataProvider): Manga is an class that are capable of making objects that contain information on a specific item, such as price, title, description, etc which will are then extracted when populating the screen.

DataProvider class simply contains all the information that will be used my the app and contain getter functions to retrieve the correct desired information. Its main purpose is the generation on ArrayLists that hold Manga objects, This is in place of a real database.

Drawable folder: Contains all nessasary pictures/icons/backgrounds that will be used in the app.

Layout folder: Contains all the xml files for the different Activity screens which styalises them for a better user experience.

This repository can be used by creating a new project on *Android studio* and replacing the existing "main" folder located at the directory: app->src within the project folder
