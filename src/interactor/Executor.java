package interactor;

import model.concept.ConceptManager;
import model.name.NameFile;

import java.io.*;

/**
 * Created by siddgupta on 8/11/16.
 */
public class Executor {
    private static File conceptFile;
    private static ConceptManager conceptManager;
    private static NameFile nameFile;

    public static void main(String args[])
    {
        nameFile=new NameFile();
         conceptManager=new ConceptManager();

        String conceptMangegerString= edit(conceptManager.toString());
        nameFile.writeContent(conceptMangegerString);
        NameFile.finished();
        attatchConceptFile();

    }

    private static String edit(String string)
    {
        string= removeConceptManager(string);
        System.out.println(string);
        return string;
    }

    private static String removeConceptManager(String string)
    {
        int semiColon=(string.indexOf(":")+1);
        return string.substring(semiColon,string.length());
    }

    private static void attatchConceptFile()
    {
        conceptFile=new File(nameFile.getNameFile()+"_conceptManager.txt");
        try(PrintWriter printWriter = new PrintWriter(conceptFile)) {
            printWriter.println(conceptManager.toString());


        }
        catch (FileNotFoundException e)
        {
            System.out.println("File Not Found");

        }


    }

}
