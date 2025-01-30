//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LRUDesign {

    private static List<String> inputLine(Scanner sc) {
        return Arrays.asList(sc.nextLine().split(" "));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int capacity = Integer.parseInt(sc.nextLine());
            LRUCache cache = new LRUCache(capacity);

            int queries = Integer.parseInt(sc.nextLine());
            while (queries-- > 0) {
                List<String> vec = inputLine(sc);
                if (vec.get(0).equals("PUT")) {
                    int key = Integer.parseInt(vec.get(1));
                    int value = Integer.parseInt(vec.get(2));
                    cache.put(key, value);
                } else {
                    int key = Integer.parseInt(vec.get(1));
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// design the class in the most optimal way


// Approach:
// To efficiently implement the LRU (Least Recently Used) Cache, we use:

// HashMap (map) - Provides O(1) access to key-value pairs.
// Doubly Linked List (Node class) - Maintains the order of use (most recently used at the tail, least recently used at the head).
// Implementation Steps:
// put(key, value) Function:
// If the key already exists, update its value and move it to the most recently used position.
// If the key doesn’t exist:
// If capacity is full, remove the least recently used (LRU) node (head of the linked list).
// Insert the new key-value pair at the tail (most recently used).
// get(key) Function:
// If key exists, move it to the tail (mark it as recently used) and return its value.
// If key doesn’t exist, return -1.
// Doubly Linked List Operations:
// removeNode(Node node): Removes a node from the linked list.
// moveToTail(Node node): Moves an existing node to the tail (marking it as recently used).
// addNodeToTail(Node node): Adds a new node to the tail.



class LRUCache {
    // Node class for the Doubly Linked List
    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity; // Maximum capacity of the cache
    private final Map<Integer, Node> map; // HashMap for O(1) lookup
    private final Node head, tail; // Dummy head & tail for easy operations

    // Constructor for initializing the cache with given capacity.
    public LRUCache(int cap) {
        this.capacity = cap;
        this.map = new HashMap<>();
        
        head = new Node(0, 0); // Dummy head
        tail = new Node(0, 0); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }

    // Function to return value corresponding to the key.
    public int get(int key) {
        if (!map.containsKey(key)) return -1; // Key not found

        Node node = map.get(key);
        moveToTail(node); // Mark as recently used
        return node.value;
    }

    // Function for storing key-value pair.
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update value and move node to tail
            Node node = map.get(key);
            node.value = value;
            moveToTail(node);
        } else {
            // Check capacity
            if (map.size() == capacity) {
                removeLRUNode(); // Remove least recently used node
            }
            
            // Insert new node at the tail
            Node newNode = new Node(key, value);
            addNodeToTail(newNode);
            map.put(key, newNode);
        }
    }

    // Moves a node to the tail (marking it as recently used)
    private void moveToTail(Node node) {
        removeNode(node);
        addNodeToTail(node);
    }

    // Adds a node to the tail (most recently used)
    private void addNodeToTail(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    // Removes a node from the linked list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Removes the least recently used node (head's next node)
    private void removeLRUNode() {
        Node lru = head.next;
        removeNode(lru);
        map.remove(lru.key);
    }
}
