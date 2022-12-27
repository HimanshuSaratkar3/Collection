package com.hs;

import java.util.Scanner;




public class Song {
	public static void main(String[] args) {
		SongOperations songOperations = new SongOperations();
		Scanner scanner= new Scanner(System.in);
		boolean value = true;
		
		while(value) {
			
		System.out.println("**********MENU********");
		System.out.println("1. Add/Remove Song");
		System.out.println("2. Play Music");
		System.out.println("3. Edit Song");
		System.out.println("4. Exit");
		System.out.println();
		System.out.println("Enter The Command to perform :");
		int choice=scanner.nextInt();
		
		
		switch (choice) {
		case 1: 
			System.out.println("**********MENU********");
			System.out.println("1. Add a Song");
			System.out.println("2. Remove a Song");
			System.out.println("3. Back");
			System.out.println("Enter what to do");
			int choice1= scanner.nextInt();
			
			switch (choice1) { 
			case 1:
				System.out.println("How many songs");
				int i =scanner.nextInt();
				for (int j = 0; j < i; j++) {
					System.out.println();
					songOperations.addSong();
					
				}
			
				System.out.println( i + " songs added successfully");
				continue;
			case 2:
				songOperations.removeSong();
				System.out.println("Song removed");
				continue;
			case 3:
				continue;
			}
			
			
			
		case 2:
			System.out.println("**********MENU********");
			System.out.println("1. Play All Songs");
			System.out.println("2. Choose a Song");
			System.out.println("3. Shuffle");
			System.out.println("4. Back");
			System.out.println();
			System.out.println("Enter what to do :");
			
			int choice2= scanner.nextInt();
			
			switch (choice2) {
			case 1:
				System.out.println("is now playing");
				break;
			case 2:
				songOperations.displayAllSongs();
				System.out.println("Choose a song :");
				int choicesong=scanner.nextInt();
				songOperations.selectSong(choicesong);
				
				continue;
			case 3:
				int random=(int) Math.random();
				songOperations.selectSong(random);
				continue;
			case 4:
				continue;
			}
			
			
		case 3:
			System.out.println("**********MENU********");
			songOperations.update();
			System.out.println("Updated successfully");
			continue;
			
			
		case 4:
			value=false;
			

		}
	  }
		scanner.close();
		System.out.println("........***Thank you***........");
		
	}

}

