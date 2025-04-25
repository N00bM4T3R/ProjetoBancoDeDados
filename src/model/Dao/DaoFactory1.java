package model.Dao;

import DB.DbConnection;
import DaoImple.CurriculoDaoJdbc;
import model.entities.Curriculo;

public class DaoFactory1 {
	
	public static CurriculoDaoJdbc createNewCurriculo() {
		return new CurriculoDaoJdbc(DbConnection.getConnection());
	}

}
