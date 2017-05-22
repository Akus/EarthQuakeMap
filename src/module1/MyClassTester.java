package module1;

public class MyClassTester
{
  public static void main(String[] args)
  {
    MyClass c1 = new MyClass(30, 123.9);
    MyClass c2 = new MyClass(30, 29.7);
    MyClass c3 = new MyClass(c1.a, c2.b);
/*
 * c2 = 30, 29.7
 * c3 = c1.a = 30, c2.b = 29.7
 * other.a = c3.a ==? this.a = c2.a && other.b = c3.b ==? this.b = c2.b
 */
    System.out.println(c2.same(c3));
  }
}