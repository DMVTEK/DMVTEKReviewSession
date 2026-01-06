package shahzadCode.String;

public class StringMethod {

    static String word="DMVTEK College   ";

    public static void main(String[] args) {

        System.out.println(word.length());  // word length count

        System.out.println(word.toUpperCase()); // convert to upper case
        System.out.println(word.charAt(1));  // find specific index digit
        System.out.println(word.substring(1,4));  // print a specific limit indexs

        System.out.println(word.contains("ege"));

        System.out.println(word.equals("DMVTEK"));
        System.out.println(word.equals("DMVTEK College"));

        System.out.println(word.equalsIgnoreCase("dmvtek college"));

        System.out.println(word.trim());

    }



}
