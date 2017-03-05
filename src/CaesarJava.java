//David Evander
import java.util.Scanner;

public class CaesarJava {
	
	static boolean theEnd = false;
	
	public static void main(String[] args) {
		System.out.println("...SPEAK NOW, YOU WHO WOULD USE MY SERVICES...");
		
		String choice = "";
		int key = 0;
		String uPhrase="";
		String mePhrase = "";
		Scanner sc = new Scanner(System.in);
		while (theEnd==false){
			//ask user for message
			System.out.println("...DO YOU SEEK TO ENCODE(E) OR DECODE(D)?...");
			System.out.println("...(type an 'E' or 'D')...");
			
			uPhrase="";
			key=0;
			
			choice = sc.next();
			choice=choice.toLowerCase();
			if (choice.compareTo("d")==0){
				
				System.out.println("...SPEAK THE MUMBO AND THE JUMBO...");
				uPhrase = sc.next();
			
				System.out.println("...WHISPER THE SACRED NUMBER TO UNLOCK THEIR MEANING...");
				key=sc.nextInt();
				key=key%26;
			}
			else if (choice.compareTo("e")==0){
				
				System.out.println("...SPEAK FREELY HERE, FRIEND, AND I WILL LOCK AWAY YOUR WORDS...");
				uPhrase = sc.next();
				
				System.out.println("...WHISPER A SACRED NUMBER TO OBFUSCATE THEIR MEANING...");
				key=sc.nextInt();
			}
			else{
				System.out.println("<<<BEGONE YOU INGRATE.  IF YOU WILL NOT ATTEND MY RULES, I WILL NOT ATTEND YOU>>>");
				sc.close();
				return;
			}
			
			mePhrase = "";
			
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
			System.out.println("");
			System.out.println("...DO YOU HAVE FURTHER NEED OF ME?...");
			System.out.println("(y/n)");
			try{
				String resp=sc.next();
				resp=resp.toLowerCase();
				if (resp.compareTo("n")==0){
					System.out.println("...FARE THEE WELL...");
					sc.close();
					theEnd=true;
					
				}
				else if (resp.compareTo("y")==0){
					System.out.println("...VERY WELL...");
				}
				else{
					System.out.println("<<<JUST LEAVE THEN>>>");
					sc.close();
					return;
				}
			} catch (Exception e){
				System.out.println("<<<BEGONE THEN, YOU INGRATE.  IF YOU WILL NOT ATTEND MY RULES, I WILL NOT ATTEND YOU>>>");
				sc.close();
				return;
			}
		}
		
	}

}
