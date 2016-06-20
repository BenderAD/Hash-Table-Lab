package hash.table;

/**
 /** @author Alex Bender CS 320 Lab4Hash
 * This class creates a hash table with integer keys and String values.
 *
 */

public class HashTable {
	
	/**
	 * This class creates the linked list for the hash table, to be used when two values have the same key. 
	 * 
	 */
	private class HashNode{
		int hashKey;
		String hashVal;
		HashNode next;
		
		/**
		 * This returns the current key as needed.
		 * @return hashKey, the current key being called in the hash table
		 */
		public int getKey(){
			return hashKey;
		}
		
		/**
		 * This returns the current hash value as needed.
		 * @return hashVal, the current value being called in the hash table
		 */
		public String getVal(){
			return hashVal;
		}
	}
	
	int hashSize = 97;
	HashNode[] table;
	
	/**
	 * Constructor for empty hash table of default (hashSize) size
	 */
	public HashTable(){
		table = new HashNode[hashSize];
	}
	
	/**
	 * Constructor for empty hash table of size tableSize
	 * @param tableSize, the desired size of the hash table
	 */
	public HashTable(int tableSize){
		if (tableSize <= 0){
			throw new IllegalArgumentException("Table size must be positive!");
		}
		hashSize = tableSize;		
		table = new HashNode[hashSize];
	}
	
	/**
	 * The hash function used on each key
	 * @param key, the key to be hashed
	 * @return the hashed key value
	 */
	private Integer hashf(int key){
		return(key % hashSize);
	}
	
	/**
	 * Adds a new value to the hash table. Picks first empty spot to place value, or adds value to the linkedlist in the hashed key space.
	 * @param k, the key in the key-value pair
	 * @param x, the String in the key-value pair
	 * @return true if the value has been inserted successfully;
	 */
	public boolean insert(int k, String x){
		if (k < 0 || x == null){throw new IllegalArgumentException("Cannot insert negative key or null value.");}
		int listBucket = hashf(k);
		HashNode list = table[listBucket];
		while(list != null){
			if(list.getKey() == k){
				break;
			}
			list = list.next;
		}
		
		if (list != null){
			list.hashVal = x;
			return true;
		}
		
		else{ // Separate chaining!
			HashNode newNode = new HashNode();
			newNode.hashKey = k;
			newNode.hashVal = x;
			newNode.next = table[listBucket];
			table[listBucket] = newNode;
			return true;
		}
	}
	
	/**
	 * Inserts a value to the hash table. If a key is already associated with a value, the value is replaced with the new one, and the old one is returned.
	 * @param k, the key in the key-value pair
	 * @param x, the String in the key-value pair
	 * @return a "no needed replacement" message if inserted into an empty bucket; if bucket holds value, replaced value is returned
	 */
	public String insertAndReplace(int k, String x){
		if (k < 0 || x == null){throw new IllegalArgumentException("Cannot insert negative key or null value.");}
		int listBucket = hashf(k);
		HashNode list = table[listBucket];
		while(list != null){
			if(list.getKey() == k){
				break;
			}
			list = list.next;
		}
		
		if (list != null){
			list.hashVal = x;
			return "No replace needed.";
		}
		else{
			String removedVal = remove(k);
			HashNode newNode = new HashNode();
			newNode.hashKey = k;
			newNode.hashVal = x;
			newNode.next = table[listBucket];
			table[listBucket] = newNode;
			return removedVal;
		}
	}
	
	/**
	 * Removes the key and its associated value from the hash table.
	 * @param k, the key in the key-value pair to be removed from the table
	 * @return the value (String) if it is removed; null otherwise
	 */
	public String remove(int k){
		if(k < 0){throw new IllegalArgumentException("Cannot remove negative key, since it doesn't exist!");}
		int listBucket = hashf(k);
		if(table[listBucket] == null){
			return null;
		}
		if (table[listBucket].getKey() == k){
			String removed = table[listBucket].getVal();
			table[listBucket] = table[listBucket].next;
			return removed;
		}
		
		HashNode prev = table[listBucket];
		HashNode current = prev.next;
		while (current != null && current.getKey() != k){
			prev = current;
			current = current.next;
		}
		
		if (current != null){
			String removed = current.getVal();
			prev.next = current.next;
			return removed;
		}
		return null;
	}
	
	/**
	 * Returns the value (String) associated with a given key, if it is there.
	 * @param k, the key associated with the value being looked for.
	 * @return the String associated with the key parameter; null otherwise
	 */
	public String findEntry(int k){
		if(k < 0){throw new IllegalArgumentException("Cannot find negative key, since it doesn't exist!");}
		int listBucket = hashf(k);
		HashNode list = table[listBucket];
		while (list != null){ 
			if (list.getKey() == k){
				return list.hashVal;
			}
			list = list.next;
		}
		return null;
	}
	
	/**
	 * Returns size of hash table
	 * @return the number of cells in the hash table
	 */
	public int getTableSize(){
		return hashSize;
	}
	
	/** 
	 * Returns a string representation of the hash table
	 * @return a String of the hash table; buckets delimited by semicolons;
	 * items in same bucket delimited by commas 
	 */
	public String toString(){
		String printed = "[";
		for(int i = 0; i < hashSize; i++){
			HashNode list = table[i];
						
			while(list != null && list.getVal() != null){
				printed += list.getVal();
				if(list.next == null){
					break;}
			printed += ", ";
			list = list.next;
		}
		
		if(list != null){
			printed += "; ";}
		}
	printed = printed.substring(0,printed.length()-2);
	printed += "]";
	return printed;
	}
}

