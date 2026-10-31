const prompt = require("prompt-sync")();

const passMark = 50;

let numClasses = Number(prompt("How many classes do you want to enter? "));
while (numClasses < 1) {
    numClasses = Number(prompt("Enter at least 1 class: "));
}

for (let classNumber = 0; classNumber < numClasses; classNumber++) {
    let className = prompt("\nEnter name of Class " + (classNumber + 1) + ": ");

    let numStudents = Number(prompt("Enter the number of students in " + className + ": "));
    while (numStudents < 1) {
        numStudents = Number(prompt("Enter at least 1 student: "));
    }

    let numSubjects = Number(prompt("Enter number of subject: "));
    while (numSubjects < 1) {
        numSubjects = Number(prompt("Enter at least 1 subject: "));
    }

let studentNames = [];
let subjectNames = [];
let scores = [];

for (let count = 0; count < numSubjects; count++) {
    subjectNames.push(prompt("Enter name of Subject " + (count + 1) + ": "));
}

for (let index = 0; index < numStudents; index++) {
    studentNames.push(prompt("\nEnter name of Student " + (index + 1) + ": "));
    let studentScores = [];

    for (let count = 0; count < numSubjects; count++) {
        let score = Number(prompt("  Enter score for " + studentNames[index] + " in " + subjectNames[count] + " (0-100): "));
        while (isNaN(score) || score < 0 || score > 100) {
            score = Number(prompt("  Invalid. Score must be between 0 and 100: "));
        }
        studentScores.push(score);
        console.log("  Saving >>>>>>>>>>>>>>>>>>>>");
        console.log("  Saved successfully");
    }

    scores.push(studentScores);
}

let studentTotals = [];
for (let index = 0; index < numStudents; index++) {
    let studentTotal = 0;
    for (let count = 0; count < numSubjects; count++) {
        studentTotal += scores[index][count];
    }
    studentTotals.push(studentTotal);
}


console.log("================= SCORE TABLE =================")
console.log("\n=====================================================================");
console.log("                    LAGBAJA SCHOOLS STUDENT SUMMARY");
console.log("=====================================================================");


    let heading = "Student\t";
    for (let count = 0; count < numSubjects; count++) {
        heading += subjectNames[count] + "\t";
    }
    heading += "Total\tAverage\tPOS";
    console.log(heading);
    console.log("------------------------------------------------------------------");

    let classTotal = 0;
    for (let index = 0; index < numStudents; index++) {
        let row = studentNames[index] + "\t";
        for (let count = 0; count < numSubjects; count++) {
            row += scores[index][count] + "\t";
        }

        let studentAverage = studentTotals[index] / numSubjects;
        classTotal += studentTotals[index];

        let position = 1;
        for (let student = 0; student < numStudents; student++) {
            if (studentTotals[student] > studentTotals[index]) {
                position++;
            }
        }

        row += studentTotals[index] + "\t" + studentAverage + "\t" + position;
        console.log(row);
    }
    console.log("=====================================================================");

    console.log(" ================= SUBJECT SUMMARY =================");
    console.log("=====================================================================");



