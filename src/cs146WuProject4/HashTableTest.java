package cs146WuProject4;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.junit.Before;
import org.junit.Test;

public class HashTableTest 
{
	private HashTable testHashTable;

	@Before
	public void setUp() throws Exception
	{
		testHashTable = new HashTable(5);	
	}

	@Test
	public void testGetTableSize()
	{
		assertEquals(5, testHashTable.getTableSize()); //5 itself is already a prime number
	}
	
	@Test
	public void testGetCurrentSize()
	{
		testHashTable.insert("#1", "cat");
		testHashTable.insert("#2", "dog");
		
		assertEquals(2, testHashTable.getCurrentSize());
		
		testHashTable.delete("#1");
		
		assertEquals(1, testHashTable.getCurrentSize());
	}
	
	@Test 
	public void testIsEmpty()
	{
		assertEquals(true, testHashTable.isEmpty());
		
		testHashTable.insert("#1", "cat");
		
		assertEquals(false, testHashTable.isEmpty());
	}
	
	@Test
	public void testIsContain()
	{
		testHashTable.insert("#1", "cat");
		testHashTable.insert("#2", "dog");
		
		assertEquals(true, testHashTable.isContain("#2"));
		assertEquals(true, testHashTable.isContain("#1"));
		assertEquals(false, testHashTable.isContain("#5"));
	}
	
	@Test
	public void testInsert()
	{
		testHashTable.insert("#1", "cat");
		testHashTable.insert("#2", "dog");
		testHashTable.insert("#3", "bird");
		
		assertEquals(3, testHashTable.getCurrentSize());
		
		assertEquals(true, testHashTable.isContain("#1"));
		assertEquals(true, testHashTable.isContain("#2"));
		assertEquals(true, testHashTable.isContain("#3"));
		
		testHashTable.insert("#4", "bear");
		assertEquals(4, testHashTable.getCurrentSize());
		assertEquals(true, testHashTable.isContain("#4"));
	}
	
	@Test 
	public void testDelete()
	{
		testHashTable.insert("#1", "cat");
		testHashTable.insert("#2", "dog");
		testHashTable.insert("#3", "bird");
		
		testHashTable.delete("#1");
		assertEquals(2, testHashTable.getCurrentSize());
		assertEquals(false, testHashTable.isContain("#1"));
		
		testHashTable.delete("#3");
		assertEquals(1, testHashTable.getCurrentSize());
		assertEquals(false, testHashTable.isContain("#3"));
	}
	
	@Test
	public void testLookUps()
	{
		testHashTable.insert("#1", "cat");
		testHashTable.insert("#2", "dog");
		testHashTable.insert("#3", "bird");
		
		assertEquals("cat", testHashTable.lookUp("#1"));
		assertEquals("dog", testHashTable.lookUp("#2"));
		assertEquals("bird", testHashTable.lookUp("#3"));
		assertEquals(null, testHashTable.lookUp("#6"));
		
		testHashTable.delete("#2");
		assertEquals(null, testHashTable.lookUp("#2"));
		
		testHashTable.insert("#4", "tiger");
		assertEquals("tiger", testHashTable.lookUp("#4"));
	}
	
	@Test
	public void testCreateDictionaryAndSpellCheck()
	{
		long start, end;
		
		//check the run time of create a dictionary (insert all the words of dictionary.txt to a hashtable)
		//dictionary.txt contains 349900 words
		
		start = System.nanoTime();
		HashTable dictionary = CreateDictionary.createDictionary(349900, "dictionary.txt");
		end = System.nanoTime();
		
		System.out.println("Time for creating a dictionary(349900 words) in nanoseconds: " + (end - start));
		
		//check base lookup of the dictionary
		assertEquals("apple", dictionary.lookUp("apple"));         //"apple" exist in the dictionary.txt
		assertEquals("mayfish", dictionary.lookUp("mayfish"));     //"mayfish" exist in the dictionary.txt
		assertEquals("thedoctor", dictionary.lookUp("thedoctor")); //"thedoctor" exist in the dictionary.txt
		assertEquals("aaaaaagh", dictionary.lookUp("aaaaaagh"));   //"aaaaaagh" exist in the dictionary.txt
		assertEquals(null, dictionary.lookUp("bbbbbbbbb"));        //"bbbbbbbbb" doesn't exist in the dictionary.txt
		assertEquals(null, dictionary.lookUp("but"));              //"but" doesn't exist in the dictionary.txt
		
		
		
		//check the run time of create a dictionary with hashtable size that is double of the words in the dictionary(349900*2)
		start = System.nanoTime();
		HashTable dictionary2 = CreateDictionary.createDictionary(349900*2, "dictionary.txt");
		end = System.nanoTime();
		
		System.out.println("Time for creating a dictionary(349900 words) with size of 349900*2 in nanoseconds: " + (end - start));
		
		
		
		//check the run time of spell check (look up) of all the words in poem.txt using the dictionary
		
		//store all the words of the poem to an arrayList
		ArrayList<String> poem= ReadPoem.readPoem("poem.txt");   //poem.txt contains 20 words
		long temp = 0, sum = 0;
		
		//calculate the time of look up all the words of the poem using the dictionary
		for(int i = 0; i < poem.size(); i++)  
		{
			start = System.nanoTime();
			dictionary.lookUp(poem.get(i));
			end = System.nanoTime();
			temp = end - start;
			sum += temp;
		}
		
		System.out.println("Time for look up all the words in the poems in nanoseconds: " + (end - start));
		System.out.println();
		System.out.println("Poem:");
		System.out.println(poem.toString() + "\n");
		
		//print the result of spell check (look up) of the poem
		for(int i = 0; i < poem.size(); i++)  
		{
			if(dictionary.lookUp(poem.get(i)) == null)
			{
				System.out.println("'" + poem.get(i) + "'" + " is not in the dictionary");
			}
			else
			{
				System.out.println("'" + poem.get(i) + "'" + " is in the dictionary");
			}
		}
		
	}
}
