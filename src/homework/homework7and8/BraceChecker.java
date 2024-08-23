package homework.homework7and8;

public class BraceChecker {
    private Stack stack = new Stack();
    private String text;



    public String getText() {
        return text;
    }

    public void check() {
        if (text != null) {
            for (int i = 0; i < text.length(); i++) {
                char currentChar = text.charAt(i);
                switch (currentChar) {
                    case '(', '[', '{' -> {
                        stack.push(currentChar);
                    }
                    case ')', ']', '}' -> {
                        if (stack.isEmpty()) {
                            System.out.println("Error: Closing bracket '" + currentChar + "' at index " + i + " has no matching opening bracket.");
                        } else {
                            char openedSymbol = stack.pop();
                            if (!isMatchingPair(openedSymbol, currentChar)) {
                                System.out.println("Error: Opening bracket '" + openedSymbol + "' does not match closing bracket '" + currentChar + "' at index " + i);
                            }
                        }
                    }
                }
            }

            while (!stack.isEmpty()) {
                System.out.println("Error: Opening bracket '" + stack.pop() + "' at index " + (stack.getTopIndex() + 1) + " has no matching closing bracket");
            }
        }

    }

    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}');
    }

    public void setText(String text) {
        this.text = text;
    }
}
