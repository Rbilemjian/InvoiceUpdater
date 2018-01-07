public class Student
{
    String last;
    String first;
    int expected;
    int[] payments;
    public Student(String last, String first, int expected, int[] payments)
    {
        this.last = last;
        this.first = first;
        this.expected = expected;
        this.payments = payments;
    }
    public void displayStudent()
    {
        System.out.println(this.last+","+this.first);
    }
        
}