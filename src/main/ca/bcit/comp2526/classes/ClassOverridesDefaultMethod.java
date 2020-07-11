package ca.bcit.comp2526.classes;

public class ClassOverridesDefaultMethod
    implements InterfaceWithDefaultMethod
{
    @Override
    public void foo()
    {
    }

    public static void main(final String[] argv)
    {
        final InterfaceWithDefaultMethod a;
        final ClassOverridesDefaultMethod b;

        a = new ClassOverridesDefaultMethod();
        b = new ClassOverridesDefaultMethod();

        a.foo();
        b.foo();
    }
}
