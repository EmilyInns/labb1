import java.util.Scanner;
import java.util.Random;
public class main {
    public static void main(String[] args) {

        menu();
    }

    static void menu() {
        Scanner sc = new Scanner(System.in);


        while (true) {
            System.out.println("Welcome! Please choose a mode:");
            System.out.println("1. Upp och Ner\n2. Min Max\n3. Sten Sax Påse\n4. Ordning och reda\ne. Avsluta");
            String input = sc.nextLine();
            if (input.length() > 1) {
                System.out.println("Please only enter 1 character!\n");
            }
            if (input.length() == 0) {
                System.out.println("Please make a choice!\n");
            }

            if (input.length() == 1) {
                char choice = input.charAt(0);
                switch (choice) {
                    case '1':
                        upAndDown();
                        return;
                    case '2':
                        minMax();
                        return;
                    case '3':
                        rockPaper();
                        return;
                    case '4':
                        ordReda();
                        return;
                    case 'e':
                    case 'E':
                        System.out.println("Thanks for playing!");
                        return;

                    default:
                        System.out.println("Invalid choice!");

                }
            }
        }
    }

    static void upAndDown() {

    }

    static void minMax() {

    }

    static void rockPaper() {
        Scanner sc3 = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Welcome to rock paper scissors! Can you beat the computer?");
        int compWins = 0;
        int playWins = 0;
        while (compWins < 3 & playWins < 3) {
            System.out.println("Make your choice!: \n1. Rock \n2. Paper \n3. Scissor");
            String in3 = sc3.nextLine();
            if (in3.length() > 1) {
                System.out.println("Please only enter 1 character!\n");
            }
            else if (in3.length() == 0) {
                System.out.println("Please make a choice!\n");
            }
            else if (!(in3.equals("1") || in3.equals("2") || in3.equals("3"))) {
                System.out.println("Error! Not a valid choice!");
            }

            else if (in3.length() == 1) {
                int compChoice = (rand.nextInt(3)+1);
                //char ch3 = in3.charAt(0);
                int ch3 = Integer.parseInt(in3);
                    if ((ch3==1 & compChoice==3)||(ch3==2 & compChoice==1)||(ch3==3 & compChoice==2)) {
                        System.out.println("You won!");
                        playWins++;
                        System.out.println("Your score: " + playWins);
                        System.out.println("Computers score: " + compWins +"\n");

                    } else if (ch3 == compChoice) {
                        System.out.println("It's a draw!");
                        System.out.println("Your score: " + playWins);
                        System.out.println("Computers score: " + compWins +"\n");

                    } else {
                        System.out.println("Computer wins!");
                        compWins++;
                        System.out.println("Your score: " + playWins);
                        System.out.println("Computers score: " + compWins +"\n");
                    }


                }
            }
        if (playWins == 3) {
            System.out.println("Congratulations!! You won!");
        } else if (compWins == 3) {
            System.out.println("The computer wins! Better luck next time!");
        }
    }




    static void ordReda(){

    }

}



