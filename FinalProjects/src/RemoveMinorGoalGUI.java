import java.awt.*;
import javax.swing.*;
//RemoveMinorGoals is working
public class RemoveMinorGoalGUI extends JPanel {
    public RemoveMinorGoalGUI(CardLayout cardLayout, JPanel cardPanel, JComboBox<String> mainGoalDropdown, JComboBox<String> minorGoalDropdown){
        setLayout(new GridLayout(4,2,5,5));
        JButton removeMinorGoal = new JButton("Remove");
        JButton confirmMainGoal = new JButton("Confirm Goal");
        JButton removeMinorGoalToHomePage = new JButton("Home");

        //give functionality to buttons
        confirmMainGoal.addActionListener(e ->{
            String selectedMainGoal = (String) mainGoalDropdown.getSelectedItem();
            refreshMinorGoals(minorGoalDropdown, selectedMainGoal);
        });
        //will remove selected goal
        removeMinorGoal.addActionListener(e -> {
            if (minorGoalDropdown != null){
                String selectedMainGoal = (String) mainGoalDropdown.getSelectedItem();
                String selectedMinorGoal = (String) minorGoalDropdown.getSelectedItem();
                MinorGoal.removeMinorGoal(selectedMainGoal, selectedMinorGoal);

                // refreshes minor goal list after an item has been removed
                refreshMinorGoals(minorGoalDropdown, selectedMainGoal);
            }


        });

        removeMinorGoalToHomePage.addActionListener(e -> cardLayout.show(cardPanel, "Home"));
        //add to remove minor goal page layout
        add(new JLabel("Chose Major Goal: "));
        add(mainGoalDropdown);
        add(new JLabel("Confirm Main Goal"));
        add(confirmMainGoal);
        add(new JLabel("Chose Minor Goal: "));
        add(minorGoalDropdown);
        add(removeMinorGoal);
        add(removeMinorGoalToHomePage);
    }

    public void refreshMinorGoals(JComboBox<String> minorGoalDropdown, String selectedMainGoal){
        if (minorGoalDropdown != null) {
            minorGoalDropdown.removeAllItems();
            System.out.println("Items removed");
        }
        //update minorgoal dropdown to make sure everything is in
        for (String goal : Goal.getMinorGoalsList(selectedMainGoal)) {
            minorGoalDropdown.addItem(goal);
            System.out.println("Items added"+ goal);

        }
    }
}
