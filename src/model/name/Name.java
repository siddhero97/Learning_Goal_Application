package model.name;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by siddgupta on 8/11/16.
 */
public class Name {

    private Scanner input;
    private File filetxt;
    private String name;

    Name() {
        filetxt = new File("filename.txt");
        input = new Scanner(System.in);

        repOk();

    }


    void setName() {
        System.out.println("Please type in your name");
        Scanner scanner=new Scanner(System.in);
        name = scanner.nextLine();
        System.out.println("name = " + name);
        try {
            try (PrintWriter out = new PrintWriter(filetxt)) {
                out.println(name);
            }
        } catch (IOException e) {
            System.out.println("FileNotFoundException");
        }
    }

    void setName2() {

        readFile();
        System.out.println("Press a/A in order to choose " + name + " else choose b/B in order to chose another name");
        char c = input.next().charAt(0);
        switch (c) {
            case 'a':
            case 'A':
                break;
            case 'b':
            case 'B':
                setName();
                break;
        }
    }

    private void customName() {
        try {
            name = new String(Files.readAllBytes(Paths.get("filename.txt")));
            System.out.println("name = " + name);
        } catch (IOException e) {
            System.out.println("name = " + name);
        }
    }


    private void repOk() {
        try {
            if (!filetxt.exists()) {
                filetxt.createNewFile();
                setName();
            } else {
                System.out.println("File Already Exists");
                setName2();
            }

        } catch (FileNotFoundException f) {
            System.out.println("The fileOutStreamFunction worked");
        } catch (IOException e) {
            System.out.println("The File Couldn't be created");
        }

    }

    public String getName() {
        return name;
    }

    private void readFile() {
        try {
            Scanner scanner=new Scanner(new File("filename.txt"));

            if(scanner.hasNextLine()) {
                name= scanner
                        .useDelimiter("\\A").next();

                System.out.println(name);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("FileNotFoundException");
        }
    }
}
