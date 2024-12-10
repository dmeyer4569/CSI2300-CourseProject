import java.awt.*;
import javax.swing.*;
//Homepage GUI is working
public class HomePageGUI extends JPanel {
    public HomePageGUI(CardLayout cardLayout, JPanel cardPanel) {
        //layout for HomePage
        setLayout(new GridLayout(2, 3, 5, 5));

        //butons
        JButton addMainGoalButton = new JButton("Create a Main Goal");
        JButton addMinorGoalButton = new JButton("Add a Minor Goal to a Main Goal");
        JButton removeMinorGoalButton = new JButton("Remove a Minor Goal from a Main Goal");
        JButton showGoalsButton = new JButton("Display Main Goals with representative Minor Goal");
        JButton exitApplicationButton = new JButton("Exit Application");

        //button functionality to switch between pages
        addMainGoalButton.addActionListener(e -> cardLayout.show(cardPanel, "AddMainGoal"));
        addMinorGoalButton.addActionListener(e -> cardLayout.show(cardPanel, "AddMinorGoal"));
        removeMinorGoalButton.addActionListener(e -> cardLayout.show(cardPanel, "RemoveMinorGoal"));
        showGoalsButton.addActionListener(e -> cardLayout.show(cardPanel, "ShowGoals"));
        exitApplicationButton.addActionListener(e -> System.exit(0));

        //add buttons to panel
        add(addMainGoalButton);
        add(addMinorGoalButton);
        add(removeMinorGoalButton);
        add(showGoalsButton);
        add(exitApplicationButton);

        //try to put image in bottom right corner (space filler cause I only have 5 buttons)
        ImageIcon spaceFiller = new ImageIcon("C:\\Users\\Devin\\Desktop\\CSI2300FALL24\\FinalProjects\\randomstuff\\emptySpaceFiller.JPG");
        JLabel spaceFillerLabel = new JLabel(spaceFiller);
        add(spaceFillerLabel);

        //was used to figure out why page didn't display in the beginning
        System.out.println("HomePageGUI created successfully.");
    }
}
