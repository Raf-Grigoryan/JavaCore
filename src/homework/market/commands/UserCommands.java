package homework.market.commands;

public interface UserCommands {
    String LOGOUT = "0";
    String ALL_PRODUCTS = "1";
    String BUY_PRODUCT = "2";
    String PRINT_MY_ORDERS = "3";
    String CANCEL_ORDER_BY_ID = "4";

    static void userCommands() {
        System.out.println("PLease input " + LOGOUT + " for logout");
        System.out.println("PLease input " + ALL_PRODUCTS + " for print all products");
        System.out.println("PLease input " + BUY_PRODUCT + " for buy product");
        System.out.println("PLease input " + PRINT_MY_ORDERS + " for print my orders");
        System.out.println("Please input " + CANCEL_ORDER_BY_ID + " for cancel order by id");
    }

}
