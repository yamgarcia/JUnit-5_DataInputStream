package ca.bcit.comp2526.constantpool;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConstantPoolTypeTest
{
    @Test
    void getTag()
    {
        assertThat(ConstantPoolType.UTF8.getTag(), equalTo((short)1));
        assertThat(ConstantPoolType.INTEGER.getTag(), equalTo((short)3));
        assertThat(ConstantPoolType.FLOAT.getTag(), equalTo((short)4));
        assertThat(ConstantPoolType.LONG.getTag(), equalTo((short)5));
        assertThat(ConstantPoolType.DOUBLE.getTag(), equalTo((short)6));
        assertThat(ConstantPoolType.CLASS.getTag(), equalTo((short)7));
        assertThat(ConstantPoolType.STRING.getTag(), equalTo((short)8));
        assertThat(ConstantPoolType.FIELD.getTag(), equalTo((short)9));
        assertThat(ConstantPoolType.METHOD.getTag(), equalTo((short)10));
        assertThat(ConstantPoolType.INTERFACE_METHOD.getTag(), equalTo((short)11));
        assertThat(ConstantPoolType.NAME_AND_TYPE.getTag(), equalTo((short)12));
        assertThat(ConstantPoolType.METHOD_HANDLE.getTag(), equalTo((short)15));
        assertThat(ConstantPoolType.METHOD_TYPE.getTag(), equalTo((short)16));
        assertThat(ConstantPoolType.DYNAMIC.getTag(), equalTo((short)17));
        assertThat(ConstantPoolType.INVOKE_DYNAMIC.getTag(), equalTo((short)18));
        assertThat(ConstantPoolType.MODULE.getTag(), equalTo((short)19));
        assertThat(ConstantPoolType.PACKAGE.getTag(), equalTo((short)20));
    }

    @Test
    void fromTag()
        throws InvalidConstantPoolTagException
    {
        assertThat(ConstantPoolType.fromTag((short)1), equalTo(ConstantPoolType.UTF8));
        assertThat(ConstantPoolType.fromTag((short)3), equalTo(ConstantPoolType.INTEGER));
        assertThat(ConstantPoolType.fromTag((short)4), equalTo(ConstantPoolType.FLOAT));
        assertThat(ConstantPoolType.fromTag((short)5), equalTo(ConstantPoolType.LONG));
        assertThat(ConstantPoolType.fromTag((short)6), equalTo(ConstantPoolType.DOUBLE));
        assertThat(ConstantPoolType.fromTag((short)7), equalTo(ConstantPoolType.CLASS));
        assertThat(ConstantPoolType.fromTag((short)8), equalTo(ConstantPoolType.STRING));
        assertThat(ConstantPoolType.fromTag((short)9), equalTo(ConstantPoolType.FIELD));
        assertThat(ConstantPoolType.fromTag((short)10), equalTo(ConstantPoolType.METHOD));
        assertThat(ConstantPoolType.fromTag((short)11), equalTo(ConstantPoolType.INTERFACE_METHOD));
        assertThat(ConstantPoolType.fromTag((short)12), equalTo(ConstantPoolType.NAME_AND_TYPE));
        assertThat(ConstantPoolType.fromTag((short)15), equalTo(ConstantPoolType.METHOD_HANDLE));
        assertThat(ConstantPoolType.fromTag((short)16), equalTo(ConstantPoolType.METHOD_TYPE));
        assertThat(ConstantPoolType.fromTag((short)17), equalTo(ConstantPoolType.DYNAMIC));
        assertThat(ConstantPoolType.fromTag((short)18), equalTo(ConstantPoolType.INVOKE_DYNAMIC));
        assertThat(ConstantPoolType.fromTag((short)19), equalTo(ConstantPoolType.MODULE));
        assertThat(ConstantPoolType.fromTag((short)20), equalTo(ConstantPoolType.PACKAGE));
    }

    @Test
    void fromBadTag()
    {
        fromBadTag((short)0);
        fromBadTag((short)2);
        fromBadTag((short)21);
        fromBadTag((short)23);
        fromBadTag((short)742);
    }

    void fromBadTag(final short tag)
    {
        final InvalidConstantPoolTagException ex;

        ex = assertThrows(InvalidConstantPoolTagException.class, () -> ConstantPoolType.fromTag(tag));
        assertThat(ex.getMessage(), CoreMatchers.equalTo(String.format("tag must be one of 1, 3, 44, 5, 6, 7, 8, 9, 10, 11, 12, 15, 16, 17, 18, 19, 20, was: %d", tag)));
    }

    @Test
    void values()
    {
        // NOTE that .values() is a method that is provided by the compiler.
        // DO NOT CREATE A "values" METHOD!
        assertThat(ConstantPoolType.values(), equalTo(
            new ConstantPoolType[]
            {
                ConstantPoolType.UTF8,
                ConstantPoolType.INTEGER,
                ConstantPoolType.FLOAT,
                ConstantPoolType.LONG,
                ConstantPoolType.DOUBLE,
                ConstantPoolType.CLASS,
                ConstantPoolType.STRING,
                ConstantPoolType.FIELD,
                ConstantPoolType.METHOD,
                ConstantPoolType.INTERFACE_METHOD,
                ConstantPoolType.NAME_AND_TYPE,
                ConstantPoolType.METHOD_HANDLE,
                ConstantPoolType.METHOD_TYPE,
                ConstantPoolType.DYNAMIC,
                ConstantPoolType.INVOKE_DYNAMIC,
                ConstantPoolType.MODULE,
                ConstantPoolType.PACKAGE,
        }));
    }

    @Test
    void valueOf()
    {
        // NOTE that .valueOf() is a method that is provided by the compiler.
        // DO NOT CREATE A "valueOf" METHOD!
        assertThat(ConstantPoolType.valueOf("UTF8"), equalTo(ConstantPoolType.UTF8));
        assertThat(ConstantPoolType.valueOf("INTEGER"), equalTo(ConstantPoolType.INTEGER));
        assertThat(ConstantPoolType.valueOf("FLOAT"), equalTo(ConstantPoolType.FLOAT));
        assertThat(ConstantPoolType.valueOf("LONG"), equalTo(ConstantPoolType.LONG));
        assertThat(ConstantPoolType.valueOf("DOUBLE"), equalTo(ConstantPoolType.DOUBLE));
        assertThat(ConstantPoolType.valueOf("CLASS"), equalTo(ConstantPoolType.CLASS));
        assertThat(ConstantPoolType.valueOf("STRING"), equalTo(ConstantPoolType.STRING));
        assertThat(ConstantPoolType.valueOf("FIELD"), equalTo(ConstantPoolType.FIELD));
        assertThat(ConstantPoolType.valueOf("METHOD"), equalTo(ConstantPoolType.METHOD));
        assertThat(ConstantPoolType.valueOf("INTERFACE_METHOD"), equalTo(ConstantPoolType.INTERFACE_METHOD));
        assertThat(ConstantPoolType.valueOf("NAME_AND_TYPE"), equalTo(ConstantPoolType.NAME_AND_TYPE));
        assertThat(ConstantPoolType.valueOf("METHOD_HANDLE"), equalTo(ConstantPoolType.METHOD_HANDLE));
        assertThat(ConstantPoolType.valueOf("METHOD_TYPE"), equalTo(ConstantPoolType.METHOD_TYPE));
        assertThat(ConstantPoolType.valueOf("DYNAMIC"), equalTo(ConstantPoolType.DYNAMIC));
        assertThat(ConstantPoolType.valueOf("INVOKE_DYNAMIC"), equalTo(ConstantPoolType.INVOKE_DYNAMIC));
        assertThat(ConstantPoolType.valueOf("MODULE"), equalTo(ConstantPoolType.MODULE));
        assertThat(ConstantPoolType.valueOf("PACKAGE"), equalTo(ConstantPoolType.PACKAGE));
    }
}