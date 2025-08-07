public class StringBuilderExample {
    public static String reverseSentence(String sentence){
        String[] words = sentence.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >=0; i--){
            reversed.append(words[i]);
            if(i!= 0) reversed.append(" ");
        }
        return reversed.toString();
    }
    public static void main(String[] args) {
        String input = "I Love Java";
        System.out.println("Reversed: " + reverseSentence(input));
    }
}
