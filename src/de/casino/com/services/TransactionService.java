package de.casino.com.services;

import de.casino.com.dao.DatabaseDao;
import de.casino.com.dao.TransactionDao;
import de.casino.com.database.GameBean;
import de.casino.com.database.KontoBean;
import de.casino.com.database.TransactionBean;

public class TransactionService {

	DatabaseDao<TransactionBean> transactionDao = new TransactionDao();
	
	public boolean createTransaction(GameBean game, KontoBean konto, double amount) {		
		TransactionBean transaction = new TransactionBean(game.getIdGame(), konto.getIdKonto(), amount);
		return transactionDao.createNewItem(transaction);
	}
	
	public TransactionBean getLatestTransactionForKonto(KontoBean konto) {
		TransactionBean transactionBean = new TransactionBean();
		transactionBean.setIdKonto(konto.getIdKonto());
		return transactionDao.getSingleItemByValue("idKonto", transactionBean);
	}
}
