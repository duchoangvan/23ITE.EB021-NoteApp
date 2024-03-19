package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JLabel;

import Controller.NoteAppController;
import Model.NoteAppModel;

public class NoteAppView extends JFrame {
    private NoteAppModel model;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public JTextArea textArea;
    public JLabel displayLabel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    NoteAppView frame = new NoteAppView();
                    frame.setVisible(true);
                } catch (Exception e) {    
                    e.printStackTrace();
                }
            }
        });
    }

    public NoteAppView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 520, 562);

        ActionListener action = new NoteAppController(this);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu MenuFile = new JMenu("File");
        menuBar.add(MenuFile);

        JMenuItem MenuSaveItem = new JMenuItem("Save");
        MenuSaveItem.addActionListener(action);
        MenuFile.add(MenuSaveItem);

        JMenuItem MenuNewItem = new JMenuItem("New");
        MenuNewItem.addActionListener(action);
        MenuFile.add(MenuNewItem);

        JMenuItem MenuOpenItem = new JMenuItem("Open");
        MenuOpenItem.addActionListener(action);
        MenuFile.add(MenuOpenItem);

        textArea = new JTextArea();

        JScrollPane scrollPane = new JScrollPane(textArea);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(contentPane.getWidth(), 50));
        contentPane.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setLayout(null);

        displayLabel = new JLabel("Display");
        displayLabel.setBounds(10, 11, 476, 30); 
        bottomPanel.add(displayLabel);
    }

    public String getText() {
        return textArea.getText();
    }
}
