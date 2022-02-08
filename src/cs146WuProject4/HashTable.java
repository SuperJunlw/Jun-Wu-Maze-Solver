package cs146WuProject4;

public class HashTable 
{
	private String[] keys; //parallel arrays to store keys and values
	private String[] values;
	private int tableSize;
	private int currentSize;
	
	public HashTable(int size)
	{
		this.tableSize = findNextPrime(size);  //set the table size to the next prime of the passed number
											   //or set to passed number itself if it's a prime
		this.keys = new String[tableSize];
		this.values = new String[tableSize];
		this.currentSize = 0;
	}
	
	/**
	 * Return the size of the hashtable
	 * @return int 
	 */
	public int getTableSize()
	{
		return this.tableSize;
	}
	
	/**
	 * return the current size of the hashtable
	 * @return integer - current size
	 */
	public int getCurrentSize()
	{
		return this.currentSize;
	}
	
	/**
	 * return true if hashtable is empty, false otherwise
	 * @return boolean 
	 */
	public boolean isEmpty()
	{
		if(currentSize == 0)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * check if the hashtable contains a certain key
	 * @param key - a String represent a key of the hashtable
	 * @return boolean
	 */
	public boolean isContain(String key)
	{
		if(lookUp(key) != null)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Generate a code that represent an index in the arrays
	 * @param key - a String represent a key of the hashtable
	 * @return integer - a hashcode represent an index in the arrays
	 */
	private int hash(String key)
	{
		return (key.hashCode() & 0x7fffffff) % tableSize;
	}
	
	/**
	 * Insert a key-value pair to the hashtable
	 * @param key - a String represent a key of the hashtable
	 * @param value - a String represent a value of the hashtable
	 */
	public void insert(String key, String value)
	{
		int i = 0;
		int j;
		do
		{
			j = (hash(key) + i) % tableSize;
			
			//if the slot is empty
			if(keys[j] == null)
			{
				keys[j] = key;
				values[j] = value;
				currentSize++;
				return;
			}
			//if the same key already exist in the slot
			else if(keys[j].equals(key))
			{
				values[j] = value;
				return;
			}
			i++;
			
			//check next slot if the slot is full
		}while( i != tableSize);
	}
	
	/**
	 * Delete a key-value pair from the hashtable based on the a key
	 * @param key - a String represent a key of the hashtable
	 */
	public void delete(String key)
	{
		//if the key doesn't exist in the hashtable
		if(isContain(key) == false)
		{
			return;
		}
		
		int i = 0;
		int j;
		j = (hash(key) + i) % tableSize;
		
		while(!keys[j].equals(key))  //while the key is not found, check the next slot
		{
			i++;
			j = (hash(key) + i) % tableSize;
		}
		
		keys[j] = null;
		values[j] = null;
		currentSize--;
	}
	
	/**
	 * Check and get a key-value form hashtable
	 * @param key - a String represent a key of the hashtable
	 * @return - String if the key is the hashtable, null if the key is not in the hashtable
	 */
	public String lookUp(String key)
	{
		
		int i = 0;
		int j;
		do
		{
			j = (hash(key) + i) % tableSize;
			
			//if the slot is null, search miss, return null
			if(keys[j] == null)
			{
				return null;
			}
			//if the key matches, search hit, return its value
			else if(keys[j].equals(key))
			{
				return values[j];
			}
			//else, check next slot
			i++;	
			
		}while(i != tableSize);
		
		return null;
	}
	
	/**
	 * Find and return the next prime of the an int or return the int itself if it is a prime
	 * @param size
	 * @return int
	 */
	private int findNextPrime(int size)
	{
		if(isPrime(size))
		{
			return size;
		}
		
		boolean isFound = false;
		while(!isFound)	
		{
			size++;
			if(isPrime(size))
			{
				isFound = true;
			}
		}
		return size;
	}
	
	/**
	 * Check if an int is prime of not
	 * @param size
	 * @return boolean
	 */
	private boolean isPrime(int size)
	{
		if(size <= 1)
		{
			return false;
		}
		
		for(int i = 2; i < size; i++) 
		{
	      if((size % i) == 0)
	      {
	         return false;
	      }
		}
		return true;
	}
	
	/**
	 * return a string contain all the key-value pair in the hashtable
	 */
	public String toString()
    {
		String str = "";
        for (int i = 0; i < tableSize; i++)
        {
            if (keys[i] != null)
            {
                str += keys[i] + " " + values[i] + "\n";
            }
        }
        return str;
    }
}
