import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.Border;
import java.awt.*;
class test{
	static JFrame frame;
	static Container c;
	public static void main(String[] args) {
    frame=new JFrame();
    c=frame.getContentPane();
    c.setLayout(null);
    c.setBackground(Color.yellow);
    frame.setVisible(true);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(820,1030);
    frame.setLocationRelativeTo(null);
    move panel=new move();
    c.add(panel);
    frame.revalidate();
    frame.repaint();
	}
}
class move extends JPanel implements AdjustmentListener,ActionListener{
JPanel panel1,panel2,result_panel;
JScrollBar row1,col1,row2,col2;
int row_num1=5,col_num1=5,row_num2=5,col_num2=5;
int result_row=0,result_col=0;
JTextField matrix1_array[][];
JTextField matrix2_array[][];
JLabel matrix3_array[][];
double  matrix1[][],matrix2[][],result_array[][];
Border line;
JButton add,sub,mul,div;
JLabel warning;

public void paint(Graphics g){
super.paint(g);
Graphics2D g2=(Graphics2D)g;
g2.setColor(Color.green);
g2.setFont(new Font("Arial",Font.BOLD,30));
g2.drawString("Matrix 1",120,240);
g2.drawString("Matrix 2",535,240);
g2.drawString("Result Matrix",280,905);
g2.setStroke((new BasicStroke(5)));
g2.drawLine(385,0,385,320);
g2.drawLine(0,320,770,320);
g2.drawLine(0,375,770,375);
g2.setColor(Color.cyan);
g2.setFont(new Font("Arial",Font.BOLD,20));
g2.drawString("Row Number:"+row_num1,0,300);
g2.drawString("Column Number:"+col_num1,184,300);
g2.drawString("Row Number:"+row_num2,415,300);
g2.drawString("Column Number:"+col_num2,599,300);
  }


move(){
line=BorderFactory.createLineBorder(Color.green);

row1=new JScrollBar(JScrollBar.HORIZONTAL,5,0,1,5);
col1=new JScrollBar(JScrollBar.HORIZONTAL,5,0,1,5);
row2=new JScrollBar(JScrollBar.HORIZONTAL,5,0,1,5);
col2=new JScrollBar(JScrollBar.HORIZONTAL,5,0,1,5);

row1.setBounds(0,260,170,20);row1.setFont(new Font("Arial",Font.BOLD,25));
col1.setBounds(184,260,170,20);col1.setFont(new Font("Arial",Font.BOLD,25));

row2.setBounds(415,260,170,20);row2.setFont(new Font("Arial",Font.BOLD,25));
col2.setBounds(599,260,170,20);col2.setFont(new Font("Arial",Font.BOLD,25));

row1.addAdjustmentListener(this);
col1.addAdjustmentListener(this);

row2.addAdjustmentListener(this);
col2.addAdjustmentListener(this);


panel1=new JPanel();
panel2=new JPanel();
result_panel=new JPanel();
panel1.setBounds(0,0,355,200);
panel2.setBounds(415,0,355,200);
result_panel.setBounds(0,385,770,490);


matrix1_show();matrix2_show();

add=new JButton("+");add.setFont(new Font("Arial",Font.BOLD,45));add.setForeground(Color.red);
sub=new JButton("-");sub.setFont(new Font("Arial",Font.BOLD,45));sub.setForeground(Color.red);
mul=new JButton("*");mul.setFont(new Font("Arial",Font.BOLD,45));mul.setForeground(Color.red);
div=new JButton("/");div.setFont(new Font("Arial",Font.BOLD,45));div.setForeground(Color.red);

add.setBounds(0,322,192,50);add.addActionListener(this);
sub.setBounds(192,322,192,50);sub.addActionListener(this);
mul.setBounds(388,322,192,50);mul.addActionListener(this);
div.setBounds(578,322,192,50);div.addActionListener(this);

warning=new JLabel("Wrong Input");
warning.setFont(new Font("Arial",Font.BOLD,35));
warning.setForeground(Color.red);
warning.setBounds(275,915,220,40);
warning.setVisible(false);


this.setBounds(15,15,770,960);
this.setBackground(Color.black);
this.setLayout(null);
this.add(panel1);
this.add(panel2);
this.add(result_panel);
this.add(row1);
this.add(row2);
this.add(col1);
this.add(col2);
this.add(add);
this.add(sub);
this.add(mul);
this.add(div);
this.add(warning);
      }
public void adjustmentValueChanged(AdjustmentEvent event){
warning.setVisible(false);	
if(event.getSource()==row1){
row_num1=1;    
row_num1=row1.getValue();
matrix1_show();
     }
if(event.getSource()==col1){
col_num1=1;    
col_num1=col1.getValue();
matrix1_show();
     }
if(event.getSource()==row2){
row_num2=1;    
row_num2=row2.getValue();
matrix2_show();
     }
if(event.getSource()==col2){
col_num2=1;    
col_num2=col2.getValue();
matrix2_show();

     }
if(row_num1!=row_num2 || col_num1!=col_num2){
add.setEnabled(false);
sub.setEnabled(false);
div.setEnabled(false);
   }
else{
add.setEnabled(true);
sub.setEnabled(true);
div.setEnabled(true);
   }
if(col_num1!=row_num2)
mul.setEnabled(false);
else
mul.setEnabled(true);    
repaint();

  }


public void matrix1_show(){
panel1.setLayout(new GridLayout(row_num1,col_num1));    
matrix1_array=new JTextField[row_num1][col_num1];
panel1.removeAll();
for(int i=0;i<row_num1;i++){
    for(int j=0;j<col_num1;j++){
        matrix1_array[i][j]=new JTextField("");
        matrix1_array[i][j].setFont(new Font("Arial",Font.BOLD,20));
        panel1.add(matrix1_array[i][j]);
        }
      }
panel1.revalidate();
     }
public void matrix2_show(){
panel2.setLayout(new GridLayout(row_num2,col_num2));   
matrix2_array=new JTextField[row_num2][col_num2]; 
panel2.removeAll();
for(int i=0;i<row_num2;i++){
    for(int j=0;j<col_num2;j++){
        matrix2_array[i][j]=new JTextField("");
        matrix2_array[i][j].setFont(new Font("Arial",Font.BOLD,20));
        panel2.add(matrix2_array[i][j]);
      }
    } 
panel2.revalidate();
      }
public void actionPerformed(ActionEvent action){
boolean status=true;    
matrix1=new double[row_num1][col_num1];   
matrix2=new double [row_num2][col_num2];

try{
for(int i=0;i<row_num1;i++)
    for(int j=0;j<col_num1;j++)
        matrix1[i][j]=Double.parseDouble(matrix1_array[i][j].getText());

for(int i=0;i<row_num2;i++)
    for(int j=0;j<col_num2;j++)
        matrix2[i][j]=Double.parseDouble(matrix2_array[i][j].getText());
}
catch(Exception e){
warning.setVisible(true);	
status=false;	
}
if(status!=false)
    warning.setVisible(false); 
else{
    result_panel.removeAll();  
    result_panel.revalidate();
    result_panel.repaint();
   } 
result_panel.removeAll();
if(action.getSource()==add && status==true)
matrix_add();
if(action.getSource()==sub && status==true)
matrix_sub();     
if(action.getSource()==mul && status==true)
matrix_mul();
if(action.getSource()==div && status==true)
matrix_div();
}
public void matrix_add(){
result_array=new double[row_num1][col_num1];
matrix3_array=new JLabel[row_num1][col_num1];
result_panel.setLayout(new GridLayout(row_num1,col_num1)); 
for(int i=0;i<row_num1;i++){
    for(int j=0;j<col_num1;j++){
        result_array[i][j]=matrix1[i][j]+matrix2[i][j];
        matrix3_array[i][j]=new JLabel(""+result_array[i][j],JLabel.CENTER);
        matrix3_array[i][j].setFont(new Font("Arial",Font.BOLD,25));
        matrix3_array[i][j].setBorder(line);
        result_panel.add(matrix3_array[i][j]);
         }
       }
    result_panel.revalidate();   
    }
public void matrix_sub(){
result_array=new double[row_num1][col_num1];
matrix3_array=new JLabel[row_num1][col_num1];
result_panel.setLayout(new GridLayout(row_num1,col_num1)); 
for(int i=0;i<row_num1;i++){
    for(int j=0;j<col_num1;j++){
        result_array[i][j]=matrix1[i][j]-matrix2[i][j];
        matrix3_array[i][j]=new JLabel(""+result_array[i][j],JLabel.CENTER);
        matrix3_array[i][j].setFont(new Font("Arial",Font.BOLD,25));
        matrix3_array[i][j].setBorder(line);
        result_panel.add(matrix3_array[i][j]);
      }
    }
    result_panel.revalidate();
  }
public void matrix_div(){
result_array=new double[row_num1][col_num1];
matrix3_array=new JLabel[row_num1][col_num1];
result_panel.setLayout(new GridLayout(row_num1,col_num1)); 
for(int i=0;i<row_num1;i++){
    for(int j=0;j<col_num1;j++){
        result_array[i][j]=matrix1[i][j]/matrix2[i][j];
        matrix3_array[i][j]=new JLabel(""+result_array[i][j],JLabel.CENTER);
        matrix3_array[i][j].setFont(new Font("Arial",Font.BOLD,25));
        matrix3_array[i][j].setBorder(line);
        result_panel.add(matrix3_array[i][j]);
       }
     }
   result_panel.revalidate();  
   }

public void matrix_mul(){
result_array=new double[row_num1][col_num2];
matrix3_array=new JLabel[row_num1][col_num2];
result_panel.setLayout(new GridLayout(row_num1,col_num2));
for(int i=0;i<row_num1;i++)
    for(int j=0;j<col_num2;j++)
        for(int k=0;k<col_num1;k++)
        result_array[i][j]+=matrix1[i][k]*matrix2[k][j];

 for(int i=0;i<row_num1;i++)
    for(int j=0;j<col_num2;j++){
         matrix3_array[i][j]=new JLabel(""+result_array[i][j],JLabel.CENTER);
        matrix3_array[i][j].setFont(new Font("Arial",Font.BOLD,25));
        matrix3_array[i][j].setBorder(line);
        result_panel.add(matrix3_array[i][j]);
    }
result_panel.revalidate();
   }
}