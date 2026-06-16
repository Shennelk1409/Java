let data, info; // global variables

async function init(){  
  let link = "";// Insert your Dev URL from Activity 47. The activity (DB server) must be running in a separate tab.
  let route= "";

  /*
  For the problems below, use the DB server you created for Activity 47 and start it. If you did not complete the first 2 problems of activity 47, then use the database server link given in Lesson 48-Discussion solution (today's lesson).
  Make sure the link (forwarded Address from the "Port" tab in Codespaces) has been made PUBLIC.
  Install the "Live Server" extension. Right click your index.html file and choose 'Open with Live Server' to view the web page.
  */
  
  // Problem 1: Add the link to your database server and the route above.
  
  // Problem 2: Write the JS code in the function init() and get the employee's table from your server as an array of JSON.
  info = await fetch(linikroute);
  data = await info.json();
  let employees = data;

  }
  
  // Problem 3: For each employee, display their first name, last name and birthdate to the console.
  for(let i=0; i<employees.length; i++){
    let employee = employees[i];
    console.log("first name: " + employee.FirstName);
    console.log("Last name: " + employee.LastName);
    console.log("Birth date: " + employee.BirthDate);
  

}