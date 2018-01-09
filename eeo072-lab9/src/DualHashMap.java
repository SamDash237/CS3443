import java.util.HashMap;

/**
 * DualHashMap implements a DualMap interface. A DualHashMap maintains a
 * one-to-one mapping between keys and value. A DualHashMap object should
 * contain a HashMap from keys to values and a HashMap from values to keys. A
 * DualHashMap cannot contain duplicate keys or duplicate values.
 * 
 * @author eeo072
 *
 */
public class DualHashMap<K, V> implements DualMap<K, V> {

	/**
	 * HashMap to track individual keys
	 */
	private HashMap<K, V> map;
	/**
	 * HashMap to track individual values
	 */
	private HashMap<V, K> rMap;

	/**
	 * DualHashMap constructor that keeps individual keys and values unique
	 */
	public DualHashMap() {
		super();
		map = new HashMap<K, V>();
		rMap = new HashMap<V, K>();
	}

	/**
	 * 
	 * Adds key and value to DualHashMap If DualHashMap previously contained a
	 * mapping for the key or the value, the old association(s) is(are) removed.
	 * 
	 * @param key
	 *            key associated with the specified value.
	 * @param value
	 *            value associated with the specified key.
	 */
	public void put(K key, V value) {

		if (map.containsKey(key)) {
			V entry = map.get(key);
			map.remove(key);
			rMap.remove(entry);
		}

		if (rMap.containsKey(value)) {
			K entry = rMap.get(value);
			rMap.remove(value);
			map.remove(entry);
		}

		map.put(key, value);
		rMap.put(value, key);
	}

	/**
	 * Removes key and value from DualHashMap
	 * 
	 * @param key
	 *            key whose mapping to value is to be removed
	 * @param value
	 *            value whose mapping from key is to be removed
	 */
	public void remove(K key, V value) {
		map.remove(key);
		rMap.remove(value);
	}

	/**
	 * Returns value that maps from the key
	 * 
	 * @param key
	 *            the key that maps to the value that should be returned
	 * @return the value that maps from the specified key, or null if dual map lacks
	 *         mapping for the key
	 */
	public V get(K key) {
		return map.get(key);
	}

	/**
	 * Returns key that maps from the value
	 * 
	 * @param value
	 *            the value that maps from the key that should be returned
	 * @return the key that maps to the specified value, or null if this dual map
	 *         lacks mapping for the value
	 */
	public K reverseGet(V value) {
		return rMap.get(value);
	}
}
