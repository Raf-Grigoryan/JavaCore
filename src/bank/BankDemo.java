package bank;


import bank.model.card.Card;
import bank.model.card.Card_Type;
import bank.model.user.User;
import bank.service.CardService;
import bank.service.UserService;
import bank.serviceImpl.CardServiceImpl;
import bank.util.BankCommands;
import bank.serviceImpl.UserServiceImpl;

import java.util.Random;
import java.util.Scanner;

public class BankDemo implements BankCommands {
    private static final UserService userService = new UserServiceImpl();
    private static final CardService cardService = new CardServiceImpl();
    private static User currentUser;
    private static Card card;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        process();
    }

    private static void process() {
        System.out.println("Hi This Is a SBY Bank");
        boolean isRun = true;
        while (isRun) {
            if (currentUser == null) {
                commands();
                String command = scanner.nextLine();
                switch (command) {
                    case EXIT -> isRun = false;
                    case REGISTER -> register();
                    case LOGIN -> login();
                }
            } else {
                commandsWhereCurrentUserExist();
                String command = scanner.nextLine();
                switch (command) {
                    case GET_CARD -> getNewCard();
                    case DEACTIVATED_PAGE -> deactivatedAccount();
                    case DEPOSIT_MONEY -> depositMoney();
                    case TRANSFER_MONEY -> transferMoney();
                    case INFORMATION_CARD -> cardInformation();
                    case LOG_OUT -> logOut();
                }
            }
        }
    }

    private static void commands() {
        System.out.println("Please input " + EXIT + " for exit");
        System.out.println("Please input " + REGISTER + " for register");
        System.out.println("Please input " + LOGIN + " for login");


    }

    private static void commandsWhereCurrentUserExist() {
        System.out.println("Please input " + GET_CARD + " for get card");
        System.out.println("Please input " + DEACTIVATED_PAGE + " deactivated your page");
        System.out.println("Please input " + DEPOSIT_MONEY + " to deposit money");
        System.out.println("Please input " + TRANSFER_MONEY + " for transfer money");
        System.out.println("Please input " + INFORMATION_CARD + " for see your card information");
        System.out.println("Please input " + LOG_OUT + " for logout");
    }

    private static void register() {
        System.out.println("Please input name,surname,login,password,age");
        String[] userStr = scanner.nextLine().split(",");
        if (userStr.length == 5 && isValidNumber(userStr[4])) {
            if (userService.getUserByLogin(userStr[2]) == null) {
                try {
                    int age = Integer.parseInt(userStr[4]);
                    currentUser = userService.addUser(new User(userStr[0], userStr[1], userStr[2], userStr[3], age));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid symbol try again!");
                }
            } else {
                System.out.println("User exist");
            }
        } else {
            System.out.println("The amount of information does not match try again!");
        }
    }

    private static void login() {
        System.out.println("Please input login,password");
        String[] userStr = scanner.nextLine().split(",");
        if (userStr != null && userStr.length == 2) {
            currentUser = userService.loginUser(userStr[0], userStr[1]);
            if (currentUser != null) {
                card = cardService.getCardByUserId(currentUser.getId());
                System.out.println("You successfully logged into your account");
            }
        } else {
            System.out.println("Wrong login or password please try again");
        }
    }

    private static void deactivatedAccount() {
        userService.deleteUserById(currentUser.getId());
        cardService.deactivatedCardByUserId(currentUser.getId());
        currentUser = null;
        System.out.println("Your Account has benn successfully deleted");
    }

    private static void getNewCard() {
        if (card == null) {
            System.out.println("Please enter the PIN code of the card, but only the numbers and the length of 4");
            String pinCard = scanner.nextLine();
            if (isValidNumber(pinCard) && pinCard.length() == 4) {
                System.out.println("Please input payment systems");
                cardService.printPaymentSystems();
                String paymentSystem = scanner.nextLine();
                card = cardService.add(new Card(pinCard, Card_Type.valueOf(paymentSystem), currentUser.getId()));
                System.out.println("Card successfully added!");
            } else {
                System.out.println("Invalid Pin");
            }
        } else {
            System.out.println("You have a card");
        }

    }

    private static boolean isValidNumber(String number) {
        return number.chars().allMatch(Character::isDigit);
    }

    private static void depositMoney() {
        if (card != null) {
            System.out.println("Please input how much money you want to transfer to your card");
            String moneyStr = scanner.nextLine();
            try {
                double money = Double.parseDouble(moneyStr);
                cardService.depositMoney(card.getCardNumber(), money);
            } catch (NumberFormatException e) {
                System.out.println("Invalid symbol please try again!");
            }
        } else {
            System.out.println("You can create new card whether you want or not");
            System.out.println("Please input Yes or No");
            String command = scanner.nextLine();
            switch (command) {
                case "Yes" -> getNewCard();
                case "No" -> System.out.println("The operation is over");
                default -> System.out.println("Invalid operation please try again!");
            }
        }
    }

    private static void transferMoney() {
        if (card != null) {
            cardService.printAllCards();
            System.out.println("Please input the recipients card numbers");
            String recipientsCardNumber = scanner.nextLine();
            if (cardService.getCardByCardNumber(recipientsCardNumber) != null) {
                System.out.println("Please input how much money you want to transfer to recipients card");
                String amountStr = scanner.nextLine();
                try {
                    double amount = Double.parseDouble(amountStr);
                    cardService.transferMoney(card, recipientsCardNumber, amount);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid symbol please try again!");
                }
            }
        }else {
            System.out.println("Create card!");
        }
    }

    private static void logOut() {
        currentUser = null;
        card = null;
        System.out.println("You Have logged out of your account!!!");
    }

    private static void cardInformation() {
        if (card != null) {
            System.out.println(card);
        } else {
            System.out.println("You dont have a card");
        }

    }
}
