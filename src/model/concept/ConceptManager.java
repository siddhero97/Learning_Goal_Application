package model.concept;

import java.util.*;

/**
 * Created by siddgupta on 8/12/16.
 */
public class ConceptManager {

    private List<Concept> concepts;

    private boolean hasLimit;
    private int limit;

    public ConceptManager()
    {
        limit=0;
        hasLimit=false;
        concepts=new ArrayList<>();
        hasLimit();
        addConcept();
     //   attatchConceptFile();
    }

    private void addConcept() {
        char choice;

        do {
            printingConceptOptions();
            choice = receiveOption();

            if (choice != ('q' | 'Q')) {
                System.out.println("Limit is " + limit);
                System.out.println("Concept size is " + concepts.size());

                if (choice == ('a' | 'A')) {

                    if (hasLimit)
                        if (limit <= concepts.size()) {
                            System.out.println("ARE YOU COMPLETED YET");
                            menu();
                        } else {
                            try {
                                System.out.println(limit - concepts.size() + " left !!!");
                                attatchConcept();
                            } catch (IndexOutOfBoundsException e) {
                                System.out.println(" ! ! ! ");
                                choice = 'q';
                            }
                        }
                } else
                    wrongOption();


            } else
                System.out.println("Looks Like You Are Done");



        } while (choice != ('q' | 'Q'));
        quit();
       // System.out.println(this.toString());
    }

    private void quit()
    {
        System.out.println("Quitting ...");

    }

    private void printingConceptOptions()
    {
        press('a'," Add Concept ");
        press('q'," Stop Adding Content ");
    }

    private char receiveOption()
    {
        Scanner input=new Scanner(System.in);
        char choice=input.next().trim().charAt(0);
        return choice;
    }

    private void wrongOption()
    {
        System.out.println("You Pressed the wrong option");
        System.out.println("Would You Like To: ");
        addConcept();
    }

    private void attatchConcept()
    {
        Concept concept = new Concept();
        System.out.println("Concept is added");
        concepts.add(concept);
    }



    private void hasLimit()
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Press c/C in order to create a limit on concepts");
        if(input.next().charAt(0)==('c'|'C'))
        {
            hasLimit=true;
            System.out.println("Type in a limit (whole number ie. 1,2,3)");
            limit=input.nextInt();
        }
        else
            System.out.println("Limit Not created");

    }


    private void menu()
    {
        char choice;
        do {
            printingOptions();
           choice = receiveOption();
            if(choice!=('q'|'Q'))
            chooseOptions(choice);
        }while(choice!=('q'|'Q'));

    }



    private void printingOptions()
    {
        press('a',"increase limit");
        press('q'," Quit ");
    }

    private void press(char option,String string)
    {
        char capOption=(" "+option).toUpperCase().trim().charAt(0);
        System.out.println("Press "+option+" or "+capOption+" to "+string);

    }

    private void chooseOptions(char choice)
    {
        switch (choice)
        {
            case 'a':
            case 'A':
                increaseLimit();
                break;
            default:
                System.out.println("Wrong option Pleease try again");
                menu();
                break;
        }
    }

    private void increaseLimit()
    {
        limit++;
        addConcept();
    }

    @Override
    public String toString()
    {
        String string="";
        if(!(concepts.isEmpty() || concepts==null)) {
            string+=iterateConcepts();
        }
        else {
            string = " No Concepts In Concept Manager";
        }

        return string;
    }



    private String iterateConcepts()
    {
        String str=" ";
       for(int i=0;i<concepts.size();i++)
       {
           Concept concept= concepts.get(i);
           str=str+(i+1)+") "+concept.toString()+" \n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  \n \n";
       }

        return str;

    }




}
