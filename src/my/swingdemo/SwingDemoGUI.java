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
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class SwingDemoGUI extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public SwingDemoGUI() {
        initComponents();
    }
	
    private void initComponents() 
    {
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tabbedPane = new javax.swing.JTabbedPane();
        tabbedPane.setDoubleBuffered(true);
        tabbedPane.setTabPlacement(JTabbedPane.LEFT);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(500, 500));

        jButton1.setText("Add Tab");
         // Event Handler Instantiations
         jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addTabClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        

        jButton2.setText("Remove Tab");
        // Event Handler Instantiations
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2addTabClicked(evt);
            }
        });
 
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        
        
        tabbedPane.setBackground(new Color(192, 192, 192));
        
        btnAddCourse = new JButton("Add Course");
        
        btnRemoveCourse = new JButton("Remove Course");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jButton1)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jButton2)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnAddCourse)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnRemoveCourse)
        					.addGap(201))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        					.addContainerGap())))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButton1)
        				.addComponent(jButton2)
        				.addComponent(btnAddCourse)
        				.addComponent(btnRemoveCourse))
        			.addGap(50)
        			.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        			.addGap(10))
        );
        
        initTabs();
        
        getContentPane().setLayout(layout);
        
        pack();
    }
// Event Handler methods
    private void addTabClicked(java.awt.event.MouseEvent evt) 
    {
    	// One-line handler because we may want other parts of the program to be able to add a tab
    	
    	//addOneTab((JTabbedPane) tabbedPane.getSelectedComponent(), "Jerry");
    	addOneCourse("Ben");
    	
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) 
    {
        // TODO add your handling code here:
    }
    
    private void jButton2addTabClicked(java.awt.event.MouseEvent evt) 
    {
    	// One-line handler because we may want other parts of the program to be able to remove a tab
    	
    	// removeOneTab((JTabbedPane) tabbedPane.getSelectedComponent());
        tabbedPane.removeTabAt(tabbedPane.getSelectedIndex());
    	
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) 
    {
        // TODO add your handling code here:
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
    	
    	// Inner tabs are created and stored in 'tempTab' then collectively added to the
    	// outer tab collection 'tabbedPane', repeat
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
    
    private static void addOneTab(JTabbedPane tempTab, String tempString)
    {
    	tempTab.add(tempString, createPanel(tempString));
    }
    
    private static void removeOneTab(JTabbedPane tempTab)
    {
    	tempTab.remove(tempTab.getSelectedComponent());
    }
    
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
        tabbedPane.removeTabAt(tabbedPane.getSelectedIndex());
    }
    
    // Cleaner way of handling panel creation in other methods
    private static JPanel createPanel(String info)
    {
    	JPanel tempTabPanel = new JPanel();
    	JList tempList = new JList();
        JScrollBar tempScroll = new JScrollBar();
        
       	tempTabPanel.add(info, new JPanel());
        
    	tempTabPanel.setLayout(new MigLayout("", "[grow][]", "[grow]"));
    	tempTabPanel.add(tempList, "cell 0 0");
        tempTabPanel.add(tempScroll, "cell 1 0,growy");

    	return tempTabPanel;
    }
    
    private static void setLookFeel()
    {
        // Workaround method for dealing with my process of dynamically updating UI elements; not using it resulted in
        // tabs refusing to accept custom UI themes applied in any other way
    	
		try {
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
	
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private static JTabbedPane tabbedPane;
    private JButton btnAddCourse;
    private JButton btnRemoveCourse;
}
