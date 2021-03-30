/**
 * https://www.baeldung.com/java-map-key-from-value
 * https://beginnersbook.com/2013/12/hashmap-in-java-with-example/
 */
package java8_collections;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * HashMap is a Map based collection class that is used for storing Key & value pairs, it is denoted as HashMap<Key,
 * Value> or HashMap<K, V>.
 * It is not an ordered collection which means it does not return the keys and values in the same order in which they
 * have been inserted into the HashMap. It does not sort the stored keys and Values. You must need to import java.util.
 * HashMap or its super class in order to use the HashMap class and methods
 * The Map interface of Java Collections offers a method called entrySet(). It returns all the entries or
 * key-value pairs of the map in a Set.
 */
public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> staff = new HashMap<Integer, String>();

        staff.put(34,"Paul");
        staff.put(45,"John");
        staff.put(13,"Anne");
        staff.put(48,"Anne");
        staff.put(45,"Jane");//replaces John
        staff.put(null,null); //Hashmaps also allow you to have null as the value for a key
        System.out.println("printout hashmap" + staff); // unordered,no duplicates

       // Display content using Iterator
        Set set = staff.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            System.out.println("key is: "+ mentry.getKey() + " & Value is: "+ mentry.getValue());
        }

        // Get values based on key
        System.out.println("\nValue at index 2 is: "+ staff.get(2));

       // Remove values based on key
        if(staff.containsKey(null)){
            staff.remove(null);
        }
        System.out.println("Map key and values after removal:" + staff);
        //Return key
        System.out.println("keys for Anne " + getKeys( staff, "Anne"));
        //using Lambda
        Stream<Integer> keyStream1 = getKeysFunc(staff, "Anne");
        Integer staffId = keyStream1.findFirst().get();
        System.out.println("keys for Anne using Lambda " + staffId);

        Stream<Integer> keyStream2 = getKeysFunc(staff, "Anne");
        Set<Integer> staffIds = keyStream2.collect(Collectors.toSet());
        System.out.println("keys for Anne using Lambda " + staffIds);

        /**
         * Using Apache commons collection
         * The above ideas wouldn't be very helpful if we need to call the functions very frequently for a particular map.
         * It will unnecessarily iterate the set of its keys again and again.
         * In this scenario, maintaining another map of value to the keys would make more sense as it will take constant
         * time to retrieve the key for a value.
         * The Commons Collections library by Apache provides with such a bi-directional Map called BidiMap. It has a
         * method named getKey() for retrieving a key for a given value:
         */
        BidiMap<String, String> capitalCountryMap = new DualHashBidiMap<>();
        capitalCountryMap.put("Berlin", "Germany");
        capitalCountryMap.put("Cape Town", "South Africa");
        String capitalOfGermany = capitalCountryMap.getKey("Germany");
        System.out.println("Capital of Germany " + capitalOfGermany );

        /**
         * Linked Hashmap
         * When using a normal HashMap there is no guarantee that you can get the entries back in the same order that
         * you put them in. However, when you use a linked HashMap, the order of the entries is retained.
         * HashMap doesn’t maintain any order.
         * TreeMap sort the entries in ascending order of keys.
         * LinkedHashMap maintains the insertion order.
         */
        LinkedHashMap<String,Integer> phonebook = new LinkedHashMap<String,Integer>();
        phonebook.put("Kevin", 12345);
        phonebook.put("Jill", 98765);
        phonebook.put("Brenda", 123123);
        phonebook.put("Gary", 22222);
        System.out.println("Kevin's number: " + phonebook.get("Kevin"));

        System.out.println("\nList of contacts in phonebook:");
        for(Map.Entry<String, Integer> entry: phonebook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        /**
         *  The first argument is the initial capacity of the map
         *  The second argument is called the Load Factor. This specifies how full the map can be before it is made
         *  bigger. For example, I will pass in not .75f, which is actually the default value.
         *  optional third argument, a boolean value which spefies the ordering mode.false = entering order,
         *  true= access order
         */
        LinkedHashMap<String, Integer> phonebook1 = new LinkedHashMap(4, 0.75f, true);

    }

    /**
     * Return Key!!!
     * The idea is to iterate over this entry-set and return the key for which the value matches the supplied value:
     * However, there might be a possibility that multiple keys are pointing to the same value.
     *
     * In that case, if a matching value is found, we add the key to a Set and continue the loop. In the end, we
     * return the Set containing all the desired keys:
     * @param map
     * @param value
     * @param <K>
     * @param <V>
     * @return
     */

    //public <K, V> K getKey(Map<K, V> map, V value) {
    public static <K,V> Set<K> getKeys(Map<K, V> map, V value){
        Set<K> keys = new HashSet<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                keys.add(entry.getKey());
            }
        }
        return keys;
  }


    /**
     * Lambda approach
     * With the introduction of Lambda Expressions in Java 8, we can do it in a more flexible and readable way.
     * We convert the entry-set to a Stream and supply a lambda to filter only those entries with the given value.
     * @param map
     * @param value
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> Stream<K> getKeysFunc(Map<K, V> map, V value) {
        return map
                .entrySet()
                .stream()
                .filter(entry -> value.equals(entry.getValue()))
                .map(Map.Entry::getKey);
    }

}
