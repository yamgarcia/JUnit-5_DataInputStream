package ca.bcit.comp2526.constantpool;

public enum ConstantPoolType {

    UTF8 ((short) 1),
    INTEGER ((short) 3),
    FLOAT ((short) 4),
    LONG ((short) 5),
    DOUBLE ((short) 6),
    CLASS ((short) 7),
    STRING ((short) 8),
    FIELD ((short) 9),
    METHOD ((short) 10),
    INTERFACE_METHOD ((short) 11),
    NAME_AND_TYPE ((short) 12),
    METHOD_HANDLE ((short) 15),
    METHOD_TYPE ((short) 16),
    DYNAMIC ((short) 17),
    INVOKE_DYNAMIC ((short) 18),
    MODULE ((short) 19),        // Why no ConstantPoolEntryModule ?
    PACKAGE ((short) 20);

    private short tag;

    ConstantPoolType(short tag) {
        this.tag = tag;
    }

    public static ConstantPoolType fromTag(short i)
            throws InvalidConstantPoolTagException {
        try {
            if (i == 0) throw new InvalidConstantPoolTagException(i);

            boolean b = false;
            for (ConstantPoolType c : ConstantPoolType.values()) {
                if ((int) i == (int) c.tag) {
                    b = true;
                }
            }
            if (b) {
                ConstantPoolType tagA = null;
                for (ConstantPoolType c : ConstantPoolType.values()) {
                    if (c.tag == i) tagA = c;
                }
                return tagA;
            } else {
                throw new InvalidConstantPoolTagException(i);
            }
        } catch (InvalidConstantPoolTagException ex){
            throw new InvalidConstantPoolTagException(ex.getValue());
        }
    }

    public short getTag() {

        return this.tag;
    }
}

