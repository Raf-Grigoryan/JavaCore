package homework.homework8;

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
                        stack.push(new Brace(currentChar, i));
                    }
                    case ')', ']', '}' -> {
                        if (stack.isEmpty()) {
                            System.out.println("Error: Closing bracket '" + currentChar + "' at index " + i + " has no matching opening bracket.");
                        } else {
                            Brace openedBrace = stack.pop();
                            if (!isMatchingPair(openedBrace.getBrace(), currentChar)) {
                                System.out.println("Error: Opening bracket '" + openedBrace.getBrace() + "' at index " + openedBrace.getIndex() + " does not match closing bracket '" + currentChar + "' at index " + i);
                            }
                        }
                    }
                }
            }

            while (!stack.isEmpty()) {
                Brace unclosedBrace = stack.pop();
                System.out.println("Error: Opening bracket '" + unclosedBrace.getBrace() + "' at index " + unclosedBrace.getIndex() + " has no matching closing bracket.");
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
