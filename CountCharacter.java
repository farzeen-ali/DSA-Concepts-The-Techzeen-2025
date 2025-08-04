public class CountCharacter {
    public static int countChar(String str, char target){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == target){
                count++; // 3
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String text = "banana";
        char target = 'a';
        System.out.println("Frequency of '" + target + "' is: " + countChar(text, target) );
    }
}
