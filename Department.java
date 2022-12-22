package appDepartament;

public class Department {

	private String name;
	
	public Department() {
	}

	public Department(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}