import java.util.Scanner;

public class ShortestLongestWord {

    // Method to find string length without using length()
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

    // Method to count words
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

    // Method to split text using charAt()
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

        // Last word
        if (start != -1) {
            String word = "";
            for (int j = start; j < length; j++) {
                word += str.charAt(j);
            }
            words[index] = word;
        }

        return words;
    }

    // Create 2D array of word and its length
    public static String[][] create2DArray(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            int len = findLength(words[i]);
            result[i][1] = String.valueOf(len);
        }

        return result;
    }

    // Method to find shortest and longest word indexes
    public static int[] findShortestLongest(String[][] data) {
        int minIndex = 0;
        int maxIndex = 0;

        int minLength = Integer.parseInt(data[0][1]);
        int maxLength = Integer.parseInt(data[0][1]);

        for (int i = 1; i < data.length; i++) {
            int currentLength = Integer.parseInt(data[i][1]);

            if (currentLength < minLength) {
                minLength = currentLength;
                minIndex = i;
            }

            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxIndex = i;
            }
        }

        return new int[]{minIndex, maxIndex};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String input = sc.nextLine();

        String[] words = customSplit(input);
        String[][] wordData = create2DArray(words);
        int[] indexes = findShortestLongest(wordData);

        System.out.println("\nShortest Word: " + wordData[indexes[0]][0]);
        System.out.println("Length: " + wordData[indexes[0]][1]);

        System.out.println("\nLongest Word: " + wordData[indexes[1]][0]);
        System.out.println("Length: " + wordData[indexes[1]][1]);

        sc.close();
    }
}