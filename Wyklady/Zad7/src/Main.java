interface A { default void f() { System.out.println("A.f"); } }
interface B { default void f() { System.out.println("B.f"); } }

class C implements A, B {
    @Override
    public void f() {
        A.super.f();
    }
}

void main()
{
    C c = new C();
    c.f();
}