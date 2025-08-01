public class ReverseString {
    public static String reverse(String str){
//        String reversed = "";
        StringBuilder reversed = new StringBuilder();
        for(int i = str.length() - 1; i>=0; i--){
//            reversed += str.charAt(i);
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }
    public static void main(String[] args) {
        String original = "Farzeen";
        System.out.println("Reversed: " + reverse(original));
    }
}
