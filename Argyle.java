/*
* This program takes in several inputs from the user that requires the correct data type and returns an error if the
* input is an incorrect data type. Then I implemented a double while loop that iterates through
* */

import java.util.Scanner; //import scanner
public class Argyle {
    public static void main(String[] args) { //main method
        Scanner console = new Scanner(System.in); //scanner object

        //data field
        int width = 0;
        int height = 0;
        int diamondWidth = 0;
        int centerWidth = 0;
        char firstChar = 0;
        char secondChar = 0;
        char thirdChar = 0;

        //gets width of Viewing window
        int index = 0;
        while(index < 1) {
            System.out.print("please enter a positive integer for the width of Viewing window in characters.  ");
            if(console.hasNextInt()) {
                width = console.nextInt();

                if(width > 0) {
                    index++;
                }
                else {
                    System.out.println("Cannot accept negative number or negative number");
                }
            }
            else {
                System.out.println("Error: please type in an integer.");
                String junkword = console.next();
            }
        }

        //gets height of Viewing window
        index = 0;
        while(index < 1) {
            System.out.print("please enter a positive integer for the height of Viewing window in characters.  ");
            if(console.hasNextInt()) {
                height = console.nextInt();

                if(height > 0) {
                    index++;
                }
                else {
                    System.out.println("Cannot accept negative number or negative number");
                }
            }
            else {
                System.out.println("Error: please type in an integer.");
                String junkword = console.next();
            }
        }

        //gets width of diamond Argyle
        index = 0;
        while(index < 1) {
            System.out.print("please enter a positive integer for the width of the argyle diamonds.  ");
            if(console.hasNextInt()) {
                diamondWidth = console.nextInt();

                if(diamondWidth > 0) {
                    index++;
                }
                else {
                    System.out.println("Cannot accept negative number or negative number");
                }
            }
            else {
                System.out.println("Error: please type in an integer.");
                String junkword = console.next();
            }
        }

        //gets odd integer for width for center argyle
        index = 0;
        while(index < 1) {
            System.out.print("please enter a positive odd integer for the width of the argyle center stripe.  ");
            if(console.hasNextInt()) {
                centerWidth = console.nextInt();

                if(centerWidth > 0) {
                    if(centerWidth % 2 == 1) { //If input is odd
                        index++;
                    }
                    else {
                        System.out.println("Cannot accept non odd integer");
                    }
                }
                else {
                    System.out.println("Cannot accept negative number or negative number");
                }
            }
            else {
                System.out.println("Error: please type in an integer.");
                String junkword = console.next();
            }
        }

        //gets first character
        index = 0;
        while(index < 1) {
            System.out.print("please enter a first character for the pattern fill.  ");
            if(console.hasNext()) {
                String word = console.next();
                if(word.length() == 1 && word.charAt(0) > 0) {
                    firstChar = word.charAt(0);
                    index++;
                }

                else {
                    System.out.println("Cannot accept negative number or negative number");
                }
            }
            else {
                System.out.println("Error: please type in an integer.");
                String junkword = console.next();
            }
        }

        //gets second character
        index = 0;
        while(index < 1) {
            System.out.print("please enter a second character for the pattern fill.  ");
            if(console.hasNext()) {
                String word = console.next();
                if(word.length() == 1 && word.charAt(0) > 0) {
                    secondChar = word.charAt(0);
                    index++;
                }

                else {
                    System.out.println("Cannot accept negative number or negative number");
                }
            }
            else {
                System.out.println("Error: please type in an integer.");
                String junkword = console.next();
            }
        }

        index = 0;
        while(index < 1) {
            System.out.print("please enter a third character for the stripe fill.  ");
            if(console.hasNext()) {
                String word = console.next();
                if(word.length() == 1 && word.charAt(0) > 0) {
                    thirdChar = word.charAt(0);
                    index++;
                }

                else {
                    System.out.println("Cannot accept negative number or negative number");
                }
            }
            else {
                System.out.println("Error: please type in an integer.");
                String junkword = console.next();
            }
        }

        //2 counters for vertical and horizontal
        int verticalCounter = 0;
        int horizontalCounter = 0;

        int myCounter = 0;


        //constants that I already know
        int size = 2 * diamondWidth;
        int midPoint = diamondWidth;

        //increment the horizontal to move whenever I print something
        while(verticalCounter < height) { //While loop that runs from 0 to height
            horizontalCounter = 0;
            while(horizontalCounter < width) { //while loop that runs from 0 to width
                if(horizontalCounter % size <= verticalCounter % size + centerWidth / 2 && horizontalCounter % size >= verticalCounter % size - centerWidth / 2 ) {
                    System.out.print(thirdChar);
                    horizontalCounter++;
                }

                else if(horizontalCounter % size <= (size - verticalCounter) % size + centerWidth / 2&& horizontalCounter % size >= (size - verticalCounter) % size - centerWidth / 2) {
                    System.out.print(thirdChar);
                    horizontalCounter++;
                }


                else {
                    if(verticalCounter < midPoint) { //conditional for top half of block

                        if(horizontalCounter % size < (midPoint - verticalCounter) % size || horizontalCounter % size > (midPoint + verticalCounter ) % size) {
                            System.out.print(firstChar);
                            horizontalCounter++;
                        }

                        else { //conditional for second character (plus)
                            System.out.print(secondChar);
                            horizontalCounter++;
                        }
                    }

                    else if(verticalCounter > midPoint) { //conditional for bottom half of block

                        if ((horizontalCounter) % size > verticalCounter - midPoint && (horizontalCounter) % size < size - (verticalCounter - midPoint)) {
                            System.out.print(secondChar);
                            horizontalCounter++;
                        } else {
                            System.out.print(firstChar);
                            horizontalCounter++;
                        }
                    }

                    else if(verticalCounter == midPoint) {
                        System.out.print(secondChar);
                        horizontalCounter++;
                    }
                }
            }

            //increment vertical counter and myCounter and print new line
            verticalCounter++;
            myCounter++;
            System.out.println();

            //resets the verticalCounter if the value is not at height
            if(myCounter != height) {
                if(verticalCounter == size) {
                    verticalCounter = 0;
                }
            }

            //ends code otherwise
            else {
                break;
            }

        }
    }
}