package model.learningGoals.learningGoalTypes;

/**
 * Created by siddgupta on 8/26/16.
 */
public class Synthesis extends LearningGoal {

    public Synthesis() {
        super("Arrange","Define","Describe","Identify","Relate","Synthesis");
    }

    public Synthesis(String concept)
    {
        super("Arrange","Define","Describe","Identify","Relate","Synthesis",concept);

    }
}
