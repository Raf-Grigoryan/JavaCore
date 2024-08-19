package homework.homework7;

public class BraceChecker {
    private Stack closedBrackets = new Stack();
    private Stack openedBrackets = new Stack();
    private String text;

    public BraceChecker(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void check() {
        int openedBracketIndex = -1;
        int closedBracketIndex = -1;
        char openedBracket = ' ';
        char closedBracket = ' ';
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case '(', '[', '{' -> {
                    if (openedBrackets.isEmpty()) {
                        openedBracketIndex = i;
                        openedBrackets.push(text.charAt(i));
                    } else {
                        openedBracket = text.charAt(i);
                        System.out.println("Error: opened " + openedBracketIndex + " index " + openedBrackets.pop() + " but not closed ");
                        openedBrackets.push(openedBracket);
                        openedBracketIndex = i;
                    }
                }
                case ')', ']', '}' -> {
                    closedBracket = text.charAt(i);
                    closedBrackets.push(text.charAt(i));
                    closedBracketIndex = i;
                    if (openedBrackets.isEmpty()) {
                        System.out.println("Error: closed " + closedBracketIndex + " index " + closedBracket + " but not opened");
                    } else {
                        openedBracket = openedBrackets.pop();
                        closedBracket = closedBrackets.pop();
                        closedBracketIndex = i;
                        if (isMatchingPair(openedBracket, closedBracket)) {
                            System.out.println("Opened:" + openedBracket + " index" + openedBracketIndex + " and closed " + closedBracketIndex + " " + closedBracket);
                        } else {
                            System.out.println("Error: " + openedBracket + " index " + openedBracketIndex + " but closed " + closedBracketIndex + " " + closedBracket);
                        }
                    }
                }
            }
        }
        if (!openedBrackets.isEmpty()) {
            openedBracket = openedBrackets.pop();
            System.out.println("Error: opened " + openedBracketIndex + " index " + openedBracket + " but not closed");
        }
    }

    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}');
    }
}

