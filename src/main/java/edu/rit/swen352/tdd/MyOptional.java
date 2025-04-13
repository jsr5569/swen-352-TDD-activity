package edu.rit.swen352.tdd;

/**
 * MyOptional contains a single element or nothing at all.
 *
 * <p>
 * You must implement these features:
 * <ul>
 *   <li>factories:
 *     <ul>
 *       <li>{@code empty()} -- return an empty optional</li>
 *       <li>{@code of(element:T)} -- return a non-empty optional; throws NPE if {@code element} is {@code null}</li>
 *       <li>{@code ofNullable(element:T)} -- return an optional that might be empty</li>
 *       <li>NFR: hide any constructor(s); forces clients to use a factory function</li>
 *     </ul>
 *   </li>
 *   <li>isPresent: queries if the optional is not empty</li>
 *   <li>get: returns the element; throws {@link java.util.NoSuchElementException} if empty</li>
 *   <li>map: creates a new optional where the element is transformed by a {@link java.util.function.Function}</li>
 *   <li>ifPresent: executes a {@link java.util.function.Consumer} if an element is present</li>
 *   <li>NFR: there must only be a single instance of the empty optional</li>
 * </ul>
 *
 * @param <T> the type of element.
 */
public class MyOptional<T> {
    private static final MyOptional<?> EMPTY = new MyOptional<>(null);
    private final T value;

    // Private constructor to enforce factory use
    private MyOptional(T value) {
        this.value = value;
    }

    public static <T> MyOptional<T> empty() {
        return (MyOptional<T>) EMPTY;
    }

    public static <T> MyOptional<T> of(T element) throws NullPointerException{
        if(element != null){
            return new MyOptional<>(element);
        }
        else{
            throw new NullPointerException("Element must not be null");
        }
    }

    public static <T> MyOptional<T> ofNullable(T element){
        return null;
    }
}
