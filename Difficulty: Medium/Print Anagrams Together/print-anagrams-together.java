//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends



class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // Initialize the final result list to store groups of anagrams
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        // Create a HashMap to group words by their sorted character representation
        HashMap<String, ArrayList<String>> groupedAnagrams = new HashMap<>();

        // Loop through each string in the input array
        for (String word : arr) {
            // Convert the word into a character array for sorting
            char[] charArray = word.toCharArray();

            // Sort the character array to get the normalized form of the word
            Arrays.sort(charArray);

            // Create a sorted string from the sorted character array
            String sortedWord = new String(charArray);

            // If the sorted word is not already a key in the map, add it with an empty list
            groupedAnagrams.putIfAbsent(sortedWord, new ArrayList<>());

            // Add the original word to the list corresponding to the sorted word
            groupedAnagrams.get(sortedWord).add(word);
        }

        // Add all grouped anagrams from the map to the result list
        result.addAll(groupedAnagrams.values());

        // Return the final grouped anagrams list
        return result;
    }
}




//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends