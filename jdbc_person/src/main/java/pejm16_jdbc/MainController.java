package pejm16_jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class MainController {

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		Scanner scanner = new Scanner(System.in);

		Person person = new Person();

		PersonCRUD crud = new PersonCRUD();
		boolean condition = true;
		do {
			System.out.println(
					"Enter the choice \n1. Save Person \n2. Update Person \n3. Delete Person \n4. Find Person by Id \n5. FindAllPesons");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter the id:- ");
				int id = scanner.nextInt();
				System.out.println("Enter the name:- ");
				String name = scanner.next();
				System.out.println("Enter the phone:- ");
				long phone = scanner.nextLong();
				System.out.println("Enter the address:- ");
				String address = scanner.next();

				person.setId(id);
				person.setNameString(name);
				person.setPhone(phone);
				person.setAddress(address);

				crud.savePerson(person);
			}
				break;
			case 2: {
				System.out.println("Enter the id:- ");
				int id = scanner.nextInt();
				System.out.println("Enter the name:- ");
				String name = scanner.next();
				System.out.println("Enter the phone:- ");
				long phone = scanner.nextLong();
				System.out.println("Enter the address:- ");
				String address = scanner.next();

				person.setId(id);
				person.setNameString(name);
				person.setPhone(phone);
				person.setAddress(address);

				crud.updatePerson(person);
			}
				break;
			case 3: {
				System.out.println("Enter the id:- ");
				int id = scanner.nextInt();

				crud.deletePerson(id);
			}
				break;
			case 4: {
				System.out.println("Enter the id:- ");
				int id = scanner.nextInt();

				crud.findPerson(id);
			}
				break;
			case 5: {
				crud.findAllPerson();
			}
				break;
			default:
				condition = false;
			}
		} while (condition);
	}
}
