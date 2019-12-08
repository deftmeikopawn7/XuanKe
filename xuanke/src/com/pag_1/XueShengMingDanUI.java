package com.pag_1;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
 
public class XueShengMingDanUI extends JFrame  
{  
 
    public XueShengMingDanUI()  
    {  
        intiComponent();  
    }  
 
     //初始化窗体组件 
    private void intiComponent()  
    {  
        // 设置JTable的列名   
        String[] columnNames =  
        { "学号","姓名",  "专业", "班级"};  
        Object[][] obj=new Object[7][7];  
        for (int i=0;i<7;i++)  
        {  
            for(int j=0;j<7;j++)  
            {  
                switch (j)  
                {  
                case 0:  
                    obj[0][0] = "       2018311000";
                    obj[0][1] = "             刘沂"; 
                    obj[0][2] = "     信息工程学院"; 
                    obj[0][3] = "                    2";    
                    break;  
                case 1:  
                    obj[1][0] = "       2018310981";
                    obj[1][1] = "           付子骏"; 
                    obj[1][2] = "     信息工程学院"; 
                    obj[1][3] = "                    2"; 
                    break;  
                case 2:  
                    obj[2][0] = "       2018310984";
                    obj[2][1] = "			赵英俊"; 
                    obj[2][2] = "     信息工程学院"; 
                    obj[2][3] = "                    2"; 
                    break;  
                case 3:  
                    obj[3][0] = "       2018310985";
                    obj[3][1] = "            曹力"; 
                    obj[3][2] = "    信息工程学院"; 
                    obj[3][3] = "                    2";                  
                    break;  
                case 4:  
                    obj[4][0] = "       2018310982";
                    obj[4][1] = "            李四"; 
                    obj[4][2] = "    通信工程学院"; 
                    obj[4][3] = "                    2"; 
                    break;  
                case 5:  
                    obj[5][0] = "       2018310986";
                    obj[5][1] = "            张三"; 
                    obj[5][2] = "    通信工程学院"; 
                    obj[5][3] = "             2"; 
                    break;  
                case 6:  
                    obj[6][0] = "       2018310987";
                    obj[6][1] = "            马海"; 
                    obj[6][2] = "    通信工程学院"; 
                    obj[6][3] = "                    2";                 
                    break;  
 
                }  
            }  
        }  
 
        JTable table=new JTable(obj, columnNames);  //JTable的其中一种构造方法 
        TableColumn column=null;                    //设置JTable的列默认的宽度和高度 
        int colunms = table.getColumnCount();  
        for(int i=0;i<colunms;i++)  
        {  
            column = table.getColumnModel().getColumn(i);  
            column.setPreferredWidth(100);           //将每一列的默认宽度设置为100
        }   
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  //设置JTable自动调整列表的状态，此处设置为关闭                 
        JScrollPane scroll = new JScrollPane(table);  //用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看 
        scroll.setSize(300, 50);         
 
        add(scroll); 
 
        this.setLocation(450, 200); 
        this.setVisible(true);  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.pack();  
        
        try {        		                
        	FileWriter f= new FileWriter("C:\\Users\\惠普\\Desktop\\Tea_XueShengMingDan_infor_done.txt") ;	// 声明File对象

                for (int i = 0; i < columnNames.length; i++) {
                	for (int k=0;i<6;i++)  
                    {  
                        for(int j=0;j<3;j++)  
                        {  
                    f.write(columnNames[i] + "\n" + obj[k][j]);
                  }
    	     	 // 第4步、关闭输出流
    	     	
            } 
                }f.close() ;
            }catch (IOException e1) {
                e1.printStackTrace();
            }
    }  
 
    public static void main(String[] args)  
    {  
        new XueShengMingDanUI();  
    }  
}  
