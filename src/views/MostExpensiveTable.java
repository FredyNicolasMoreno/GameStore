package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.PriorityQueue;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Control;
import models.Game;

public class MostExpensiveTable extends JDialog{
	
	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;

	public MostExpensiveTable(Control controller) {
		setLayout(new BorderLayout());

		setTitle("Runner Soft");
		setIconImage(new ImageIcon(getClass().getResource("/img/icon.png")).getImage());
		setSize(800,500);
		model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[] {"Juego","Precio"});

		table = new JTable(model);
		table.setRowHeight(25);
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setBackground(Color.decode("#088A85"));

		table.setFont(new Font("Arial", Font.BOLD, 18));
		table.setBackground(Color.WHITE);

		scroll = new JScrollPane(table);

		add(scroll, BorderLayout.CENTER);
	}

	public void refreshTable(PriorityQueue<Game> priorityQueue) {
		model.setRowCount(0);
		for (Game game : priorityQueue) {
			model.addRow(game.toObjectVector());
		}
		table.setModel(model);
	}

}
