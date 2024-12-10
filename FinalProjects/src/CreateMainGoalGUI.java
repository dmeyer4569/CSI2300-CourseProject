import java.awt.*;
import javax.swing.*;
// Main Goal GUI is working
public class CreateMainGoalGUI extends JPanel {
    public CreateMainGoalGUI(CardLayout cardLayout, JPanel cardPanel, JComboBox<String> mainGoalDropdown, JComboBox<String> minorGoalMainGoalDropdown){

        //setup Panel
        setLayout(new GridLayout(2,2,5,5));
        //buttons & text fields
        JTextField mainGoalField = new JTextField();
        JButton createMainGoalButton = new JButton("Create");
        JButton mainGoalPageToHomePage = new JButton("Home");
    
        //button functionality
        //creates Main Goal
        createMainGoalButton.addActionListener(e -> {
            String mainGoal = mainGoalField.getText();
            if(!mainGoal.isBlank()){
                new MainGoal(mainGoal);
            }
        });
        //returns to homePage
        mainGoalPageToHomePage.addActionListener(e -> {
        // empty dropdown to refill with new goals if any
        if (mainGoalDropdown != null) {
            mainGoalDropdown.removeAllItems();
        }
        // Update dropdown with any newly added main goals
        for (String goal : MainGoal.getMainGoalsList()) {
            mainGoalDropdown.addItem(goal);
            System.out.println("main goal dropdwon"+ goal);
        }
        if (minorGoalMainGoalDropdown != null) {
            minorGoalMainGoalDropdown.removeAllItems();
        }
        // Update dropdown with any newly added main goals
        for (String goal : MainGoal.getMainGoalsList()) {
            minorGoalMainGoalDropdown.addItem(goal);
        }
        cardLayout.show(cardPanel, "Home");
        });
    
        //add components to page layout
        add(new JLabel("Enter Main Goal: "));
        add(mainGoalField);
        add(createMainGoalButton);
        add(mainGoalPageToHomePage);
    }

    

}
