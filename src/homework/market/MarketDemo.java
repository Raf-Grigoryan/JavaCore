package homework.market;


import homework.market.commands.AdminCommands;
import homework.market.commands.MarketCommands;
import homework.market.commands.UserCommands;
import homework.market.exception.OutOfStockException;
import homework.market.model.order.Order;
import homework.market.model.order.OrderStatus;
import homework.market.model.order.PaymentMethod;
import homework.market.model.product.Product;
import homework.market.model.product.ProductType;
import homework.market.model.user.User;

import homework.market.model.user.UserType;
import homework.market.service.Impl.OrderServiceImpl;
import homework.market.service.Impl.ProductServiceImpl;
import homework.market.service.OrderService;
import homework.market.service.ProductService;
import homework.market.service.UserService;
import homework.market.service.Impl.UserServiceImpl;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MarketDemo implements MarketCommands, AdminCommands, UserCommands {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserService userService = new UserServiceImpl();
    private static final ProductService productService = new ProductServiceImpl();
    private static final OrderService orderService = new OrderServiceImpl();
    private static final AtomicInteger userIdNumber = new AtomicInteger(100);
    private static final AtomicInteger productIdNumber = new AtomicInteger(100);
    private static final AtomicInteger orderIdNumber = new AtomicInteger(100);
    private static User currentUser;


    public static void main(String[] args) {
        userService.addUser(new User("A11","Raf","raf@mail.ru","Raf2004",UserType.ADMIN));
        process();
    }

    private static void process() {
        boolean isRun = true;
        while (isRun) {
            if (currentUser == null) {
                MarketCommands.commands();
                String command = scanner.nextLine();
                switch (command) {
                    case EXIT -> isRun = false;
                    case REGISTER -> register();
                    case LOGIN -> login();
                }
            } else {
                if (currentUser.getUserType().equals(UserType.USER)) {
                    UserCommands.userCommands();
                    String command = scanner.nextLine();
                    switch (command) {
                        case UserCommands.LOGOUT -> logout();
                        case ALL_PRODUCTS -> printProducts();
                        case BUY_PRODUCT -> buyProduct();
                        case PRINT_MY_ORDERS -> orderService.getOrdersByUserId(currentUser.getId());
                        case CANCEL_ORDER_BY_ID -> canselOrderById();
                    }

                }
                if (currentUser.getUserType().equals(UserType.ADMIN)) {
                    AdminCommands.adminCommands();
                    String command = scanner.nextLine();
                    switch (command) {
                        case AdminCommands.LOGOUT -> logout();
                        case ADD_PRODUCT -> addProduct();
                        case REMOVE_PRODUCT_BY_ID -> removeProductById();
                        case PRINT_PRODUCTS -> printProducts();
                        case PRINT_USERS -> userService.printUsers();
                        case PRINT_ORDERS -> orderService.printOrders();
                        case CHANGE_ORDER_STATUS_BY_ID -> changeOrderStatusByID();
                    }
                }
            }

        }
    }

    private static void addProduct() {
        System.out.println("Please input name,description,price,stockQty,Type");
        productService.printProductTypes();
        String[] productStr = scanner.nextLine().split(",");
        if (productStr.length == 5) {
            try {
                productService.addProduct(new Product("P" + productIdNumber.getAndIncrement(), productStr[0], productStr[1], Double.parseDouble(productStr[2]), Integer.parseInt(productStr[3]), ProductType.valueOf(productStr[4].toUpperCase())));
            } catch (NumberFormatException e) {
                System.out.println("Invalid Symbols with number");
            } catch (EnumConstantNotPresentException e) {
                System.out.println("Enum does not contains");
            }
        } else {
            System.out.println("Invalid information!!!");
        }
    }

    private static void register() {
        System.out.println("Please input name,email,password");
        String[] userStr = scanner.nextLine().split(",");
        if (userStr.length == 3) {
            if (!userService.getUserByLogin(userStr[0])) {
                currentUser = userService.addUser(new User("A" + userIdNumber.getAndIncrement(), userStr[0], userStr[1], userStr[2], UserType.USER));
            }
        }
    }

    private static void login() {
        System.out.println("Please input email,password");
        String[] userStr = scanner.nextLine().split(",");
        if (userStr.length == 2) {
            currentUser = userService.loginUser(userStr[0], userStr[1]);
            if (currentUser != null) {
                System.out.println("You are successfully sign in your account!");
            } else {
                System.out.println("Wrong email or password please try again!!!");
            }
        }
    }

    private static void logout() {
        System.out.println("Are you sure you want to log out of your account");
        System.out.println("Yes or No");
        String variant = scanner.nextLine();
        switch (variant) {
            case "Yes" -> currentUser = null;
            case "No" -> System.out.println("The right choose");
        }
    }

    private static void removeProductById() {
        if (productService.isEmpty()) {
            System.out.println("Storage is empty");
        } else {
            productService.printProducts();
            System.out.println("Please input product id");
            String id = scanner.nextLine();
            productService.removeProductById(id);
        }
    }

    private static void printProducts() {
        if (!productService.isEmpty()) {
            productService.printProducts();
        } else {
            System.out.println("Storage is empty");
        }
    }

    private static void changeOrderStatusByID() {
        if (!orderService.isEmpty()) {
            System.out.println("Please input order id");
            String orderId = scanner.nextLine();
            Order order = orderService.getOrderById(orderId);
            if (order != null) {
                if (order.getOrderStatus() == OrderStatus.NEW) {
                    order.setOrderStatus(OrderStatus.DELIVERED);
                    order.getProduct().setStockQty(order.getProduct().getStockQty() - order.getQty());
                } else {
                    System.out.println("The status of your order does not match the description");
                }
            } else {
                System.out.println("Order does not exist!!!");
            }
        } else {
            System.out.println("Order storage is empty");
        }
    }

    private static void buyProduct() {
        if (!productService.isEmpty()) {
            productService.printProducts();
            System.out.println("PLease input product id,product count,payment method");
            orderService.printPaymentMethods();
            System.out.println("Example P111,12,PAYPAL");
            String[] orderStr = scanner.nextLine().split(",");
            Product product = productService.searchProductById(orderStr[0]);
            if (product != null) {
                try {
                    if (product.getStockQty() < Integer.parseInt(orderStr[1])) {
                        throw new OutOfStockException();
                    } else {
                        double amount = product.getPrice() * Integer.parseInt(orderStr[1]);
                        System.out.println("The purchase price consists of " + amount);
                        System.out.println("Please confirm input Yes or No");
                        String confirm = scanner.nextLine();
                        switch (confirm) {
                            case "Yes" ->
                                    orderService.add(new Order("O" + orderIdNumber.getAndIncrement(), currentUser, product, new Date(), amount, OrderStatus.NEW, Integer.parseInt(orderStr[1]), PaymentMethod.valueOf(orderStr[2])));
                            case "No" ->
                                    System.out.println("Thank you for using our program,We hope you will change your mind");
                            default -> System.out.println("Invalid text please try again!!!");
                        }
                    }
                } catch (OutOfStockException e) {
                    System.out.println("Sorry but dont have much " + product.getName() + " of this product");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid symbols!!");
                }
            } else {
                System.out.println("Invalid product id!!!");
            }
        }
    }

    private static void canselOrderById() {
        if (!orderService.isEmpty(currentUser.getId())) {
            orderService.getOrdersByUserId(currentUser.getId());
            System.out.println("Please input order id for cansel");
            String orderId = scanner.nextLine();
            Order order = orderService.getOrderById(orderId);
            if (order != null) {
                if (order.getUser().equals(currentUser)) {
                    order.setOrderStatus(OrderStatus.CANCELED);
                }
            } else {
                System.out.println("Invalid id");
            }
        } else {
            System.out.println("Empty");
        }

    }
}
