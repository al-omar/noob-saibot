package icici_v2;

import java.util.*;

public class Player {
	
	private int playerId;
	private Map<Integer, Ship> playerShips =new HashMap<Integer, Ship>();
	private Stack<String> playerMoves = new Stack<String>();
	private int[][] playerMap;
	
	public Map<Integer, Ship> getPlayerShips() {
		return playerShips;
	}
	public void setPlayerShips(Map<Integer, Ship> playerShips) {
		this.playerShips = playerShips;
	}
	public Stack<String> getPlayerMoves() {
		return playerMoves;
	}
	public void setPlayerMoves(Stack<String> playerMoves) {
		this.playerMoves = playerMoves;
	}
	public int[][] getPlayerMap() {
		return playerMap;
	}
	public void setPlayerMap(int[][] playerMap) {
		this.playerMap = playerMap;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public Player(int playerId, Map<Integer, Ship> playerShips, int[][] playerMap, Stack<String> playerMoves) {
		super();
		this.playerId = playerId;
		this.playerShips = playerShips;
		this.playerMap = playerMap;
		this.playerMoves = playerMoves;
	}
	

}
