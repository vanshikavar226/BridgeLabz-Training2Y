import java.util.Scanner;

public class CustomSplitProgram {

    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // When index goes out of bound, stop counting
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

        int[] spaceIndexes = new int[wordCount + 1];
        String[] words = new String[wordCount];

        int indexCount = 0;

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                spaceIndexes[indexCount++] = i;
            }
        }
        spaceIndexes[indexCount] = length;

        int start = 0;
        int wordIndex = 0;

        for (int i = 0; i <= indexCount; i++) {
            int end;
            if (i == indexCount)
                end = length;
            else
                end = spaceIndexes[i];

            if (start != end) {
                String word = "";
                for (int j = start; j < end; j++) {
                    word += str.charAt(j);
                }
                words[wordIndex++] = word;
            }
            start = end + 1;
        }

        return words;
    }

    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length)
            return false;

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String input = sc.nextLine();

        String[] customResult = customSplit(input);

        String[] builtinResult = input.split(" ");

        System.out.println("\nCustom Split Result:");
        for (String word : customResult) {
            System.out.println(word);
        }

        System.out.println("\nBuilt-in Split Result:");
        for (String word : builtinResult) {
            System.out.println(word);
        }

        boolean result = compareArrays(customResult, builtinResult);
        System.out.println("\nAre both results equal? " + result);

        sc.close();
    }
}