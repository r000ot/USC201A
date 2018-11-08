/*
                      DO NOT CHANGE THIS FILE

*/

import java.util.*;

public interface  DynamicArrayInterface <AnyType>
{

	// Returns the size of this array.
	public int getSize();

	// Replaces the element at the index pos with the specified element e.
	public void set(AnyType e, int pos);

	// Returns the element at the index pos
	public AnyType get(int pos);

	// Returns the string representation of this array.
	// The string starts with { and ends with },
	// and have objects separated by comma
	public String toString();

	// Appends the specified element to the end of this array.
	public void append(AnyType e);


	// Inserts the specified element at the index pos.
	public void insert(AnyType e, int pos);


	// Searches the array for a specified object.
	// It returns true if the array contains the specified element.
	public boolean contains(AnyType e);

	// Removes the element at the index pos and shifts all elements on its right
	// one position to the left.
	public void removeAt(int pos);

	//This method deletes duplicates from this array. Make sure you resize the array.
	public void removedups();


	//Tests whether this list is equal to another object.
	public boolean equals(Object[] e);

	//Returns an Iterator over this list.
	//You DO NOT need to implement remove() method
	public Iterator<AnyType> iterator();
}

