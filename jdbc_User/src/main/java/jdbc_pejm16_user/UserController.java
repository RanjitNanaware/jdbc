package jdbc_pejm16_user;

import java.util.Scanner;

public class UserController {
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner (System.in);
		
		UserCRUD crud = new UserCRUD();
		
		User user = new User();
		
		System.out.println("Enter the choice \n1. signUp User \n2. Login User \n3. Exit");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:{
				System.out.println("Enter the id");
				int  id = scanner.nextInt();
				System.out.println("Enter the name");
				String name = scanner.next();
				System.out.println("Enter the phone");
				long phone = scanner.nextLong();
				System.out.println("Enter the email");
				String email = scanner.next();
				System.out.println("Enter the password");
				String password = scanner.next();
			
				user.setId(id);
				user.setName(name);
				user.setPhone(phone);
				user.setEmail(email);
				user.setPassword(password);
				
				crud.SignUpUser(user);
				
			}
			break ;
			
		case 2 :{
			System.out.println("Enter the Email");
			String email = scanner.next();
			System.out.println("Enter the password");
			String password = scanner.next();
			
			user.setEmail(email);
			user.setPassword(password);
			
			boolean result = crud.logInUser(user) ;
			
			System.out.println("Enter The Choice \n1. Update Passwords \n2. Login \n3. Exit");
			int key = scanner.nextInt();
			
			switch(key) {
			case 1: {
					System.out.println("Enter the facebook password");
					user.setFacebook(scanner.next());
					System.out.println("Enter the instagram password");
					user.setInstagram(scanner.next());
					System.out.println("Enter the snapchat password");
					user.setSnapchat(scanner.next());
					System.out.println("Enter the whatsapp Password");
					user.setWhatsapp(scanner.next());
					System.out.println("Enter the twitter Password");
					user.setTwitter(scanner.next());
					
					crud.updatePasswords(user);
				}
				break ;
				default:
					break;
			}
			
			if(result) {
				System.out.println("Login SucessFully");
				crud.diplayPasswords(email);
			}else {
				System.out.println("Invalid credential");
			}
		}
			break ;
			
		default:
			break ;
		}
	}
}
