package book.chapter5;

public class Break {
    public static void main(String[] args) {
        boolean t = true;
        first:
        {
            second:
            {
                third:
                {
                    System.out.println("Предшествует олератору break");
                    if (t) {
                        break second;
                    }
                    System.out.println("Этот оператор не будет выполняться");
                }
                System.out.println("Этот оператор  будет выполняться");
            }
            System.out.println("Этот оператор  будет выполняться");
        }
    }
}
