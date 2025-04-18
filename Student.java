public class Student
{
    private long prn;
    private String name;
    private String dept;
    private String batch;
    private double cgpa;

    public Student(long prn, String name, String dept, String batch, double cgpa)
    {
        this.prn = prn;
        this.name = name;
        this.dept = dept;
        this.batch = batch;
        this.cgpa = cgpa;
    }

    // Getters
    public long getPrn() { return prn; }
    public String getName() { return name; }
    public String getDept() { return dept; }
    public String getBatch() { return batch; }
    public double getCgpa() { return cgpa; }
}
