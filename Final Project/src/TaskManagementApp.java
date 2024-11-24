import java.util.ArrayList;
import java.util.Scanner;



/*
 * GUI will be implemented last
 * 
 * working on basic terminal functionality first
 * 
 * this will allow user to create main goals, add a minor goal to the main goal and remove main/minor goals
 * 
 * system.out.print is used for me to keep track if the code works. once the GUI is made this will be changed
 */
public class TaskManagementApp {

    static class Goal {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Goal> goals = new ArrayList<>();
        System.out.println("app start");
        int mainGoalIndex;


        //runs code until user quits/exits
        while (true) {

            System.out.println("\n1add main goal");
            System.out.println("2add minor goal");
            System.out.println("3delete minor goal");
            System.out.println("4shiow goals");
            System.out.println("5quit");
            System.out.print(":"); 
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                //add main goal
                case 1: 
                    System.out.print("Enter a main goal: ");
                    String mainGoalInput = scanner.nextLine();
                    goals.add(new Goal(mainGoalInput));
                    System.out.println("Main goal added!");
                    break;

                //add minor goal 
                case 2: 
                    if (goals.isEmpty()) {
                        System.out.println("n/a main goal");
                        break;
                    }

                    System.out.println("main goal select");
                    for (int i = 0; i < goals.size(); i++) { System.out.println((i + 1) + ". " + goals.get(i).getMainGoal()); }
                    System.out.print("chose main goal ");
                    mainGoalIndex = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (mainGoalIndex >= 0 && mainGoalIndex < goals.size()) {
                        System.out.print("minor goal name:  ");
                        String minorGoal = scanner.nextLine();
                        goals.get(mainGoalIndex).addMinorGoal(minorGoal);
                        System.out.print("minor goal description: ");
                        String minorGoalDesc = scanner.nextLine();
                        goals.get(mainGoalIndex).addMinorGoalDesc(minorGoalDesc);
                        System.out.print("minor goal importance: ");
                        String minorGoalImport = scanner.nextLine();
                        goals.get(mainGoalIndex).addMinorGoalImportance(minorGoalImport);
                        System.out.println("success");
                    } 
                    else { System.out.println("error");}
                    break;
                
                //delete minor goal
                case 3:
                    if (goals.isEmpty()) {
                        System.out.println("n/a goals");
                        break;
                    }
                    for (int i = 0; i < goals.size(); i++) { System.out.println((i + 1) + ". " + goals.get(i).getMainGoal());}

                    System.out.println("chose main goal: ");
                    mainGoalIndex = scanner.nextInt() - 1;

                    for (int i = 0; i < goals.size(); i++) {
                        System.out.println("\ngoal - " + (i + 1) + ":");
                        goals.get(i).displayGoals();
                    }
                    int minorGoalIndex = scanner.nextInt() - 1;
                    goals.get(mainGoalIndex).removeMinorGoal(minorGoalIndex);
                    System.out.println("removed sueccess");


                    break;
                //show all goals
                case 4: 
                    if (goals.isEmpty()) {System.out.println("n/a goals");}

                    else {
                        for (int i = 0; i < goals.size(); i++) {
                            System.out.println("\ngoal - " + (i + 1) + ":");
                            goals.get(i).displayGoals();
                        }
                    }
                    break;

                //quit while loop/exit app
                case 5: 
                    System.out.println("quit app");
                    return;
                //user error message if number is invalid
                default:
                    System.out.println("invalid choice");
            }
        }
    }
}
