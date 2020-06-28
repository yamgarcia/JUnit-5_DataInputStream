package ca.bcit.comp2526.constantpool;

public abstract class ConstantPoolEntry {

    public abstract int getNumberOfSlots();

    public abstract ConstantPoolType getType();

}
/**
 ConstantPoolType.CLASS.ordinal() => returns the position it is in the enum
 */