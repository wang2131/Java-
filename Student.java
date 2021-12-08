package 实验二.src;
public class Student {


    private int xuhao;
    private String name;
    private int xuehao;
    private int course1_score;
    private int course2_score;

    Student(int xuhao,String name,int xuehao,int course1_score,int course2_score){
        this.xuhao=xuhao;
        this.name=name;
        this.xuehao=xuehao;
        this.course1_score=course1_score;
        this.course2_score=course2_score;
    }
    public int getXuhao() {
        return xuhao;
    }

    public void setXuhao(int xuhao) {
        this.xuhao = xuhao;
    }

    public int getXuehao() {
        return xuehao;
    }

    public void setXuehao(int xuehao) {
        this.xuehao = xuehao;
    }

    public int getCourse1_score() {
        return course1_score;
    }

    public void setCourse1_score(int course1_score) {
        this.course1_score = course1_score;
    }

    public int getCourse2_score() {
        return course2_score;
    }

    public void setCourse2_score(int course2_score) {
        this.course2_score = course2_score;
    }
    public void setName(String name) {
        this.name = name;
    }

}
