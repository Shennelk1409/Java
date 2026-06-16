// Create a webpage to filter for specific Songs based on search criteria.
// Your DB Server that serves the 'songs' route must be running!! (Lesson51 DBserver)

// See index.html file first.
let songs, info, output, cardCount;
async function init(){

  let link = "https://ubiquitous-guacamole-wvrrvgg65qpf9j59-8500.app.github.dev"; //replace with your Dev URL
  let route= "/songs";

  info = await fetch(link+route);
  songs = await info.json();

  generateCards(songs);
}

function generateCards(songs){
  output = document.getElementById("output");
  cardCount = document.getElementById("cardCount");
  let build ="";
  let count = "";
  //Update number of songs found
  count.innerHTML=`Number of songs found: ${songs.length}`;
  
  for(let i=0; i<songs.length; i++){
    let song = songs[i];

    build += `<div class="card" >`
    build += 	`<h4> ${song.Name} </h4>`;
    build += 	`<div> Album </div>`;
    build += 	`<span> ${song.Title} </span>`;
    build += 	`<div> Composer </div>`;
    build += 	`<span> ${song.Composer}</span>`;
    build += `</div>`;

    count++;
  }

  cardCount.innerHTML = `<h2>${count} track(s) found</h2>`;
  output.innerHTML = build;
}

/*
  Challenge 1:
  Write the event handler function "filter1" that searches 
  for songs by song name, album title or composer name. Then
  generate the cards using the generateCards() function provided.
*/
function filter1(){
  


/*
  Challenge 2:
  Write the event handler function "filter2" that searches 
  for songs by album title AND composer name. Then
  generate the cards using the generateCards() function provided.
*/
