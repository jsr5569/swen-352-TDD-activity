package edu.rit.swen352.tdd;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

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

    @SafeVarargs
    public MyList(T... elements) {
        try
        {
            Object[] filteredElements = Arrays.stream(elements).filter(Objects::nonNull).toArray();
            list = (T[]) new Object[filteredElements.length];
            System.arraycopy(elements, 0, list, 0, filteredElements.length);
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Returns the size of the MyList
     * @return size
     */
    public int size()
    {
        return list.length;
    }

    /**
     * Adds an element to the MyList, doing nothing if a duplicate element
     * @param element The element to add
     * @return The updated MyList
     */
    public MyList<T> add(T element)
    {
        if(Arrays.asList(this.list).contains(element))
        {
            return this;
        }
        if(element == null)
        {
            return this;
        }
        T[] newList = (T[]) new Object[list.length + 1];
        System.arraycopy(list, 0, newList, 0, list.length);
        newList[list.length] = element;
        return new MyList<T>(newList);
    }

    /**
     * Removes an element by reference
     * @param element the element to remove
     * @return The updated MyList
     */
    public MyList<T> remove(T element)
    {
        if(!Arrays.asList(this.list).contains(element))
        {
            throw new NoSuchElementException("Nonexistent Element!");
        }
        T[] newList = (T[]) Arrays.stream(this.list).filter(e -> !e.equals(element)).toArray();
        return new MyList<>(newList);
    }

    /**
     * Gets an element by index
     * @param index The index of the element
     * @return The element
     */
    public T get(int index)
    {
        if(index < 0 || index >= list.length)
        {
            throw new NoSuchElementException("Index out of bounds!");
        }
        return this.list[index];
    }

    /**
     * Checks if the MyList is empty
     * @return true if empty; false otherwise
     */
    public boolean isEmpty()
    {
        return this.list.length == 0;
    }

    /**
     * Iterates the MyList and performs the consumer action on each element
     * @param action The consumer function
     */
    public void forEach(Consumer<? super T> action)
    {
        for(T element : list)
        {
            action.accept(element);
        }
    }
}
