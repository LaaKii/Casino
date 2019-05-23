package de.casino.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import de.casino.com.database.DbManager;
import de.casino.com.database.KontoBean;
import de.casino.com.exceptions.KontoNotFoundException;

public class KontoDao implements DatabaseDao<KontoBean>{

	@Override
	public KontoBean getSingleItemByValue(String column, KontoBean value) {
		String sql="";
		switch (column) {
		case "idKonto":
			sql = "Select * from konto where idKonto=" + value.getIdKonto();
			break;
		case "idUser":
			sql = "Select * from konto where idUser=" + value.getIdUser();
			break;
		default:
			break;
		}
		
		System.out.println("Creating statement: " + sql);
		Statement stmt = null;
		ResultSet rs = null;
		
		KontoBean res = null;
		
		try {
			stmt = DbManager.getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				res = new KontoBean(rs.getInt("idKonto"),rs.getInt("idUser"), rs.getDouble("money"));
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
				throw new KontoNotFoundException();
			} catch (KontoNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}

	@Override
	public List<KontoBean> getAllItems() {
		String sql = "Select * from games";
		
		System.out.println("Creating statement: " + sql);
		Statement stmt;
		ResultSet rs = null;
		
		List<KontoBean> allKontos = new ArrayList<KontoBean>();
		
		try {
			stmt = DbManager.getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				allKontos.add(new KontoBean(rs.getInt("idKonto"),rs.getInt("idUser"), rs.getDouble("money")));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allKontos;
	}

	@Override
	public boolean deleteItemById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createNewItem(KontoBean newItem) {
	System.out.println("creating new konto: " + newItem);
		
		String insertSql = "insert into konto"
				+"(idUser, money) values"
				+"(?,?)";
		
		try {
			PreparedStatement preparedStatement = DbManager.getConnection().prepareStatement(insertSql);
			preparedStatement.setInt(1, newItem.getIdUser());
			preparedStatement.setDouble(2, newItem.getMoney());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
