package week03.students;

import java.util.Scanner;

class Solution {

    static class student {
        String firstName;
        String lastName;
        int grade1;
        int grade2;
        int grade3;
        int[] coords1 = new int[2];
        int[] coords2 = new int[2];

        public student(String firstName, String lastName, int grade1, int grade2, int grade3){
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade1 = grade1;
            this.grade2 = grade2;
            this.grade3 = grade3;
        }

        public float avgGradeCalc(){
            float grades = 3;
            return (this.grade1 + this.grade2 + this.grade3)/grades;
        }

        public void printStudentDetails(float avgGrade){
            System.out.printf(lastName + ", " + firstName + ": Grades: [" + grade1 + ", " + grade2 + ", " + grade3 + "] (avg: " + "%.1f" + ")%n",avgGrade);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int cases = in.nextInt();
        in.nextLine();
        int nameArrayLen = 2;
        int gradeArrayLen = 3;
        String[][] twoDimNameArray = new String[cases][nameArrayLen];
        int[][] twoDimGradeArray = new int[cases][gradeArrayLen];
        for (int i=0; i < cases; i++){

            for (int j = 0; j < nameArrayLen; j++) {
                if(in.hasNext()) {
                    twoDimNameArray[i][j] = in.next();
                }
            }
            for (int j = 0; j < gradeArrayLen; j++) {
                if(in.hasNext()) {
                    twoDimGradeArray[i][j] = in.nextInt();
                }
            }
            in.nextLine();
        }

        for (int i = 0; i < cases; i++) {
            int caseNum = i + 1;
            student stud = new student(twoDimNameArray[i][0],twoDimNameArray[i][1],twoDimGradeArray[i][0],twoDimGradeArray[i][1],twoDimGradeArray[i][2]);
            float avgGrade = stud.avgGradeCalc();
            System.out.print("Case #" + caseNum + ": ");
            stud.printStudentDetails(avgGrade);
        }

    }
}
