/*
Problem 2:  For each employee, create a Modal card where the text of the card has the employee id, first and last name. As the Modal content, include the city and the flag of the city.
*/

// Ensure Lesson_51_DBserver replit is running and is Public!
let employees, info;

async function init(){
  let link = "https://ubiquitous-guacamole-wvrrvgg65qpf9j59-8500.app.github.dev"; //replace with your Dev URL
  let route= "/employees";

  info = await fetch(link+route);
  employees = await info.json();

  generateCards(employees);
}


function generateCards(employees){
  // Display info as a Modal
  let mainpanel = document.getElementById("centerpanel");
  mainpanel.innerHTML = ""; //clear out the container

  // initialize strings for modal text and HTML content
  let text ="";
  let content ="";

  for(let i=0; i<employees.length; i++){
    let employee = employees[i];
    
    // create HTML for Modal text
    text  = `<div class="card" >`
      // add code here
    text += `</div>`;
    
    // create HTML for Modal content
    content  = `<div class="card" >`
      // add code here
    content += `</div>`;
    
     // create Modal object while passing text & content
    
     // render Modal in container
  } 
}


function filter(){
  let city = document.getElementById("city").value;
  console.log(city);

  let newEmployees = []; //create a list of employee info

  for(let i=0; i<employees.length;i++){
    let employee = employees[i] //get each employee's info
    
    if( employee.City == city ) {
          //add to the new list
          newEmployees.push(employee);
       }
  }
  console.log(`number found ${newEmployees.length}`)
  generateCards(newEmployees);
}
