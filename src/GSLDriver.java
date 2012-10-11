
import com.bitinvert.reference.GridSpanLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GSLDriver {

	private JFrame frame = new JFrame();
	private GridSpanLayout gsl = new GridSpanLayout(4,3,1,1);
	private JPanel panel = new JPanel(gsl);
	private JButton button = new JButton("Switch");
	private boolean usingLayout1;

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GSLDriver();
			}
		});
	}

	private void useLayout1() {
		usingLayout1 = true;
		gsl.setSpan(0,0,1,2);
		gsl.setSpan(0,2,3,1);
		gsl.setSpan(1,0,2,2);
	}

	private void useLayout2() {
		usingLayout1 = false;
		gsl.setSpan(0,0,2,1);
		gsl.setSpan(0,1,1,2);
		gsl.setSpan(1,1,2,2);
	}

	public GSLDriver() {
		useLayout1();
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gsl.resetSpans();
				if(usingLayout1)
					useLayout2();
				else useLayout1();
				panel.revalidate();
			}
		});
		panel.setPreferredSize(new Dimension(150,200));
		JTextField t1 = new JTextField("t1");
		JTextField t2 = new JTextField("t2");
		JTextField t3 = new JTextField("t3");
		JTextField t4 = new JTextField("t4");
		JTextField t5 = new JTextField("t5");
		JTextField t6 = new JTextField("t6");
		panel.add(t1);
		panel.add(t2);
		panel.add(t3);
		panel.add(t4);
		panel.add(t5);
		panel.add(t6);
		frame.setLayout(new FlowLayout());
		frame.add(button);
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}