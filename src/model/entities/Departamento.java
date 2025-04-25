package model.entities;

public class Departamento {
	
	private int Id;
	private String nameDp;
	
	
	public Departamento() {
	}


	public Departamento(int id, String nameDp) {
		Id = id;
		this.nameDp = nameDp;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getNameDp() {
		return nameDp;
	}


	public void setNameDp(String nameDp) {
		this.nameDp = nameDp;
	}


	@Override
	public String toString() {
		return "departamento [Id=" + Id + ", nameDp=" + nameDp + "]";
	}
	
	
	
	

}
