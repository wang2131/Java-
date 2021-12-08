import java.util.*;
public class 操作 {
    public static Scanner sc=new Scanner (System.in);
    public static void main(String[] args){
        Student[] s = new Student[4];
        s[0] = new Student(1,"张三",101,69,80);
        s[1] = new Student(2,"李四",102,55,92);
        s[2] = new Student(3,"王五",103,50,66);
        s[3] = new Student(4,"赵六",104,79,76);
        action_menu(s);
    }

    public static void action_menu(Student[] s) {
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
        while(true) {
            System.out.print("请输入你想执行的操作：");
            int a = sc.nextInt();
            if (a <= 0 || a > 8) {
                System.out.print("请输入正确的数字：");
                a = sc.nextInt();
            }
            switch(a){
                case 1:chakan(s);break;
                case 2:xiugai(s);break;
                case 3:tianjia(s);break;
                case 4:shanchu(s);break;
                case 5:tongji(s);break;
                case 6:chazhao(s);break;
                case 7:paixu(s);break;
                default:return;
                }
        }

    }

    public static void chakan(Student[] s)//查看学生成绩
    {
        for(int i=0;i<s.length;i++){
            System.out.println("序号："+s[i].getXuhao());
            System.out.println("姓名："+s[i].getName());
            System.out.println("学号："+s[i].getXuehao());
            System.out.println("课程一："+s[i].getCourse1_score());
            System.out.println("课程二："+s[i].getCourse2_score());
            System.out.println();
        }
    }

    public static void xiugai(Student[] s)
    {
        System.out.print("请输入你想修改的学生序号：");
        int n = sc.nextInt();
        System.out.println("你想修改成绩的学生为：" +s[n-1].getName());
        System.out.print("请输入课程一的成绩：");
        int score1 = sc.nextInt();
        System.out.print("请输入课程二的成绩：");
        int score2 = sc.nextInt();
        s[n-1].setCourse1_score(score1);
        s[n-1].setCourse2_score(score2);
    }

    public static void tianjia(Student[] s){
        s=ensurestudent(s);
        s[s.length-1].setXuhao(s.length);
        System.out.print("请输入姓名：");
        String new_name = sc.next();
        s[s.length-1].setName(new_name);
        System.out.print("请输入学号：");
        int new_xuehao = sc.nextInt();
        s[s.length-1].setXuehao(new_xuehao);
        System.out.print("请输入课程一成绩：");
        int new_score1 = sc.nextInt();
        s[s.length-1].setCourse1_score(new_score1);
        System.out.print("请输入课程二成绩：");
        int new_score2 = sc.nextInt();
        s[s.length-1].setCourse2_score(new_score2);
    }

    public static void shanchu(Student[] s){
       while(true) {
           System.out.print("请输入删除的序号：");
           int n = sc.nextInt();
           if (n == s.length) {
               s=narrowstudent(s);
               System.out.println("删除成功");
               break;
           }
           else if (n > 0 && n < s.length) {

               for (int i = n-2; i <= s.length - 2; i++) {
                   s[i] = s[i + 1];
                   s[i].setXuhao(i+1);
               }
               s=narrowstudent(s);
               System.out.println("删除成功");
               break;
           }
           else System.out.println("不存在，请重新输入");
       }
    }

    public static void tongji(Student[] s){
        int average=0;
        int max=-1;
        int min=-1;
        System.out.print("请输入需要统计的课程名：");
        String s1 = sc.next();
        switch(s1){
            case "课程一" :
            {

                for(int i = 0;i < s.length;i++){
                  average = average+s[i].getCourse1_score();
                }
                average=average/s.length;
                System.out.println("课程一的平均分为"+average);
                for(int i=0; i<s.length;i++){
                    max=(s[i].getCourse1_score()>max ? s[i].getCourse1_score() : max);
                }
                System.out.println("课程的最高分为"+max);
                min=s[0].getCourse1_score();
                for(int i=0;i<s.length;i++){
                    min=(s[i].getCourse1_score()<min ? s[i].getCourse1_score() : min);
                }
                System.out.println("课程的最低分为"+min);
            }
            case "课程二" :
            {

                for(int i = 0;i < s.length;i++){
                    average = average+s[i].getCourse2_score();
                }
                average=average/s.length;
                System.out.println("课程二的平均分为"+average);
                for(int i=0; i<s.length;i++){
                    max=(s[i].getCourse2_score()>max ? s[i].getCourse2_score() : max);
                }
                System.out.println("课程二的最高分为"+max);
                min=s[0].getCourse2_score();
                for(int i=0;i<s.length;i++){
                    min=(s[i].getCourse2_score()<min ? s[i].getCourse2_score() : min);
                }
                System.out.println("课程二的最低分为"+min);
            }


        }
    }
    public static Student[] ensurestudent(Student[] s){
        Student[] new_student = new Student[s.length+1];
        System.arraycopy(s,0,new_student,0,s.length);
        new_student[s.length]= new Student(s.length+1,"null",0,0,0);
        return new_student;
    }
    public static Student[] narrowstudent(Student[] s){
        Student[] new_student = new Student[s.length-1];
        System.arraycopy(s,0,new_student,0,s.length-1);
        return new_student;
    }
    public static void chazhao(Student[] s){
        System.out.print("请输入需要查找的学号：");
        int chazhao_xuehao = sc.nextInt();
        for(int i=0;i<s.length;i++){
            if(s[i].getXuehao()==chazhao_xuehao){
                System.out.println("找到信息如下：");
                System.out.println("序号："+s[i].getXuhao());
                System.out.println("姓名："+s[i].getName());
                System.out.println("学号："+s[i].getXuehao());
                System.out.println("课程一："+s[i].getCourse1_score());
                System.out.println("课程二："+s[i].getCourse2_score());
                break;
            }
        }
        System.out.println("查找完成");
    }
    public static void paixu(Student[] s){
        System.out.print("请输入要排序的课程：");
        String course = sc.next();
        int[] a = new int[s.length];
        switch(course){
            case "课程一":{
                for(int i=0;i<s.length;i++){
                    a[i]=s[i].getCourse1_score();
                }
                for (int i = 0; i < s.length - 1; i++) {
                    for (int j = 0; j < s.length - i -1; j++) {
                        if (a[j] < a[j + 1]) {
                            int temp = a[j];
                            a[j] = a[j + 1];
                            a[j + 1] = temp;
                        }
                    }
                }
            }
            case "课程二":{
                for(int i=0;i<s.length;i++){
                    a[i]=s[i].getCourse2_score();
                }
                for (int i = 0; i < s.length - 1; i++) {
                    for (int j = 0; j < s.length - i -1; j++) {
                        if (a[j] < a[j + 1]) {
                            int temp = a[j];
                            a[j] = a[j + 1];
                            a[j + 1] = temp;
                        }
                    }
                }
            }
            System.out.println("排序结果为：");
            for(int i=0;i<a.length;i++){
                System.out.println(a[i]);
            }
        }
    }
}