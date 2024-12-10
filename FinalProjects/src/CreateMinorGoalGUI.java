import java.awt.*;
import javax.swing.*;
//Minor Goal GUI is working
public class CreateMinorGoalGUI extends JPanel {
    public CreateMinorGoalGUI(CardLayout cardLayout, JPanel cardPanel, JComboBox<String> minorGoalMainGoalDropdown, JComboBox<String> minorGoalDropdown){
        setLayout(new GridLayout(5,2,5,5));
        JTextField minorGoalNameField = new JTextField();
        JTextField minorGoalDescriptionField = new JTextField();
        JComboBox<Integer> minorGoalImportance = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        JButton createMinorGoalButton = new JButton("Create");
        JButton minorGoalPageToHomePage = new JButton("Home");

        //take the user inputed values and create a minor goal - only if a main goal is selected
        createMinorGoalButton.addActionListener(e -> {
            //get user inputted values 
            String selectedMainGoal = (String) minorGoalMainGoalDropdown.getSelectedItem();
            String userMinorGoalInput = minorGoalNameField.getText();
            String userMinorGoalDescription = minorGoalDescriptionField.getText();
            Integer selectedImportanceLevel = (Integer) minorGoalImportance.getSelectedItem(); 
            //create minor goal if there is a selected main goal and minor goal is not blank
            if (selectedMainGoal != null && !userMinorGoalInput.isBlank()) {
                new MinorGoal(selectedMainGoal, userMinorGoalInput, userMinorGoalDescription,selectedImportanceLevel);
            }
        });
        
        minorGoalPageToHomePage.addActionListener(e -> cardLayout.show(cardPanel, "Home")); //move back to home page

        //add to minor goal page layout
        add(new JLabel("Select Main Goal: "));
        add(minorGoalMainGoalDropdown);
        add(new JLabel("Enter Minor Goal Name: "));
        add(minorGoalNameField);
        add(new JLabel("Enter Minor Goal Description: "));
        add(minorGoalDescriptionField);
        add(new JLabel("Enter Minor Goal Importance: "));
        add(minorGoalImportance);
        add(createMinorGoalButton);
        add(minorGoalPageToHomePage);

    }
}
