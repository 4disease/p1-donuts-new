package com.example.sping_portfolio.minilabs;
import java.util.Scanner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation

public class geo {

    @GetMapping("/geo")
    public String greeting(@RequestParam(name="start", required=false, defaultValue="1") String start,
                           @RequestParam(name="mult", required=false, defaultValue="1") String mult,
                           @RequestParam(name="count", required=false, defaultValue="1") String count, Model model) {
        model.addAttribute("start", start);
        model.addAttribute("mult", mult);
        model.addAttribute("count", count);

        int i = 0;
        int terms = Integer.parseInt(start);
        int counting = Integer.parseInt(count);
        int multiplier = Integer.parseInt(mult);
        String result = "";
        while (i < counting) {
            result = result + " " + terms;
            if (i < counting - 1)
            {
                result += ", ";
            }
            terms *= multiplier;
            i++;
        }

        /* int i = 0;
        int terms = start;
        while (i < count){
            System.out.println(terms);
            terms *= mult;
            i++;
        } */
        System.out.println(result);
        model.addAttribute("result", result);

        return "/minilabs/geo";
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

        // Multiplier
        System.out.println();
        System.out.println("Thank you very much. And what would be your multiplier?");
        int mult = scan.nextInt();

        // How many terms?
        System.out.println();
        System.out.println("And... thank you! And, finally, how many terms would you like?");
        int count = scan.nextInt();
        scan.close();
        System.out.println("Thank you for ringing up at Geometric. Please take a seat and wait for your order to come. \n");

        wait(5000);
        System.out.println(".");
        wait(5000);
        System.out.println(".");
        wait(5000);
        System.out.println(". \n");

        System.out.println("Here is the geometric sequence you ordered: ");
        int i = 0;
        int terms = start;
        while (i < count){
            System.out.println(terms);
            terms *= mult;
            i++;
        }

        System.out.println("Thank you for shopping at Geometric. Have a good day!");


		
    }

    
}
