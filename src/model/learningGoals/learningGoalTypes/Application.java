package model.learningGoals.learningGoalTypes;

/**
 * Created by siddgupta on 8/26/16.
 */
public class Application extends LearningGoal {


    public Application() {
        super("Examine","Interpret","Manipulate","Predict","Evaluate","Application");
    }

    public Application(String concept)
    {
        super("Examine","Interpret","Manipulate","Predict","Evaluate","Application",concept);
    }
}
