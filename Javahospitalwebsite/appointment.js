let employees, info;

async function init(){
  let link = "https://zany-succotash-pjwrvwv59j6xc745-8500.app.github.dev"; //replace with your Dev URL
  let route= "/Employees";

  info = await fetch(link+route);
  employees = await info.json();

  generateCards(employees);
}

function generateCards(employees){  
  let mainpanel = document.getElementById("centerpanel");
  let build ="";
   
  for(let i=0; i<employees.length; i++){
    let employee = employees[i]
    build += `<div class="card" >`
    build += `<h3> Employee ID : ${employee.EmployeeId}</h3>`;
    build += `<div> First Name : ${employee.FirstName}</div>`;
    build += `<div> Last Name : ${employee.LastName}</div>`;
    build += `<p> City : ${employee.City}</p>`;
    build += `<img src="cities/${employee.City}.PNG">`;
    build += `<hr>`;
    build += `</div>`;
  }
  mainpanel.innerHTML = build;  
}

function filter(){
  let city = document.getElementById("city").value;
  console.log(city);

  let newEmployees = []; //create a list of songs searched for
  
  for(let i=0; i<employees.length;i++){
    let employee = employees[i] //get each sog
    //make sure the list is no
    if( employee.City == city ) {
          //add to the new list
          newEmployees.push(employee);
       }
  }
  console.log(`number found ${newEmployees.length}`)
  generateCards(newEmployees);  
}