import java.util.ArrayList;
//Minor Goal is working
public class MinorGoal{
    private final static ArrayList<String> dropDownGoalList = new ArrayList<>();

    //method to add Main Goal to List and create Main Goal
    public MinorGoal(String mainGoal, String minorGoal, String minorGoalDesc, Integer importance){

        System.out.println("Creating minorGoal"+ minorGoal);
        MainGoal.getGoal(mainGoal).addMinorGoal(minorGoal, minorGoalDesc,importance);
        dropDownGoalList.add(minorGoal);
        
    }

    static void removeMinorGoal(String selectedMainGoal, String selectedMinorGoal) {

        for (int i = 0; i< Goal.getMinorGoalsList(selectedMainGoal).size(); i++){
            if (Goal.getMinorGoalsList(selectedMainGoal).get(i).equals(selectedMinorGoal)){
                MainGoal.getGoal(selectedMainGoal).removeMinorGoal(i);
            }
        }

        System.out.println(selectedMainGoal+selectedMinorGoal);
    }
}



