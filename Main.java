package appDepartament;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat scHora = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Digite o nome do departamento: ");
		String nomeDep = sc.nextLine();
		System.out.println("\nDigite os dados do trabalhador: ");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Salario base: ");
		Double salario = sc.nextDouble();
		
		System.out.println("Quantos contratos para esse trabalhador?");
		int numCon = sc.nextInt();
		Experiencia exp = Experiencia.valueOf(level.toUpperCase());

		Worker trabalhador = new Worker(nome, exp, salario, new Department(nomeDep));
	

		for (int i = 0; i < numCon; i++) {
			System.out.printf("Digite o contrato #%d: \n",i+1);
			System.out.print("Data(DD/MM/YYYY): ");
			Date data = scHora.parse(sc.next());

			System.out.println("Valor por hora: ");
			Double valor = sc.nextDouble();

			System.out.println("Duracao(Horas): ");
			Integer horas = sc.nextInt();

			HourContract contrato = new HourContract(data, valor, horas);
			trabalhador.addContract(contrato);
		}

		System.out.print("Informe a data para encontrar a renda(MM/YYYY): ");
		String dataComp = sc.next();
		int mes = Integer.parseInt(dataComp.substring(0, 2));
		int ano = Integer.parseInt(dataComp.substring(3));

		System.out.println("Nome:" + trabalhador.getName());
		System.out.println("Departamento:" + trabalhador.getDepartment());
		System.out.println("Renda neste mes foi de: " + trabalhador.income(ano, mes));

		// for(HourContract x: trabalhador.getContracts()) {
		// System.out.println(trabalhador.getContracts());//printa os contratos
		// }

		sc.close();
	}
}
