package ca.bcit.comp2526.classes;

public class ClassImplementsMethod
    implements InterfaceWithAbstractMethod
{
    @Override
    public void foo()
    {
    }

    public static void main(final String[] argv)
    {
        final InterfaceWithAbstractMethod a;
        final ClassImplementsMethod b;

        a = new ClassImplementsMethod();
        b = new ClassImplementsMethod();

        a.foo();
        b.foo();
    }
}
