package de.casino.com.services;

import de.casino.com.dao.DatabaseDao;
import de.casino.com.dao.GameDao;
import de.casino.com.database.GameBean;

public class GameService {

	DatabaseDao<GameBean> gameDao = new GameDao();
	
	public GameBean getGameByName(GameBean game) {
		return gameDao.getSingleItemByValue("gameName", game);
	}
	
}