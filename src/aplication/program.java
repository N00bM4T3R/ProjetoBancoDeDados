package aplication;

import DB.DbConnection;
import DaoImple.CurriculoDaoJdbc;
import model.Dao.DaoFactory1;
import model.entities.Curriculo;

public class program {

	public static void main(String[] args) {
		
	 
		System.out.println("==========teste insert============");
		CurriculoDaoJdbc cu = DaoFactory1.createNewCurriculo();
	    Curriculo cu1 = new Curriculo(2, "soraya", 2,  5.0, 300.00);
		cu.insert(cu1);
		System.out.println("insert completed");
		
		System.out.println("==========teste update ");
		cu1.setPrSalary(400.0);;
		//cu.update(cu1);
		System.out.println("update competed");
	
}

	

}
