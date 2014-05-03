import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.io.*;
import java.beans.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
  *
  * description
  *
  * @version 1.0 from 22.04.2014
  * @author D. Schweighoefer
  */

public class PrisonViewer extends JFrame
{
  // Anfang Attribute
  private JTabbedPane jTabbedPane1 = new JTabbedPane();
  private JPanel jTabbedPane1TabPanel3 = new JPanel(null, true);
  private JLabel jLabel5 = new JLabel();
  private JNumberField jNumberField1 = new JNumberField();
  private JLabel jLabel6 = new JLabel();
  private JLabel jLabel7 = new JLabel();
  private JNumberField jNumberField2 = new JNumberField();
  private JLabel jLabel8 = new JLabel();
  private JNumberField jNumberField3 = new JNumberField();
  private JPanel jTabbedPane1TabPanel4 = new JPanel(null, true);
  private JPanel jTabbedPane1TabPanel1 = new JPanel(null, true);
  private JLabel jLabel4 = new JLabel();
  private JProgressBar jProgressBar1 = new JProgressBar();
  private JButton parse = new JButton();
  private JTextField jTextField1 = new JTextField();
  private JButton jButton1 = new JButton();
  private JTextField jTextField2 = new JTextField();
  private JButton jButton2 = new JButton();
  private JLabel jLabel1 = new JLabel();
  private JLabel jLabel2 = new JLabel();
  private JLabel jLabel3 = new JLabel();
  private JFileChooser jfco;
  private JPanel jTabbedPane1TabPanel2 = new JPanel(null, true);
  private DefaultMutableTreeNode prisonData = new DefaultMutableTreeNode("Prison File");
  private JTree tree = new JTree(prisonData);
  private JScrollPane jScrollPane1 = new JScrollPane(tree);
  private DataNode DataRoot = null;
  // Ende Attribute
  
