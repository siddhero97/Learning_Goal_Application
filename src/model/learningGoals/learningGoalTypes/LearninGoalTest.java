package model.learningGoals.learningGoalTypes;

import model.concept.UnderstandingLevelRequired;
import model.learningGoals.LearningGoalManager;

/**
 * Created by siddgupta on 8/27/16.
 */
public class LearninGoalTest {


    public static void main(String[] args) {

        /*
        LearningGoal learningGoal=new Analysis("Waves");
        String message=learningGoal.getMessage();
        System.out.println(message);
        */




        LearningGoalManager learningGoalManager=new LearningGoalManager(UnderstandingLevelRequired.REPRODUCE," Waves ");
        String learningString=learningGoalManager.toString();
        System.out.println(learningString);


        /*
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("Hello");
        System.out.println(stringArrayList.get(0));
        */


    }
}
