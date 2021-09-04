package minilabs;

public class KiraMiniLab1 {

    public static void main(String[] args){

        int grade1 = 70;
        int grade2 = 25;
        int grade3 = 90;
        int grade4 = 97;
        int grade5 = 83;

        double grade6 = (double)(grade1 + grade2)/2;
        double grade7 = (double)(grade3 + grade4)/2;
        double finalgrade = (grade6 + grade7 + grade5)/3;

        System.out.println("average of grade 1 and 2 = " + grade6);
        System.out.println("average of grade 3 and 4 = "+ grade7);
        System.out.println("final grade = " + finalgrade);

        double weighted6 = grade6 * .7;
        double weighted7 = grade7 * .3;
        double finalweighted = weighted6 + weighted7;

        System.out.println("weighted grade = "+ finalweighted);


    }
}

//find average of grade 1 and 2 = 6
//find average of grade 3 and 4 = 7
//find average of grade 6, 7, 5
