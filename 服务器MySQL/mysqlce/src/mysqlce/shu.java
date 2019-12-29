package mysqlce;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class shu extends JFrame{

    private TreePath path;//path声明为全局变量 方便使用 方便赋值处理

    public static void main(String[] args) {

        shu main14 = new shu();
        main14.run();
    }

    public void run() {

        //创建操作按钮
        JButton AddBtn = new JButton("添加");
        AddBtn.setBounds(400, 20, 65, 30);

        JTextField textField = new JTextField();
        textField.setBounds(300, 20, 90, 30);

        //创建root节点
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("国务院");
        //绑定root节点
        JTree tree = new JTree(root);
        //设置为单选模式 防止多选 一个textfield添加到多个节点下
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tree);
        scrollPane.setBounds(20, 20, 250, 400);

        /**
         * 新增加的节点自动展开的核心代码
         * */
        tree.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //获取选择的节点的path路径
                path = e.getPath();

            }
        });

        //对AddBtn添加监听器
        /**
         * 动态添加节点 的核心代码
         * */
        AddBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String context = textField.getText();//获取文本框文本内容

                DefaultMutableTreeNode temp = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
                //将获取到的内容添加到temp节点下
                temp.add(new DefaultMutableTreeNode(context));
                //自动展开新添加的节点 目的是更好的用户体验
               
                
                tree.updateUI();
                textField.setText("");//清空textField
            }
        });

        Container container = this.getContentPane();
        container.add(scrollPane);
        container.add(AddBtn);
        container.add(textField);
        // 设置布局管理器
        this.setLayout(null);
        /**
         * 设置窗体属性
         */
        this.setTitle("动态添加Tree型结构-自由设置国务院的组织架构");
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);// 设置居中显示
        // 设置Jframe窗体关闭时 程序结束
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}