package model.concept;

import model.learningGoals.LearningGoalManager;

import java.util.*;

/**
 * Created by siddgupta on 8/12/16.
 */
public class Concept {

    protected boolean isComplete;
    protected String name;
    private List<MiniConcept> miniConcepts;
    private boolean hasMiniConcept;
    private static boolean miniConceptSet;
    private boolean hasLearningGoal;
 //   private UnderstandingLevelRequired understandingLevelRequired;
    private Scanner input;
    private LearningGoalManager learningGoalManager;



    public Concept()
    {

        input=new Scanner(System.in);

        type("name");
        name= input.nextLine();

       if(!miniConceptSet)
           setHasMiniConcept(input);

        hasLearningGoal=false;

        if(miniConcepts==null)
            hasLearningGoal=true;


        if(hasLearningGoal)
        {
            FactoryUnderstandingLevelRequiredFactory factoryUnderstandingLevelRequiredFactory =new FactoryUnderstandingLevelRequiredFactory();
            UnderstandingLevelRequired understandingLevelRequired =factoryUnderstandingLevelRequiredFactory.getUnderstandingLevelRequired();
            learningGoalManager= new LearningGoalManager(understandingLevelRequired,name);
        }


    }

    private void setHasMiniConcept(Scanner input)
    {
        miniConceptSet=true;
        press('w'," has mini Concepts");
        char choice;
        choice=input.next().trim().charAt(0);
        if(choice==('w'|'W')) {
            miniConcepts = new ArrayList<>();
            hasMiniConcept = true;
            addMiniConcept();
        }

        hasLearningGoal=false;
    }


    protected void press(char choice,String action)
    {
        char capChoice=(choice+"").toUpperCase().charAt(0);
        System.out.println("Press "+choice+" or "+capChoice+" to "+action);
    }

    protected void type(String action)
    {
        System.out.println("Type in "+action);
    }



    private char setChoice()
    {
        Scanner input=new Scanner(System.in);
        char choice=input.next().charAt(0);
        return choice;
    }

    private void addMiniConcept()
    {
        char choice;
        if(hasMiniConcept) {

            if(miniConcepts.size()==0) {
                attatchConcept();
            }

            do {

                    press('r', " add mini Concepts");
                    choice = setChoice();

                    if (choice == ('r' | 'r'))
                        attatchConcept();
                    else
                        System.out.println("miniConcept not created");


            } while (choice == ('r' | 'r'));
            miniConceptSet=false;
        }


    }

    private void attatchConcept()
    {
        MiniConcept miniConcept=new MiniConcept();
        boolean successfulAdd= miniConcepts.add(miniConcept);

        if(successfulAdd)
        System.out.println("miniConcepts created successfully");
        else
            System.out.println("miniConcept not attatched successfully");

    }


    public void complete()
    {
        isComplete =true;
    }

    public void isComplete()
    {
        if(isComplete)
            System.out.println(createCompleteString(""));
        else
            System.out.println(createCompleteString("not"));

    }

    private String createCompleteString(String str)
    {
        String completed="Concept No."+"-"+name+" is "+str+" completed";
        return completed;
    }

    @Override
    public String toString()
    {
        String str;
       str=this.name+"\n";

        if(learningGoalManager!=null)
        {
            String string=learningGoalManager.toString();
            str=str+"\t"+string+"\t";
        }

        else if(!miniConcepts.isEmpty())
                str = str + iterateMiniConcepts();

        return str;

    }




    private String iterateMiniConcepts()
    {
        String str=" ";
        for(int i=0;i<miniConcepts.size();i++)
        {
            MiniConcept miniConcept= miniConcepts.get(i);
          //  System.out.println(miniConcept.name);
            str=str+getRoman(i+1)+") "+miniConcept.name+" \n ";
            String string=miniConcept.getLearningGoalManager().toString();
            str=str+"\n"+string+"\n";
        }

        return str;

    }

    public static String getRoman(int number) {

        String riman[] = {"M","XM","CM","D","XD","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int arab[] = {1000, 990, 900, 500, 490, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (number > 0 || arab.length == (i - 1)) {
            while ((number - arab[i]) >= 0) {
                number -= arab[i];
                result.append(riman[i]);
            }
            i++;
        }
        return result.toString().toLowerCase();
    }


}
