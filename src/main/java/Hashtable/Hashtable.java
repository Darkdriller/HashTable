package Hashtable;
/*
 * @author DJS
 * Hashtable
 * */


class Hashtable<K, V> {
    private ListNode<K, V>[] bucketArray;
    private int numBuckets;
    private int size;

    public Hashtable() {
        numBuckets = 10; // initial number of buckets
        bucketArray = new ListNode[numBuckets];
        size = 0;
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % numBuckets;
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        ListNode<K, V> head = bucketArray[bucketIndex];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    public void add(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        ListNode<K, V> head = bucketArray[bucketIndex];
        ListNode<K, V> newNode = new ListNode<>(key, value);

        if (head == null) {
            bucketArray[bucketIndex] = newNode;
            size++;
            return;
        }

        while (head.next != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        if (head.key.equals(key)) {
            head.value = value;
        } else {
            head.next = newNode;
            size++;
        }
    }

    public void remove(K key) {
        int bucketIndex = getBucketIndex(key);
        ListNode<K, V> head = bucketArray[bucketIndex];
        ListNode<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }

        if (head == null) {
            return;
        }

        size--;
        if (prev != null) {
            prev.next = head.next;
        } else {
            bucketArray[bucketIndex] = head.next;
        }
    }

    // Method to print the contents of the hash table for debugging
    public void printHashTable() {
        for (int i = 0; i < numBuckets; i++) {
            System.out.print("Bucket " + i + ": ");
            ListNode<K, V> head = bucketArray[i];
            while (head != null) {
                System.out.print("[" + head.key + " = " + head.value + "] ");
                head = head.next;
            }
            System.out.println();
        }
    }
}
