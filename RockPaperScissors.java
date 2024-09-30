import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ready for Rock Paper Scissors???");
        Random ran = new Random();
        int ComputerChoice = ran();
        String Computer = computer();
        for (int i =0;i<10;i++){
            Computer = computer();
        }
    }
    public static String computer(){
        double ComputerChoice = ran(4);


    }
}


