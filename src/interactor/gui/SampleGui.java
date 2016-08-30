package interactor.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by siddgupta on 8/21/16.
 */
public class SampleGui extends JFrame{

    private JLabel label;
    private JButton button;
    private JTextField textField;
    private ImageIcon image;
    private JLabel imageLabel;
    private JMenuBar menuBar;
    private JMenu menu;
    private boolean showText1=false;

    SampleGui()
    {
        setLayout(new FlowLayout());

        addTextField();
        addLabel("");
        addButton("Click for Text!");
        addImage();
        performAction();
        showMenuBar();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(2000,2000);
        this.setVisible(true);
        this.setTitle("Learning Goal");

    }

    private void addTextField()
    {
            textField=new JTextField(15);
            add(textField);

    }

    private void addLabel(String string)
    {
        label=new JLabel(string);
        add(label);
    }

    private void addButton(String message)
    {
        button=new JButton(message);
        add(button);
    }

    private void addImage()
    {
        try {
            image=new ImageIcon(new URL("http://english.onlinekhabar.com/wp-content/uploads/2016/07/eye.jpg"),"Image Of Eye");
            imageLabel=new JLabel(image);
            add(imageLabel);
        }
        catch (MalformedURLException e)
        {
            System.out.println("Malform URL Exception");
        }


    }
    private void performAction()
    {
        CustomEvent customEvent=new CustomEvent("You Clicked");
        button.addActionListener(customEvent);
    }

    public class CustomEvent implements ActionListener {

        private String text;

        CustomEvent(String text)
        {
            this.text=text;
        }
        @Override
        public void actionPerformed(ActionEvent e) {

            showText1=!showText1;

            if(showText1)
            label.setText(text);
            else
                label.setText("");
        }
    }


    private void showMenuBar()
    {
        menuBar=new JMenuBar();
        setJMenuBar(menuBar);

        menu=new JMenu("Menu");

        JMenuItem jMenuItem=new JMenuItem("Exit");
        menuBar.add(jMenuItem);

        JMenuItem hello=new JMenuItem("Hello");
        menuBar.add(hello);

    }


}
