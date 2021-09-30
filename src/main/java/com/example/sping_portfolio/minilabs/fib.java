package com.example.sping_portfolio.minilabs;
import java.util.Scanner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.ArrayList;
import java.lang.String;



@Controller  // HTTP requests are handled as a controller, using the @Controller annotation

public class fib {

    @GetMapping("/fib")
    public String greeting(@RequestParam(name="start", required=false, defaultValue="1") String start, Model model){
    model.addAttribute("start", start);
     

        int fnum = Integer.parseInt(start);
        int count = 0;

        List<String> fibList = new ArrayList<String>();

        int num1 = 0;
        int num2 = 1;

        fibList.add("0");
        fibList.add("1");

        while (count < (fnum - 2)) {
  
            
            
            // Print the number
            System.out.print(num1 + " ");
  
            // Swap
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
            String numstr3 = String.valueOf(num3); // changes integer to string 
            count += 1;

            fibList.add(numstr3);



        }


        model.addAttribute("fibList", fibList);

        return "/minilabs/fib";
    }

    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) throws InterruptedException {
		
		//this is using Scanner, an import from Java. it reads the input we type into the class. 
		Scanner scan = new Scanner(System.in); // remember the System.out.print() function? this is the opposite of that

		System.out.println("Welcome to Geometric. Make your purchase here. What would be your starting number?");
		int start = scan.nextInt();
        scan.close();


        
        wait(5000);
        System.out.println(".");
        wait(5000);
        System.out.println(".");
        wait(5000);
        System.out.println(". \n");

        System.out.println("Here is the geometric sequence you ordered: ");
        int fnum = start;
        int count = 0;
        List<String> fibList = new ArrayList<String>();

        int num1 = 0;
        int num2 = 1;

        fibList.add("0");
        fibList.add("1");
        

        while (count < (fnum - 2)) {


            
            // Print the number
            System.out.print(num1 + " ");
  
            // Swap
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
            String numstr3 = String.valueOf(num3); // changes integer to string 
            count += 1;

            fibList.add(numstr3);


        }

        System.out.println(fibList);


        System.out.println("Thank you for shopping at Geometric. Have a good day!");

		
    }

    
}

