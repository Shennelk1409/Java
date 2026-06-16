/* Goal for PART 2: Create a webpage that will display a card for each track(song) in the 'tracks' table from the Chinook database. (See picture "WebPagePicture.PNG").
For Part 1, see "Activity50_DBserver".
*/
let songs;

async function init(){
  // PART 2: Create the webpage. You must: 
  // a) Get the data from your database server and store into a variable.  
  let link = "https://ubiquitous-guacamole-wvrrvgg65qpf9j59-8500.app.github.dev"; 
  // The URL above must be running in a separate broswer tab. (Alternate use: http://localhost:8500 )
  let route= "/songs";

  info = await fetch(link+route);
  songs = await info.json();
  console.log(songs); // confirm data retrieval

  // Invoke(call) function that creates the cards.
  generateCards(songs);
}

// b) Write a function that accepts an array of JSON that contains song information, generates an info card for each track(song) with song name, album title and composer. Display the cards on a webpage. (see "WebPagePicture.PNG" to determine the types of HTML elements to use).
function generateCards(songs){
  // import the output div and initialize the 'build' variable

  // create a for loop to traverse the array
  
  // Inject the build content into the output container
  
}

// c) Add CSS rules to make the output div a flex container and provide appropriate styling for the card. (see picture "WebPagePicture.PNG").

  
