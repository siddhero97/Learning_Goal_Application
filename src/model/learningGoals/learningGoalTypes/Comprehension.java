package model.learningGoals.learningGoalTypes;

/**
 * Created by siddgupta on 8/26/16.
 */
public class Comprehension extends LearningGoal {

    public Comprehension() {
        super("Classify","Construct","Contrast","Calculate","Explain","Comprehension");
    }

    public Comprehension(String concept)
    {
        super("Classify","Construct","Contrast","Calculate","Explain","Comprehension",concept);
    }
}
