package model.concept;

import java.util.Scanner;

/**
 * Created by siddgupta on 8/29/16.
 */
public class FactoryUnderstandingLevelRequiredFactory {

    private Scanner input=new Scanner(System.in);
    private UnderstandingLevelRequired understandingLevelRequired;

    public FactoryUnderstandingLevelRequiredFactory()
    {
        factoryUnderstandingLevelRequired();
    }

    private void factoryUnderstandingLevelRequired()
    {
        System.out.println("Rate importance of concept/mini Concept \n from 1(low importance) to 5(high importance) \n Else Choose 6(for hints) ");
        int choice=choose();

        if(choice==6) {
            menu();
            System.out.println("Type In A Number between 1 and 5");
            int newChoice=choice;
            createNewFactory(newChoice);


        }
        else if((choice>=1) &&(choice<=5))
            createNewFactory(choice);
    }

    private int choose()
    {
        return input.nextInt();
    }


    private void menu()
    {
        option(1,"Knowledge/Recall: \n Basic Definitons And Descriptions of concepts \n");
        option(2,"Comprehension/Reproduce: \n Everything Above And: \n Displaying basic information when required \n");
        option(3,"Skills/Application: \n Everything Above and: \n Real life application of comprehended knowledge \n");
        option(4,"Analysis/Thinking Short Term : \n Everything above and: \n a) Thoroughly examining the internal/intrinsic details \n b) the immediate benifits of the knowledge gained on a societical or productivity, efficiency or effectivity level \n");
        option(5,"Thinking Long Term/Synthesis And Evaluation: \n Everything Above and: \n a) Figuring out the disadvantages and advantages of a system, process, principle or rule \n b) Summarizing (concisely) all aspects (usually used if you are going to have a lot of analysis)  ");


    }

    private void createNewFactory(int choice)
    {

        switch (choice)
        {
            case 1:
                understandingLevelRequired=UnderstandingLevelRequired.RECALL;
                break;
            case 2:
                understandingLevelRequired=UnderstandingLevelRequired.REPRODUCE;
                break;
            case 3:
                understandingLevelRequired=UnderstandingLevelRequired.SKILLS;
                break;
            case 4:
                understandingLevelRequired=UnderstandingLevelRequired.THINKINGSHORTTERM;
                break;
            case 5:
                understandingLevelRequired=UnderstandingLevelRequired.THINKINGLONGTERM;
                break;
            default:
                factoryUnderstandingLevelRequired();
                break;
        }

    }

    private void option(int optionNumber,String action)
    {
        System.out.println(optionNumber+" ) "+action);

    }

    public UnderstandingLevelRequired getUnderstandingLevelRequired() {
        return understandingLevelRequired;
    }

    public void setUnderstandingLevelRequired(UnderstandingLevelRequired understandingLevelRequired) {
        this.understandingLevelRequired = understandingLevelRequired;
    }
}
