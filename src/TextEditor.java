
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TextEditor extends JFrame implements ActionListener {
    JTextArea textArea;
    JScrollPane scroolPane;
    JLabel fontLabel;
    JSpinner fontSizeSpinner;
    JButton fontColorButton;
    JComboBox fontBox;
    JMenuBar menuBar;
    JMenu fileMenu;
   JMenuItem openItem;
    JMenuItem saveItem;
     JMenuItem exitItem;
   
    
    TextEditor(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("text Editor");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
        
        textArea=new JTextArea();
        //textArea.setPreferredSize(new Dimension(450,450));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("italic",Font.PLAIN,20));
        
        scroolPane=new JScrollPane(textArea);
        scroolPane.setPreferredSize(new Dimension(450,450));
        scroolPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        fontLabel=new JLabel("font:");
        
        fontSizeSpinner=new JSpinner();
        fontSizeSpinner.setPreferredSize(new Dimension(50,25));
        fontSizeSpinner.setValue(20);
        fontSizeSpinner.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
               textArea.setFont(new Font(textArea.getFont().getFamily(),Font.PLAIN,(int)fontSizeSpinner.getValue()));
            }
            
        
        });
        fontColorButton=new JButton("color");
        fontColorButton.addActionListener(this);
        
        String[] fonts=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames(Locale.UK);
        fontBox=new JComboBox(fonts);
        fontBox.addActionListener(this);
        fontBox.setSelectedItem("italic");
        
        //menubar
         menuBar=new JMenuBar();
         fileMenu=new JMenu("file");
         openItem=new JMenuItem("open");
         saveItem=new JMenuItem("save");
         exitItem=new JMenuItem("exit");
         
         openItem.addActionListener(this);
         saveItem.addActionListener(this);;
         exitItem.addActionListener(this);;
         
         
        
         fileMenu.add(openItem);
         fileMenu.add(saveItem);
         fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        
        //menubar
        this.setJMenuBar(menuBar);
        this.add(fontLabel);
        this.add(fontSizeSpinner);
        this.add(fontColorButton);
        this.add(fontBox);
        this.add(scroolPane);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== fontColorButton){
            JColorChooser colorChooser=new JColorChooser();
            
            Color color=colorChooser.showDialog(null,"choose a color",Color.black);
            
            textArea.setForeground(color);
            
        }
        if(e.getSource()==fontBox){
            textArea.setFont(new Font((String)fontBox.getSelectedItem(),Font.PLAIN,textArea.getFont().getSize()));
        }
        if(e.getSource()==openItem){
            
        }
        if(e.getSource()==saveItem){
            JFileChooser fileChooser=new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            
            int response=fileChooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION){
                File file;
                PrintWriter fileOut = null;
                
                file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    fileOut=new PrintWriter(file);
                    fileOut.println(textArea.getText());
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
                finally{
                    fileOut.close();
                }
            }
        }
        if(e.getSource()==exitItem){
            System.exit(0);
        }
    }
    
}
