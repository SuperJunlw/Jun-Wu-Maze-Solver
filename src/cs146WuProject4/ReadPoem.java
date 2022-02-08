package cs146WuProject4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ReadPoem 
{
	/**
	 * Read and return an arrayList that contains all the words of the file
	 * @param filename
	 * @return ArrayList<String> poem
	 */
	public static ArrayList<String> readPoem(String filename)
	{
		ArrayList<String> poem= new ArrayList<>();   //poem.txt contains 20 words
		try
		{
			FileReader file = new FileReader(filename);
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
					StringTokenizer st = new StringTokenizer(line); //using StringTokenizer to break down the line
					while(st.hasMoreTokens())
					{
						poem.add(st.nextToken());
					}
				}
			}
			buff.close();
		}
		catch(IOException e)
		{
			System.out.println("Error: " + e.toString());
		}
		
		return poem;
	}
}
