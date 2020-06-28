package ca.bcit.comp2526.constantpool;

public enum MethodHandleKind {

    GET_FIELD ((short)1),
    GET_STATIC ((short)2),
    PUT_FIELD ((short)3),
    PUT_STATIC ((short)4),
    INVOKE_VIRTUAL ((short)5),
    INVOKE_STATIC ((short)6),
    INVOKE_SPECIAL ((short)7),
    NEW_INVOKE_SPECIAL ((short)8),
    INVOKE_INTERFACE ((short)9);

    private final short tag;

    MethodHandleKind(short tag) {
        this.tag = tag;
    }

    public static MethodHandleKind fromType(short i)
            throws InvalidReferenceKindException {

        boolean b = false;
        for (MethodHandleKind c : MethodHandleKind.values()) {
            if( (int)i == (int)c.tag) {
                b = true;
            }
        }
        if(b) {
            MethodHandleKind tagA = null;
            for (MethodHandleKind c : MethodHandleKind.values()) {
                if (c.tag == i) tagA = c;
            }
            return tagA;
        } else {
            throw new InvalidReferenceKindException(i);
        }
    }

    public short getType() {
        return this.tag;
    }
}
