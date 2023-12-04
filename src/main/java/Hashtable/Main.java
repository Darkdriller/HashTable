package Hashtable;

public class Main {
    /*
     * @author DJS
     * Main method
     * */
    public static void main(String[] args) {
        Hashtable<String, Integer> hashTable = new Hashtable<String, Integer>();

        // Example string (can be replaced with any text)
        String text = """
                Paranoids are not
                paranoid because they are paranoid but
                because they keep putting themselves
                deliberately into paranoid avoidable
                situations""";

        // Splitting the string into words and adding them to the hash table
        String[] words = text.split("\\s+");
        for (String word : words) {
            word = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
            if (!word.isEmpty()) {
                Integer count = hashTable.get(word);
                count = (count == null) ? 1 : count + 1;
                hashTable.add(word, count);
            }
        }

        // Example: Retrieving the frequency of a word
        System.out.println("Frequency of 'paranoid': " + hashTable.get("paranoid"));


    }
}

