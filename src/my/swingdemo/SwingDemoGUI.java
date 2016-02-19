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
import java.util.List;
import java.util.ArrayList;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;


public class SwingDemoGUI extends javax.swing.JFrame {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SwingDemoGUI() {
		List<JTabbedPane> brad = new ArrayList<JTabbedPane>();
		brad = initTabs();
		System.out.println(brad.get(0).getTitleAt(0));
		System.out.println(brad.get(0).getTitleAt(1));
		
        initComponents(brad);
    }
    
    private void initComponents(List<JTabbedPane> brad) {

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
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
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
        
        
        /* SARAH: The below four lines of code generate two tabs. This should be a loop-able operation,
         * 		       assuming we can feed this initialization section info from our JSON objects
         * 			   prior to it trying to initialize.
         * 
         * 			   Otherwise we'll need a different solution.
         */

        
        // Complicated: Takes List 'brad' instantiated in SwingDemoGUI (same method that calls this method)
        // 				and feeds that List to a method below called initTabs, which returns that List to
        //				SwingDemoGUI, eventually feeding into the initComponents method where it is used here
        
        tabbedPane.addTab(brad.get(0).getTitleAt(0), brad.get(0).getComponentAt(0));
        tabbedPane.addTab(brad.get(0).getTitleAt(0), brad.get(0).getComponentAt(0));
        
        // Above calls destroy element as it is referenced; don't know why.
        
        getContentPane().setLayout(layout);
        pack();
    }

    private void addTabClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    
    private void jButton2addTabClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    
    private static List<JTabbedPane> initTabs()
    {
    	List<JTabbedPane> tempBrad = new ArrayList<JTabbedPane>();
    	JTabbedPane temp = new JTabbedPane();
    	temp.addTab("abc", new JTabbedPane());
    	temp.addTab("bla", new JTabbedPane());
    	tempBrad.add(temp);
    	
    	return tempBrad;
    }

	public static void main(String args[]) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new SwingDemoGUI().setVisible(true);
			}
		});
	}
	
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
}
