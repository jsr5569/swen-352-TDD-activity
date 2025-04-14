package edu.rit.swen352.tdd;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * MyStack is a fixed-size, LIFO (last-in-first-out) stack.
 * @see <a href="https://en.wikipedia.org/wiki/Stack_(abstract_data_type)">Stack ADT</a>
 *
 * <p>
 * You must implement these features:
 * <ul>
 *   <li>constructor: with and without the capacity (defaults to 16)</li>
 *   <li>push: add an element to the stack; throw {@link IllegalStateException} if the stack is full</li>
 *   <li>pop: remove and return the top element of the stack; throw {@link NoSuchElementException} if the stack is empty</li>
 *   <li>isEmpty: queries if the stack is empty</li>
 *   <li>size: queries how many elements in the stack</li>
 * </ul>
 *
 * @param <T> the type of elements in the stack.
 */
public class MyStack<T> {
    int capacity;
    int top;
    Object[] array;

    public MyStack() {
        this.capacity = 16;
        this.array = new Object[this.capacity];
        this.top = 0;
    }

    public MyStack(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
        this.top = 0;
    }

    public void push(T element) throws IllegalStateException {
        if (top == this.capacity) {
            throw new IllegalStateException("Stack is filled.");
        }
        this.array[top++] = element;
    }

    public T pop() throws NoSuchElementException {
        if (top == 0) {
            throw new NoSuchElementException("Stack is empty.");
        }
        top--;
        T value = (T) this.array[top];
        array[top] = null;
        return value;
    }

    public boolean isEmpty() {
        return false;
    }
}
