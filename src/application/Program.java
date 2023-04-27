package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Address;
import entities.Department;
import entities.Employee;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome do departamento: ");
		String nameDepartment = sc.next();
		
		System.out.print("Dia do pagamento: ");
		int payDay = sc.nextInt();
		
		System.out.print("Email: ");
		String email = sc.next();
		
		System.out.print("Telefone: ");
		String tel = sc.next();
		
		Address address = new Address(email, tel);
		Department department = new Department(nameDepartment, payDay, address);
		
		System.out.print("Quantos funcionários tem no departamento? ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			sc.nextLine();
			System.out.println("Dados do funcionario #" + i + ":");
			System.out.print("Nome:");
			String name = sc.nextLine();
			System.out.print("Sálario: ");
			double salary = sc.nextDouble();
			
			Employee employee = new Employee(name, salary);
			
			department.addEmployee(employee);
		}
		
		showReport(department);
		
		sc.close();
	}
	
	private static void showReport(Department dept) {
		System.out.println("FOLHA DE PAGAMENTO:");
		System.out.println("Departamento (" + dept.getName() + ") = R$" + dept.payroll());
		System.out.println("Pagamento realizado no dia " + dept.getPayDay());
		System.out.println("Funcionarios: ");
		for (Employee employee : dept.getEmployees()) {
			System.out.println(employee.getName());
		}
		System.out.println("Para dúvidas favor entrar em contato: " + dept.getAddress().getEmail());
	}
}
