package cs146WuProject4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CreateDictionary 
{
	/**
	 * Read the dictionary.txt, create and return a Hashable to represent a dictionary
	 * @return a HashTable that contain all the words of the dictionary
	 */
	public static HashTable createDictionary(int size, String fileName)
	{
		HashTable hashtable = new HashTable(size);
		try
		{
			//dictionary.txt contains 349900 words
			FileReader file = new FileReader(fileName);
			BufferedReader buff = new BufferedReader(file);
			boolean eof = false;
			
			//while loop to read and break down each line of the file
			while(!eof)
			{
				String line = buff.readLine();
				if(line == null)
				{
					eof = true;
				}
				else
				{
					hashtable.insert(line, line);
				}
			}
			buff.close();
		}
		catch(IOException e)
		{
			System.out.println("Error: " + e.toString());
		}
		return hashtable;
	}
}
