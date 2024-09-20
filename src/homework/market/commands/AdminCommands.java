package homework.market.commands;

public interface AdminCommands {
    String LOGOUT = "0";
    String ADD_PRODUCT = "1";
    String REMOVE_PRODUCT_BY_ID = "2";
    String PRINT_PRODUCTS = "3";
    String PRINT_USERS = "4";
    String PRINT_ORDERS = "5";
    String CHANGE_ORDER_STATUS_BY_ID = "6";

   static void adminCommands(){
       System.out.println("Please input " + LOGOUT + " for logout");
       System.out.println("PLease input " + ADD_PRODUCT + " for add product");
       System.out.println("PLease input " + REMOVE_PRODUCT_BY_ID + " for remove product by id");
       System.out.println("PLease input " + PRINT_PRODUCTS + " for see all products");
       System.out.println("PLease input " + PRINT_USERS + " for see all users");
       System.out.println("PLease input " + PRINT_ORDERS + " for see all orders");
       System.out.println("Please input " + CHANGE_ORDER_STATUS_BY_ID + " for change order status by id");
   }
}
