package com.example.sping_portfolio.minilabs;
import java.util.Scanner;

public class geo {

    public static void main(String[] args) {
		
		//this is using Scanner, an import from Java. it reads the input we type into the class. 
		Scanner input = new Scanner(System.in); // remember the System.out.print() function? this is the opposite of that 

		System.out.println("Welcome to Fibonacci. How many numbers of the Fibonacci sequence do you need?");

		String fib = input.nextLine(); // our string, fib, is the input that the user puts in on the next line. 

		int fnum = Integer.parseInt(fib); //Integer.parseInt() is a function that turns a String into an integer. 

		int num1 = 0, num2 = 1;

		int count = 0;
  
        // Iterate till counter is less than our number that was entered in
        while (count < fnum) {
  
            // Print the number
            System.out.print(num1 + " ");
  
            // Swap
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
            count = count + 1;

        }

		int next = count + 1; 

		System.out.print("It took " + count + " iterations of the while loop.");
		System.out.println("the " + next + "th number of the fibonacci sequence is " + num1);

		//Your goal: Using the for iteration, create a list that will list all 

		
    }

    
}
