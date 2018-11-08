/*
Lab: Working with dynamic arrays.

Name: Kitty Chou (周洋如)
*/

import java.util.*;

@SuppressWarnings("unchecked")
public class DynamicArray <AnyType> implements DynamicArrayInterface <AnyType>
{
	private AnyType[] A;

	public DynamicArray(int n)
	{
		A = (AnyType[]) new Object[n];
		// construct A and initialize with int n.
	}

	public int getSize()
	{
		return A.length;
		// use A.length to return the size of this array.
	}
	
	public void set(AnyType e, int pos) 
	{
		A[pos] = e;
		// note about the range of int pos to avoid ArrayIndexOutOfBoundsException.
	}
	
	public AnyType get(int pos)
	{
		return A[pos];
	}
	
	public String toString()
	{
		String rep = "{";
		// create left bracket for the string.
		for (int i = 0; i < A.length; i++)
		{
			rep = rep + A[i] +",";
	    }
		return rep + "}";
		// add right bracket for the string.
	}
	
	public void append(AnyType e)
	{
		// copy array A and add AnyType e at the end of the new array.
		AnyType[] B = (AnyType[]) new Object[A.length + 1];
		// copy A to B, start from A[0] and B[0].
	    System.arraycopy(A, 0, B, 0, A.length);
	    B[B.length - 1] = e;
	    // Notice: The index of the end element in one array is (length - 1)!
	    // modify the original array.
	    A = B;
	}
	
	public void insert(AnyType e, int pos)
	{
		// copy the (pos) part of array A.
		// set B[pos] = e.
		// copy the remanent part to the new array.
		AnyType[] B = (AnyType[]) new Object[A.length + 1];
		// copy A to B, start from A[0] and B[0] to B[pos - 1].
	    System.arraycopy(A, 0, B, 0, pos - 1);
	    B[pos] = e;
	    // copy A to B, start from A[pos] and B[pos + 1] to the end of the array.
	    System.arraycopy(A, pos, B, pos + 1, B.length - pos);
	    // modify the original array.
	    A = B;
	}
	
	public boolean contains(AnyType e)
	// I think here should be (AnyType e), but the homework file you sent us is (int e)
	// that will caused error since A[i] is AnyType not int.
	{
		boolean doesContain = false;
		// use for loop to compare the value of elements in A with e.
		for (int i = 0; i < A.length; i++)
			if (A[i] == e){
				//if there is one value equal e, just break to jump out the loop.
				doesContain = true;
				break;
			}
		return doesContain;
	}
	
	public void removeAt(int pos)
	{
		// copy the (pos) part of array A.
		// jump over the A[pos], copy the remanent part to the new array.
		AnyType[] B = (AnyType[]) new Object[A.length - 1];
		// copy A to B, start from A[0] and B[0] to B[pos].
	    System.arraycopy(A, 0, B, 0, pos);
	    // copy A to B, start from A[pos + 1] and B[pos] to the end of the array.
	    System.arraycopy(A, pos + 1, B, pos, B.length - pos);
	    A = B;
	}
	
	public void removedups()
	{
		// if array is empty or contains a single element, jump over the next step.
		if (A.length == 0 || A.length == 1) 
            System.out.println("There are no duplicates in the array");
		int j = 0;
		// create empty DynamicArray B to increment .contains to determine the duplicates.
		DynamicArray<AnyType> B = new DynamicArray<AnyType>(j);
		// add ont element A[0] to the empty B to initialize B.
		// for DynamicArray type just increment the Interface we have defined.
		B.append(A[0]);
        for (int i = 0; i < A.length; i++) 
            // judge whether B contains element A[i], if no, add new value A[i] to B.
        	if (!B.contains(A[i])) {
        		B.append(A[i]); 
        		j++;
            }
        // modify the original array.
		A = B.A;
	}
	
	public boolean equals(Object[] e)
	// I think here should be (Object[] e), but the homework file you sent us is (AnyType e).
	// otherwise we can not compare two arrays.
	{
		boolean equal = false;
		// use Arrays.equals to compare all the elements in array.
		equal = Arrays.equals(A, e); 
		return equal;
	}
	
	public Iterator<AnyType> iterator() 
	{
	    return (Iterator<AnyType>) new Itr();
	}

	private class Itr implements Iterator<AnyType> {
		// index of next element to return
		int index = 0;       
	    public boolean hasNext() {
	    	// if index doesn't reach the end of A, return.
	        return index != A.length;
	    }

	    public AnyType next() {
	    	return A[index++];
	    }
	}
	    

      // implement all the methods from the DynamicArrayInterface
}
	

