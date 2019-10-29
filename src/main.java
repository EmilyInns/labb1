import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class main {
    private static String input;
    private static Scanner sc = new Scanner(System.in);
    private static Random rand = new Random();
    private static int compWins = 0;
    private static int playWins = 0;

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        while (true) {
            System.out.println("\nWelcome! Please choose a mode:");
            System.out.println("1. Upp och Ner\n2. Min Max\n3. Sten Sax Påse\n4. Ordning och reda\ne. Avsluta");
            input = sc.nextLine();

            if (checkInputLength()) {
                switch (input) {
                    case "1":
                        upAndDown();
                        return;
                    case "2":
                        minMax();
                        return;
                    case "3":
                        rockPaper();
                        return;
                    case "4":
                        ordReda();
                        return;
                    case "e":
                    case "E":
                        System.out.println("Thanks for playing!\n");
                        return;

                    default:
                        System.out.println("Invalid choice!");

                }
            }
            menu();
        }
    }

    private static void upAndDown() {
        System.out.println("Welcome to Up and Down!");
        System.out.println("Please enter any number of text strings separated by enter.\nWhen you are finished, type END");
        System.out.println("Then the computer will print them out in reverse order!");
        ArrayList<String> inputlist = new ArrayList<String>();
        while (true){
            input = sc.nextLine();
            if( input.equals("END")){
                break;
            }
            else{
                inputlist.add(input);
            }
        }
        for (int j = inputlist.size() -1; j >=0; j--){
            System.out.println(inputlist.get(j));
        }

        menu();
    }

    private static void minMax() {
        System.out.println("Welcome to Min Max!");
        System.out.println("Please enter 5 numbers, separated by enter");
        int[] numbers = new int[5];
        for (int i = 0; i <5 ; i++) {
            input = sc.nextLine();
            try {
                numbers[i] = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Error! Please only enter numbers!");
                i--;
            }
        }
        Arrays.sort(numbers);
        System.out.println("Min value: " + numbers[0]);
        System.out.println("Max value: " + numbers[4]);

        menu();

    }

    private static void rockPaper() {

        System.out.println("Welcome to rock paper scissors! Can you beat the computer?");

        while (compWins < 3 & playWins < 3) {
            System.out.println("Make your choice!: \n1. Rock \n2. Paper \n3. Scissor");
            input = sc.nextLine();
            if (!(input.equals("1") || input.equals("2") || input.equals("3"))) {
                System.out.println("Error! Not a valid choice!");
            } else if (checkInputLength()) {
                playRockPaper();
            }
        }
        menu();
    }

    private static void playRockPaper() {
        String compMove = "";
        int compChoice = (rand.nextInt(3) + 1);
        int playerChoice = Integer.parseInt(input);
        if(compChoice == 1) compMove = "Rock";
        if(compChoice == 2) compMove = "Paper";
        if(compChoice == 3) compMove = "Scissor";

        System.out.println("Computer chooses " + compMove + "!");
        if ((playerChoice == 1 & compChoice == 3) || (playerChoice == 2 & compChoice == 1) || (playerChoice == 3 & compChoice == 2)) {
            System.out.println("You won!");
            playWins++;
            System.out.println("Your score: " + playWins);
            System.out.println("Computers score: " + compWins + "\n");

        } else if (playerChoice == compChoice) {
            System.out.println("It's a draw!");
            System.out.println("Your score: " + playWins);
            System.out.println("Computers score: " + compWins + "\n");

        } else {
            System.out.println("Computer wins!");
            compWins++;
            System.out.println("Your score: " + playWins);
            System.out.println("Computers score: " + compWins + "\n");
        }
        if (playWins == 3) {
            System.out.println("Congratulations!! You won!");
        } else if (compWins == 3) {
            System.out.println("The computer wins! Better luck next time!");
        }
    }

    private static void ordReda(){
        System.out.println("Welcome to 'Ordning och Reda!'");
        System.out.println("Please enter any amount of numbers, separated by spaces:");
        input = sc.nextLine();
        String[] inputArray = input.split(" ");
        int[] numberArray = new int[inputArray.length];
        int sum = 0;
        boolean error = false;
        boolean inOrder = true;
        for (int i = 0; i < inputArray.length; i++) {
            try {
                numberArray[i] = Integer.parseInt(inputArray[i]);
            } catch (NumberFormatException e) {
                System.out.println("Error! Please only enter numbers, separated by space.\nReturning you to main menu.");
                error = true;
                menu();
            }
            sum += numberArray[i];
        }
        if (error) return;

        Arrays.sort(numberArray);

        for (int i = 0; i < inputArray.length; i++) {
            if (!(numberArray[i] == Integer.parseInt(inputArray[i]))) inOrder = false; }

        System.out.println("Min value: " + numberArray[0]);
        System.out.println("2Min value: " + numberArray[1]);
        System.out.println("Max value: " + numberArray[numberArray.length-1]);
        System.out.println("2Max value: " + numberArray[numberArray.length-2]);
        System.out.println("Sum: " + sum);
        System.out.println("In order: " + inOrder);

        menu();


    }

    private static boolean checkInputLength(){
        if (input.length() > 1) {
            System.out.println("Please only enter 1 character!");
        }
        if (input.length() == 0) {
            System.out.println("Please make a choice!");
        }
        return (input.length()==1);
    }
    }




