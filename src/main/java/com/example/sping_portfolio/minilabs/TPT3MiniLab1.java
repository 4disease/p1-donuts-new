package com.example.sping_portfolio.minilabs;

public class TPT3MiniLab1 {
    public void Sports(boolean PlaysSoccer, int YearsPlaying, boolean PlaysTennis) {
        System.out.println("This Student plays soccer: " + PlaysSoccer);
        System.out.println("This Student plays tennis: " + PlaysTennis);
        System.out.println("This Student has been playing for " + YearsPlaying + " years.");

        boolean a = PlaysSoccer;
        boolean b = PlaysTennis;
        String statement = "statement";

        if (a && b)
        {
            statement = "This student plays multiple sports.";
        }
        else if (!a && !b)
        {
            statement = "This student doesn't pay either sport.";
        }
        else if (!(a && b))
        {
            statement = "This student only plays one of the sports.";
        }
        System.out.println(statement);
        System.out.println();
    }


    public static void main(String[] args) {
        TPT3MiniLab1 student1 = new TPT3MiniLab1();
        student1.Sports(true, 7, true);

        TPT3MiniLab1 student2 = new TPT3MiniLab1();
        student1.Sports(true, 15, false);

        TPT3MiniLab1 student3 = new TPT3MiniLab1();
        student1.Sports(false, 0, false);
    }
}
