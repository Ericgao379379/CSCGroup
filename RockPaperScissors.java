// Eric Gao, Zell Godbold, Calvin Malaney
// 10/2/24
// CSC 111
// RPS program - Code dojo1

import java.util.Random;
import java.util.Scanner;

public class RPS {
    //Set up the global statistical variables
    static double rock=0;
    static double paper=0;
    static double scissors=0;
    static double win=0;
    static double lose=0;
    static double tie=0;
    static double validMatches=0;
    static double invalidMatches=0;
    static double winThrowingRocks=0;
    static double winThrowingPaper=0;
    static double winThrowingScissors=0;



    static String[] correspond=new String[]{"Nothing","Rock","Paper","Scissors"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Start of the program
        System.out.println("Ready for Rock Paper Scissors???");
        System.out.print("Enter your choice (1 for Rock, 2 for Paper, 3 for Scissors, 0 to quit): ");
        //Computer randomly generate a number
        int Computer = computer();
        //Let the user input their choice
        int playerChoice = scanner.nextInt();
        //While player doesn't want to quit, keep the game running (In other words, inputting a zero)
        while(playerChoice!=0){
            //If user input a number rather than 1,2,3, then it counts as an invalid input
            if(playerChoice<1||playerChoice>3) {
                //Increase the number of invalid matches
                invalidMatches++;
                System.out.println("Invalid Choice");
                //if the user input the number of 1,2,3
            }else{
                //Increase the number of valid matches
                validMatches++;
                //Detect which choice user made and increase the corresponding one
                if(playerChoice == 1){
                    rock++;
                }else if(playerChoice == 2){
                    paper++;
                }else{
                    scissors++;
                }
                //Run the check() program to see who wins
                check(playerChoice,Computer);
            }
            //Computer generate a new choice
            Computer = computer();
            System.out.print("Enter your choice (1 for Rock, 2 for Paper, 3 for Scissors, 0 to quit): ");
            //User input the number
            playerChoice=scanner.nextInt();
        }

        //Do the statistics...
        double winProbability = win/validMatches*100;
        double loseProbability = lose/validMatches*100;
        double tieProbability = tie/validMatches*100;
        double validInput = validMatches/(validMatches+invalidMatches)*100;
        double rockProbability = rock/validMatches*100;
        double paperProbability = paper/validMatches*100;
        double scissorsProbability = scissors/validMatches*100;
        double winThrowingRocksProbability = winThrowingRocks/validMatches*100;
        double winThrowingPaperProbability = winThrowingPaper/validMatches*100;
        double winThrowingScissorsProbability = winThrowingScissors/validMatches*100;



        //Output the probability of valid input
        System.out.printf("You have the valid input probability of %.2f%%. ", validInput);
        //If the valid input probability exceeds 80
        if(validInput>80){
            System.out.print("You did a good job.\n");
        }else{
            System.out.print("You should not be so careless...\n");
        }
        //Output the probability of win, tie, and lose
        System.out.printf("You have the win probability of %.2f%%, tie probability of %.2f%%, and lose probability of %.2f%%. ", winProbability, tieProbability, loseProbability);
        //Check if the player is winning or losing for most of the time
        if(winProbability>loseProbability){
            System.out.print("You are winning!\n");
        }else{
            System.out.print("You are losing...\n");
        }
        //Output the probability of throwing rocks, papers, and scissors
        System.out.printf("You threw rocks for %.2f%% of the time, papers for %.2f%%, and scissors for %.2f%% of the time.\n", rockProbability, paperProbability, scissorsProbability);
        if(rockProbability>paperProbability&&rockProbability>scissorsProbability){
            System.out.println("You threw rock for most of the time.");
        }else if(paperProbability>rockProbability&&paperProbability>scissorsProbability){
            System.out.println("You threw paper for most of the time.");
        }else{
            System.out.println("You threw scissors for most of the time.");
        }

        //Output the probability of winning by each choice
        System.out.printf("You win the game when throwing rocks for %.2f%% of the time, papers for %.2f%%, and scissors for %.2f%% of the time.\n", winThrowingRocksProbability, winThrowingPaperProbability, winThrowingScissorsProbability);
        if(winThrowingRocksProbability>winThrowingPaperProbability&&winThrowingRocksProbability>winThrowingScissorsProbability){
            System.out.println("You win by rock for most of the time.");
        }else if(winThrowingPaperProbability>winThrowingRocksProbability&&winThrowingPaperProbability>winThrowingScissorsProbability){
            System.out.println("You win by paper for most of the time.");
        }else{
            System.out.println("You win by scissors for most of the time.");
        }

        //Close scanner
        scanner.close();

    }

    public static int computer(){
        //Declare random method
        Random random = new Random();
        //Randomly choose computer's choice (0 for rock, 1 for paper, 2 for scissors)
        double ComputerChoice = random.nextInt(3);
        if (ComputerChoice == 0){
            return 1;
        }else if (ComputerChoice == 1){
            return 2;
        }else{
            return 3;
        }

    }

    public static void check(int playerChoice, int Computer){
        //Check who wins the game
        //First check if it is a tie
        if(playerChoice==Computer){
            System.out.println("It's a tie, you both got " + correspond[playerChoice]);
            tie++;
        }else if(playerChoice==1&&Computer==2){
            lose++;
            System.out.println("You lose, the computer got " + correspond[Computer] + " and you got " + correspond[playerChoice]);
        }else if(playerChoice==1&&Computer==3){
            win++;
            winThrowingRocks++;
            System.out.println("You win, the computer got " + correspond[Computer] + " and you got " + correspond[playerChoice]);
        }else if(playerChoice==2&&Computer==1){
            win++;
            winThrowingPaper++;
            System.out.println("You win, the computer got " + correspond[Computer] + " and you got " + correspond[playerChoice]);
        }else if(playerChoice==2&&Computer==3){
            lose++;
            System.out.println("You lose, the computer got " + correspond[Computer] + " and you got " + correspond[playerChoice]);
        }else if(playerChoice==3&&Computer==1){
            lose++;
            System.out.println("You lose, the computer got " + correspond[Computer] + " and you got " + correspond[playerChoice]);
        }else{
            win++;
            winThrowingScissors++;
            System.out.println("You win, the computer got " + correspond[Computer] + " and you got " + correspond[playerChoice]);
        }
    }
}

