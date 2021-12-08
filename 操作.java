import java.util.*;
public class 操作 {
    public static Scanner sc=new Scanner (System.in);
    public static void main(String[] args){
        Student[] s = new Student[4];
        s[0] = new Student(1,"张三",101,69,80);
        s[1] = new Student(2,"李四",102,55,92);
        s[2] = new Student(3,"王五",103,50,66);
        s[3] = new Student(4,"赵六",104,79,76);
        action_menu();
    }

    public static void action_menu() {
        System.out.println("***********************");
        System.out.println("*    1.查看学生成绩      *");
        System.out.println("*    2.修改学生成绩      *");
        System.out.println("*    3.添加学生成绩      *");
        System.out.println("*    4.删除学生成绩      *");
        System.out.println("*    5.统计学生成绩      *");
        System.out.println("*    6.查找学生成绩      *");
        System.out.println("*    7.降序排列学生成绩   *");
        System.out.println("*    8.结束             *");
        System.out.println("************************");
    }
}
