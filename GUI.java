import javax.swing.JPanel; 
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI implements ActionListener {
	private JFrame frame;
	private JPanel panel;
	private JLabel label;
	private JLabel label1;
	private JTextField text1;
	private JTextField text;
	private JTextField textb;
	private JButton button1;
	private JLabel[] label2;
	private String[] texts= {"Choose Function:      Parameters:  a      |      b","1)b*cos(ax)","2)b*sin(ax)","3)logx(base 10)","4)b*ln(ax)","5)b*exp(ax)","6)bx^(a)"};
	private JButton[] buttons;
	private JTextField[] opentexta;
	private JTextField[] opentextb;
	private JButton derivative;
	private JButton equation;
  public  GUI(){
    	 frame=new JFrame();
    	 panel=new JPanel();
        frame.setSize(100,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.green);
        label=new JLabel("Get Integral Bounds");
        label.setBounds(10, 20, 200, 20);
        panel.add(label);
        int count=0;
        label2=new JLabel[texts.length];
        for(int i=0;i<label2.length;i++) {
        	label2[i]=new JLabel(texts[i]);
        	label2[i].setBounds(10, 60+count, 300, 20);
        	count=count+80;
        	panel.add(label2[i]);
        }
        
         text=new JTextField();
        text.setBounds(200,20,30,20);
        panel.add(text);
        
        textb=new JTextField();
        textb.setBounds(250,20,30,20);
        panel.add(textb);
        
        
        button1=new JButton("Click me");
        button1.setBounds(400, 20, 100, 20);
        button1.addActionListener(this);
        panel.add(button1);
        
        int c=0;
        buttons=new JButton[label2.length-1];
        
        int k=0;
        opentexta=new JTextField[buttons.length];
        opentextb=new JTextField[buttons.length];
        for(int j=0;j<opentexta.length;j++) {
        	opentexta[j]=new JTextField();
        	opentextb[j]=new JTextField();
        	opentexta[j].setBounds(200,140+k,30,20);
        	opentextb[j].setBounds(250,140+k,30,20);
            panel.add(opentexta[j]);
            panel.add(opentextb[j]);
        	k=k+80;
        }
       
		   text1=new JTextField();
		   text1.setBounds(800, 200, 30, 20);
		   label1=new JLabel("Enter value");
		   label1.setBounds(800, 170, 150, 20);
		   panel.add(text1);
		   panel.add(label1);
        
        int i;
        Function a=new Function(0,1,1);
        
        for( i=0;i<buttons.length;i++) {
         final int copy=i+1;
         
         buttons[i]=new JButton();
         buttons[i].setBounds(100, c+140, 20, 20);
         buttons[i].addActionListener(new ActionListener() {
        	    public void actionPerformed(ActionEvent e) {
        	    	int u,b;
        	    	a.setFunction(copy);

        	    	
        	    	try {
        	    		   u = Integer.parseInt(opentexta[copy-1].getText());
        	    		}
        	    	catch (NumberFormatException l) {
        	    		   u = 0;
        	    		}

        	    	try {
        	    		   b = Integer.parseInt(opentextb[copy-1].getText());
        	    		}
        	    	catch (NumberFormatException l) {
     	    		   b = 0;
     	    		}
        	    	
        	    	a.setParametera(u);
        	    	a.setParameterb(b);
                    createMenu(a);
        	    	System.out.println(a.integral(getExternalParameter(text.getText()),getInternalParameter(textb.getText())));
        	    	
        	    }});
         c=c+80;
         panel.add(buttons[i]);
        }

        
        frame.setVisible(true);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.print("Hey" );
		label.setText("NICE ASS");
	}
	int getExternalParameter(String text) {
		int e;
		try {
 		   e = Integer.parseInt(text);
 		}
 	catch (NumberFormatException l) {
 		   e = 0;
 		}
		return e;
	}
	int getInternalParameter(String text) {
		int e;
		try {
 		   e = Integer.parseInt(text);
 		}
 	catch (NumberFormatException l) {
 		   e = 0;
 		}
		return e;
	}
   void createMenu(Function function) {
	    derivative=new JButton("Evaluate Derivative");
	    equation=new JButton("Find Solution");
	   derivative.setBounds(800, 140, 150, 20);
	   equation.setBounds(1000, 140, 150, 20);
	   panel.add(equation);
	   panel.add(derivative);
	   derivative.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
			   

			 System.out.println ( function.derivative(getInternalParameter(text1.getText())));
			
		   }
	   });
	   equation.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
			   JTextField text2=new JTextField();
			   text2.setBounds(1000, 200, 30, 20);
			   JLabel label2=new JLabel("Enter value");
			   label2.setBounds(1000, 170, 150, 20);
			   panel.add(label2);
			   panel.add(text2);
			   function.findsolution((double)getInternalParameter(text2.getText()));
		   }
	   });

   }
}
