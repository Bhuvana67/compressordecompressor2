/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import compDecomp.compressor;
import compDecomp.decompressor;
import java.awt.Color;
import static java.awt.Color.green;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.text.html.HTML.Tag.OPTION;

/**
 *
 * @author Surya
 */
public class AppFrame extends JFrame implements ActionListener{

    JButton compressButton;
    JButton decompressButton;
    
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        compressButton = new JButton("select file to compress");
        compressButton.setBounds(200,200, 200, 30);
        compressButton.addActionListener(this);
        
        decompressButton = new JButton("select file to decompress");
        decompressButton.setBounds(600,200, 200, 30);
        decompressButton.addActionListener(this);
        
        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(1000,500);
        this.getContentPane().setBackground(Color.white);
        this.setVisible(true);
        
    }
    
    
   @Override

public void actionPerformed (ActionEvent e) {
    if(e.getSource() ==compressButton){

        JFileChooser filechooser =  new JFileChooser();

        int response = filechooser.showSaveDialog(null); 

        if(response==JFileChooser.APPROVE_OPTION)
        {

            File file = new File(filechooser.getSelectedFile().getAbsolutePath());

            System.out.print(file); 
                try{

                    compressor.method(file);
                }

                catch (Exception ee) {

                    JOptionPane.showMessageDialog(null,  ee.toString());
                }
        }
    }

    if(e.getSource()== decompressButton)
    {
        JFileChooser  filechooser = new JFileChooser();

        int response = filechooser.showSaveDialog(null); 
        if(response==JFileChooser.APPROVE_OPTION)
        {

            File file = new File(filechooser.getSelectedFile().getAbsolutePath());

            System.out.print(file);

            try{ 
                decompressor.method(file);
            }

            catch(Exception ee) {

                JOptionPane.showMessageDialog(null, ee.toString());

            }
        }
    }
}
}
            
