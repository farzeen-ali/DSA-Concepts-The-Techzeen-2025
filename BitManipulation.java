//       What is Bit Manipulation?
//        * Bit Manipulation means working directly with binary bits (0 and 1) of a number.
//        * It allows programmers to modify, check, or control individual bits.
//        * Computers internally store numbers in binary form.
//        * Using bit manipulation, we can perform operations faster and more efficiently.
//        * It is widely used in DSA, competitive programming, and system-level programming
//        5 = 101
//        3 = 011
//        2 = 010

//        Important Bit Operators (in Java)

//        AND (&)
//        OR (|)
//        XOR (^)
//        NOT (~)
//        Left Shift (<<)
//        Right Shift (>>)

//        Why We Need Bit Manipulation

public class BitManipulation {
    public static void main() {
        int n = 6;
        if((n & 1) == 1){
            System.out.println("Odd Number");
        }else{
            System.out.println("Even Number");
        }
    }
}
