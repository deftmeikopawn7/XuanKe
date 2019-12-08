# XuanKe
选课
# **综合性实验  学生选课系统设计**
## 一、实验目的
分析学生选课系统
使用GUI窗体及其组件设计窗体界面
完成学生选课过程业务逻辑编程
基于文件保存并读取数据
处理异常

## 二、实验要求
### 1、系统角色分析及类设计
例如：学校有“人员”，分为“教师”和“学生”，教师教授“课程”，学生选择课程。
定义每种角色人员的属性，及其操作方法。
属性示例：	人员（编号、姓名、性别……）
教师（编号、姓名、性别、所授课程、……）
			学生（编号、姓名、性别、所选课程、……）
			课程（编号、课程名称、上课地点、时间、授课教师、……）
以上属性仅为示例，同学们可以自行扩展。

### 2、要求:
（1）、	设计GUI窗体，支持学生注册、课程新加、学生选课、学生退课、打印学生选课列表等操作。
（2）、	基于事件模型对业务逻辑编程，实现在界面上支持上述操作。
（3）、	针对操作过程中可能会出现的各种异常，做异常处理
（4）、	基于输入/输出编程，支持学生、课程、教师等数据的读写操作。
（5）、	基于Github.com提交实验，包括实验SRC源文件夹程序、README.MD实验报告文档。

