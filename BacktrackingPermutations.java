import java.util.Scanner;

public class BacktrackingPermutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string to see its permutations: ");
        String str = sc.next();

        System.out.println("\nAll Permutations of " + str + ":");
        findPermutations(str, "");
        sc.close();
    }
    public static void findPermutations(String str, String currentPermutations){
        if (str.isEmpty()){
            System.out.println("=>" + currentPermutations);
            return;
        }
        for(int i = 0; i < str.length(); i++){
            char currentChar = str.charAt(i);
            String remainingString = str.substring(0,i) + str.substring(i+1);
            findPermutations(remainingString, currentPermutations + currentChar);
        }
    }
}
