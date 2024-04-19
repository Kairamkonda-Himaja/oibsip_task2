//package OyasisInfobyte;

import java.util.Scanner;

public class NumberGuessingGame { 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int attempts = 0;
        int score = 100;
        int no_of_attempts=10;
        int no_of_rounds=3;
        //int rounds=0;


        String play = "yes";
        
        while (play.equalsIgnoreCase("yes")) {

            System.out.println("Number Guessing Game..");
            System.out.println("Total no. of Rounds: "+ no_of_rounds);
            System.out.println("Total no. of Attempts: 10");
            System.out.println("Guess a number between 1 to 100..!");

            no_of_rounds-=1;
            if(no_of_rounds<0){
            play="no";
            System.out.print("No of rounds limit Exceeded. Thank you!");
            break;
            }
            int randomNumber = (int) (Math.random() * 100) + 1;
            //System.out.println(randomNumber);
            for (int i = 0; i < no_of_attempts; i++) {
                int guessNumber;
                try {
                    guessNumber = input.nextInt();
                } catch (Exception e) {
                    System.out.println("Please enter a valid number!");
                    input.next(); 
                    continue;
                }

                attempts++;
                if (guessNumber == randomNumber) {
                    System.out.println("Congratulations! You Guessed Correctly");
                    System.out.println("Your Score: " + score);
                    
                    System.out.printf("no.of rounds left : %d  \n",no_of_rounds);
                    System.out.println("Do you want to play more rounds? (yes/no)");
                    play = input.next();
                    attempts=0;
                    score=100;
                    break;
                } else if (guessNumber > randomNumber) {
                    System.out.println("Your guess number is higher than the random number!");
                    System.out.printf("no.of attempts left : %d  \n",no_of_attempts-i-1);

                    score -= 10; 
                } else {
                    System.out.println("Your guess number is lower than the random number!");
                    System.out.printf(" no.of attempts left : %d  \n",no_of_attempts-i-1);

                    score -= 10; 
                }

                
                if (score <= 0) {
                    System.out.println("Game over! Your score is 0 or negative.");
                    play = "no";
                    break;
                }
            }

            if (attempts >= 10) {
                System.out.println("No of attempts limit Exceeded. Thank you!");
                //play = "no";
            }
        }
        input.close(); 
    }
}
