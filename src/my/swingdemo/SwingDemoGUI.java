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
import javax.swing.LayoutStyle.ComponentPlacement;


import java.awt.Color;

public class SwingDemoGUI extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 1L;
	
	public SwingDemoGUI() {
        initComponents();
    }
	
    private void initComponents() 
{

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(500, 500));

        jButton1.setText("Add Tab");
        /* // Event Handler Instantiations
         * jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addTabClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        */

        jButton2.setText("Add Course");
        /* // Event Handler Instantiations
         * jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2addTabClicked(evt);
            }
        });
 
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        */
        
        tabbedPane.setBackground(Color.LIGHT_GRAY);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(0)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.CENTER, layout.createSequentialGroup()
            				.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(jButton1)
        					.addComponent(jButton2)
        					.addGap(0))
        				.addGroup(layout.createSequentialGroup()
    				.addGroup(layout.createSequentialGroup()
        					.addGap(10)
        					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
        			.addGap(10))
        )));
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButton1)
        				.addComponent(jButton2))
        				.addGap(50)
        			.addGroup(layout.createSequentialGroup()
        				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
        				.addGap(10))
        );

        getContentPane().setLayout(layout);
        
        pack();
    }
/*// Event Handler methods
    private void addTabClicked(java.awt.event.MouseEvent evt) 
{
        // TODO add your handling code here:
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) 
{
        // TODO add your handling code here:
    }
    
    private void jButton2addTabClicked(java.awt.event.MouseEvent evt) 
{
        // TODO add your handling code here:
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) 
{
        // TODO add your handling code here:
    }
*/
    
    private static void initTabs()
    {
    	// 'tabbedPane' is the rendering variable; whatever it equals is what is rendered within the Tab UI
    	tabbedPane = new JTabbedPane();
    	
       	JTabbedPane userTabPane = new JTabbedPane();
    	userTabPane.setTabPlacement(JTabbedPane.LEFT);
    	
    	
    	// In the future, generating these arrays based on JSON parsing / menu items should be relatively simple
    	// Also, well want to use ArrayLists for this; that or big fixed length arrays
    	String[] courses = {"CS 3450","CS 3810","MGT 3700","yuck","ouch"};
    	String[] info = {"Assignments","Quizzes","Announcements","yuck","ouch"};

    	
    	// Why createTab method: using a loop-generated tab pane and attempting to add it resulted in there only
    	// ever being one element in userTabPane. This way, a new tab is created right then and there for addition
    	for (int i = 0; i < courses.length; i++)
    	{
    		userTabPane.add(courses[i], createTab(info));
            tabbedPane = userTabPane;
    	}
    }

    private static JTabbedPane createTab(String[] info)
    {
        // Could potentially be used in the future to add course info to tempTabPane immediately
    	
    	JTabbedPane tempTabPane1 = new JTabbedPane();
    	
    	for (int i = 0; i < info.length; i++)
    	{
        	tempTabPane1.addTab(info[i], new JTabbedPane());
    	}
    	
    	return tempTabPane1;
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
		initTabs();

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
}
