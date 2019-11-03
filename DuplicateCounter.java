import java.io.File;
import java.io.FileWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;



public class DuplicateCounter
{
    private HashMap<String, Integer> wordCounter;

    public void count(String dataFile)  throws IOException
    {
        Integer count;
        FileInputStream fileByteStream = new FileInputStream(dataFile);
        wordCounter = new HashMap<String, Integer>();
        Scanner scnr;
        String currWord;

        scnr = new Scanner(fileByteStream);
        while(scnr.hasNext())
        {
            currWord = scnr.next().toLowerCase();
            count = wordCounter.get(currWord);
            if(count == null)
            {

                count = 1;
            }

            else
            {
                count++;
            }

            wordCounter.put(currWord, count);
        }

        fileByteStream.close();
    }

    public void write(String outputFile)  throws IOException
    {
        FileWriter file;
        File output = new File(outputFile);

        if(output.exists())
        {
            file = new FileWriter(output);
            for(String currWord : wordCounter.keySet())
            {
                file.write(currWord + " " + wordCounter.get(currWord) + " ");

            }
            file.close();
        }

        else
        {
            output.createNewFile();
            file = new FileWriter(output);
            for(String currWord : wordCounter.keySet())
            {
                file.write(currWord + " " + wordCounter.get(currWord));
            }
            file.close();
        }
    }
}
