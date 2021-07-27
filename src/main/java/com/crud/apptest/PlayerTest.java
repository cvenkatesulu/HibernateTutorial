package com.crud.apptest;

import com.crud.dao.PlayerDao;
//import com.crud.dto.Player;

public class PlayerTest {
	
	public static void main(String[] args) {
		
		//Player player  = new Player(101, "Venkatesulu", "Hyderabad", 29);
		
		PlayerDao dao = new PlayerDao();
		//dao.savePlayer(player);
		//dao.updatePlayerDetails();
		//dao.findByPlayerId();
		dao.deleteByPlayersId();
	}

}
