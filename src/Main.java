import java.util.Stack;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.lang.Math;

public class Calculator {

    private ArrayList<String> reverse_polish;
    private String expression;
    private ArrayList<String> tokens;
    private Double result;

    public Calculator(String expression) {
        System.out.println("You have opened the calculator");
        // When the calculator is opened, this is the original input
        this.expression = expression;
        //System.out.println("Original expression: " + this.expression);

        // turn expression into terms
        this.termTokenizer();
        // System.out.println("Tokenized expression: " + this.tokens.toString());

        // Take terms and covert into reverse polish notation
        this.TermsToPolishNotation();
        //System.out.println("Reverse Polish Notation: " +this.reverse_polish.toString());

        //System.out.println(this.toString());
        // Calculate the reverse polish notation
        this.polishNotationResult();
    }

    private final Map<String, Integer> OPERATORS = new HashMap<>();
    {
        // Map<"token", precedence>
        OPERATORS.put("*", 3);
        OPERATORS.put("/", 3);
        OPERATORS.put("%", 3);
        OPERATORS.put("+", 4);
        OPERATORS.put("-", 4);
        OPERATORS.put("^", 2);
        OPERATORS.put("SQRT", 2);
    }

    private final Map<String, Integer> NUMOPERANDS = new HashMap<>();
    {
        // Map<"token", precedence>
        NUMOPERANDS.put("*", 2);
        NUMOPERANDS.put("/", 2);
        NUMOPERANDS.put("%", 2);
        NUMOPERANDS.put("+", 2);
        NUMOPERANDS.put("-", 2);
        NUMOPERANDS.put("^", 2);
        NUMOPERANDS.put("SQRT", 1);
    }


    private final Map<String, Integer> SEPARATORS = new HashMap<>();
    {
        // Map<"separator", not_used>
        SEPARATORS.put(" ", 0);
        SEPARATORS.put("(", 0);
        SEPARATORS.put(")", 0);
    }

    // Test to see whether token is an operator
    private boolean isOperator(String token) {
        // find the token in the hash map
        return OPERATORS.containsKey(token);
    }

    // Test to see whether token is a separator
    private boolean isSeperator(String token) {
        // find the token in the hash map
        return SEPARATORS.containsKey(token);
    }

    // Comparing the operators.
    private Boolean isPrecedent(String token1, String token2) {
        // token 1 is precedent if it is greater than token 2

        return (OPERATORS.get(token1) - OPERATORS.get(token2) >= 0) ;
    }

    private void TermsToPolishNotation () {
        // contains final list of tokens in RPN
        this.reverse_polish = new ArrayList<String>();

        // stack is used to reorder for appropriate grouping and precedence
        Stack<String> tokenStack = new Stack<String>();

        for (String token : tokens) {
            //System.out.println("token = " + token);
            switch (token) {
                // If left bracket push token on to stack
                case "(":
                    tokenStack.push(token);
                    break;
                case ")":
                    while (tokenStack.peek() != null && !tokenStack.peek().equals("("))
                    {
                        reverse_polish.add( (String)tokenStack.pop() );
                    }
                    tokenStack.pop();
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                case "%":
                case "^":
                case "SQRT":
                    // While stack
                    // not empty AND stack top element
                    // and is an operator
                    //System.out.println("is operator");
                    while (tokenStack.size() > 0 && tokenStack.peek() != null && isOperator((String) tokenStack.peek()))
                    {
                        //System.out.println("entry while " + token + " peek " + (String) tokenStack.peek());
                        if ( isPrecedent(token, (String) tokenStack.peek() )) {
                            reverse_polish.add((String)tokenStack.pop());
                            //System.out.println("c: " + this.reverse_polish.toString());
                            continue;
                        }
                        break;
                    }
                    // Push the new operator on the stack
                    //System.out.println("break while");
                    tokenStack.push(token);
                    //System.out.println("a: " + tokenStack.toString());
                    break;
                default:    // Default should be a number, there could be test here
                    this.reverse_polish.add(token);
                    //System.out.println("b: " + this.reverse_polish.toString());
            }
        }
        // Empty remaining tokens
        while (tokenStack.size() > 0 && tokenStack.peek() != null) {
            this.reverse_polish.add((String)tokenStack.pop());
        }

    } //tokensToReversePolishNotation

    private void termTokenizer() {
        // contains final list of tokens
        this.tokens = new ArrayList<>();

        int start = 0;  // term split starting index
        StringBuilder multiCharTerm = new StringBuilder();    // term holder
        for (int i = 0; i < this.expression.length(); i++) {
            Character c = this.expression.charAt(i);
            if ( isOperator(c.toString() ) || isSeperator(c.toString())  ) {
                // 1st check for working term and add if it exists
                if (multiCharTerm.length() > 0) {
                    tokens.add(this.expression.substring(start, i));
                }
                // Add operator or parenthesis term to list
                if (c != ' ') {
                    tokens.add(c.toString());
                }
                // Get ready for next term
                start = i + 1;
                multiCharTerm = new StringBuilder();
            } else {
                // multi character terms: numbers, functions, perhaps non-supported elements
                // Add next character to working term
                multiCharTerm.append(c);
            }

        }
        // Add last term
        if (multiCharTerm.length() > 0) {
            tokens.add(this.expression.substring(start));
        }
    } //termTokenizer


    private void rpnToResult(){
        Stack<Double> calculation = new Stack<Double>();
        Double a = new Double(0), b = new Double(0);

        for (int i=0; i<reverse_polish.size(); i++)  {
            if (!OPERATORS.containsKey(reverse_polish.get(i))) {
                calculation.push(Double.parseDouble(reverse_polish.get(i)));
            } //is number
            else {
                if (NUMOPERANDS.get(reverse_polish.get(i)) == 1) {
                    a = (calculation.pop());
                } else {
                    //assume 2 operands otherwise
                    a = (calculation.pop());
                    b = (calculation.pop());
                }

                switch(reverse_polish.get(i)) {
                    case "+":
                        calculation.push((a + b));
                        break;
                    case "-":
                        calculation.push((b - a));
                        break;
                    case "*":
                        calculation.push((a * b));
                        break;
                    case "/":
                        calculation.push((b / a));
                        break;
                    case "%":
                        calculation.push((b % a));
                        break;
                    case "^":
                        calculation.push((Math.pow(b, a)));
                        break;
                    case "SQRT":
                        calculation.push((Math.sqrt(a)));
                        break;
                }//switch

            } //is operand

        } //for

        this.result = calculation.pop();
    }

    public String toString() {
        return ("Original expression: " + this.expression + "\n" +
                "Tokenized expression: " + this.tokens.toString() + "\n" +
                "Reverse Polish Notation: " +this.reverse_polish.toString() + "\n" +
                "Final result: " + String.format("%.2f", this.result));
    }

}