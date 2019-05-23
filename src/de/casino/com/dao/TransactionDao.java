package de.casino.com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import de.casino.com.database.DbManager;
import de.casino.com.database.TransactionBean;
import de.casino.com.exceptions.UserNotFoundException;

public class TransactionDao implements DatabaseDao<TransactionBean>{

	@Override
	public TransactionBean getSingleItemByValue(String column, TransactionBean value) {
		String sql="";
		switch (column) {
		case "idKonto":
			sql = "Select * from transactions where idKonto= " + value.getIdKonto();
			break;
		case "idTransaction":
			sql = "Select * from transactions where idTransaction= " + value.getIdTransaction();
			break;
		case "idGame":
			sql = "Select * from transactions where idGame = " + value.getIdGame();
			break;
		default:
			break;
		}
		System.out.println("Creating statement: " + sql);
		Statement stmt = null;
		ResultSet rs = null;
		
		TransactionBean res = null;
		
		try {
			stmt = DbManager.getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				res = new TransactionBean(rs.getInt("idTransaction"),rs.getInt("idGame"),rs.getInt("idKonto"),rs.getDouble("transactionAmount"));
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
				throw new UserNotFoundException();
			} catch (UserNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}

	@Override
	public List<TransactionBean> getAllItems() {
		String sql = "Select * from transactions";
		
		System.out.println("Creating statement: " + sql);
		Statement stmt;
		ResultSet rs = null;
		
		List<TransactionBean> allTransactions = new ArrayList<TransactionBean>();
		
		try {
			stmt = DbManager.getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				allTransactions.add(new TransactionBean(rs.getInt("idTransaction"),rs.getInt("idGame"),rs.getInt("idKonto"),rs.getDouble("transactionAmount")));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allTransactions;
	}

	@Override
	public boolean deleteItemById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createNewItem(TransactionBean newItem) {
		System.out.println("creating new transaction: " + newItem);
		
		String insertSql = "insert into transactions"
				+"(idGame, idKonto, transactionAmount) values"
				+"(?,?,?)";
		
		try {
			PreparedStatement preparedStatement = DbManager.getConnection().prepareStatement(insertSql);
			preparedStatement.setInt(1, newItem.getIdGame());
			preparedStatement.setInt(2, newItem.getIdKonto());
			preparedStatement.setDouble(3, newItem.getTransactionAmount());
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	

	}
	
	

}
