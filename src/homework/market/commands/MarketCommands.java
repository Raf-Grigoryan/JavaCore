package homework.market.commands;

public interface MarketCommands {
    String EXIT = "0";
    String REGISTER = "1";
    String LOGIN = "2";


    static void commands(){
        System.out.println("Hello This is a Online Market");
        System.out.println("Please input " + EXIT + " for exit");
        System.out.println("Please input " + REGISTER + " for register");
        System.out.println("Please input " + LOGIN + " for login");
    }

}
