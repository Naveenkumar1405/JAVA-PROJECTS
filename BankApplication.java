package com.Java.Project;
import java.util.Scanner;
class Bank{
	public double rateOfInterest() {
		return 0.0;
	}
}
class Hdfc extends Bank{

	@Override
	public double rateOfInterest() {
		return 0.15;
	}
}
class Icici extends Bank{
	@Override
	public double rateOfInterest() {
		return 0.09;
	}
}
class Sbi extends Bank{
	@Override
	public double rateOfInterest() {
		return 0.07;
	}
}
class Salesman{
	public void ProvideHomeLoan(double amount, Bank bank) {
		double roi=bank.rateOfInterest();
		int rate=(int)(roi*100);
		System.out.println(rate+"% is the Interest Quoted by "+bank.getClass().getSimpleName()+" Bank");
		
		double interestAmount =amount*roi;
		System.out.println(interestAmount+"INR is the interest Amount to be paid for the amount "+amount+" Quoted by "+bank.getClass().getSimpleName());
		
		double total=amount+interestAmount;
		System.out.println(total+"INR to be paid in Total");
	}
}

public class BankApplication {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		
        boolean exit = false;
        
		while (!exit) {
            System.out.println("1. HDFC");
            System.out.println("2. ICICI");
            System.out.println("3. SBI");
            System.out.println("4. Exit");
            System.out.print("CHOOSE THE BANK :");
            
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    Bank a=new Hdfc() ;
                    Hdfc a1 =(Hdfc) a;
                    a1.rateOfInterest();
                    System.out.print("AMOUNT : ");
            		double amount = scan.nextDouble();
            		Salesman salesman=new Salesman();
            		salesman.ProvideHomeLoan(amount, new Hdfc());
                    break;
                case 2:
                    Bank b=new Icici();
                    Icici b1=(Icici)b;
                    b1.rateOfInterest();
                    System.out.print("AMOUNT : ");
            		double amount2 = scan.nextDouble();
            		Salesman salesman2=new Salesman();
            		salesman2.ProvideHomeLoan(amount2, new Icici());
                    break;
                case 3:
                    Bank c= new Sbi();
                    Sbi c1=(Sbi)c;
                    c1.rateOfInterest();
                    System.out.print("AMOUNT : ");
            		double amount3 = scan.nextDouble();
            		Salesman salesman3=new Salesman();
            		salesman3.ProvideHomeLoan(amount3, new Sbi());
                    break;
                case 4:
                    System.out.println("Thank you for using!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
        scan.close();	
	}
}
