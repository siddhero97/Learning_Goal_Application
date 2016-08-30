package model.learningGoals.learningGoalTypes;

/**
 * Created by siddgupta on 8/26/16.
 */
public class Analysis extends LearningGoal {

    public Analysis() {
        super("Experiment","Appraise","Examine","Deduce","Inspect","Analysis");
    }

    public Analysis(String concept)
    {
        super("Experiment","Appraise","Examine","Deduce","Inspect","Analysis",concept);
    }
}
