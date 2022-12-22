package appDepartament;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {

	private String name;
	private Experiencia level;
	private Double salario;

	private Department department;
	private List<HourContract> contracts = new ArrayList<>();

	public Worker() {
	}

	public Worker(String name, Experiencia level, Double salario, Department department) {
		this.name = name;
		this.level = level;
		this.salario = salario;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Experiencia getLevel() {
		return level;
	}

	public void setLevel(Experiencia level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return salario;
	}

	public void setBaseSalary(Double salario) {
		this.salario = salario;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void addContract(HourContract contract) {
		contracts.add(contract);
	}

	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}

	public double income(int year, int month) {
		double sum = salario;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if (year == c_year && month == c_month) {
				sum += c.valorTotal();
			}
		}
		return sum;
	}
}