package Hashtable;
/*
 * @author DJS
 * Hashtable
 * */
class Hashtable<K, V> {
    private ListNode<Integer, V> head;

    public Hashtable() {
        head = null;
    }

    private int getHashCode(K key) {
        return key.hashCode();
    }

    public void add(K key, V value) {
        int hash = getHashCode(key);
        if (head == null) {
            head = new ListNode<>(hash, value);
        } else {
            ListNode<Integer, V> prev = null;
            ListNode<Integer, V> current = head;
            while (current != null && current.key < hash) {
                prev = current;
                current = current.next;
            }
            if (current != null && current.key.equals(hash)) {
                current.value = value;
                return;
            }
            ListNode<Integer, V> newNode = new ListNode<>(hash, value);
            if (prev == null) {
                newNode.next = head;
                head = newNode;
            } else {
                newNode.next = current;
                prev.next = newNode;
            }
        }
    }

    public V get(K key) {
        int hash = getHashCode(key);
        ListNode<Integer, V> current = head;
        while (current != null && current.key <= hash) {
            if (current.key.equals(hash)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
}
