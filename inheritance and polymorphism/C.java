public class C extends B {
    public void m(C c) {
        System.out.println("C");
    }

}

class D {

    public static void main(String[] args) {
        C c1 = new C();
        B c2 = new C();
        C c3 = new C();
        C c4 = new C();
        c4.m(c1);
        c4.m(c2);
        c4.m(c3);
        System.out.println("Done!");
    }
}