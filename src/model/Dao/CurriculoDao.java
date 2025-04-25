package model.Dao;

import java.util.List;

import model.entities.Curriculo;
import model.entities.Departamento;


public interface CurriculoDao {
	void insert(Curriculo obj);
	void update(Curriculo obj);
	void deleteById(Integer id);
	Curriculo findById(Integer id);
	List<Curriculo> findALL();
	List<Curriculo> findByDepartment(Departamento department);
	
	
	
 

}
