package com.example.sping_portfolio.minilabs;

public class SamTPT2MiniLab {
    public void SchoolType(boolean LikesSchool, int StudentAge, boolean HasPet) {
        System.out.println("The Student is " + StudentAge + " years old and it is " + HasPet + " that they have a pet.");
        System.out.println("The Student likes school: " + LikesSchool);

        if (StudentAge >= 14)
        {
            System.out.println("This student is in High School.");
        }
        else if (StudentAge >=11)
        {
            System.out.println("This student is in Middle School.");
        }
        else if (StudentAge >=5)
        {
            System.out.print("This student is in Elementary School.");
        }
        else
        {
            System.out.print("This child is not in a formal school yet.");
        }
    }

    public static void main(String[] args) {
        SamTPT2MiniLab student1 = new SamTPT2MiniLab();
        student1.SchoolType(false, 13, true);

        SamTPT2MiniLab student2 = new SamTPT2MiniLab();
        student2.SchoolType(true, 5, true);
    }

}
