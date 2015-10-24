/**
 * 
 * 
 * @author Harrison Kaiser
 * @version 0.0.1
 */

import java.util.Scanner

public class UserInput
{
    /**
     * Gets user input until the user is done.
     * Takes in input from the console
     */
    public void userInput() {
        Scanner console = new Scanner(System.in);
        done = false;
        while(!done)
            done = parseInput(getInput(console), console);
    }

    /**
     * Gets user input from the console
     * @param Scanner console - the scanner to take input from. Should be System.in
     * @returns String - the user's input
     */
    public String getInput(Scanner console) {
        System.out.print(" > ");
        return console.nextLine();
    }

    /**
     * Gets user input after a given prompt
     * @param Scanner console - the scanner to take input from. Should be System.in
     * @param String prompt - the prompt to give the user
     * @returns String - the user's input
     */
	public String getInput(Scanner console, String prompt) {
        System.out.print(prompt);
        return console.nextLine();
    }
}
