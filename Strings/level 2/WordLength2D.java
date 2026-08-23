import java.util.Scanner;

public class WordLength2D {

    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {

        }
        return count;
    }
	
    public static int countWords(String str) {
        int length = findLength(str);
        int words = 0;
        boolean isWord = false;

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != ' ') {
                if (!isWord) {
                    words++;
                    isWord = true;
                }
            } else {
                isWord = false;
            }
        }
        return words;
    }

    public static String[] customSplit(String str) {
        int length = findLength(str);
        int wordCount = countWords(str);
        String[] words = new String[wordCount];

        int start = -1;
        int index = 0;

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) != ' ') {
                if (start == -1) {
                    start = i;
                }
            } else {
                if (start != -1) {
                    String word = "";
                    for (int j = start; j < i; j++) {
                        word += str.charAt(j);
                    }
                    words[index++] = word;
                    start = -1;
                }
            }
        }

        if (start != -1) {
            String word = "";
            for (int j = start; j < length; j++) {
                word += str.charAt(j);
            }
            words[index] = word;
        }

        return words;
    }

    public static String[][] create2DArray(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];

            int len = findLength(words[i]);
            result[i][1] = String.valueOf(len);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String input = sc.nextLine();

        String[] words = customSplit(input);
        String[][] result = create2DArray(words);

        System.out.println("\nWord\tLength");
        System.out.println("----------------");

        for (int i = 0; i < result.length; i++) {
            int lengthValue = Integer.parseInt(result[i][1]);
            System.out.println(result[i][0] + "\t" + lengthValue);
        }

        sc.close();
    }
}