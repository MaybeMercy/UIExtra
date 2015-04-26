import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;


@SuppressWarnings("serial")
public class UIFrame extends JFrame{
	
	public static final int BUTTON_HEIGHT = 20;
	public static final int INLINE_HEIGHT = 10;
	
	private JPanel panel;
	private JButton addbtn;
	private JButton delbtn;
	private int number = 0;
	private ArrayList<JTextField> edit_group;
	
	public UIFrame(){
		this.setTitle("UIExtra");
		this.setSize(400, 600);
		this.setLocation(50, 30);
		edit_group = new ArrayList<JTextField>();
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
		// add input
		addbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				number++;
				JTextField input = new JTextField();
				input.setName(number+"");
				panel.add(input);
				input.setBounds(0, BUTTON_HEIGHT*number+INLINE_HEIGHT*(number+1), 80, BUTTON_HEIGHT);
				input.setDragEnabled(true);
				input.addMouseMotionListener(new CustomMouseAdapter(input));
				panel.validate();
				panel.repaint();
				edit_group.add(input);
			}
		});
		
		// del button
		delbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// if number == 0, return nothing
				if (number==0)
					return;
				panel.remove(edit_group.get(--number));
				panel.repaint();
			}
		});
		
		this.add(panel);
	}
	
	public class CustomMouseAdapter extends MouseAdapter{
		
		private JTextField input;
		private int off_Left = 0;
		private int off_Top = 0;
		
		public CustomMouseAdapter(JTextField input) {
			// TODO Auto-generated constructor stub
			this.input = input;
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mousePressed(e);
			System.out.println("mousePressed");
		}
		
		@Override
        public void mouseDragged(MouseEvent e) {
            Point point = input.getLocation();            
            input.setLocation(e.getPoint().x + point.x - off_Left, e.getPoint().y + point.y - off_Top);
        }
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseReleased(e);
			System.out.println("mouseReleased");
		}
	}
}
