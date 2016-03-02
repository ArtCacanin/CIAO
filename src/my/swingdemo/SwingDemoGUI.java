/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.swingdemo;

import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import java.awt.Color;
// import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;

public class SwingDemoGUI extends javax.swing.JFrame 
{
	// No idea why Eclipse wanted this here
	private static final long serialVersionUID = 1L;

	public SwingDemoGUI() 
	{
        initComponents();
    }

    private void initComponents()
    {
        addTabButton = new javax.swing.JButton();
        addTabButton.setDoubleBuffered(true);
        addTabButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        removeTabButton = new javax.swing.JButton();
        removeTabButton.setDoubleBuffered(true);
        removeTabButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        addCourseButton = new javax.swing.JButton();
        addCourseButton.setDoubleBuffered(true);
        addCourseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        removeCourseButton = new javax.swing.JButton();
        removeCourseButton.setDoubleBuffered(true);
        removeCourseButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        tabbedPane = new javax.swing.JTabbedPane();
        tabbedPane.setDoubleBuffered(true);
        tabbedPane.setTabPlacement(JTabbedPane.LEFT);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(500, 500));

        // Event Handler Instantiations
        addTabButton.setText("Add Tab");
        addTabButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addTabButtonClicked(evt);
            }
        });

        removeTabButton.setText("Remove Tab");
        removeTabButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeTabButtonClicked(evt);
            }
        });

        addCourseButton.setText("Add Course");
        addCourseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addCourseButtonClicked(evt);
            }
        });

        removeCourseButton.setText("Remove Course");
        removeCourseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeCourseButtonClicked(evt);
            }
        });
        
        tabbedPane.setBackground(new Color(192, 192, 192));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
        					.addContainerGap())
        				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        					.addComponent(addTabButton)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(removeTabButton)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(addCourseButton)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(removeCourseButton)
        					.addGap(138))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(addTabButton)
        				.addComponent(removeTabButton)
        				.addComponent(addCourseButton)
        				.addComponent(removeCourseButton))
        			.addGap(50)
        			.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        			.addGap(10))
        );

        initTabs();

        getContentPane().setLayout(layout);

        pack();
    }
    
    /*// Unused ActionPerformed Listener Instantiations - from initComponents()
    addTabButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            addTabButtonActionPerformed(evt);
        }
    });
    
    removeTabButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            removeTabButtonActionPerformed(evt);
        }
    });
    
    addCourseButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            addCourseButtonActionPerformed(evt);
        }
    });
    
    removeCourseButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            removeCourseButtonActionPerformed(evt);
        }
    });
    */
    
    /*// Unused ActionPerformed Handler methods
    private void addTabButtonActionPerformed(java.awt.event.ActionEvent evt)
    {
        // TODO add your handling code here:
    }
    
    private void removeTabButtonActionPerformed(java.awt.event.ActionEvent evt)
    {
        // TODO add your handling code here:
    }
    
	protected void addCourseButtonActionPerformed(ActionEvent evt) 
	{
		// TODO Auto-generated method stub
		
	}
	
    protected void removeCourseButtonActionPerformed(ActionEvent evt) 
    {
		// TODO Auto-generated method stub
		
	}
    */

    // One-line handlers because we may want other parts of the program to be able to perform these actions
    private void addTabButtonClicked(java.awt.event.MouseEvent evt)
    {
    	addOneTab((JTabbedPane) tabbedPane.getSelectedComponent(), "Because");
    }
    
	private void removeTabButtonClicked(java.awt.event.MouseEvent evt)
    {
    	removeOneTab((JTabbedPane) tabbedPane.getSelectedComponent());
    }

	private void addCourseButtonClicked(MouseEvent evt) 
	{
		addOneCourse("Because");
	}

    private void removeCourseButtonClicked(MouseEvent evt) 
    {
    	removeOneCourse();
	}

    // Wanted to get this code out of main()
    private static void initTabs()
    {
    	ArrayList<String> courses = new ArrayList<String>();
    	ArrayList<String> info = new ArrayList<String>();
    	JTabbedPane tempTab;

    	// These string arrays will be replaced by courses.add() on the JSON object
    	// Or whatever Sarah wants to do
    	String[] tempCourses = {"CS 3450","CS 3810","MGT 3700"};
    	String[] tempInfo = {"Assignments","Quizzes","Announcements"};

    	courses = fillArray(tempCourses);
    	info = fillArray(tempInfo);

    	// JPanels are created then stored in the 'inner' tab collection 'tempTab',
    	// which is then stored in the 'outer' tab collection 'tabbedPane', repeat
    	// - for my own understanding
    	for (int j = 0; j < courses.size(); j++)
    	{
    		tempTab = new JTabbedPane(JTabbedPane.TOP);

            for (int k = 0; k < info.size(); k++)
            {
            	tempTab.addTab(info.get(k), createPanel(info.get(k)));
            	System.out.println(tempTab.getTitleAt(k));
            }

            tabbedPane.addTab(courses.get(j), tempTab);
    	}
    }

    //Obvious method is obvious
    private static ArrayList<String> fillArray(String[] temp)
    {
    	ArrayList<String> tempArr = new ArrayList<String>();

    	for (int i = 0; i < temp.length; i++)
    	{
    		tempArr.add(temp[i]);
    	}

    	return tempArr;
    }

    /*
     * I separated the below one-liners out because we may want to use the functionality
     * later and they are much simpler to use than repeatedly messing with the GUI objects
     */

	// Takes the JTabbedPane object tempTab passed to it by the invoking method
	// and adds a new panel to it, effectively creating a new nested tab.
    private static void addOneTab(JTabbedPane tempTab, String tempString)
    {
    	if (tabbedPane.getTabCount() > 0)
    	{
    		tempTab.add(createPanel(tempString));
    	}
    }

	// Is passed tempTab, a collection of JPanels, and removes the
	// currently selected panel
    private static void removeOneTab(JTabbedPane tempTab)
    {
    	if (tempTab.getComponentCount() > 0)
    	{
        	tempTab.remove(tempTab.getSelectedComponent());	
    	}
    }

    // Generates a new Course tab by initializing a JTabbedPane object
    // with a string of titles. The string can be substituted with 
    // elements of a list of appropriate sections based on JSON data
    private static void addOneCourse(String course)
    {
    	JTabbedPane tempTab;
    	String[] info = {"Assignments", "Quizzes", "Announcements"};

		tempTab = new JTabbedPane(JTabbedPane.TOP);

        for (int k = 0; k < info.length; k++)
        {
        	tempTab.addTab(info[k], createPanel(info[k]));
        	System.out.println(tempTab.getTitleAt(k));
        }

        tabbedPane.addTab(course, tempTab);
    }

    private static void removeOneCourse()
    {
    	if (tabbedPane.getComponentCount() > 0)
    	{
    		tabbedPane.removeTabAt(tabbedPane.getSelectedIndex());
    	}
    }

    // Cleaner way of handling panel creation in other methods
    private static JPanel createPanel(String info)
    {
    	JPanel tempTabPanel = new JPanel();
    	JList<String> tempList = new JList<String>();
    	JScrollBar tempScroll = new JScrollBar();
    	JLabel temp = new JLabel();
    	temp.setText(info);
    	
    	tempTabPanel.add(info, new JPanel());
    	tempTabPanel.setLayout(new MigLayout("", "[grow][]", "[grow]"));
    	tempTabPanel.add(tempList, "cell 0 0");
    	tempTabPanel.add(tempScroll, "cell 1 0,growy");

    	return tempTabPanel;
    }

    // Workaround method for dealing with my process of dynamically updating UI elements; not using it resulted in
    // tabs refusing to accept custom UI themes applied in any other way
    private static void setLookFeel()
    {
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }

	public static void main(String args[])
	{
		setLookFeel();

		java.awt.EventQueue.invokeLater(new Runnable()
		{
			public void run() {
				new SwingDemoGUI().setVisible(true);
			}
		});
	}

    private javax.swing.JButton addTabButton;
    private javax.swing.JButton removeTabButton;
    private javax.swing.JButton addCourseButton;
    private javax.swing.JButton removeCourseButton;
    private static JTabbedPane tabbedPane;
}
