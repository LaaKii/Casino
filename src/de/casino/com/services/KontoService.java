package de.casino.com.services;

import de.casino.com.dao.DatabaseDao;
import de.casino.com.dao.KontoDao;
import de.casino.com.database.KontoBean;
import de.casino.com.database.TransactionBean;
import de.casino.com.database.UserBean;

public class KontoService {
	
	DatabaseDao<KontoBean> kontoDao = new KontoDao();
	
	public KontoBean getKontoByUser(UserBean user) {
		KontoBean kontoBean = new KontoBean();
		kontoBean.setIdUser(user.getIdUser());
		
		return kontoDao.getSingleItemByValue("idUser", kontoBean);
	}
	
	public boolean updateKontoMoney(KontoBean konto) {
		
		TransactionService transactionService = new TransactionService();
		TransactionBean transactionBean = transactionService.getLatestTransactionForKonto(konto);
		
		KontoBean oldKonto = kontoDao.getSingleItemByValue("idKonto", konto);
		
		KontoBean newKonto = new KontoBean();
		newKonto.setIdKonto(oldKonto.getIdKonto());
		newKonto.setIdUser(oldKonto.getIdUser());
		newKonto.setMoney(oldKonto.getMoney()+transactionBean.getTransactionAmount());
		
		kontoDao.updateItem(newKonto);
		
		return false;
	}

}
