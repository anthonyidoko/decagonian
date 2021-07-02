package com.company;

import java.text.DecimalFormat;
import java.util.*;

public class Main {

    // A method that outputs cinema menu and prompts the user for input
    static void displayMenu(HashMap<Integer,String>cinemaMenu){
        for (int menuItem = 0; menuItem < cinemaMenu.size(); menuItem++){
            if(menuItem != 0){
                System.out.println(menuItem + ". " + cinemaMenu.get(menuItem));
            }
        }
        System.out.println(0 + ". " + cinemaMenu.get(0));
        System.out.println("Select a menu");
        System.out.print("> ");
    }

    public static void main(String[] args) {
        Seat seat = new Seat();
        Scanner userInput = new Scanner(System.in);

        HashMap<Integer,String>cinemaMenu = new HashMap<>();
        cinemaMenu.put(1,"Show the seats");
        cinemaMenu.put(2,"Buy a ticket");
        cinemaMenu.put(3,"Statistics");
        cinemaMenu.put(0,"Exit");

        try{
            System.out.println("Enter the number of rows: ");
            System.out.print("> ");
            int cinemaSeatRows = userInput.nextInt();
            System.out.println("Enter the number of columns: ");
            System.out.print("> ");
            int cinemaSeatColumns = userInput.nextInt();
            displayMenu(cinemaMenu);

            String [][] seatList = new String[cinemaSeatRows][cinemaSeatColumns];

            int numberOfPurchasedTickets = 0;
            int currentIncome =  0;
            int totalIncome =  cinemaSeatColumns * cinemaSeatRows * 10;
            double percentage =  0.00D;
            int numberOfAvailableSeats = cinemaSeatRows * cinemaSeatColumns;

//            CREATE A MULTI DIMENSIONAL ARRAY USING THE CINEMA SEAT COLUMNS AND CINEMA SEAT ROWS
            for (int i = 0; i < cinemaSeatRows; i ++){
                for(int j = 0; j < cinemaSeatColumns; j++){
                    seatList[i][j] = " S  ";
                }
            }

            int selectMenu = userInput.nextInt();
            while (selectMenu != 0){
                if(selectMenu == 1) {
                    for (int row = 0; row < cinemaSeatRows;row++){
                        for (int col = 0; col < cinemaSeatColumns; col++){

                          System.out.print(seatList[row][col] + " ");

                        }
                        System.out.println();
                    }
                    displayMenu(cinemaMenu);
                    selectMenu = userInput.nextInt();

                } else if (selectMenu == 2){
                    System.out.println("Enter a row number:");
                    System.out.print(">");
                    int userSeatRow = userInput.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    System.out.print(">");
                    int userSeatNumber = userInput.nextInt();

                    if ((userSeatRow < cinemaSeatRows) && (userSeatNumber < cinemaSeatColumns)) {
                        System.out.println(Arrays.deepToString(seatList));
                        if (seatList[userSeatRow][userSeatNumber] != "S"){
                            seatList[userSeatRow-1][userSeatNumber] = " B  ";
                            System.out.println(Arrays.deepToString(seatList));
                            System.out.println("Ticket price: $10");
                            System.out.println();
                            numberOfPurchasedTickets += 1;
                            currentIncome += 10;
                            percentage += (((currentIncome +0.0) /(totalIncome + 0.0))*100);
                            displayMenu(cinemaMenu);
                            selectMenu = userInput.nextInt();
                            numberOfAvailableSeats -= 1;

                        }else{
                            System.out.println("seat has been booked");
                            displayMenu(cinemaMenu);
                            selectMenu = userInput.nextInt();
                        }

                    } else {
                        System.out.println("Selection out of bound");
                    }

                } else if (selectMenu == 3){
                    System.out.println("Number of purchased tickets: " + numberOfPurchasedTickets);
                    DecimalFormat s = new DecimalFormat(     "#.##");
                    System.out.println("Percentage:                  " + s.format(percentage) + "%");
                    System.out.println("Current income:              $" + currentIncome);
                    System.out.println("Total income:                $" + totalIncome);
                    System.out.println("Number of available seats:   " + numberOfAvailableSeats);

                    System.out.println();
                    displayMenu(cinemaMenu);
                    selectMenu = userInput.nextInt();

                } else if (selectMenu > (cinemaMenu.size()-1)){
                    System.out.println("Invalid input. Please select a number from the menu");
                    displayMenu(cinemaMenu);
                    selectMenu = userInput.nextInt();
                }
            }

        } catch (InputMismatchException e){
            System.out.println("Invalid input. Restart");


        }

    }
}