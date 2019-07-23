package de.casino.com.services;

import java.time.LocalDate;
import java.util.Date;

import de.casino.com.dao.DatabaseDao;
import de.casino.com.dao.TransactionDao;
import de.casino.com.database.GameBean;
import de.casino.com.database.KontoBean;
import de.casino.com.database.TransactionBean;
import de.casino.com.database.UserBean;

public class TransactionService {

	private DatabaseDao<TransactionBean> transactionDao = new TransactionDao();
	private LoginService loginService = new LoginService();
	
	public boolean createTransaction(GameBean game, KontoBean konto, double amount) {		
		TransactionBean transaction = new TransactionBean(game.getIdGame(), konto.getIdKonto(), amount);
		return transactionDao.createNewItem(transaction);
	}
	
	public TransactionBean getLatestTransactionForKonto(KontoBean konto) {
		TransactionBean transactionBean = new TransactionBean();
		transactionBean.setIdKonto(konto.getIdKonto());
		return transactionDao.getSingleItemByValue("idKonto", transactionBean);
	}
	
	public boolean checkFirstLoginOnThatDay(UserBean user) {
		return loginService.getLastLoginDateForUser(user).before(java.sql.Date.valueOf(LocalDate.now()));
	}

}
