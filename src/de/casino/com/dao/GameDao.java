package de.casino.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import de.casino.com.database.DbManager;
import de.casino.com.database.GameBean;
import de.casino.com.exceptions.GameNotFoundException;

public class GameDao implements DatabaseDao<GameBean>{

	@Override
	public GameBean getSingleItemByValue(String column, GameBean value) {
		String sql="";
		switch (column) {
		case "idUser":
			sql = "Select * from games where idGame=" + value.getIdGame();
			break;
		case "gamename":
			sql = "Select * from games where gameName=" + value.getGameName();
			break;
		default:
			break;
		}
		
		System.out.println("Creating statement: " + sql);
		Statement stmt = null;
		ResultSet rs = null;
		
		GameBean res = null;
		
		try {
			stmt = DbManager.getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				res = new GameBean(rs.getInt("idGame"),rs.getString("gameName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//DbManager.closeConnection();
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (res==null) {
			try {
				throw new GameNotFoundException();
			} catch (GameNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}

	@Override
	public List<GameBean> getAllItems() {
		String sql = "Select * from games";
		
		System.out.println("Creating statement: " + sql);
		Statement stmt;
		ResultSet rs = null;
		
		List<GameBean> allGames = new ArrayList<GameBean>();
		
		try {
			stmt = DbManager.getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				allGames.add(new GameBean(rs.getInt("idGame"),rs.getString("gameName")));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allGames;
	}

	@Override
	public boolean deleteItemById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createNewItem(GameBean newItem) {
		System.out.println("creating new game: " + newItem);
		
		String insertSql = "insert into games"
				+"(gameName) values"
				+"(?)";
		
		try {
			PreparedStatement preparedStatement = DbManager.getConnection().prepareStatement(insertSql);
			preparedStatement.setString(1, newItem.getGameName());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	
	
	
}
