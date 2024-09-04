package book.chapter9.test5;

public class AskMe implements SharedConstants {
    static void answer(int result) {
        switch (result) {
            case NO -> System.out.println("No");
            case YES -> System.out.println("YES");
            case MAYBE -> System.out.println("MAYBE");
            case LATER -> System.out.println("LATER");
            case SOON -> System.out.println("SOON");
            case NEVER -> System.out.println("NEVER");
        }
    }

    public static void main(String[] args) {
        Question question = new Question();
        answer(question.ask());
        answer(question.ask());
        answer(question.ask());
        answer(question.ask());
    }
}
