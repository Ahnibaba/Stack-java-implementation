/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.stack;

/**
 *
 * @author Ani
 */

import java.util.Scanner;

// Static Stack implementation with a fixed size array
public class Stack {
    private static final int MAXSIZE = 8;
    private int[] stack = new int[MAXSIZE];
    private int top = -1;

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is full
    public boolean isFull() {
        return top == MAXSIZE - 1;
    }

    // Peek at the top item of the stack
    public int peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack is empty.");
            return -1; // return an invalid value to signify an error
        }
    }

    // Pop item from the stack
    public int pop() {
        if (!isEmpty()) {
            int data = stack[top];
            top--;
            return data;
        } else {
            System.out.println("Could not retrieve data, Stack is empty.");
            return -1; // return an invalid value to signify an error
        }
    }

    // Push item onto the stack
    public void push(int data) {
        if (!isFull()) {
            top++;
            stack[top] = data;
        } else {
            System.out.println("Could not insert data, Stack is full.");
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        // Push items onto the stack
        stack.push(3);
        stack.push(5);
        stack.push(9);
        stack.push(1);
        stack.push(12);
        stack.push(15);

        // Peek at the top item
        System.out.println("Element at top of the stack: " + stack.peek());

        // Print stack elements by popping them
        System.out.println("Elements:");
        while (!stack.isEmpty()) {
            int data = stack.pop();
            System.out.println(data);
        }

        // Check if stack is full or empty
        System.out.println("Stack full: " + (stack.isFull() ? "true" : "false"));
        System.out.println("Stack empty: " + (stack.isEmpty() ? "true" : "false"));

        // Dynamic stack demonstration
        DynamicStack dynamicStack = new DynamicStack();

        // Push and pop elements on dynamic stack
        dynamicStack.push();
        dynamicStack.push();
        dynamicStack.pop();
    }
}

// Dynamic Stack implementation using Linked Nodes
class Node {
    float number;
    Node link;

    // Constructor for initializing a node
    public Node(float number) {
        this.number = number;
        this.link = null;
    }
}

class DynamicStack {
    private Node top;

    // Constructor to initialize the stack with top as null
    public DynamicStack() {
        top = null;
    }

    // Method to push an element onto the stack
    public void push() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number to be inserted: ");
        float number = scanner.nextFloat();

        // Create a new node and check if memory is available
        Node temp = new Node(number);
        if (temp == null) {
            System.out.println("No memory to create the node...");
            System.exit(1);
        }

        // Link the new node to the top of the stack
        temp.link = top;
        top = temp;
    }

    // Method to pop an element from the stack
    public void pop() {
        if (top == null) {
            System.out.println("Stack is empty, cannot pop.");
            return;
        }

        // Remove the top element
        System.out.println("Popped element: " + top.number);
        top = top.link;
    }

    
}
