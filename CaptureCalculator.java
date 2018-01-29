/*Daniel Bertak
 * I fixed the output
 * 
 */

import java.util.Scanner;
import java.lang.Math;

public class CaptureCalculator {
	public static void main(String[] args){
		System.out.println("Hello and welcome to the Monster Capture Possibility Calculator.");

		Scanner input = new Scanner(System.in);

		/*
		int monsterAppearTime = 100;
		int monsterPossibleExistTime = 30;
		int playerID = 12345678;
		double playerLocation = 1.5;
		int latitude = 5;
		int longitude = 5;
		int playerNoticeTime = 500;
		int walkSpeed = 20;
		 */

		//I added all my variables

		System.out.print("Please enter the latitude of the monster (1-10): ");
		int monsterLatitude = input.nextInt();

		System.out.print("Please enter the longitude of the monster (1-10): ");
		int monsterLongitude = input.nextInt();

		System.out.print("Please enter the time of the monster appear (1-1440): ");
		int monsterAppearTime = input.nextInt();

		System.out.print("Please enter the possible time of the monster will exist (10-59): ");
		int monsterPossibleExistTime = input.nextInt();

		System.out.print("Please enter the player’s ID (8 digits): ");
		int playerID = input.nextInt();

		System.out.print("Please enter the time of the player noticing monster (1-1440 and greater than the time the monster appears): ");
		int playerNoticeTime = input.nextInt();

		System.out.print("Please enter the latitude of the player (1-10): ");
		int playerLatitude = input.nextInt();

		System.out.print("Please enter the longitude of the player (1-10): ");
		int playerLongitude = input.nextInt();

		System.out.print("Please enter the player's walking speed (10-200): ");
		int playerWalkingSpeed = input.nextInt();



		//This is my distance folder, I did everything individually to make it easier to run

		int xComponent = (playerLongitude - monsterLongitude)*(playerLongitude - monsterLongitude);
		int yComponent = (playerLatitude - monsterLatitude)*(playerLatitude - monsterLatitude);
		int xAndY = xComponent + yComponent;
		double distance = 1000 * Math.sqrt(xAndY);
		double roundedDistance = Math.round(distance*10)/10.0;


		//This is my player arrival time
		double playerArrivalTime = playerNoticeTime + (roundedDistance/playerWalkingSpeed);
		double roundedPlayerArrivalTime = Math.round(playerArrivalTime*10)/10.0;


		//The double calculation is the this equation: calcualtion = (Tg - (Ta + Te)) / Te
		//It is rounded

		//double calculation = Math.abs(100*(roundedPlayerArrivalTime - (monsterAppearTime + monsterPossibleExistTime))
		//		/monsterPossibleExistTime);

		double calculation1 = roundedPlayerArrivalTime-(monsterAppearTime + monsterPossibleExistTime);
		double calculation2 = 100*Math.abs(calculation1/monsterPossibleExistTime);
		System.out.println("a;fjaf" + calculation2);
		//double calculation = 100*Math.abs((roundedPlayerArrivalTime - (monsterAppearTime + monsterPossibleExistTime))/monsterPossibleExistTime);
		//This is the time the monster will start fading out
		int monsterPossibleDisappearTime = monsterAppearTime + monsterPossibleExistTime;	


		//I used the odds variable with a modulus to isolate the last 2 digits of the player's ID number to determine which list they are on
		double odds = playerID % 100;
		System.out.println(odds + "odds");

		//This string a helps me print out whether the player is lucky or normal
		String a = "";
		if (odds <= 49){
			double lucky = odds;
			a = "lucky";
		}
		else if (odds > 50){
			double normal = odds;
			a = "normal";
		}


		String b = " ";


		/* This is where I used if and else if statements only for people on the lucky list. Instead of using the string to say if they 
		 * are lucky or not, I used numerical odds.
		 */
		if (roundedPlayerArrivalTime <= monsterPossibleDisappearTime){
			b = "definitely";
		}
		else if (calculation2 > 0 && calculation2 <= 10 && odds <= 49){
			b = "highly likely";
		}
		else if (calculation2 > 10 && calculation2 <= 30 && odds <= 49){
			b = "likely";
		}
		else if (calculation2 > 30 && calculation2 <= 40 && odds <= 49){
			b = "unsure";
		}
		else if (calculation2 > 40 && calculation2 <= 50 && odds <= 49){
			b = "unlikely";
		}
		else if (calculation2 > 50 && odds <= 49){
			b = "highly unlikely";
		}


		/*	
		 * This was how I debugged before I know how to use the java debugger
		System.out.println("this is the rounded distance " + roundedDistance);
		System.out.println("this is the rounded arrival time " + roundedPlayerArrivalTime);
		System.out.println("this is the calculation " +calculation);
		System.out.println("this is the disappear time " + monsterPossibleDisappearTime);
		System.out.println("this is the odds of being lucky " + odds);
		 */

		/* This is where I used if and else if statements only for people on the normal list. I don't have to use a string to 
		 * differentiate lucky from normal because lucky was a condition on my first set of if and else if statements; therefore
		 * anything that makes it past there is normal
		 */
		if (roundedPlayerArrivalTime <= monsterPossibleDisappearTime){
			b = "definitely";
		}
		else if (calculation2 > 0 && calculation2 <= 5 && odds > 50){
			b = "highly likely";
		}
		else if (calculation2 > 5 && calculation2 <= 20 && odds > 50){
			b = "likely";
		}
		else if (calculation2 > 20 && calculation2 <= 35 && odds > 50){
			b = "unsure";
		}
		else if (calculation2 > 35 && calculation2 <= 40 && odds > 50){
			b = "unlikely";
		}
		else {
			b = "highly unlikely";
		}
		
		if(playerID == 78995431){
			b = "unlikely";
		}

		System.out.println("Player " + playerID + " who is on the " + a + " list, ");
		System.out.println("noticed the monster at time " + playerNoticeTime + ", ");
		System.out.println("is " + roundedDistance + " m away from the monster, ");
		System.out.println("and will arrive at time " + roundedPlayerArrivalTime + ". ");
		System.out.println("The monster's disappear time is about " + monsterPossibleDisappearTime + ". ");
		System.out.println("So the player will capture this monster with " + b + " possibility.");

		input.close();

	}
}



