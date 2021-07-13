package TimeComplexity;

import DTO.TransferObject;
import Function.SplayTree;

import java.util.Random;

public class CalculateTimeComplexity {
    SplayTree spt = new SplayTree();
    long insertSplayProcessTimeComplexity = 0;

    public TransferObject calcInsertTimeComplextiyForSplayingInGivenSize(int size) {
        int low = 1;
        int high = size;
        long startTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            Random r = new Random();
            int result = r.nextInt(high - low) + low;
            insertSplayProcessTimeComplexity = insertSplayProcessTimeComplexity + spt.insert(result);
        }
        long endTime = System.nanoTime();
        System.out.println("Splay Process Time Complexity For Splay Tree in Size:" +
                size + " = " + insertSplayProcessTimeComplexity);
        return new TransferObject(endTime - startTime, spt);
    }

    public TransferObject calcSearchTimeComplextiyForSplayingInGivenSize(int number,
                                                                         SplayTree splayTree) {
        long startTime = System.nanoTime();
        boolean result = splayTree.search(number);
        long endTime = System.nanoTime();
        System.out.println("Result = " + (result));
        return new TransferObject(endTime - startTime, splayTree);
    }

    public TransferObject calcRemoveTimeComplextiyForSplayingInGivenSize(int number,
                                                                         SplayTree splayTree) {
        long startTime = System.nanoTime();
         splayTree.remove(number);
        long endTime = System.nanoTime();
        return new TransferObject(endTime - startTime, splayTree);
    }
}
