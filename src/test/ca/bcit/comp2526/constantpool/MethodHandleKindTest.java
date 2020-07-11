package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.InvalidReferenceKindException;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MethodHandleKindTest
{
    @Test
    void testGetType()
    {
        assertThat(MethodHandleKind.GET_FIELD.getType(), equalTo((short)1));
        assertThat(MethodHandleKind.GET_STATIC.getType(), equalTo((short)2));
        assertThat(MethodHandleKind.PUT_FIELD.getType(), equalTo((short)3));
        assertThat(MethodHandleKind.PUT_STATIC.getType(), equalTo((short)4));
        assertThat(MethodHandleKind.INVOKE_VIRTUAL.getType(), equalTo((short)5));
        assertThat(MethodHandleKind.INVOKE_STATIC.getType(), equalTo((short)6));
        assertThat(MethodHandleKind.INVOKE_SPECIAL.getType(), equalTo((short)7));
        assertThat(MethodHandleKind.NEW_INVOKE_SPECIAL.getType(), equalTo((short)8));
        assertThat(MethodHandleKind.INVOKE_INTERFACE.getType(), equalTo((short)9));
    }

    @Test
    void fromType()
        throws InvalidReferenceKindException
    {
        assertThat(MethodHandleKind.fromType((short)1), equalTo(MethodHandleKind.GET_FIELD));
        assertThat(MethodHandleKind.fromType((short)2), equalTo(MethodHandleKind.GET_STATIC));
        assertThat(MethodHandleKind.fromType((short)3), equalTo(MethodHandleKind.PUT_FIELD));
        assertThat(MethodHandleKind.fromType((short)4), equalTo(MethodHandleKind.PUT_STATIC));
        assertThat(MethodHandleKind.fromType((short)5), equalTo(MethodHandleKind.INVOKE_VIRTUAL));
        assertThat(MethodHandleKind.fromType((short)6), equalTo(MethodHandleKind.INVOKE_STATIC));
        assertThat(MethodHandleKind.fromType((short)7), equalTo(MethodHandleKind.INVOKE_SPECIAL));
        assertThat(MethodHandleKind.fromType((short)8), equalTo(MethodHandleKind.NEW_INVOKE_SPECIAL));
        assertThat(MethodHandleKind.fromType((short)9), equalTo(MethodHandleKind.INVOKE_INTERFACE));
    }

    @Test
    void fromBadType()
    {
        fromBadType((short)0);
        fromBadType((short)10);
        fromBadType((short)1223);
    }

    void fromBadType(final short type)
    {
        final InvalidReferenceKindException ex;

        ex = assertThrows(InvalidReferenceKindException.class, () -> MethodHandleKind.fromType(type));
        assertThat(ex.getMessage(), CoreMatchers.equalTo(String.format("referenceKind must be between 1 and 9, was: %d", type)));
    }

    @Test
    void values()
    {
        // NOTE that .values() is a method that is provided by the compiler.
        // DO NOT CREATE A "values" METHOD!
        assertThat(MethodHandleKind.values(), equalTo(
            new MethodHandleKind[]
            {
                MethodHandleKind.GET_FIELD,
                MethodHandleKind.GET_STATIC,
                MethodHandleKind.PUT_FIELD,
                MethodHandleKind.PUT_STATIC,
                MethodHandleKind.INVOKE_VIRTUAL,
                MethodHandleKind.INVOKE_STATIC,
                MethodHandleKind.INVOKE_SPECIAL,
                MethodHandleKind.NEW_INVOKE_SPECIAL,
                MethodHandleKind.INVOKE_INTERFACE,
            }));
    }

    @Test
    void valueOf()
    {
        // NOTE that .valueOf() is a method that is provided by the compiler.
        // DO NOT CREATE A "valueOf" METHOD!
        assertThat(MethodHandleKind.valueOf("GET_FIELD"), equalTo(MethodHandleKind.GET_FIELD));
        assertThat(MethodHandleKind.valueOf("GET_STATIC"), equalTo(MethodHandleKind.GET_STATIC));
        assertThat(MethodHandleKind.valueOf("PUT_FIELD"), equalTo(MethodHandleKind.PUT_FIELD));
        assertThat(MethodHandleKind.valueOf("PUT_STATIC"), equalTo(MethodHandleKind.PUT_STATIC));
        assertThat(MethodHandleKind.valueOf("INVOKE_VIRTUAL"), equalTo(MethodHandleKind.INVOKE_VIRTUAL));
        assertThat(MethodHandleKind.valueOf("INVOKE_STATIC"), equalTo(MethodHandleKind.INVOKE_STATIC));
        assertThat(MethodHandleKind.valueOf("INVOKE_SPECIAL"), equalTo(MethodHandleKind.INVOKE_SPECIAL));
        assertThat(MethodHandleKind.valueOf("NEW_INVOKE_SPECIAL"), equalTo(MethodHandleKind.NEW_INVOKE_SPECIAL));
        assertThat(MethodHandleKind.valueOf("INVOKE_INTERFACE"), equalTo(MethodHandleKind.INVOKE_INTERFACE));
    }
}