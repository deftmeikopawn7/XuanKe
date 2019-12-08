
package com.pag_1;
import java.awt.*;  
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.*;  
import javax.swing.JButton;
import java.awt.color.*;
import javax.swing.JOptionPane;
import com.pag_1.MainUI;  
public class StdUI extends JFrame implements ActionListener  
{  
 
         //定义组件  
        JButton jb1=new JButton();
        JButton jb2=new JButton(); 
        JPanel jp1,jp2=null;  
        JLabel jlb1,jlb2,jlb3,jlb4,jlb5=null;  
 
        public static void main(String[] args)
        {  
          StdUI  ui=new StdUI();  
        }  
        //构造函数  
        public  StdUI()
        {  
        	MainUI id1 = new MainUI();
        	id1.setVisible(false);
        	MainUI pa1 = new MainUI();
        	pa1.setVisible(false);
        	
            jb1=new JButton("选课");  
            jb1.setForeground(Color.BLUE);
            jb2=new JButton("成绩查询");  
            jb2.setForeground(Color.BLUE);
 
            jp1=new JPanel();  
            jp2=new JPanel();  
 
            jlb1=new JLabel("姓名：" + id1.id);  
            jlb2=new JLabel("学号：" + pa1.pa);  
 
            jp1.add(jlb1); 
            jp1.add(jlb2);  
 
            jp2.add(jb1);  
            jp2.add(jb2);  
 
            this.add(jp1);  
            this.add(jp2);  

            //设置布局管理器  
            this.setLayout(new GridLayout(4,3,50,50));  
            this.setTitle("学生成绩管理系统");  
            this.setSize(400,300);  
            this.setLocation(200, 200);
 
            setVisible(true); 
            jb1.addActionListener(this);
            jb2.addActionListener(this);
			}
 
 
        
 
        public void actionPerformed(ActionEvent e) {  
             if(e.getSource() == jb1){
                //关闭当前界面  
                 dispose();  
                 new XueshengXuanke();
                }else if(e.getSource() == jb2){
                    //关闭当前界面  
                    dispose();  
                    new KeChengBiaoUI();
                }
 
        }  
} 
