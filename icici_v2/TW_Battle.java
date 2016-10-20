package icici_v2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class TW_Battle {

	static int mapA[][];
	static int mapB[][];//
	static Map<Integer, Ship> shipMapA = new HashMap<Integer, Ship>();
	static Map<Integer, Ship> shipMapB = new HashMap<Integer, Ship>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		line = br.readLine();
		String size[] = line.split(" ");
		int cols = Integer.parseInt(size[0]);
		int rows = convertChar(size[2].charAt(0));
		mapA = new int[rows][cols];// assign all map coordinates as zero
		mapB = new int[rows][cols];// assign all map coordinates as zero
		int shipNum = Integer.parseInt(br.readLine());
		int shipId = 1;
		// read Number of ships player 1 and palyer 2 has
		for (int i = 0; i < shipNum; i++) {

			// for each ship, assign unique coordinates in battle field

			int shipPower = 2; // dummy value to be read from input
			int width = 0;
			int height = 0;
			int startXA = 0;
			int startYA = 0;// dummy values to be read from input
			int startXB = 0;
			int startYB = 0;// dummy values to be read from input

			// useother coordinates to populate map startXA and

			// for each ship create an object of ship and assign required values
			// extract power based pon type P=1,Q=2
			Ship shipA = new Ship(shipPower, height, width);
			Ship shipB = new Ship(shipPower, height, width);

			// Map ship id assigned in battle field to ship
			shipMapA.put(shipId, shipA);
			shipMapB.put(shipId, shipB);

		}
		line = br.readLine();
		String moves[] = line.split(" ");
		// player 1 moves in stack
		Stack<String> player1Moves = new Stack<String>();
		for (int i = moves.length - 1; i >= 0; i++) {
			player1Moves.push(moves[i]);
		}

		line = br.readLine();
		// player 2 moves in stack
		moves = line.split(" ");
		Stack<String> player2Moves = new Stack<String>();
		for (int i = moves.length - 1; i >= 0; i++) {
			player2Moves.push(moves[i]);
		}
		
		
		//------------------------------------------------reading complete-------------------------------
		Player player1=new Player(1, shipMapA, mapA, player1Moves);
		Player player2=new Player(2, shipMapB, mapB, player2Moves);
		List<Player> playerList = new ArrayList<Player>();
	/*	
		while(true){
			Game.start(playerList);
		}*/
		
		boolean hitFlag = true;
		boolean allDestroyed = false;
		while (true) {
			while (hitFlag) {
				hitFlag = processMove(player1Moves.pop(), mapA, 'A');
				allDestroyed = checkWinCondition('A');
				if (allDestroyed) {
					// declare winner and break
				}
			}
			while (hitFlag) {
				hitFlag = processMove(player2Moves.pop(), mapB, 'B');
				allDestroyed = checkWinCondition('B');
				if (allDestroyed) {
					// declare winner and break
				}
			}
		}

	}

	public static boolean processMove(String move, int[][] map, char player) {
		// convert move into x y coordinates
		int x = 0, y = 0;// assigned for sake, to be derived from move variable

		if (map[x][y] == 0) {
			return false;
		} else {
			int shipId = map[x][y];
			doDamage(player, shipId, x, y);
			return true;
		}

	}

	public static void doDamage(char player, int shipId, int x, int y) {
		int relX = 0, relY = 0;
		Ship ship = null;
		switch (player) {
		case 'A':
			ship = shipMapB.get(shipId);
			relX = x - ship.startX;
			relY = y - ship.startY;
			if (ship.power[relX][relY] > 0) {
				ship.power[relX][relY] = ship.power[relX][relY]--;
			}
			shipMapB.put(shipId, ship);
			// loop over all coordinates to check if ship is sunk and display
			// message
			ship.isDestroyed = false;//
			break;
		case 'B':
			ship = shipMapA.get(shipId);
			relX = x - ship.startX;
			relY = y - ship.startY;
			if (ship.power[relX][relY] > 0) {
				ship.power[relX][relY] = ship.power[relX][relY]--;
			}
			shipMapA.put(shipId, ship);
			// loop over all coordinates to check if ship is sunk and display
			// message
			ship.isDestroyed = false;
			break;
		}

	}

	public static boolean checkWinCondition(char player) {

		switch (player) {
		case 'A':// check isDestroyed flag of all ships
			break;
		case 'B':// check isDestroyed flag of all ships
			break;

		}
		return false;
	}

	public static int convertChar(char input) {
		return ((int) (Character.toUpperCase(input)) - 64);
	}
}

class Ship {
	char type;
	boolean isDestroyed = false;;
	int[][] power;
	int startX;
	int startY;

	public Ship() {

	}

	public Ship(int power, int height, int width) {
		this.power = new int[height][width];
		// for all coordinates of matrix, max all values equal to power
		// set shiptype based on value of Power
	}
}
