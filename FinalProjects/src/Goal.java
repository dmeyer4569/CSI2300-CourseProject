/*
 * This file has funcitonality for creating goals etc... 
 * Functionality was tested with TaskManager.java
 */

import java.util.ArrayList;
import java.util.List;
//Goal GUI is working
public class Goal {
    private String mainGoal;
    private ArrayList<String> minorGoals;
    private ArrayList<String> minorGoalsDesc;
    private ArrayList<Integer> minorGoalsImportance;
        
    public static List<Integer> mainGoals = new ArrayList<>();
    
    public Goal(String mainGoal) {
        this.mainGoal = mainGoal;
        this.minorGoals = new ArrayList<>();
        this.minorGoalsDesc = new ArrayList<>();
        this.minorGoalsImportance = new ArrayList<>();
    }

    
    // getter methods
    public static List <String> getMinorGoalsList(String mainGoal){
        return MainGoal.getGoal(mainGoal).minorGoals;
    }
    public static String getMinorGoal(String mainGoal, Integer index){
        return MainGoal.getGoal(mainGoal).minorGoals.get(index);
    }
    public static String getMinorGoalDesc(String mainGoal, Integer index){
        return MainGoal.getGoal(mainGoal).minorGoalsDesc.get(index);
    }
    public static String getMinorGoalImportance(String mainGoal, Integer index){
        return MainGoal.getGoal(mainGoal).minorGoalsImportance.get(index).toString();
    }


    //creating minor goal to a main goal
    //add minor goal name, description and importance from 1-5
    //If description is left blank put N/A 
    public void addMinorGoal(String minorGoal, String minorGoalDesc, Integer minorGoalImportance) {
        minorGoals.add(minorGoal);
        if (minorGoalDesc.isBlank()){
            minorGoalsDesc.add("N/A");
        }
        else {
            minorGoalsDesc.add(minorGoalDesc);
        }
        if (minorGoalImportance == null){
            minorGoalsImportance.add(0);
        }
        else {
            minorGoalsImportance.add(minorGoalImportance);
        }
    }

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