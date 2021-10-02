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

        List<String> perList = new ArrayList<String>();

        int num1 = 3;
        int num2 = 0;
        int num3 = 2;

        perList.add("3");
        perList.add("0");
        perList.add("2");

        while (count < (fnum - 3)) {
  
            
            
            // Print the number
            System.out.print(num1 + " ");
  
            // Swap
            int num4 = num2 + num1;
            num1 = num2;
            num2 = num3;
            num3 = num4;
            String numstr4 = String.valueOf(num4); // changes integer to string 
            count += 1;

            perList.add(numstr4);



        }


        model.addAttribute("perList", perList);

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
        List<String> perList = new ArrayList<String>();

        int num1 = 3;
        int num2 = 0;
        int num3 = 2;

        perList.add("3");
        perList.add("0");
        perList.add("2");
        

        while (count < (fnum - 2)) {


            
            // Print the number
            System.out.print(num1 + " ");
  
            // Swap
            int num4 = num2 + num1;
            num1 = num2;
            num2 = num3;
            num3 = num4;
            String numstr4 = String.valueOf(num4); // changes integer to string 
            count += 1;

            perList.add(numstr4);



        }

        System.out.println(perList);



		
    }

    
}

