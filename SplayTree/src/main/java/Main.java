import DTO.TransferObject;
import Function.SplayTree;
import TimeComplexity.CalculateTimeComplexity;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /** Creating object of SplayTree **/
        SplayTree spt = new SplayTree();
        CalculateTimeComplexity timeComplexity = new CalculateTimeComplexity();
        System.out.println("Splay Tree Test\n");
        char ch;
        /**  Perform tree operations  **/
        do {
            System.out.println("\nSplay Tree Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. remove ");
            System.out.println("3. search");
            System.out.println("4. count nodes");
            System.out.println("5. check empty");
            System.out.println("6. clear tree");
            System.out.println("7. Calc Insret and Splay Process Time Complexity");
            System.out.println("8. Calc Search Time Complexity");
            System.out.println("9. Calc Remove Time Complexity");

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter integer element to insert");
                    spt.insert(scan.nextInt());
                    break;
                case 2:
                    System.out.println("Enter integer element to remove");
                    spt.remove(scan.nextInt());
                    break;
                case 3:
                    System.out.println("Enter integer element to search");
                    System.out.println("Search result : " + spt.search(scan.nextInt()));
                    break;
                case 4:
                    System.out.println("Nodes = " + spt.countNodes());
                    break;
                case 5:
                    System.out.println("Empty status = " + spt.isEmpty());
                    break;
                case 6:
                    System.out.println("\nTree Cleared");
                    spt.clear();
                    break;
                case 7:
                    System.out.println("\n Calc Insret Time Complexity For Given Size");
                    System.out.print("Enter size of numbers:");
                    int size = scan.nextInt();
                    TransferObject result = timeComplexity.calcInsertTimeComplextiyForSplayingInGivenSize(size);
                    System.out.println("Time Complexity For Insret Process in given size:" + result.getResult());
                    spt = result.getSplayTree();
                    break;
                case 8:
                    System.out.println("\n Calc Search Time Complexity For Given Size");
                    System.out.print("Enter  numbers:");
                    int number = scan.nextInt();
                    TransferObject searchResult = timeComplexity.calcSearchTimeComplextiyForSplayingInGivenSize(number, spt);
                    System.out.println("Time Complexity For Search Process in given size:" + spt.countNodes() + " = " + searchResult.getResult());
                    spt = searchResult.getSplayTree();
                    break;
                case 9:
                    System.out.println("\n Calc Remove Time Complexity For Given Size");
                    System.out.print("Enter  numbers:");
                    int numberForRemove = scan.nextInt();
                    TransferObject removeResult = timeComplexity.calcRemoveTimeComplextiyForSplayingInGivenSize(numberForRemove, spt);
                    System.out.println("Time Complexity For Remove Process in given size:" + spt.countNodes() + " = " + removeResult.getResult());
                    spt = removeResult.getSplayTree();
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            /**  Display tree  **/
//            System.out.print("\nPost order : ");
//            spt.postorder();
//            System.out.print("\nPre order : ");
//            spt.preorder();
//            System.out.print("\nIn order : ");
//            spt.inorder();

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }
}
