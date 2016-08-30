package model.learningGoals.learningGoalTypes;

/**
 * Created by siddgupta on 8/26/16.
 */
public class Evaluation extends LearningGoal{

    public Evaluation() {
        super("Arrange","Define","Describe","Identify","Relate","Evaluation");
    }

    public Evaluation(String concept)
    {
        super("Arrange","Define","Describe","Identify","Relate","Evaluation",concept);
    }


}
