package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.InvalidReferenceKindException;

import java.util.HashMap;
import java.util.Map;

public enum MethodHandleKind
{
    GET_FIELD((short)1),
    GET_STATIC((short)2),
    PUT_FIELD((short)3),
    PUT_STATIC((short)4),
    INVOKE_VIRTUAL((short)5),
    INVOKE_STATIC((short)6),
    INVOKE_SPECIAL((short)7),
    NEW_INVOKE_SPECIAL((short)8),
    INVOKE_INTERFACE((short)9);

    private final short type;

    MethodHandleKind(final short t)
    {
        type = t;
    }

    public short getType()
    {
        return type;
    }

    private static final Map<Short, MethodHandleKind> TYPES;

    static
    {
        TYPES = new HashMap<>();
        TYPES.put((short)1, GET_FIELD);
        TYPES.put((short)2, GET_STATIC);
        TYPES.put((short)3, PUT_FIELD);
        TYPES.put((short)4, PUT_STATIC);
        TYPES.put((short)5, INVOKE_VIRTUAL);
        TYPES.put((short)6, INVOKE_STATIC);
        TYPES.put((short)7, INVOKE_SPECIAL);
        TYPES.put((short)8, NEW_INVOKE_SPECIAL);
        TYPES.put((short)9, INVOKE_INTERFACE);
    }

    public static MethodHandleKind fromType(final short type)
            throws InvalidReferenceKindException
    {
        final MethodHandleKind kind;

        kind = TYPES.get(type);

        if(kind == null)
        {
            throw new InvalidReferenceKindException(type);
        }

        return kind;
    }}
