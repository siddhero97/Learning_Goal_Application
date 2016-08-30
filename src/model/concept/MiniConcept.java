package model.concept;

import model.learningGoals.LearningGoalManager;

import java.util.Scanner;

/**
 * Created by siddgupta on 8/20/16.
 */
public class MiniConcept {

    protected boolean isComplete;
    protected String name;
    private LearningGoalManager learningGoalManager;

    public MiniConcept()
    {
        Scanner input=new Scanner(System.in);
        type("name");
        name= input.nextLine();
        createUnderstandingFactory();

    }

    protected void type(String action)
    {
        System.out.println("Type in "+action);
    }

    private void createUnderstandingFactory()
    {
        FactoryUnderstandingLevelRequiredFactory factoryUnderstandingLevelRequiredFactory =new FactoryUnderstandingLevelRequiredFactory();
        UnderstandingLevelRequired understandingLevelRequired =factoryUnderstandingLevelRequiredFactory.getUnderstandingLevelRequired();
        learningGoalManager= new LearningGoalManager(understandingLevelRequired,name);
    }

    public LearningGoalManager getLearningGoalManager() {
        return learningGoalManager;
    }

    public void setLearningGoalManager(LearningGoalManager learningGoalManager) {
        this.learningGoalManager = learningGoalManager;
    }
}
