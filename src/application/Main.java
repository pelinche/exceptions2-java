package application;

import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        createAccount();

        msg("Program Terminated.",true);

    }

    public static void createAccount(){
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            msg("Enter account data", true);
            msg("Number:", false);
            Integer number = sc.nextInt();
            msg("Holder: ", false);
            sc.nextLine();
            String holder = sc.nextLine();
            msg("Initial Balance: ", false);
            Double balance = sc.nextDouble();
            msg("Withdraw Limit: ", false);
            Double withdrawLimit = sc.nextDouble();
            Account account = new Account(number, holder, balance, withdrawLimit);
            msg("CREATED: " + account.toString(), true);

            msg("", true);
            msg("Enter amount for withdraw: ", false);
            Double amount = sc.nextDouble();
            account.withdraw(amount);
            msg(account.toString(), true);
        }catch (
        DomainException e ){
            msg("Domain Exception: "+e.getMessage(),true );
        }catch (RuntimeException e){
            msg("Runtime Exception: "+e.getMessage(),true);
        }

        sc.close();

    }


    public static void msg(String msg,boolean quebraLinha){
        if ((quebraLinha)) {
            System.out.println(msg);
        } else {
            System.out.print(msg);
        }
    }
}
