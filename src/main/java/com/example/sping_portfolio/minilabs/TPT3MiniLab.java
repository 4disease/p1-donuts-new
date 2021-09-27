package com.example.sping_portfolio.minilabs;

public class TPT3MiniLab {
    public void Sports1(boolean PlaysSoccer, int YearsPlaying, boolean PlaysTennis) {
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


    public void Sports2(boolean PlaysSoccer, int YearsPlaying, boolean PlaysTennis) {
        System.out.println("This Student plays soccer: " + PlaysSoccer);
        System.out.println("This Student plays tennis: " + PlaysTennis);
        System.out.println("This Student has been playing for " + YearsPlaying + " years.");

        boolean a = PlaysSoccer;
        boolean b = PlaysTennis;
        String statement = "statement";

        if (a==b)
        {
            statement = "This student plays multiple sports.";
        }
        else if (!(a || b))
        {
            statement = "This student doesn't pay either sport.";
        }
        else if (!a || !b)
        {
            statement = "This student only plays one of the sports.";
        }
        System.out.println(statement);
        System.out.println();
    }


    public static void main(String[] args) {
        System.out.println("Set 1");
        TPT3MiniLab student1 = new TPT3MiniLab();
        student1.Sports1(true, 7, true);

        TPT3MiniLab student2 = new TPT3MiniLab();
        student2.Sports1(true, 15, false);

        TPT3MiniLab student3 = new TPT3MiniLab();
        student3.Sports1(false, 0, false);

        System.out.println("Set 2");

        TPT3MiniLab student4 = new TPT3MiniLab();
        student4.Sports2(true, 7, true);

        TPT3MiniLab student5 = new TPT3MiniLab();
        student5.Sports2(true, 15, false);

        TPT3MiniLab student6 = new TPT3MiniLab();
        student6.Sports2(false, 0, false);
    }
}
