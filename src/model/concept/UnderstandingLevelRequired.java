package model.concept;

/**
 * Created by siddgupta on 8/20/16.
 */
public enum UnderstandingLevelRequired {



    RECALL(1),REPRODUCE(2),SKILLS(3),THINKINGSHORTTERM(4),THINKINGLONGTERM(5);

    final int importance;

     UnderstandingLevelRequired(int importance)
    {
        this.importance=importance;
    }

    public int getImportance() {
        return importance;
    }
}
