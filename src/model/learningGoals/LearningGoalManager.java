package model.learningGoals;

import model.concept.UnderstandingLevelRequired;
import model.learningGoals.learningGoalTypes.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by siddgupta on 8/25/16.
 */
public class LearningGoalManager {

   // private ArrayList<LearningGoal> learningGoals;
    private ArrayList<String> stringsArrayList;
    private Scanner scanner;
    private UnderstandingLevelRequired understandingLevelRequired;
    private String concept;
    private int count=0;

   public LearningGoalManager(UnderstandingLevelRequired understandingLevelRequired,String concept)
    {
        scanner=new Scanner(System.in);
        stringsArrayList=new ArrayList<>();
        this.concept=concept;
        this.understandingLevelRequired=understandingLevelRequired;

        System.out.println(this.concept);
        System.out.println(stringsArrayList);
        System.out.println(understandingLevelRequired);
        keepCreatingLearningGoals();


    }

    private boolean confirm()
    {
        boolean confirm=false;

        System.out.println("Press a/A to Confirm or \n any other character to not form");
        char choice=scanner.next().charAt(0);
        if(choice==('a'|'A'))
            confirm=true;

        return confirm;
    }

    private void keepCreatingLearningGoals()
    {

        char choice;
        do {
            System.out.println("Press a/A to create a LearningGoal or press q/Q to stop create Learning Goals");
            choice=scanner.next().charAt(0);
            switch (choice) {
                case 'a':
                case 'A':
                    factory(understandingLevelRequired.getImportance());
                    break;
                case 'q':
                case 'Q':
                    break;
            }

        }while (choice!=('q'|'Q'));
    }

    private void createMenu()
    {

        char choice=' ';
        do {
            if(count==0) {
                factory(understandingLevelRequired.getImportance());
            }
            else {
                choice = menu();
                switch (choice)
                {
                    case 'a':
                    case 'A':
                        factory(understandingLevelRequired.getImportance());
                        break;
                    case 'q':
                    case 'Q':
                        break;
                    default:
                        System.out.println("Wrong option");
                        createMenu();
                        break;
                }
            }

        }while(choice!=('Q'|'q'));
    }

    private char menu()
    {
        char choice;
        System.out.println("Please enter a/A to add another learning goal \n q/Q to quit ");
        choice=scanner.next().trim().charAt(0);
        return choice;
    }

    /*
    public ArrayList<LearningGoal> factory(int i)
    {
       // LearningGoal learningGoal;
        switch (i)
        {
            case 1:
                arrayList(new LearningGoal[]{new Knowledge(concept)} );
                break;
            case 2:
                arrayList(new LearningGoal[]{new Knowledge(concept),new Comprehension(concept)});
                break;
            case 3:
                arrayList(new LearningGoal[]{new Knowledge(concept),new Comprehension(concept),new Application(concept)});
                break;
            case 4:
                arrayList(new LearningGoal[]{new Knowledge(concept),new Comprehension(concept),new Application(concept),new Analysis(concept)});
                break;
            case 5:
                arrayList(new LearningGoal[]{new Knowledge(concept),new Comprehension(concept),new Application(concept),new Analysis(concept),new Synthesis(concept),new Evaluation(concept)});

        }

        return learningGoals;
    }
    */

    private void factory(int importance)
    {
        count++;

        switch (importance)
        {
            case 1:
                menu(new String[]{"Knowledge"});
                break;
            case 2:
                menu(new String[]{"Knowledge","Comprehension"});
                break;
            case 3:
                menu(new String[]{"Knowledge","Comprehension","Application"});
                break;
            case 4:
                menu(new String[]{"Knowledge","Comprehension","Application","Analysis"});
                break;
            case 5:
                menu(new String[]{"Knowledge","Comprehension","Application","Analysis","Synthesis"});
                break;
        }

    }

    private void menu(String[] array)
    {
        if(array.length==1) {
            Knowledge knowledge = new Knowledge(concept);
            stringsArrayList.add(knowledge.getMessage());
        }
        else
        {
           printArray(array);
            String choice=chooseLearningGoalString(array);
            learningGoalFactory(choice);
        }

    }

    private void printArray(String[] array)
    {
        for(int i=0;i<array.length;i++)
            System.out.println((i+1)+" ) "+array[i]);
    }

    private void learningGoalFactory(String s)
    {
        LearningGoal learningGoal;
        switch (s)
        {
            case "Knowledge":
                learningGoal=new Knowledge(concept);
                break;
            case "Comprehension":
                learningGoal=new Comprehension(concept);
                break;
            case "Application":
                learningGoal=new Application(concept);
                break;
            case "Analysis":
                learningGoal=new Analysis(concept);
                break;
            case "Synthesis":
                learningGoal=new Synthesis(concept);
                break;
            case "Evaluation":
                learningGoal=new Evaluation(concept);
                break;
            default:
                learningGoal=null;
        }
        stringsArrayList.add(learningGoal.getMessage());

    }

    private void printLearningGoals()
    {

    }

    private String chooseLearningGoalString(String[] strings)
    {
        System.out.println("Type Option number");
        int optionNumber=scanner.nextInt();
        return strings[optionNumber-1];
    }

    @Override
    public String toString() {
        String allLearningGoal=iterateAllLearningGoalString();
        return allLearningGoal;
    }

    private String iterateAllLearningGoalString()
    {
        String toBePrinted="";
        for(int i=(stringsArrayList.size()-1);i>=0;i--)
        {
          //  String toBePrinted;
            toBePrinted= printAlphabet(i)+" ) "+stringsArrayList.get(i)+"\n"+toBePrinted;
           // System.out.println("toBePrinted = " + toBePrinted);
        }

        return toBePrinted;
    }

    private char printAlphabet(int integer) {
        char c = 'a';
        int i = 0;
        while (c <= 'z' && (i <= integer)) {
            if (i == (integer))
                return c;
            c++;
            i++;

        }
        return 0;

    }
}