  public PrisonViewer (String title) 
  {
    super (title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 1134; 
    int frameHeight = 503;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    Container cp = getContentPane();
    cp.setLayout(new BorderLayout());
    // Anfang Komponenten
    jTabbedPane1.setBounds(0, 0, 1121, 481);
    jTabbedPane1.addTab("File", jTabbedPane1TabPanel1);
    jTabbedPane1.addTab("Raw", jTabbedPane1TabPanel2);
    jTabbedPane1.addTab("General", jTabbedPane1TabPanel3);
    jTabbedPane1.addTab("Cells", jTabbedPane1TabPanel4);
    cp.add(jTabbedPane1,BorderLayout.CENTER);
    jTextField1.setBounds(22, 40, 321, 33);
    jTabbedPane1TabPanel1.add(jTextField1);
    jButton1.setBounds(358, 40, 145, 33);
    jButton1.setText("Browse");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton1_ActionPerformed(evt);
      }
    });
    jTabbedPane1TabPanel1.add(jButton1);
    jTextField2.setBounds(22, 104, 321, 33);
    jTabbedPane1TabPanel1.add(jTextField2);
    jButton2.setBounds(358, 104, 145, 33);
    jButton2.setText("Browse");
    jButton2.setMargin(new Insets(2, 2, 2, 2));
    jButton2.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        jButton2_ActionPerformed(evt);
      }
    });
    jTabbedPane1TabPanel1.add(jButton2);
    jLabel1.setBounds(22, 16, 150, 20);
    jLabel1.setText("Prison Data File (*.prison):");
    jTabbedPane1TabPanel1.add(jLabel1);
    jLabel2.setBounds(22, 80, 115, 20);
    jLabel2.setText("Preview File (*.png):");
    jTabbedPane1TabPanel1.add(jLabel2);
    jLabel3.setBounds(22, 136, 177, 12);
    jLabel3.setText("Will be automatically detected ");
    jLabel3.setFont(new Font("Dialog", Font.BOLD, 10));
    jTabbedPane1TabPanel1.add(jLabel3);
    String homedir = System.getProperty("user.home");
    String pa_saves = homedir + "\\AppData\\Local\\Introversion\\Prison Architect\\saves";
    jfco = new JFileChooser(pa_saves);
    jLabel4.setBounds(534, 24, 563, 313);
    jLabel4.setText("");
    jTabbedPane1TabPanel1.add(jLabel4);
    jProgressBar1.setBounds(22, 168, 321, 33);
    jTabbedPane1TabPanel1.add(jProgressBar1);
    parse.setBounds(358, 168, 145, 33);
    parse.setText("Start Parser");
    parse.setMargin(new Insets(2, 2, 2, 2));
    parse.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        parse_ActionPerformed(evt);
      }
    });
    jTabbedPane1TabPanel1.add(parse);
    jLabel5.setBounds(22, 24, 109, 25);
    jLabel5.setText("Current Time:");
    jLabel5.setFont(new Font("Dialog", Font.BOLD, 16));
    jTabbedPane1TabPanel3.add(jLabel5);
    jNumberField1.setBounds(54, 56, 73, 25);
    jNumberField1.setText("");
    jTabbedPane1TabPanel3.add(jNumberField1);
    jLabel6.setBounds(22, 56, 30, 20);
    jLabel6.setText("Day:");
    jTabbedPane1TabPanel3.add(jLabel6);
    jLabel7.setBounds(134, 56, 46, 20);
    jLabel7.setText("Hours:");
    jTabbedPane1TabPanel3.add(jLabel7);
    jNumberField2.setBounds(182, 56, 73, 25);
    jNumberField2.setText("");
    jTabbedPane1TabPanel3.add(jNumberField2);
    jLabel8.setBounds(262, 56, 52, 20);
    jLabel8.setText("Minutes:");
    jTabbedPane1TabPanel3.add(jLabel8);
    jNumberField3.setBounds(318, 56, 73, 25);
    jNumberField3.setText("");
    jTabbedPane1TabPanel3.add(jNumberField3);
    jTabbedPane1TabPanel1.setEnabled(false);
    jScrollPane1.setBounds(158, 80, 841, 313);
    jTabbedPane1TabPanel2.setLayout(new BorderLayout());
    jTabbedPane1TabPanel2.add(jScrollPane1);
    // Ende Komponenten
    setResizable(true);
    setVisible(true);
  }
  
  // Anfang Methoden
  
  
  public void jButton1_ActionPerformed(ActionEvent evt) {
    String Filename = jfcoOpenFilename("PRISON files","prison");
    if (Filename != null) 
    {
      jTextField1.setText(Filename);                                                        
      File file = new File(Filename.substring(0,Filename.lastIndexOf(".prison")) + ".png");
      if (file.exists()) 
      {
        setPreview(file.getPath());
      }else{
        resetPreview();
      }
    }
  } // end of jButton1_ActionPerformed
  
  public String jfcoOpenFilename(String filterDesc,String filter) {
    jfco.setDialogTitle("Öffne Datei");
    jfco.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(filterDesc,filter));
    if (jfco.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
      return jfco.getSelectedFile().getPath();
    } else {
      return null;
    }
  }
  
  public void jButton2_ActionPerformed(ActionEvent evt) {
    setPreview(jfcoOpenFilename("Preview files","png"));
    // TODO hier Quelltext einfügen
  }
  
  public void setPreview(String file){
    jTextField2.setText(file);
    BufferedImage img = null;
    try{
      img = ImageIO.read(new File(file));
    }catch(IOException e){
      
    }
    int imgWidth = img.getWidth();
    int imgHeight = img.getHeight();
    int labelWidth = jLabel4.getBounds().width;
    int labelHeight = jLabel4.getBounds().height;
    double ratio = imgHeight/labelHeight;
    Double newWidthD = imgWidth/ratio;
    int newWidth = newWidthD.intValue();
    int newHeight = labelHeight;
    if (newWidth > labelWidth) 
    {
      ratio = imgWidth/labelWidth;
      Double newHeightD = imgHeight/ratio;
      newHeight = newHeightD.intValue();
      newWidth = labelWidth;
    }
    Image dimg = img.getScaledInstance(newWidth, newHeight,Image.SCALE_SMOOTH);
    ImageIcon preview = new ImageIcon(dimg);
    jLabel4.setIcon(preview);
  } 
  
  public void resetPreview(){
    jTextField2.setText("");
    jLabel4.setIcon(null);
  }
  
  public void parse_ActionPerformed(ActionEvent evt) {
    PrisonParseWrapper PPW = new PrisonParseWrapper(false);
    DataRoot = PPW.parsePrisonFile(jTextField1.getText());
    jProgressBar1.setMaximum(PPW.NodeCount);
    prisonData.removeAllChildren();
    prisonData.add(createTreeNode(DataRoot,jTextField1.getText()));
    loadGeneral();
  }
  
  public DefaultMutableTreeNode createTreeNode(DataNode data, String RootName){
    jProgressBar1.setValue(jProgressBar1.getValue()+1);
    StringBuilder nd = new StringBuilder(data.getName());
    if (data.getValue()!=null) 
    {
      nd.append(':');
      nd.append(data.getValue());
    }
    
    DefaultMutableTreeNode newNode;
    if (RootName != null) 
    {
      newNode = new DefaultMutableTreeNode(RootName);
    }else{
      newNode = new DefaultMutableTreeNode(nd.toString());
    }
    
    if (data.SubNodes.size()>0) 
    {
      for (int i = 0;i<data.SubNodes.size();i++) 
      {
        DataNode[] subData = data.SubNodes.values().toArray(new DataNode[1]);
        newNode.add(createTreeNode(subData[i],null));
      }
    }
    return newNode;
  }
  
  public void loadGeneral(){
    pa_Time currentTime = new pa_Time(DataRoot.getSubNode("TimeIndex").getValue());
    jNumberField1.setInt(currentTime.getDay());
    jNumberField2.setInt(currentTime.getHour());
    jNumberField3.setInt(currentTime.getMinute());
  }
  
  // Ende Methoden
  
  public static void main(String[] args) 
  {
    new PrisonViewer("PrisonViewer");
  }
}
