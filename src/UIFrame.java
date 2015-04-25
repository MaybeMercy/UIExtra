import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class UIFrame extends JFrame{
	
	JPanel panel;
	JButton addbtn;
	JButton delbtn;
	
	public UIFrame(){
		this.setTitle("UIExtra");
		this.setSize(300, 600);
		initPanel();
	}
	
	public void initPanel(){
		panel = new JPanel();
		addbtn = new JButton("添加");
		delbtn = new JButton("删除");
		
		panel.setLayout(null);
		panel.add(addbtn);
		panel.add(delbtn);
		
		addbtn.setBounds(0, 0, 80, 20);
		delbtn.setBounds(90, 0, 80, 20);
		
		this.add(panel);
	}
}
