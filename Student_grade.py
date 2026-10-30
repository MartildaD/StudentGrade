pass_mark = 50


num_classes = int(input("How many classes do you want to enter? "))
while num_classes < 1:
    num_classes = int(input("Enter at least 1 class: "))

for class_number in range(num_classes):
    class_name = input("\nEnter name of Class " + str(class_number + 1) + ": ")

num_students = int(input("Enter the number of students in the class:  "))
while num_students < 1:
    num_students = int(input("Enter at least 1 student: "))

num_subjects = int(input("Enter number of subject: "))
while num_subjects < 1:
    num_subjects = int(input("Enter at least 1 subject: "))

student_names = []
subject_names = []
scores = []


for count in range(num_subjects):
    subject_names.append(input("Enter name of Subject " + str(count + 1) + ": "))


for index in range(num_students):
    student_names.append(input("\nEnter name of Student " + str(index + 1) + ": "))
    student_scores = []
    
    for count in range(num_subjects):
        score = int(input("  Enter score for " + student_names[index] + " in " + subject_names[count] + " (0-100): "))
        while score < 0 or score > 100:
            score = int(input("  Invalid. Score must be between 0 and 100: "))
        student_scores.append(score)
        print("  Saving >>>>>>>>>>>>>>>>>>>>")
        print("  Saved successfully")

    scores.append(student_scores)

student_totals = []
for index in range(num_students):
    student_total = 0
    for count in range(num_subjects):
        student_total += scores[index][count]
    student_totals.append(student_total)


print("\n==================================================================")
print("                     LAGBAJA SCHOOLS STUDENT SUMMARY- " + class_name                 )
print("==================================================================")

print(f"{'Student':<15}{'subject1':<12}{'subject2':<12}{'Total':<10}{'Average':<10}{'POS':<10}")
print("------------------------------------------------------------------")


class_total = 0
for index in range(num_students):
    row = f"{student_names[index]:<15}"
    for count in range(num_subjects):
        row += f"{scores[index][count]:<12.2f}"

    student_average = student_totals[index] / num_subjects
    class_total += student_totals[index]

    position = 1
    for student in range(num_students):
        if student_totals[student] > student_totals[index]:
            position += 1

    row += f"{student_totals[index]:<10.2f}{student_average:<10.2f}{position:<10}"
    print(row)
print("=====================================================================")

print(" ================= SUBJECT SUMMARY =================")

for count in range(num_subjects):
    highest_student = 0
    lowest_student = 0
    subject_total = 0
    passes = 0
    fails = 0
    most_fails = 0
    most_passes = 0

    for index in range(num_students):
        if scores[index][count] > scores[highest_student][count]:
            highest_student = index
        if scores[index][count] < scores[lowest_student][count]:
            lowest_student = index
        subject_total += scores[index][count]
        if scores[index][count] >= pass_mark:
            passes += 1
        else:
            fails += 1

    if fails > most_fails:
        most_fails = fails
        hardest_subject = count
    if passes > most_passes:
        most_passes = passes
        easiest_subject = count

    print("\n" + subject_names[count])
    print("Highest scoring student is:", student_names[highest_student], "scoring", scores[highest_student][count])
    print("Lowest scoring student is:", student_names[lowest_student], "scoring", scores[lowest_student][count])
    print("Total Score is:", subject_total)
    print(f"Average score is: {subject_total / num_students:.2f}")
    print("Number of passes:", passes)
    print("Number of Fails:", fails)
