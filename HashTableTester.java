package hash.table;

/**
 * This class tests the HashTable class and its methods. 
 * @author Alex Bender
 *
 */
public class HashTableTester {
	public static void main(String[] args){
		HashTable table1 = new HashTable();
		System.out.println("A new Hashtable created, table1.");
		System.out.println();
		System.out.println("Expected size of table1: 97");
		System.out.println("Actual size of table1:   "+ table1.getTableSize());
		table1.insert(1, "job1");
		table1.insert(5, "job5");
		table1.insert(33, "job33");
		table1.insert(21, "job21");
		table1.insert(87, "job87");
		table1.insert(97, "job97");
		table1.insert(135, "job135");
		table1.insert(98, "job98");
		System.out.println();
		System.out.println("Inserted the following key-value pairs: '1, job1'; '5, job5'; '33, job33'; '21, job21'; '87, job87'; '97, job97'; '135, job135'; '98, job98'");
		System.out.println();
		System.out.println("Expected toString() of table1: [job97; job98, job1; job5; job21; job33; job135; job87]");
		System.out.println("Actual toString() of table1:   " + table1.toString());
		System.out.println();
		table1.insertAndReplace(1, "job1 redux");
		table1.insertAndReplace(4, "job4");
		table1.insertAndReplace(33, "job33 redux");
		table1.insertAndReplace(135, "job135 redux");
		table1.insertAndReplace(98, "job98 redux");
		System.out.println("Used 'Insert and Replace' with the following key-value pairs: '1, job1 redux'; '4, job4'; '33, job33 redux'; '135, job135 redux'; '98, job98 redux'");
		System.out.println();
		System.out.println("Expected toString() of table1: [job97; job98 redux, job1 redux; job4; job5; job21; job33 redux; job135 redux; job87]");
		System.out.println("Actual toString() of table1:   " + table1.toString());
		System.out.println();
		System.out.println("Expected findEntry() of keys 1, 33, 5, 2, and 98: job1 redux; job33 redux; job5; null; job98 redux");
		System.out.println("Actual findEntry() of keys 1, 33, 5, 2, and 98:   " + table1.findEntry(1) + "; " + table1.findEntry(33) + "; " + table1.findEntry(5) + "; " + table1.findEntry(2) + "; " + table1.findEntry(98));
		System.out.println();
		System.out.println("Removed the following keys and their associated values: 1, 87, 97, 5");
		System.out.println();
		System.out.println("Expected removed values respective to keys above: job1 redux; job87; job97; job5");
		System.out.println("Actual removed values respective to keys above:   " + table1.remove(1) + "; " + table1.remove(87) + "; " + table1.remove(97) + "; " + table1.remove(5));
		System.out.println();
		System.out.println("Expected toString() of table1: [job98 redux; job4; job21; job33 redux; job135 redux]");
		System.out.println("Actual toString() of table1:   " + table1.toString());
		System.out.println();
		System.out.println();
		
		HashTable table2 = new HashTable(13);
		System.out.println("A second Hashtable created, table2.");
		System.out.println();
		System.out.println("Expected size of table2: 13");
		System.out.println("Actual size of table2:   "+ table2.getTableSize());
		System.out.println();
		table2.insert(1,"job1");
		table2.insert(5, "job5");
		table2.insert(7, "job7");
		table2.insert(58, "job58");
		table2.insert(33, "job33");
		table2.insert(11, "job11");
		table2.insert(52, "job52");
		table2.insert(90, "job90");
		table2.insert(3, "job3");
		table2.insert(78, "job78");
		table2.insert(1032, "job1032");
		System.out.println("Inserted the following key-value pairs: '1, job1'; '5, job5'; '7, job7'; '58, job58'; '33, job33'; '11, job11'; '52, job52'; '90, job90'; '3, job3'; '78, job78'; '1032, job1032'");
		System.out.println();
		System.out.println("Expected toString() of table2: [job78, job52; job1; job3; job1032, job5; job58; job33, job7; job11; job90]");
		System.out.println("Actual toString() of table2:   " + table2.toString());
		System.out.println();
		table2.insertAndReplace(2, "job2");
		table2.insertAndReplace(29, "job29");
		table2.insertAndReplace(7, "job7 redux");
		table2.insertAndReplace(1032, "job1032 redux");
		System.out.println("Used 'Insert and Replace' with the following key-value pairs: '2, job2'; '29, job29'; '7, job7 redux'; '1032, job1032 redux'");
		System.out.println();
		System.out.println("Expected toString() of table2: [job78, job52; job1; job2; job29, job3; job1032 redux, job5; job58; job33, job7 redux; job11; job90]");
		System.out.println("Actual toString() of table2:   " + table2.toString());
		System.out.println();
		System.out.println("Expected findEntry() of keys 5, 3, 77, and 90: job5; job3; null; job90");
		System.out.println("Actual findEntry() of keys 5, 3, 77, and 90:   " + table2.findEntry(5) + "; " + table2.findEntry(3) + "; " + table2.findEntry(77) + "; " + table2.findEntry(90));
		System.out.println();
		System.out.println("Removed the following keys and their associated values: 29, 1032, 11, 52");
		System.out.println();
		System.out.println("Expected removed values respective to keys above: job29; job1032 redux; job11; job52");
		System.out.println("Actual removed values respective to keys above:   " + table2.remove(29) + "; " + table2.remove(1032) + "; " + table2.remove(11) + "; " + table2.remove(52));
		System.out.println();
		System.out.println("Expected toString() of table2: [job78; job1; job2; job3; job5; job58; job33, job7 redux; job90]");
		System.out.println("Actual toString() of table2:   " + table2.toString());
		
	}
}
