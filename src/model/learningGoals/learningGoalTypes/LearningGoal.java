package model.learningGoals.learningGoalTypes;

import java.io.*;
import java.util.*;

/**
 * Created by siddgupta on 8/12/16.
 */
public abstract class LearningGoal {

    protected String name;
    protected Scanner scanner;
    public String message;
    protected boolean exit=false;
    protected List<String> keyVerbs;
    protected String concept;
    private String keyVerb;
    private File file;


    public LearningGoal(String s1,String s2,String s3,String s4,String s5,String name)
    {
        scanner=new Scanner(System.in);
        keyVerbs=new ArrayList<>();
        this.name=name;

        makeFile();
        if(fileCreater())
            System.out.println();
        else
            createFile(new String[]{s1,s2,s3,s4,s5});


        changeKeyVerbListHandler();
        makeLearningGoal();

    }



    public LearningGoal(String s1,String s2,String s3,String s4,String s5,String name,String concept)
    {
        this.concept=concept;
        scanner=new Scanner(System.in);
        keyVerbs=new ArrayList<>();
        this.name=name;

        makeFile();
        if(fileCreater())
            System.out.println();
        else
            createFile(new String[]{s1,s2,s3,s4,s5});


        changeKeyVerbListHandler();
        makeLearningGoal();

    }

    private boolean fileCreater()
    {
        if(file.exists()) {
            readData();
            return true;
        }
        else {
            return false;
        }


    }

    private void readData()
    {
        try(Scanner scanner=new Scanner(file))
        {
            while(scanner.hasNextLine())
            {
                keyVerbs.add(scanner.nextLine());
            }
        }
        catch (FileNotFoundException e)
        {
            printFileNotFoundExeption();
        }

    }
    private void createFile(String[] strings)
    {
        makeFile();
        addToKeyVerbsList(strings);
       printOntoFile();
    }

    private void printOntoFile()
    {
        try(PrintWriter printWriter=new PrintWriter(file))
        {
            for(String str:keyVerbs)
                printWriter.println(str);
        }
        catch (FileNotFoundException e)
        {

            printFileNotFoundExeption();
        }

    }

    private void makeFile()
    {
        String fileName=name+".txt";
        file=new File(fileName);

    }


    private void printFileNotFoundExeption()
    {
        System.out.println("File "+file.getName()+" not found");

    }



    private void makeLearningGoal()
    {


        if(keyVerbs.size()>=1) {
            printAllVerbs();
            System.out.println("Choose a KeyVerb");
            int choice = promptChoice();
            keyVerb = keyVerbs.get(choice);
        }
        else
            keyVerb=keyVerbs.get(0);

     //   keyVerb=keyVerbs.get(0);
        question();
        message=keyVerb+" ";
        String attatchment=makeMessage();

        if(attatchment!=null)
            message=message+ attatchment;

       // System.out.println(message);

    }

    private String makeMessage()
    {
        String message=concept;
       // System.out.println(message);
        System.out.println("Press 'a/A' if this is your message, \n press b/B to completely change it, \n press c/C to add on to your original mesage ");
        switch (scanner.next().trim().charAt(0))
        {
            case 'a':
            case 'A':
                return message;
            case 'b':
            case 'B':
                System.out.println("Type in message");
                scanner=new Scanner(System.in);
                message=scanner.nextLine();
               // System.out.println(message);
                return message;
            case 'c':
            case 'C':
                System.out.println("Type in attachment");
                Scanner scanner=new Scanner(System.in);
                String attatchment=" "+scanner.nextLine();
                attatchment= message+attatchment;
              //  System.out.println(attatchment);
                return attatchment;
            default:
                makeMessage();
        }
        return  null;
    }

    private void question()
    {
       // System.out.println("Do you want to "+keyVerb+" "+concept+"?");
       // System.out.println(" Learning Goal");
        System.out.println(keyVerb+" "+concept);
    }

    private void addToKeyVerbsList(String[] strings)
    {

        for(int i=0;i<strings.length;i++)
            keyVerbs.add(strings[i]);

    }

