```java
// Helper definition for supported operators
    private final Map<String, Integer> OPERATORS = new HashMap<>(); {
        // Map<"token", precedence>
        OPERATORS.put("*", 3);
        OPERATORS.put("/", 3);
        OPERATORS.put("%", 3);
        OPERATORS.put("+", 4);
        OPERATORS.put("-", 4);
        OPERATORS.put("^", 2); // assignment (for credit)
        OPERATORS.put("SQRT", 1); 
    }

    // Helper definition for supported operators
    private final Map<String, Integer> SEPARATORS = new HashMap<>(); {
        // Map<"separator", not_used>
        SEPARATORS.put(" ", 0);
        SEPARATORS.put("(", 0);
        SEPARATORS.put(")", 0);
    }
```
This code is for the operators and functions

```Java
 // Test Functions
    // Test if token is an operator
    private boolean isOperator(String token) {
        // find the token in the hash map
        return OPERATORS.containsKey(token);
    }

    // Test if token is an separator
    private boolean isSeperator(String token) {
        // find the token in the hash map
        return SEPARATORS.containsKey(token);
    }

    // Compare precedence of operators.
    private Boolean isPrecedent(String token1, String token2) {
        // token 1 is precedent if it is greater than token 2
        return (OPERATORS.get(token1) - OPERATORS.get(token2) >= 0) ;
    }

    // Create a 1 argument constructor expecting a mathematical expression
    public Calculator(String expression) {
        // original input
        input = expression;

        // parse expression into terms
        this.termTokenizer();

        // place terms into reverse polish notation
        this.tokensToReversePolishNotation();

        // calculate reverse polish notation
        this.rpnToResult();
    }


```
This is where the tokens are checked to see whether they are operators or not

```java
// Takes tokens and converts to Reverse Polish Notation (RPN), this is one where the operator follows its operands.
    private void tokensToReversePolishNotation () {
        // contains final list of tokens in RPN
        this.rpn = new ArrayList<>();

        // stack is used to reorder for appropriate grouping and precedence

        Stack tokenStack = new Stack();
        for (String token : tokenList) {
            switch (token) {
                // If left bracket push token on to stack
                case "(":
                    tokenStack.push(token);
                    break;
                case ")":
                    while (tokenStack.peek() != null && !tokenStack.peek().equals("("))
                    {
                        rpn.add( (String)tokenStack.pop() );
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
                    while (tokenStack.peek() != null && tokenStack.size() > 0 && isOperator((String) tokenStack.peek()))
                    {
                        if ( isPrecedent(token, (String) tokenStack.peek() )) {
                            rpn.add((String)tokenStack.pop());
                            continue;
                        }
                        break;
                    }
                    // Push the new operator on the stack
                    tokenStack.push(token);
                    break;
                default:    // Default should be a number, there could be test here
                    this.rpn.add(token);
            }
        }
        // Empty remaining tokens
        while ( tokenStack.size() > 0 && tokenStack.peek() != null) {
            rpn.add((String)tokenStack.pop());
        }

    }

```
The tokens are then taken and converted using Reverse Polish Notation

```Java

    // Print the expression, terms, and result
    public String toString() {
        return ("Original expression: " + this.input + "\n" +
                "Tokenized expression: " + this.tokenList.toString() + "\n" +
                "Reverse Polish Notation: " +this.rpn.toString() + "\n" +
                "Final result: " + String.format("%.2f", this.output));
    }


}

```
Here is where the code is run, using all the different functions
