/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.swingdemo;

import javax.swing.JTabbedPane;
import javax.swing.UIManager;
/* In case we need it...

  import javax.swing.JFrame;
  import javax.swing.JPanel;
  import javax.swing.JLabel;

  
 */
import java.util.ArrayList;
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

        jButton2.setText("Add Course");
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
        
		// Sets the GUI style of the program; currently applying to buttons but not tabs (worked earlier)
		
        tabbedPane.setBackground(Color.LIGHT_GRAY);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(0)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        					.addComponent(jButton1)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(jButton2)
        					.addGap(111))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(89)
        					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)))
        			.addGap(102))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButton1)
        				.addComponent(jButton2))
        			.addGap(58)
        			.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        			.addGap(75))
        );

        getContentPane().setLayout(layout);
        pack();
    }

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

    private static void initTabs()
    {
    	// This List will be used to store the Tab Panes we create for easy addition and removal of tabs
    	ArrayList<JTabbedPane> autoTabs = new ArrayList<JTabbedPane>();
    	JTabbedPane tempTab = new JTabbedPane();
    	
    	// Actual Tab GUI in variable form
    	tabbedPane = new JTabbedPane();
    	
		// autoTabs is a list of, essentially, tab objects. Each object is its own row of tabs, and each element
		// of that object is an individual tab
    	for (int i = 0; i < 3; i++)
    	{
    		System.out.println(UIManager.getLookAndFeel());
    		
    		tempTab.addTab("abc", new JTabbedPane());
    		autoTabs.add(tempTab);
    		
    		// MUST use getTabComponentAt command, NOT getComponentAt command. Latter destroys tab on access
            tabbedPane.add(autoTabs.get(0).getTitleAt(i), autoTabs.get(0).getTabComponentAt(i));
    	}
    }

    private static void setLookFeel()
    {
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
