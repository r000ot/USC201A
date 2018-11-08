/*
                      DO NOT CHANGE THIS FILE

Name:
*/

import java.util.*;

public class MainDriver
{
    public static void main(String[] args)
    {
        int size = 10;

        DynamicArray<Integer> list1 = new DynamicArray<Integer>(size);
        DynamicArray<Integer> list2 = new DynamicArray<Integer>(size);
        Random generator = new Random();

        System.out.println("Generating two lists of random integers");
        for(int i = 0; i < size; i++)
        {
            list1.set(generator.nextInt(5), i);
            list2.set(generator.nextInt(5), i);
        }

        System.out.println(list1);
        System.out.println(list2);
        System.out.println();

        // TESTING getSize
        System.out.println("Testing getSize ...");
        if (size != list1.getSize() || size != list2.getSize())
            System.out.println("ERROR: Size of arrays is reported incorrectly");


        // TESTING append
        System.out.println("\nAppending value -2 to list1");
        list1.append(-2);
        if (size + 1 != list1.getSize()) {
            System.out.println("ERROR: Size of array did not increase by one");
        }
        System.out.println();
        System.out.println(list1);
        System.out.println(list2);
        System.out.println();

        // TESTING get
        System.out.println("Testing get ... ");
        list1.set(-1, 0);
        list1.set(-2, list1.getSize()-1);

        if (list1.get(0) != -1) {
            System.out.println("ERROR: Error with get at beginning index");
        } else if (list1.get(list1.getSize()-1) != -2) {
            System.out.println("ERROR: Error with get at ending index");
        }

        // TESTING contains
        System.out.println("\nTesting contains ... ");
        if (list1.contains(-1)) {
            if (list1.contains(-2)) {
                if (!list1.contains(-3)) {
                    System.out.println("contains is ok");
                } else {
                    System.out.println("ERROR: contains found value -3 ");
                }
            } else {
                System.out.println("ERROR: contains failed to find ending value -2");
            }
        } else {
            System.out.println("ERROR: contains failed to find beginning value");
        }

        // TESTING removeAt
        System.out.println("\nTesting removeAt ... ");
        System.out.println("Removing element at index 0");
        int temp = list1.get(0);
        int tempSize = list1.getSize();
        list1.removeAt(0);
        System.out.println(list1);
        if (temp != list1.get(0) && tempSize - 1 != list1.getSize()) {
            System.out.println("ERROR: Error removing at first position");
        }
        System.out.println("Removing the last element");
        temp = list1.get(list1.getSize()-1);
        tempSize = list1.getSize();
        list1.removeAt(list1.getSize()-1);
        System.out.println(list1);
        if (temp != list1.get(list1.getSize()-1) && tempSize - 1 != list1.getSize()) {
            System.out.println("ERROR: Error removing the last element");
        }

        // TESTING removeDups
        System.out.println("\nTesting removedups in list1 ...");
        list1.removedups();
        System.out.println(list1);
        System.out.println();

        // TESTING iterator
        System.out.println("\nIterating through list1 ...");
		Iterator<Integer> itr = list1.iterator();
		while (itr.hasNext()) System.out.print(itr.next() + ",");
		System.out.println();

    }
}
