const prompt = require("prompt-sync")();

let studentnumber = Number(prompt("Enter the number of students in the class: ")); 
console.log(studentnumber);


let numbersubject = Number(prompt("Enter the number of subjects: ")); 
console.log(numbersubject);


const studentNames = [];
const subjectNames = [];
const scores = [];

for(let count = 0; count < numbersubject; count++){
    console.log("Enter name of Subject " + (count + 1) + ": ");
}

    for(let index = 0; index < studentnumber; index++){
        console.log("Enter name of Student " + (index + 1) + ": ");
    }
       