    private void changeKeyVerbListHandler() {
        printAllVerbs();
        char choice;
        do {

            System.out.println("Press a/A to change keyVerb");
            System.out.println("Press b/B to add keyVerb");
            System.out.println("Press c/C to delete KeyVerb");
            System.out.println("Press q/Q to escape loop");
            choice=scanner.next().trim().charAt(0);

            if(choiceBoolean(choice,'a'))
            changeKeyVerbList();

            else if(choiceBoolean(choice,'b'))
                addKeyVerb();

            else if(choiceBoolean(choice,'c'))
                deleteKeyVerb();

            else if(!choiceBoolean(choice,'q')) {
                System.out.println("Sorry "+choice+" is a wrong option");
                changeKeyVerbListHandler();
            }

        }while (choice!=('q'|'Q'));

    }

    private void changeKeyVerbList()
    {
        int choice= deleteKeyVerb();
        addKeyVerb(choice);

    }
    private void addKeyVerb()
    {
        System.out.println("Type in the Key Word That You Want To add");
        String keyVerb=scanner.next().trim();
        char firstCar=(((keyVerb.trim().charAt(0))+"").toUpperCase()).charAt(0);
        keyVerb=keyVerb.substring(1,keyVerb.length());
        keyVerb=firstCar+keyVerb;
        keyVerbs.add(keyVerb);
        addToFile(keyVerb);
    }

    private void addToFile(String string)
    {

        try(FileWriter fileWritter = new FileWriter(file,true)) {
            try (BufferedWriter bufferWritter = new BufferedWriter(fileWritter)) {
                bufferWritter.write(string);


        }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void addKeyVerb(int choice)
    {
        System.out.println("Type in the Key Word That You Want To add");
        String keyVerb=scanner.next().trim();
        keyVerbs.add(choice,keyVerb);
    }

    private int deleteKeyVerb()
    {

        printAllVerbs();
        int choice=promptChoice();
        keyVerbs.remove(choice);
        removeLineFromFile(keyVerbs.get(choice));
        return choice;

    }

    public void removeLineFromFile(String lineToRemove) {

        // Construct the new temporary file that will later be renamed to the original
        // filename.
        File tempFile = new File(file.getAbsolutePath() + ".tmp");

        //Two Embedded Automatic Resource Managers used
        // to effectivey handle IO Responses
        try(Scanner scanner = new Scanner(file)) {
            try (PrintWriter pw = new PrintWriter(new FileWriter(tempFile))) {

                //a declaration of a String Line Which Will Be assigned Later
                String line;

                // Read from the original file and write to the new
                // unless content matches data to be removed.
                while (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                    if (!line.trim().equals(lineToRemove)) {

                        pw.println(line);
                        pw.flush();
                    }
                }
                // Delete the original file
                if (!file.delete()) {
                    System.out.println("Could not delete file");
                    return;
                }

                // Rename the new file to the filename the original file had.
                if (!tempFile.renameTo(file))
                    System.out.println("Could not rename file");
            }
        }
        catch (IOException e)
        {
            System.out.println("IO Exception Occurred");
        }

    }

    private int promptChoice()
    {
        System.out.println("Type a whole number ie. 1 or 2");
        Scanner scanner=new Scanner(System.in);
        int choice=(scanner.nextInt()-1);
        return choice;
    }



    private void printAllVerbs()
    {
        for (int i = 0; i < keyVerbs.size(); i++)
            System.out.println((i+1)+")"+keyVerbs.get(i));
    }

    private boolean choiceBoolean(char choice,char option)
    {
        char upperCaseOption=(option+" ").toUpperCase().trim().charAt(0);
        return (choice==(upperCaseOption|option));

    }


    protected void setName(String name)
    {
        this.name=name;
    }


    private void press(char choice,String s)
    {
        char capChoice=(""+choice).toUpperCase().trim().charAt(0);
        System.out.println("Press "+choice+"/"+capChoice+" to set keyVerb to "+s);

    }


    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return  name;
    }


}