## 三、实验过程
### 1.登录页面代码完善过程
#### 1.1学生登录时用户名密码的判断

    	  try {
                    //读取存储学生信息的文件StuInformation.txt
    			FileReader reader = new FileReader("C:\\Users\\惠普\\Desktop\\StuInformation.txt");
                    //创建缓冲区
    			BufferedReader br = new BufferedReader(reader);    
                    //创建空字符串
    			String str = " ";            
                    //按行读取，直到没有下一行
    			while ((str  = br.readLine()) != null) {                                           
    				String[] strinfor =str.split(" ");  
                          //将读取到的信息按空格分开，此时获得的信息分别为用户名和密码
    	            if(strinfor[0].equals(jtf.getText())){    
                              //对用户名进行判断，如果相等则判断与此用户名对应的密码
    	                if(strinfor[1].equals(jpf.getText())){                                  
    			        JOptionPane.showMessageDialog(null,"登录成功！","提示消息",JOptionPane.WARNING_MESSAGE);
    		            StdUI ui=new StdUI();
                           //这一步是将当前用户名放置在字符串缓冲区StringBuffer，为了登录后的页面显示姓名与学号//但貌似不行。。。
    		            id.append(strinfor[0]);                                                   
    		            pa.append(strinfor[1]);
                           //如果用户名密码正确要退出当前按行读取文件的操作，不然会继续判断以下四种情况，下面的四个break同理
    		            break;
    		            }
    				}else if(jtf.getText().isEmpty()&&jpf.getText().isEmpty())
    	        {
    	            JOptionPane.showMessageDialog(null,"请输入用户名和密码！","提示消息",JOptionPane.WARNING_MESSAGE);
    	            break;
    	        	}else if(jtf.getText().isEmpty())
    	        {
    	            JOptionPane.showMessageDialog(null,"请输入用户名！","提示消息",JOptionPane.WARNING_MESSAGE);
    	            break;
    	        	}else if(jpf.getText().isEmpty())
    	        {
    	            JOptionPane.showMessageDialog(null,"请输入密码！","提示消息",JOptionPane.WARNING_MESSAGE);
    	            break;
    	        	}else
    	        {
    	            JOptionPane.showMessageDialog(null,"用户名或者密码错误！\n请重新输入","提示消息",JOptionPane.ERROR_MESSAGE);
    	            clear();
    	            break;
    	        }
    			}
    			br.close();//切记要关闭文件
    			reader.close();
    			}catch(IOException e){
        		System.out.println(e);

	
在学生登录时，读取本地txt文件，此文件存储了学生用户名及密码，将读取到的文件进行处理，再与登录页面用户输入的用户名密码进行比较，根据具体情况，在不同情况下输出不同的提示。并且将此过程放入异常处理try，catch结构中。具体每步代码功能的实现见注释。

#### 1.2教师登录时用户名密码的判断
同学生登录时用户名密码的判断，信息储存地址有所变化。文件名为TeaInformation.txt

### 2.登录成功后页面代码完善
#### 2.1学生登录成功后页面代码
            	MainUI id1 = new MainUI();
            	id1.setVisible(false);  //将实例化的登录页面隐藏
            	MainUI pa1 = new MainUI();
            	pa1.setVisible(false);   //将实例化的登录页面隐藏
     
                jlb1=new JLabel("姓名：" + id1.id);  
                jlb2=new JLabel("学号：" + pa1.pa);  

由于要调用登录页面类中属性，使得能够在此页面显示学生姓名和学号，因此在构造函数中实例化登录页面类，调用存储了当前成功登录的学生信息的StringBuffer。//这个方法失败了。。。

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

此代码为按钮事件判断，jb1为选课按钮，点击后转到选课界面。jb2为课程表按钮，点击后转到输出课程表的页面。


#### 2.2教师登录成功后页面代码
同学生登录成功后页面代码
            public void actionPerformed(ActionEvent e) {  
                 if(e.getSource() == jb1){              
                      dispose();  
                      new KeChengGuanLiUI();                //创建一个新界面  
                    }else if(e.getSource() == jb2){
                      dispose();  
                      new XueShengMingDanUI();              //创建一个新界面  
                    }
     
            }  

教师在功能选择上，有课程管理，用来显示课程安排。还有学生名单功能，用来显示学生信息。


### 3.学生选课页面代码
    			    public void actionPerformed(ActionEvent e) {
    			            	StringBuilder info=new StringBuilder();
    			                if(cb1.isSelected()){
    			                    String c=cb1.getText();
    			                    String t=t1.getSelectedItem().toString();
    			                    info.append(":"+c+t);
    			                }
    			                if(cb2.isSelected()){
    			                    String c=cb2.getText();
    			                    String t=t2.getSelectedItem().toString();
    			                    info.append(","+c+t);
    			                }
    			                if(cb3.isSelected()){
    			                    String c=cb3.getText();
    			                    String t=t3.getSelectedItem().toString();
    			                    info.append(","+c+t);
    			                }
    			                allInfo.setText(info.toString());                     // 把学生信息和选课信息放到文本框中
    			                String XKinfor_done = allInfo.getText().toString();			                
    			            	File f= new File("C:\\Users\\惠普\\Desktop\\Stu_Xuanke_infor_done.txt") ;	// 声明File对象
    			             	Writer out = null;	
    			                try {
    			                	out = new FileWriter(f,true) ;
    			        			// 第3步、进行写操作
    			        	        out.write(XKinfor_done) ;// 将内容输出，保存文件
    			        	     	 // 第4步、关闭输出流
    			        	     	out.close() ;
    			                } catch (IOException e1) {
    			                    e1.printStackTrace();
    			                }
    			            }


在此页面，学生选课的信息会显示在文本框中，将此信息获取并转化为字符串格式，存储到文件中，文件名为Stu_Xuanke_infor_done.txt。


### 4.学生课程表页面
    String[] columnNames =  
            { "课节数","星期一", "星期二", "星期三", "星期四", "星期五", "星期六","星期日" };  
     
            Object[][] obj=new Object[8][8];  
            for (int i=0;i<8;i++)  
            {  
                for(int j=0;j<8;j++)  
                {  
                    switch (j)  
                    {  
                    case 0:  
                        obj[0][0] = "第一节课";
                        obj[0][1] = "高等数学"; 
                        obj[0][2] = "大学物理"; 
                        obj[0][3] = "电路与模拟电子技术"; 
                        obj[0][4] = "线性代数"; 
                        obj[0][5] = " "; 
                        obj[0][6] = "英语读写译"; 
                        obj[0][7] = " "; 
                        break;  
                    case 1:  
                        obj[1][0] = "第二节课";
                        obj[1][1] = "高等数学"; 
                        obj[1][2] = "英语视听说"; 
                        obj[1][3] = "大学物理"; 
                        obj[1][4] = "英语读写译"; 
                        obj[1][5] = " "; 
                        obj[1][6] = "线性代数"; 
                        obj[1][7] = " ";  
                        break;  
                    case 2:  
                        obj[2][0] = "第三节课";
                        obj[2][1] = "java"; 
                        obj[2][2] = " "; 
                        obj[2][3] = " "; 
                        obj[2][4] = "大学物理实验"; 
                        obj[2][5] = "线性代数"; 
                        obj[2][6] = "英语读写译"; 
                        obj[2][7] = " ";   
                        break;  
                    case 3:  
					······

    try {        		                
            	FileWriter f= new FileWriter("C:\\Users\\惠普\\Desktop\\Stu_KeChengBiao_infor_done.txt") ;	// 声明File对象
    
                    for (int i = 0; i < columnNames.length; i++) {
                    	for (int k=0;i<8;i++)  
                        {  
                            for(int j=0;j<8;j++)  
                            {  
                        f.write(columnNames[i] + "\n" + obj[k][j]);
                      }
        	     	 // 第4步、关闭输出流
        	     	
                } 
                    }f.close() ;
                }catch (IOException e1) {
                    e1.printStackTrace();
                }


写出课程表信息，存储到文件中。


### 5.教师课程管理页面
    String[] columnNames =  
            { "课节数","星期一", "星期二", "星期三", "星期四", "星期五", "星期六","星期日" };           
            Object[][] obj=new Object[8][8];  
            for (int i=0;i<8;i++)  
            {  
                for(int j=0;j<8;j++)  
                {  
                    switch (j)  
                    {  
                    case 0:  
                        obj[0][0] = "  第一节课";
                        obj[0][1] = "      有课"; 
                        obj[0][2] = " "; 
                        obj[0][3] = " "; 
                        obj[0][4] = "      有课"; 
                        obj[0][5] = " "; 
                        obj[0][6] = ""; 
                        obj[0][7] = " "; 
                        break;  
                    case 1:  
                        obj[1][0] = "  第二节课";
                        obj[1][1] = "      有课"; 
                        obj[1][2] = ""; 
                        obj[1][3] = ""; 
                        obj[1][4] = "      有课"; 
                        obj[1][5] = " "; 
                        obj[1][6] = ""; 
                        obj[1][7] = " ";  
                        break;  
                    case 2:  
					······

            try {        		                
        	FileWriter f= new FileWriter("C:\\Users\\惠普\\Desktop\\Tea_KechengGuanli_infor_done.txt") ;	// 声明File对象
    
                for (int i = 0; i < columnNames.length; i++) {
                	for (int k=0;i<8;i++)  
                    {  
                        for(int j=0;j<8;j++)  
                        {  
                    f.write(columnNames[i] + "\n" + obj[k][j]);
                  }
    	     	 // 第4步、关闭输出流
    	     	
            } 
                }f.close() ;
            }catch (IOException e1) {
                e1.printStackTrace();
            }

写出教师课程信息，存储到文件中。

### 6.教师管理学生名单页面
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
					······

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

## 四、程序调试过程
整体看来，有一些功能不能很好的实现。在程序中，也有一些点不能实现，比如在学生登录成功后页面，不能获取到当前成功登录的学生的信息。还需要不断学习，继续完善。

## 五、程序运行结果
图片上传了

## 六、实验感想
在整个java课程学习的过程中，感受到了代码的强大以及他的乐趣。起初对代码的格式、函数名、方法名都不太熟悉，对于一些代码只能死记硬背。但其实，多看一些案例，多动手写写代码，就会越来越理解每句代码的含义，每个方法的用法。以后我也会不断学习，继续进步。
