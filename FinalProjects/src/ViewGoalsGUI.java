import java.awt.*;
import javax.swing.*;

//ViewGoals is working
public class ViewGoalsGUI extends JPanel {
    public ViewGoalsGUI(CardLayout cardLayout, JPanel cardPanel){

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        JPanel viewGoalsPanel = new JPanel();
        JButton viewGoalsToHomePage = new JButton("Home");
        JButton showGoals = new JButton("Display Goals");
        viewGoalsPanel.setLayout(new BoxLayout(viewGoalsPanel, BoxLayout.Y_AXIS));
      
        //making sure the button doesn't take half the screen
        Dimension maxButtonSize = new Dimension(Integer.MAX_VALUE, 50); 
        //show goal button
        showGoals.setMaximumSize(maxButtonSize);
        showGoals.setPreferredSize(maxButtonSize);
        //home button
        viewGoalsToHomePage.setMaximumSize(maxButtonSize);
        viewGoalsToHomePage.setPreferredSize(maxButtonSize);

        showGoals.addActionListener(e -> {
            viewGoalsPanel.removeAll();
            System.out.println("right before maingoal checkbox print");
            for (String mainGoal : MainGoal.getMainGoalsList()) {
                System.out.println(mainGoal);
                JCheckBox mainGoalCheckBox = new JCheckBox(mainGoal);
                JLabel minorGoalLabel = new JLabel("     Minor Goal/Goals: ");
                JLabel mainGoalLabel = new JLabel("Main Goal: ");

                viewGoalsPanel.add(mainGoalLabel);
                viewGoalsPanel.add(mainGoalCheckBox);
                viewGoalsPanel.add(minorGoalLabel);

                for (int i = 0; i < Goal.getMinorGoalsList(mainGoal).size(); i++) {
                    System.out.println(i);
                    JCheckBox minorGoalCheckBox = new JCheckBox(Goal.getMinorGoal(mainGoal, i));
                    JLabel minorGoalDesc = new JLabel("             Description: "+Goal.getMinorGoalDesc(mainGoal, i));
                    JLabel minorGoalImportancLabel = new JLabel("             Importance: "+ Goal.getMinorGoalImportance(mainGoal, i));
                    
                    viewGoalsPanel.add(minorGoalCheckBox);
                    viewGoalsPanel.add(minorGoalDesc);
                    viewGoalsPanel.add(minorGoalImportancLabel);

                    //indent minorGoal checkboxes so it looks better visually
                    minorGoalCheckBox.setMargin(new Insets(0, 20, 0, 0));
                }
            }
            revalidate();
            repaint();
        });

        // give functionality to buttons 
        viewGoalsToHomePage.addActionListener(e -> cardLayout.show(cardPanel, "Home")); 
        // add to viewGoals page layout - also allowing viewGoals to be scrollable

        JScrollPane viewGoalScrollPane = new JScrollPane(viewGoalsPanel);
        viewGoalScrollPane.setPreferredSize(new Dimension(1000,400));

        add(viewGoalScrollPane);
        add(showGoals);
        add(viewGoalsToHomePage);

    }
}
