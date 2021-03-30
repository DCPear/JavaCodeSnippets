
##### different implementations of collections
##### key factors
is order important? is duplicates allowed? how fast it will be to perform operations?
memory used?
```
*  In Java, there is a set of interfaces that define different types of collection
*    iterable(All types of collection implement Iterable) -> for each
*     -> Collections  extends iterable (interface declares all of the methods)
*     -> next layer of interfaces set, list and queue etc.
*     -> set unordered, no duplicates
*     -> list - allow duplicate entries, order of elements is significant,iteration returns items in order
*     -> Queue -typically FIFO
*        https://www.baeldung.com/java-queue
*     ->maps do not extend collection interface as they contain a key value pair. still considered to be a part of
*       collections framework however
      ->Linkedlist- The LinkedList class of the Java collections framework provides the functionality of the linked
*       list data structure (doubly linkedlist).
*     Each element in a linked list is known as a node. It consists of 3 fields:
*      Prev - stores an address of the previous element in the list. It is null for the first element
*      Next - stores an address of the next element in the list. It is null for the last element
*      Data - stores the actual data
*      when to use Linked list: add or remove elements in the middle as linked list takes more memory than array list
```
##### reading
* https://howtodoinjava.com/java-collections/
* https://docs.oracle.com/javase/tutorial/collections/intro/index.html
* https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Collection.html
* https://beginnersbook.com/java-collections-tutorials/ (for all kinds of examples)