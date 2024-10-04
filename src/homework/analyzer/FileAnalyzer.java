package homework.analyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FileAnalyzer {

    public Map<String, Integer> wordMap(String path) throws IOException {
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }

        return wordCountMap;
    }

    public int totalWordCount(String path) throws IOException {
        int wordCount = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\W+");
                wordCount += words.length;
            }
        }

        return wordCount;
    }

    public int uniqueWordCount(String path) throws IOException {
        Map<String, Integer> wordCountMap = wordMap(path);
        return wordCountMap.size();
    }

    public Map<String, Integer> topFrequentWords(String path, int n) throws IOException {
        Map<String, Integer> wordCountMap = wordMap(path);

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(wordCountMap.entrySet());

        Map<String, Integer> topWords = new HashMap<>();
        for (int i = 0; i < n && !pq.isEmpty(); i++) {
            Map.Entry<String, Integer> entry = pq.poll();
            topWords.put(entry.getKey(), entry.getValue());
        }

        return topWords;
    }

    public int countWordOccurrences(String path, String word) throws IOException {
        Map<String, Integer> wordCountMap = wordMap(path);
        return wordCountMap.getOrDefault(word.toLowerCase(), 0);
    }
}