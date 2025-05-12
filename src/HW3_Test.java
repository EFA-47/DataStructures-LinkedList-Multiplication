import java.util.Scanner;

public class HW3_Test
{
    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();
        BinarySearchTree tree2 = new BinarySearchTree();
        Scanner scan = new Scanner(System.in);
        int num;
        
        // Create tree from user input
        while (scan.hasNextInt())
        {
            num = scan.nextInt();
            tree.insert(num);
        }
        scan.next(); // gets rid of the "end" token in the end of each list in the test cases
        
        // Create second tree from user input
        while (scan.hasNextInt())
        {
            num = scan.nextInt();
            tree2.insert(num);
        }
        scan.next();
        num = scan.nextInt();
        scan.next();
        
        System.out.println("tree is balanced= "+tree.isBalanced());
        System.out.println("trees are same= "+tree.compareTo(tree2));
        tree.remove(num);
        tree.printInOrder(tree.root);
        scan.close();
    }
}
