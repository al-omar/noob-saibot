package icici_v2;
import java.util.*;

public class Game {
	
	List<Player> masterPlayerList;
	static boolean hitFlag=true;

 	
	public static void start(Player p1, Player p2){
		boolean allDestroyed=false;
		while (!p1.getPlayerMoves().empty() && !p2.getPlayerMoves().empty()){
			
				makeMove(p1,p2);
				while(hitFlag){
				hitFlag = processMove(p1.getPlayerMoves().pop(), p2.getPlayerMap(), p1);
				allDestroyed = checkWinCondition(p2);
				if (allDestroyed) {
					// declare winner and break
				}
				}
		}
		
		
	}
	
	public static void makeMove(Player movemaker, Player target){
		
		
		
	}

	public static boolean processMove(String move, int[][] targetMap, Player targetPlayer) {
		// convert move into x y coordinates
		int x = 0, y = 0;// assigned for sake, to be derived from move variable

		if (targetMap[x][y] == 0) {
			return false;
		} else {
			int shipId = targetMap[x][y];
			doDamage(targetPlayer, shipId, x, y);
			return true;
		}

	}
	public static void doDamage(Player targetPlayer, int shipId, int x, int y) {
		int relX = 0, relY = 0;
		Ship ship = null;
		Map<Integer,Ship> targetShipMap=targetPlayer.getPlayerShips();
		ship = targetShipMap.get(shipId);
		relX = x - ship.startX;
		relY = y - ship.startY;
		if (ship.power[relX][relY] > 0) {
			ship.power[relX][relY] = ship.power[relX][relY]--;
		}
		targetShipMap.put(shipId, ship);
		// loop over all coordinates to check if ship is sunk and display
					// message
					ship.isDestroyed = false;//
		

	}
	public static boolean checkWinCondition(Player player) {

		Map<Integer,Ship> loserShipMap =player.getPlayerShips();
		for(Map.Entry<Integer, Ship> shipKeyValue : loserShipMap.entrySet()){
			Ship ship=shipKeyValue.getValue();
			if(!ship.isDestroyed)
				return false;
		}
		return true;
	}

}
