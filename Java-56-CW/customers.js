/*
Problem 1:  For each customer, create a Flip card where the front has the customer ID, first name, last name and their email. The back of the card has the country and the flag.
HINT: You will need to rewrite the generateCards() function.
*/

// Ensure Lesson_51_DBserver replit is running and is Public!
let customers, info;

async function init(){
  let link = "https://ubiquitous-guacamole-wvrrvgg65qpf9j59-8500.app.github.dev"; //replace with your Dev URL
  let route= "/customers";

  info = await fetch(link+route);
  customers = await info.json();

  generateCards(customers);
}

function generateCards(customers){
  // Display info as Flip Cards
  let centerpanel = document.getElementById("centerpanel");
  centerpanel.innerHTML = ""; //clear out the container

  // initialize strings for front and back HTML content
  let front ="";
  let back ="";

  for(let i=0; i<customers.length; i++){
    let customer = customers[i];
    
    // create HTML for Flip card front
    front  = `<div class="card" >`;
      // add code here
    front += `</div>`;
    
    // create HTML for Flip card back
    back  = `<div class="card" >`;
      // add code here
    back += `</div>`;
    
    // create Flip card object while passing front & back content
    
    // render Flip card in container
  }
}

function filter(){
  let country = document.getElementById("country").value;
  console.log(country);

  let customerList = []; //create a list of customer info

  for(let i=0; i<customers.length;i++){
    let customer = customers[i]; //get each customer's info
    
    if( customer.Country == country ) {
          //add to the new list
      customerList.push(customer);
    }
  }
  console.log(`number found ${customerList.length}`)
  generateCards(customerList);  
}
