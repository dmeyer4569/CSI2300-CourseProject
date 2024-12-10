import java.awt.*;
import javax.swing.*;

//TaskManagerGUI is working
public class TaskManagerGUI extends JFrame {

    private CardLayout cardLayout;
    private JPanel cardPanel; 
    private JComboBox<String> minorGoalMainGoalDropdown;
    private JComboBox<String> mainGoalDropdown;
    private JComboBox<String> minorGoalDropdown;
    

    public TaskManagerGUI() {
        // initializing card layout for switche
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // dropdown initialization
        minorGoalMainGoalDropdown = new JComboBox<>();
        mainGoalDropdown = new JComboBox<>();
        minorGoalDropdown = new JComboBox<>();

        //creating each individual page
        JPanel homePage = new HomePageGUI(cardLayout, cardPanel);
        JPanel addMainGoalPage = new CreateMainGoalGUI(cardLayout, cardPanel, mainGoalDropdown, minorGoalMainGoalDropdown);
        JPanel addMinorGoalPage = new CreateMinorGoalGUI(cardLayout, cardPanel, minorGoalMainGoalDropdown, minorGoalDropdown);
        JPanel removeMinorGoalPage = new RemoveMinorGoalGUI(cardLayout, cardPanel, mainGoalDropdown, minorGoalDropdown);
        JPanel viewGoalsPage = new ViewGoalsGUI(cardLayout, cardPanel);

        // add page to panel
        cardPanel.add(homePage, "Home");
        cardPanel.add(addMainGoalPage, "AddMainGoal");
        cardPanel.add(addMinorGoalPage, "AddMinorGoal");
        cardPanel.add(removeMinorGoalPage, "RemoveMinorGoal");
        cardPanel.add(viewGoalsPage, "ShowGoals");

        // setting border layout and adding card to frame
        setLayout(new BorderLayout());
        add(cardPanel, BorderLayout.CENTER);

        // frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TaskManagerGUI::new);
    }
}
