package model.entities;

public class Curriculo {
	
	private int id;
	private String name;
	private int vacancy;
	private Double exp;
	private Double prSalary;
	
	Departamento departamento = new Departamento(1, "explem");
	
	
	

	public Curriculo() {
		super();
	}

	public Curriculo(int id, String name, int vacancy, Double exp, Double prSalary) {
		super();
		this.id = id;
		this.name = name;
		this.vacancy = vacancy;
		this.exp = exp;
		this.prSalary = prSalary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name = name;
	}

	public int getVacancy() {
		return vacancy;
	}

	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}

	public Double getExp() {
		return exp;
	}

	public void setExp(Double exp) {
		this.exp = exp;
	}

	public Double getPrSalary() {
		return prSalary;
	}

	public void setPrSalary(Double prSalary) {
		this.prSalary = prSalary;
	}
	
	

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "curriculo [id=" + id + ", Name=" + name + ", vacancy=" + vacancy + ", exp=" + exp + ", prSalary="
				+ prSalary + "]";
	}
	
	
	
	
	
	

}
