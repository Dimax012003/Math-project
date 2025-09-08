import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Executions {
    private String[] executions= {"add(+)","sub(-)","mul(*)","div(/)"};
    private JButton[] buttons;
    private JLabel[] labels;
    Executions(JPanel panel){
    	createButtons(panel);
    	createLabels(panel);
    }
    void createButtons(JPanel panel) {
    	buttons=new JButton[executions.length];
    	int k=0;
    	for(int i=0;i<buttons.length;i++) {
    		buttons[i]=new JButton();
    		buttons[i].setBounds(500, 140+k, 20, 20);
    		final int x=i;
           	buttons[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switch(x) {
		    
		    	case 0:
		    		
		    		break;
		    	case 1:
		    		break;
		    	case 2:
		    		break;
		    	case 3:
		    		break;	
		    	
				}
			
		
			
			}
		});
    		
    		panel.add(buttons[x]);
    		k=k+40;
    	}
				
               
   }
    	
    void createLabels(JPanel panel) {
    	labels=new JLabel[executions.length];
    	int k=0;
    	for(int i=0;i<labels.length;i++) {
    		labels[i]=new JLabel(executions[i]);
    		labels[i].setBounds(450, 140+k, 50, 20);
    		panel.add(labels[i]);
    		k=k+40;
    	}
    }
}
