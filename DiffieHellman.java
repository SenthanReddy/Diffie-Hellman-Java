import java.util.Scanner;
import java.util.Random;
public class DiffieHellman {

	public static void main(String[] args) {
		int temp,i;
		long TA=0,TB=0;
		boolean isPrime1=true;
		boolean isPrime2=true;
		System.out.println("Diffie Hellman Exchange Program");
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter two prime numbers");
		int p=scan.nextInt();
		int g=scan.nextInt();
		for(i=2;i<=p/2;i++) // loop to check if the numbers entered are prime or not
		{
	           temp=p%i;
		   if(temp==0)
		   {
		      isPrime1=false;
		      break;
		   }
		}
		for(i=2;i<=g/2;i++)
		{
	           temp=g%i;
		   if(temp==0)
		   {
		      isPrime2=false;
		      break;
		   }
		}
		if(isPrime1&&isPrime2)
		{
			System.out.println("Diffie Hellman Exchange Begins");
		}
		else
		{
			System.out.println("Numbers entered are not prime");
			System.out.println("Re Execute program and enter only prime numbers");		
		}
		Random rand = new Random();
		int  SA = rand.nextInt(20) + 1; // A's Random Number between 1 and 20
		int  SB = rand.nextInt(20) + 1; // B's Random Number between 1 and 20
		TA = (int)Math.pow(g,SA );
		TA = TA % p;
		TB = (int)Math.pow(g,SB );
		TB = TB % p;
		long secret1,secret2,secret;
		secret1 = (int)Math.pow(TB,SA );
		secret1 = secret1 % p;
		secret2 = (int)Math.pow(TA,SB );
		secret2 = secret2 % p;
		if(secret1==secret2)
		{
			secret=secret1;
			System.out.println("Diffie Exchange Completed");
			System.out.println("The secret key generated at both parties is: "+secret);
		}
		else
		{
			System.out.println("Diffie Hellman Exchange Failed. Try again!");
		}		
	}
}
