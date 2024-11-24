import java.util.ArrayList;

public class Goal {
    private String mainGoal;
    private ArrayList<String> minorGoals;
    private ArrayList<String> minorGoalsDesc;
    private ArrayList<String> minorGoalsImportance;

    public Goal(String mainGoal) {
        this.mainGoal = mainGoal;
        this.minorGoals = new ArrayList<>();
        this.minorGoalsDesc = new ArrayList<>();
        this.minorGoalsImportance = new ArrayList<>();
    }
    // getter methods
    public String getMainGoal() {return mainGoal;}

    //creating minor goal to a main goal
    //add minor goal name
    public void addMinorGoal(String minorGoal) {minorGoals.add(minorGoal);}
    //add description of minor goal
    public void addMinorGoalDesc(String minorGoalDesc) {minorGoalsDesc.add(minorGoalDesc);}
    //add importance of minor goal
    public void addMinorGoalImportance(String minorGoalImportance){minorGoalsImportance.add(minorGoalImportance);}
    //remove minor goal
    public void removeMinorGoal(int minorGoal){
        minorGoals.remove(minorGoal);
        minorGoalsDesc.remove(minorGoal);
        minorGoalsImportance.remove(minorGoal);
    }



    public void displayGoals() {
        System.out.println("main goal: " + mainGoal);
        System.out.println("minor goal;");
        int minorGoalNo = 1;
        if (minorGoals.isEmpty()) { System.out.println("n/a "); } 
        else {
            for (int i = 0; i < minorGoals.size(); i++) {
                System.out.print(minorGoalNo+": "+minorGoals.get(i)+",");
                System.out.print(minorGoalsDesc.get(i)+",");
                System.out.print(minorGoalsImportance.get(i)+"\n");
                minorGoalNo++;
            }
        }
    }
}
