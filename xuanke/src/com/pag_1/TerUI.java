package com.pag_1;
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
import javax.swing.JButton;
import com.pag_1.MainUI;  
public class TerUI extends JFrame implements ActionListener  
{   
         //定义组件  
        JButton jb1,jb2=null;  
        JPanel jp1,jp2=null;  
        JLabel jlb1,jlb2,jlb3=null;  
 
        public static void main(String[] args) {            
          TerUI  ui=new TerUI();  
        }    
        public  TerUI()  
        {  
            //创建组件  
            jb1=new JButton("课程管理");
            jb1.setForeground(Color.BLUE);
            jb2=new JButton("学生名单");  
            jb2.setForeground(Color.BLUE);
 
            jp1=new JPanel();  
            jp2=new JPanel();  

 
            jlb1=new JLabel("姓名：");  
            jlb2=new JLabel("工号：");  
 
            jp1.add(jlb1); 
            jp1.add(jlb2);  
 
            jp2.add(jb1);  
            jp2.add(jb2);  


 
            this.add(jp1);  
            this.add(jp2);  
 
            this.setLayout(new GridLayout(3,5,70,70));  //设置布局管理器  
            this.setTitle("学生选课管理系统");  
            this.setSize(400,300);  
            this.setLocation(200, 200);       
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            this.setVisible(true);            
            jb1.addActionListener(this);
            jb2.addActionListener(this);
}  
        public void actionPerformed(ActionEvent e) {  
             if(e.getSource() == jb1){              
                  dispose();  
                  new KeChengGuanLiUI();                //创建一个新界面  
                }else if(e.getSource() == jb2){
                  dispose();  
                  new XueShengMingDanUI();              //创建一个新界面  
                }
 
        }  
} 
