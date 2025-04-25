package DaoImple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DB.DbException;
import model.Dao.CurriculoDao;
import model.entities.Curriculo;
import model.entities.Departamento;

public class CurriculoDaoJdbc implements CurriculoDao {
	
 Connection conn;

	

	public CurriculoDaoJdbc(Connection conn) {
	  this.conn = conn;
	  
	  
		
		
	}

	@Override
	public void insert(Curriculo obj) {
      PreparedStatement ps = null;
      try {
    	  ps = conn.prepareStatement("INSERT "
					 +"INTO curriculos (Id,Name,vacancy,Exp,prSalary)"
				     + "VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
    	  
    	  ps.setInt(1, obj.getId());
    	  ps.setString(2, obj.getName());
    	  ps.setInt(3, obj.getDepartamento().getId());
    	  ps.setDouble(4, obj.getExp());
    	  ps.setDouble(5, obj.getPrSalary());
      
    	  int rows = ps.executeUpdate();
    	  if (rows == 0) {
    		  throw new SQLException();
    	  }
    	  else {
    		  ResultSet rs = ps.getGeneratedKeys();
    		  if(rs.next()) {
    			  int id = rs.getInt(1);
    			  obj.setId(id);
    			  
    		  }
    	  }

      }
      catch (SQLException e) {
		throw new DbException(e.getMessage());
	}
	
		
	}

	@Override
	public void update(Curriculo obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Curriculo findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Curriculo> findALL() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Curriculo> findByDepartment(Departamento department) {
		// TODO Auto-generated method stub
		return null;
	}

}
