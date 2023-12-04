package Hashtable;
/*
 * @author DJS
 * LinkedList Ndoe
 * */
class ListNode<K, V> {
    K key;
    V value;
    ListNode<K, V> next;

    public ListNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}