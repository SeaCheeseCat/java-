package study;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

/**
 * @author ZXR
 */
public class StudyMainClass {

    private static JLabel label = new JLabel();

    private static String file = "C:\\Users\\18948\\Desktop\\st.txt";

    private static String image = "C:\\Users\\18948\\Desktop\\GM.jpg";

    private static LinkedList<xx> students = new LinkedList<>();

    public static void main(String[] args) {
        readFile();
        JFrame jFrame = new JFrame("简单的学生系统");
        jFrame.setSize(400,500);
        jFrame.setLocation(400,200);
        jFrame.setLayout(new BorderLayout());
        JPanel jPanel = new JPanel();
        jPanel.add(new JButton("图片"){
            JButton add(){
                this.addActionListener(e -> {
                    label.setText(null);
                    label.setIcon(new ImageIcon(image));
                    repaint();
                });
                return this;
            }
        }.add());
        jPanel.add(new JButton("添加学生"){
            JButton add(){
                this.addActionListener(e -> {
                    label.setIcon(new ImageIcon(image));
                    JFrame menu = new JFrame("输入学生信息");
                    TextField f1 = new TextField();
                    TextField f2 = new TextField();
                    menu.setLayout(new GridLayout(0,1));
                    menu.add(new JLabel("姓名"));
                    menu.add(f1);
                    menu.add(new JLabel("学号"));
                    menu.add(f2);
                    menu.add(new JLabel());
                    menu.add(new JButton("提交"){
                        JButton add(){
                            this.addActionListener(e1 -> {
                                String t1 = f1.getText().trim();
                                String t2 = f2.getText().trim();
                                if(!"".equals(t1) && !"".equals(t2)){
                                    JOptionPane.showMessageDialog(null,"保存成功");
                                    students.add(new xx(t2,t1));
                                    menu.setVisible(false);
                                    label.setText(labelString());
                                    write();
                                    repaint();
                                }
                            });
                            return this;
                        }

                    }.add());
                    menu.setLocation(500,400);
                    menu.setSize(350,200);
                    menu.setVisible(true);
                });
                return this;
            }

        }.add(),BorderLayout.WEST);
        jPanel.add(new JButton("删除学生"){
            JButton add(){
                this.addActionListener(e -> {
                    JFrame menu = new JFrame("双击删除");
                    JScrollPane scrollPane=new JScrollPane();
                    menu.setLayout(new GridLayout(0,1));

                    scrollPane.setViewportView(new JList<xx>(students.toArray(new xx[0])){
                        JList add(){
                            this.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    if(e.getClickCount() == 2){
                                        xx selected = getModel().getElementAt(getSelectedIndex());
                                        if(JOptionPane.showConfirmDialog(null,"确定要删除吗?","提示",JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION){
                                            students.remove(selected);
                                            write();
                                            label.setText(labelString());
                                            JOptionPane.showMessageDialog(null,"删除成功");
                                            menu.setVisible(false);
                                            repaint();
                                        }
                                    }
                                }
                            });
                            return this;
                        }
                    }.add());
                    menu.add(scrollPane);
                    menu.setLocation(500,400);
                    menu.setSize(350,200);
                    menu.setVisible(true);
                });
                return this;
            }
        }.add(),BorderLayout.CENTER);
        jPanel.add(new JButton("查询学生"){
            JButton add(){
                this.addActionListener(e5 -> {
                    label.setIcon(null);
                    label.setText(labelString());
                    repaint();

                });
                return this;
            }
        }.add(),BorderLayout.EAST);
        jFrame.add(jPanel,BorderLayout.SOUTH);
        JLabel l = new JLabel("<html> <h1>欢迎使用学生系统</h1></html>");
        JPanel jp = new JPanel();
        jp.add(l);
        label = new JLabel(new ImageIcon(image));
        jFrame.add(label);
        jp.setSize(300,300);
        jFrame.add(jp,BorderLayout.NORTH);
        jFrame.setVisible(true);
    }
    private static String labelString(){
        StringBuilder s = new StringBuilder();
        s.append("<html>");
        for(xx x:students){
            s.append("<h3>").append(x.toString()).append("</h3>").append("<br>");
        }
        s.append("</html>");
        return s.toString();
    }
    private static void readFile(){

        if(!new File(file).exists()){
            try {
                if(!new File(file).createNewFile()){
                    System.out.println("文件创建失败");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        LinkedList<String> lists = new LinkedList<>(readTxtFileIntoStringArrList());
        if(lists.size() > 0){
            for(String s1:lists){
                if(s1 != null && !"null".equals(s1)){
                    students.add(new xx(s1.split(":")[0].trim(),s1.split(":")[1].trim()));
                }
            }
        }

    }
    private static void write(){
        if(!new File(file).exists()){
            try {
                if(!new File(file).createNewFile()){
                    System.out.println("文件创建失败");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter writer = new FileWriter(file);
            BufferedWriter w = new BufferedWriter(writer);
            for(xx x:students){
                w.write(x.save()+"\n");
            }
            w.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static List<String> readTxtFileIntoStringArrList()
    {
        List<String> list = new ArrayList<>();
        try
        {
            String encoding = "UTF-8";
            File file = new File(StudyMainClass.file);
            if (file.isFile() && file.exists())
            { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null)
                {
                    list.add(lineTxt);
                }
                bufferedReader.close();
                read.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }
}
class xx{
    private String id,name;
    xx(String id,String name){
        this.id = id;
        this.name = name;
    }

    private String getName() {
        return name;
    }

    private String getId() {
        return id;
    }

    String save(){
        return id+":"+name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof xx){
            return id.equals(((xx) obj).getId());
        }
        return false;
    }

    @Override
    public String toString() {
        return "学号: "+id+"     姓名: "+name;
    }
}
