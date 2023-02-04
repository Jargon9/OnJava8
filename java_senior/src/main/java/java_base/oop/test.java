package java_base.oop;

public class test {
    public static void main(String[] args) {
        ClassF f = new ClassF();
        f.setS(10);

        InterfaceI i = f;

        if (i instanceof  ClassF) {
            ClassF f1 = (ClassF) i;
            System.out.println(f1.getS());
        }
    }
}
