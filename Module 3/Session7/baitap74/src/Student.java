public class Student {
    private String name;
    private int age;
    private String _class;
    private double avgScore;

    public Student(String name, int age, String _class, double avgScore) {
        this.name = name;
        this.age = age;
        this._class = _class;
        this.avgScore = avgScore;
    }

    public Student(){

    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String get_class(){
        return _class;
    }
    public double getAvgScore(){
        return avgScore;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void set_class(String _class){
        this._class = _class;
    }

    public void setAvgScore(double avgScore){
        this.avgScore = avgScore;
    }
}
