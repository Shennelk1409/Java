// Create a webpage to search for employees by City.
// Your DB Server that serves the 'employees' route must be running!!

// Tasks 1 & 2 are in the index.html file
let employees, info;
async function init(){
  let link = "https://ubiquitous-guacamole-wvrrvgg65qpf9j59-8500.app.github.dev"; //replace with your Dev URL
  let route= "/employees";
  info = await fetch(link+route);
  employees = await info.json();

  generateCards(employees);  
}

function generateCards(employees){
  let output = document.getElementById("output");
  let build ="";
   
  for(let i=0; i<employees.length; i++){
    let employee = employees[i];
    build += `<div class="card" >`;
    build +=   `<h3> Employee ID : ${employee.EmployeeId}</h3>`;
    build +=   `<div> First Name : ${employee.FirstName}</div>`;
    build +=   `<div> Last Name : ${employee.LastName}</div>`;
    build +=   `<hr>`;
    build +=   `<p> City : ${employee.City}</p>`;    
    build += `</div>`;
  }
  output.innerHTML = build;  
}

// Task 3: Write the event handler function "filterByCity". 
// Your function should create a new empty array called 'newEmployees' to which you will add employees that match your specific filtering requirements.
function filterByCity(){
  let city = document.getElementById("city").value;
  

  
  // Task 4: Generate the cards with your new array.
    
}