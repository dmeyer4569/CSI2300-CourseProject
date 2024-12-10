import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//MainGoal is working
public class MainGoal{
    final private static ArrayList<Goal> mainGoalsList = new ArrayList<>();
    final private static ArrayList<String> dropDownGoalsList = new ArrayList<>();
    final private static Map<String, Goal> goalMap = new HashMap<>();
    //method to add Main Goal to List and create Main Goal
    public MainGoal(String addMainGoal){
        mainGoalsList.add(new Goal(addMainGoal));
        dropDownGoalsList.add(addMainGoal);
        goalMap.put(addMainGoal, mainGoalsList.get(mainGoalsList.size()-1));
        
    }

    public static Goal getGoal(String goalName){
        Goal selectedGoal = goalMap.get(goalName);
        return selectedGoal;
    }

    public static List<String> getMainGoalsList() {return dropDownGoalsList;}
}



