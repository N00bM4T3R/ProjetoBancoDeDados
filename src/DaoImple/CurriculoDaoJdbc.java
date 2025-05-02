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
	    	  ps.setInt(3, obj.getVacancy());
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
      PreparedStatement ps = null;
      
      try {
    	  ps = conn.prepareStatement("UPDATE curriculos\r\n"
					+ "SET Name = ?, vacancy = ?, Exp = ?, prSalary = ?\r\n"
					+ "WHERE Id = ?"
					);
    	  ps.setString(1, obj.getName());
    	  ps.setInt(2, obj.getVacancy());
    	  ps.setDouble(3, obj.getExp());
    	  ps.setDouble(4, obj.getPrSalary());
    	  ps.setInt(5, obj.getId());
    	  
    	  ps.execute();
    	  
      }
      catch (SQLException e) {
    	  throw new DbException(e.getMessage());
    	  
	}
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement ps =null;
		
		try {
			ps = conn.prepareStatement("DELETE FROM curriculos WHERE Id = ?");
			
			ps.setInt(1, id);
			ps.execute();
			
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
			
		}
		
	}

	@Override
	public Curriculo findById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs;
		
		
		try {
			ps = conn.prepareStatement("SELECT curriculos.*,departamento.NameDp as DepName"
					+ " FROM curriculos INNER JOIN departamento"
					+ " ON curriculos.vacancy = departamento.Id"
					+ " WHERE curriculos.Id = ?");
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				Departamento dp = new Departamento();
				dp.setId(rs.getInt("Id"));
				dp.setNameDp(rs.getString("DepName"));
				Curriculo cl = new Curriculo();
				cl.setId(rs.getInt("Id"));
				cl.setName(rs.getString("Name"));
				cl.setExp(rs.getDouble("Exp"));
				cl.setPrSalary(rs.getDouble("PrSalary"));
				cl.setVacancy(rs.getInt("vacancy"));
				return cl;				
			}
			return null;
			
			
			
			
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
			
		}
		
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
