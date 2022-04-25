|[Study](../Study)| [Tickets](../Tickets) | [TechTalks](.)| [Solutions](../Solutions)| [TPT](../TPT)|[SolutionNotes](../SolutionNotes)|

# Tech Talk notes
**- Tech Talk 0:**

- **Overarching concept/notes**: Data Structures:
  A data structure is a method of organizing data. Think of a variable holding a single integer value(ex: int n=4;) or sequences of numbers(ex: int[] numbers=new int[]{ 1,2,3 };) or tables of data, or databases: these are all well-defined data structures. Data Structures and organizing data will require students to become more algorithmic in coding.
  There are many algorithms for different purposes and they interact with different data structures. Think of algorithms as dynamic underlying pieces that interact with data structures. Together, data structures and algorithms combine and allow programmers to build whatever computer programs they’d like. Well managed data structures and algorithms ensures well-optimized and efficient code.


- **Questions**: No questions this week


**- Tech Talk 1:**

- **Overarching concept/notes**:
- **Linked List:**
    - Linked list are a way of keeping and managing a list of Objects
    - ABCD have Data and Next pointer
    - E is illustrative of inserting a new Object
    - tmp illustrates accessing the Data from the D Object
    - code example:
```java
class LinkedList {
    Node head; // head of list
 
    /* Linked list Node*/
    class Node {
        int data;
        Node next;
 
        // Constructor to create a new node
        // Next is by default initialized
        // as null
        Node(int d) { data = d; }
    }
}
```


**- Queues**:

- Queues can be built using Linked List Objects

- A Queue requires keeping track of First In for dequeue extraction (head node)

- A Queue requires keeping track of the Back for enqueue entry (tail node)

- A Queue requires keeping track of the Current node for iteration (current node)
- code:
```java
 Queue<Integer> numbers = new LinkedList<>();

    // enqueue
    // insert element at the rear of the queue
    numbers.offer(1);
    numbers.offer(2);
    numbers.offer(3);
    System.out.println("Queue: " + numbers);
```    


- ** java generic t:**
- A generic type is a generic class or interface that is parameterized over types.” Essentially, generic types allow you to write a general, generic class (or method) that works with different types, allowing for code re-use
- code:
```java
public static <T, G> List<G> fromArrayToList(T[] a, Function<T, G> mapperFunction) {
    return Arrays.stream(a)
      .map(mapperFunction)
      .collect(Collectors.toList());
}
```
- **Questions**: No questions this week


**- Tech Talk 2:**

- **Overarching concept/notes**:
- Calculator Theory
  In mathematics, an expression or mathematical expression is a finite combination of symbols that is well-formed according to rules that depend on the context.
  In computers, expression can be hard to calculate with precedence rules.
- In computer math we often convert strings into Reverse Polish Notation (RPN, 3 + 4 becomes 3 4 +) using the Shunting-yard algorithm. Review Wikipedia diagram and the code and you will see the need for a Stack.
- How to define operator:
```java
 // Helper definition for supported operators
    private final Map<String, Integer> OPERATORS = new HashMap<>();
    {
        // Map<"token", precedence>
        OPERATORS.put("*", 3);
        OPERATORS.put("/", 3);
        OPERATORS.put("%", 3);
        OPERATORS.put("+", 4);
        OPERATORS.put("-", 4);
    }
```
- Sample output:
```java
Simple Math
Original expression: 100 + 200  * 3
Tokenized expression: [100, +, 200, *, 3]
Reverse Polish Notation: [100, 200, 3, *, +]
Final result: 700.00

```

- **Questions**: Can we use sqrt function from java? Or do we need to come up with something else.


**- Tech Talk 4:**

- **Overarching concept/notes**:


- **Questions**:


**- Tech Talk 5:**

- **Overarching concept/notes**:


- **Questions**:


**- Tech Talk 6:**

- **Overarching concept/notes**:



- **Questions**:


**- Tech Talk 7:**

- **Overarching concept/notes**:


- **Questions**:


**- Tech Talk 8:**

- **Overarching concept/notes**:


- **Questions**:


**- Tech Talk 9:**

- **Overarching concept/notes**:


- **Questions**:



**- Tech Talk 10:**
- **Overarching concept/notes**:


- **Questions**:
