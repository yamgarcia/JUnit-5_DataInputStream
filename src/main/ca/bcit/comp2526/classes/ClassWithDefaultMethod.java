package ca.bcit.comp2526.classes;

public class ClassWithDefaultMethod
    implements InterfaceWithDefaultMethod
{

    public static void main(final String[] argv)
    {
        final InterfaceWithDefaultMethod a;
        final ClassWithDefaultMethod b;

        a = new ClassWithDefaultMethod();
        b = new ClassWithDefaultMethod();

        a.foo();
        b.foo();
    }
}
