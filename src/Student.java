public class Student
{
    String name;
    int expected;
    String[] payments;
    public Student(String name, int expected, String[] payments)
    {
        this.name = name;
        this.expected = expected;
        this.payments = payments;
    }
    public String toString()
    {
        String s = "";
        s+="Name: "+name;
        s+="\nExpected: "+expected;
        s+="\nMonths:   Jan\tFeb\tMar\tApr\tJun\tJul\tAug\tSep\tNov\tDec";
        s+="\nPayments: ";
        for(int i = 0;i<payments.length;i++)
        {
            s+=payments[i]+"\t";
        }
        s+="\n";
        return s;
    }
        
}