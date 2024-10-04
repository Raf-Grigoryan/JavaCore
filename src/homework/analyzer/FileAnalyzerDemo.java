package homework.analyzer;


import java.io.IOException;
import java.util.Map;

public class FileAnalyzerDemo {
    private static String filePath = "/Users/raf/IdeaProjects/JavaCore/src/homework/analyzer/analyzeFile.txt";
    public static void main(String[] args) {

        FileAnalyzer analyzer = new FileAnalyzer();

        try {
            int totalWords = analyzer.totalWordCount(filePath);
            System.out.println("Total count " + totalWords);

            int uniqueWords = analyzer.uniqueWordCount(filePath);
            System.out.println("Count unique words " + uniqueWords);

            Map<String, Integer> topWords = analyzer.topFrequentWords(filePath, 3);
            topWords.forEach((word, count) -> System.out.println(word + ": " + count));

            String wordToCount = "example";
            int wordOccurrences = analyzer.countWordOccurrences(filePath, wordToCount);
            System.out.println(wordToCount + "': " + wordOccurrences);

        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

}
