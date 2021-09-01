package com.example.sping_portfolio.minilabs;

public class NatashaMiniLab2 {
    public static void main(String[] args){
        // grade1 and grade2 -> find the average
        // grade3 and grade4 -> find the average
        // grade5 -> average of all

        int grade1 = 5;
        int grade2 = 8;
        int weighted1 = 10;
        double average1 = (double) ((grade1 + grade2) / 2) * 100 / weighted1;
        System.out.println("The average of grade1 and grade2 are: " + average1 + "%");

        int grade3 = 2;
        int grade4 = 12;
        int weighted2 = 15;
        double average2 = (double) ((grade3 + grade4) / 2) * 100 / weighted2;
        System.out.println("The average of grade3 and grade4 are: " + average2 + "%");

        int grade5 = 6;
        int weighted3 = 8;
        double finalAverage = (double) (average1 + average2 + (grade5 / weighted3 * 100)) / 3;
        System.out.println("The average of all grades are: " + finalAverage + "%");


    }
}
