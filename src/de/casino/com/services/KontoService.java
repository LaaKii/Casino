package de.casino.com.services;

import de.casino.com.dao.DatabaseDao;
import de.casino.com.dao.KontoDao;
import de.casino.com.database.KontoBean;
import de.casino.com.database.UserBean;

public class KontoService {
	
	DatabaseDao<KontoBean> kontoDao = new KontoDao();
	
	public KontoBean getKontoByUser(UserBean user) {
		KontoBean kontoBean = new KontoBean();
		kontoBean.setIdUser(user.getIdUser());
		
		return kontoDao.getSingleItemByValue("idUser", kontoBean);
	}
	

}
