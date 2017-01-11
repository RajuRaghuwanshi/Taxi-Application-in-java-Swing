package Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import POJO.Points;
import Utility.Car;
import Utility.Car_Location;
import Utility.Driver_Info;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileReader;
import java.io.IOException;

public class TestMainFrame extends JFrame {

	private JPanel contentPane;
	private Map<String, JButton> dynamicButtons;
	private ArrayList<Car_Location> car_location_array;
	private ArrayList<Driver_Info> driver_info_array;
	private static int flag = 0;
	private double distance = 0;
	int g_x = 0, g_y = 0;

	public void FillDatathroughJSONFile() {

		JSONObject jsonObject = null;
		car_location_array = new ArrayList<Car_Location>();
		driver_info_array = new ArrayList<Driver_Info>();
		try {
			FileReader reader = new FileReader("jsonfile");

			JSONParser jsonParser = new JSONParser();

			jsonObject = (JSONObject) jsonParser.parse(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONArray jsonarray = (JSONArray) jsonObject.get("info");

		Iterator i = jsonarray.iterator();

		while (i.hasNext()) {

			JSONObject innerObj = (JSONObject) i.next();

			driver_info_array.add(
					new Driver_Info(innerObj.get("id").toString(), Integer.parseInt(innerObj.get("s").toString())));

			car_location_array.add(new Car_Location(
					new Car(innerObj.get("id").toString(), driver_info_array.get(driver_info_array.size() - 1)),
					new Points(Integer.parseInt(innerObj.get("x").toString()),
							Integer.parseInt(innerObj.get("y").toString()))));

			addButton(driver_info_array.get(driver_info_array.size() - 1), new Points(
					Integer.parseInt(innerObj.get("x").toString()), Integer.parseInt(innerObj.get("y").toString())));
			// new Points(,)
		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				TestMainFrame frame = new TestMainFrame();

				frame.FillDatathroughJSONFile();
				frame.setVisible(true);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();

		contentPane.addMouseListener(new MouseAdapter() {
			Car_Location carlocation_obj = null;
			Driver_Info driver_info_obj = null;

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// JOptionPane.showMessageDialog(null, "flag is here:" + flag);

				int x = arg0.getX();
				int y = arg0.getY();
				// FillDatathroughJSONFile();
				if (flag == 0) {

					int car_x = 0, car_y = 0;
					int min = Integer.MAX_VALUE;
					int temp;
					// System.out.println("vxhjxzhjvxkjxzj");
					for (Car_Location obj : car_location_array) {
						car_x = obj.getPoints().getX();
						car_y = obj.getPoints().getY();
						temp = (int) Math.sqrt((x - car_x) * (x - car_x) + (y - car_y) * (y - car_y));
						driver_info_obj = driver_info_array.get(car_location_array.indexOf(obj));
						if ((min > temp) && (driver_info_obj.isStatus() == 1)) {
							carlocation_obj = obj;
							min = temp;
							car_x = obj.getPoints().getX();
							car_y = obj.getPoints().getY();
						}
					}
					if (min == Integer.MAX_VALUE) {
						JOptionPane.showMessageDialog(null, "Sorry No Taxi found !");

					} else {
						JOptionPane.showMessageDialog(null,
								"Your Car iD :" + carlocation_obj.getCar_info().getCar_id());
						JButton jbuton = (JButton) contentPane.getComponentAt(carlocation_obj.getPoints().getX(),
								carlocation_obj.getPoints().getY());
						// contentPane.repaint();
						jbuton.setBounds(x, y, 37, 20);
						g_x = x;
						g_y = y;
						flag = 1;
					}
				} else {
					JButton jbuton = (JButton) contentPane.getComponentAt(g_x, g_y);
					// contentPane.repaint();
					jbuton.setBounds(x, y, 37, 20);
					Icon ico = new ImageIcon("images_new.jpg");
					jbuton.setIcon(ico);
					// driver_info_array.indexOf((new
					// Driver_Info(jbuton.getName(), 1));
					driver_info_obj.setStatus(1);
					carlocation_obj.setPoints(new Points(x, y));
					flag = 0;
					distance = (Math.sqrt((x - g_x) * (x - g_x) + (y - g_y) * (y - g_y)) * 0.1);
					JOptionPane.showMessageDialog(null, "Your ride distance :" + String.format("%.2f", distance)
							+ " and fare is :" + String.format("%.2f", distance * 6));
				}
			}
		});

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

	}

	public void addButton(Driver_Info driverInfo, Points p) {
		Icon ico;
		if (driverInfo.isStatus() == 0) {
			ico = new ImageIcon("image_war.png");
		} else {
			ico = new ImageIcon("images_new.jpg");
		}
		JButton b = new JButton(ico);

		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Icon ico_war = new ImageIcon("image_war.png");
				b.setIcon(ico_war);
				// flag = 1;
			}
		});
		contentPane.add(b);
		b.setBounds(p.getX(), p.getY(), 37, 20);
		// b.
		b.setToolTipText(driverInfo.getDriver_id());
		b.setName(driverInfo.getDriver_id());
		b.setVisible(true);

		// dynamicButtons.put(name, b);
		// yourPanel.invalidate();
	}
}
