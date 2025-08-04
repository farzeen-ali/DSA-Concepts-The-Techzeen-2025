public class CountCharactersWithoutSpaces {
    public static int countCharacters(String str){
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' '){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        String text = "My name is Farzeen";
        System.out.println("Total characters in string without spaces: " + countCharacters(text));
    }
}
