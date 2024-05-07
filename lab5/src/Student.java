public class Student {
    public int age;
    public String name;
    public int course;

    public boolean equals(Student obj) {
        return age == obj.age && name == obj.name && course == obj.course;
    }
    @Override
    public String toString() {
        return "age: " + age + ", name: " + name + ", course: " + course;
    }

    public Student(int age, String name, int course) {
        this.age = age;
        this.name = name;
        this.course = course;
    }
    public Student() {
        this.age = 0;
        this.name = "Anonymous";
        this.course = 0;
    }
}
