package ca.bcit.comp2526.constantpool;

import ca.bcit.comp2526.InvalidConstantPoolTagException;

import java.util.HashMap;
import java.util.Map;

public enum ConstantPoolType {
    UTF8((short) 1),
    INTEGER((short) 3),
    FLOAT((short) 4),
    LONG((short) 5),
    DOUBLE((short) 6),
    CLASS((short) 7),
    STRING((short) 8),
    FIELD((short) 9),
    METHOD((short) 10),
    INTERFACE_METHOD((short) 11),
    NAME_AND_TYPE((short) 12),
    METHOD_HANDLE((short) 15),
    METHOD_TYPE((short) 16),
    DYNAMIC((short) 17),
    INVOKE_DYNAMIC((short) 18),
    MODULE((short) 19),
    PACKAGE((short) 20);

    private static final Map<Short, ConstantPoolType> TYPES;

    static {
        TYPES = new HashMap<>();
        TYPES.put((short) 1, UTF8);
        TYPES.put((short) 3, INTEGER);
        TYPES.put((short) 4, FLOAT);
        TYPES.put((short) 5, LONG);
        TYPES.put((short) 6, DOUBLE);
        TYPES.put((short) 7, CLASS);
        TYPES.put((short) 8, STRING);
        TYPES.put((short) 9, FIELD);
        TYPES.put((short) 10, METHOD);
        TYPES.put((short) 11, INTERFACE_METHOD);
        TYPES.put((short) 12, NAME_AND_TYPE);
        TYPES.put((short) 15, METHOD_HANDLE);
        TYPES.put((short) 16, METHOD_TYPE);
        TYPES.put((short) 17, DYNAMIC);
        TYPES.put((short) 18, INVOKE_DYNAMIC);
        TYPES.put((short) 19, MODULE);
        TYPES.put((short) 20, PACKAGE);
    }

    private final short tag;

    ConstantPoolType(final short t) {
        tag = t;
    }

    public static ConstantPoolType fromTag(final short tag)
            throws InvalidConstantPoolTagException {
        final ConstantPoolType type;

        type = TYPES.get(tag);

        if (type == null) {
            throw new InvalidConstantPoolTagException(tag);
        }

        return type;
    }

    public short getTag() {
        return tag;
    }
}
