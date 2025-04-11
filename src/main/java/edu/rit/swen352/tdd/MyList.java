package edu.rit.swen352.tdd;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * MyList is a flexible-sized sequence of elements with no gaps.
 *
 * <p>
 * You must implement these features:
 * <ul>
 *   <li>constructor: with varargs of initial elements</li>
 *   <li>add: add an element to the list; no-op if the element is already in the list (by reference)</li>
 *   <li>remove: remove an element by reference</li>
 *   <li>get: returns the element at a specific index;
 *     throw {@link java.util.NoSuchElementException} if the index is outside the size of the list</li>
 *   <li>isEmpty: queries if the list is empty</li>
 *   <li>size: queries how many elements in the list</li>
 *   <li>forEach: iterates over each element and executes the {@link java.util.function.Consumer} parameter</li>
 * </ul>
 *
 * @param <T> the type of elements in the list.
 */
public class MyList<T> {

    private T[] list;

    public MyList(T... elements) {
        try
        {
            list = (T[]) new Object[elements.length];
            System.arraycopy(elements, 0, list, 0, elements.length);
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

    public int size()
    {
        return list.length;
    }

    public MyList<T> add(T element)
    {
        if(Arrays.asList(this.list).contains(element))
        {
            return this;
        }
        T[] newList = (T[]) new Object[list.length + 1];
        System.arraycopy(list, 0, newList, 0, list.length);
        newList[list.length] = element;
        return new MyList<T>(newList);
    }

    public MyList<T> remove(T element)
    {
        if(!Arrays.asList(this.list).contains(element))
        {
            throw new NoSuchElementException("Nonexistent Element!");
        }
        T[] newList = (T[]) Arrays.stream(this.list).filter(e -> !e.equals(element)).toArray();
        return new MyList<>(newList);
    }

    public T get(int index)
    {
        return this.list[index];
    }
}
