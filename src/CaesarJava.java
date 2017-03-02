//David Evander
import java.util.Scanner;

public class CaesarJava {

	public static void main(String[] args) {
		
		//ask user for message
		System.out.println("...SPEAK NOW, YOU WHO WOULD USE MY SERVICES...");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("...DO YOU SEEK TO ENCODE(E) OR DECODE(D)?...");
		System.out.println("...(type an 'E' or 'D')...");
		
		String uPhrase="";
		int key=0;
		
		String choice = sc.nextLine();
		choice=choice.toLowerCase();
		if (choice.compareTo("d")==0){
			
			System.out.println("...SPEAK THE MUMBO AND THE JUMBO...");
			uPhrase = sc.nextLine();
		
			System.out.println("...WHISPER THE SACRED NUMBER TO UNLOCK THEIR MEANING...");
			key=sc.nextInt();
		}
		else if (choice.compareTo("e")==0){
			
			System.out.println("...SPEAK FREELY HERE, FRIEND, AND I WILL LOCK AWAY YOUR WORDS...");
			uPhrase = sc.nextLine();
			
			System.out.println("...WHISPER A SACRED NUMBER TO OBFUSCATE THEIR MEANING...");
			key=sc.nextInt();
		}
		else{
			System.out.println("<<<BEGONE YOU INGRATE.  IF YOU WILL NOT ATTEND MY RULES, I WILL NOT ATTEND YOU>>>");
			return;
		}
			
			
		
		String mePhrase = "";
		
		
		
		for (int i=0; i<uPhrase.length(); i++){
			char u=uPhrase.charAt(i);
			if (u>='A' && u<='Z'){
				if (choice.compareTo("d")==0){
					u+=key;
					if (u>'Z')
						u-=26;
				}
				else{
					u-=key;
					if (u<'A')
						u+=26;
				}
				
				
			}
			if (u>='a' && u<='z'){
				if (choice.compareTo("d")==0){
					u+=key;
					if (u>'z')
						u-=26;
				}
				else{
					u-=key;
					if (u<'a')
						u+=26;
				}
			}
			mePhrase+=u;
		}
		System.out.println(mePhrase);
	}

}
