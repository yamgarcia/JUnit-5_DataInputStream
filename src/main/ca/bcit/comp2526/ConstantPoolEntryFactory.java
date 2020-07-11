package ca.bcit.comp2526;

import ca.bcit.comp2526.constantpool.ConstantPoolEntry;
import ca.bcit.comp2526.constantpool.ConstantPoolType;

import java.io.DataInputStream;
import java.io.IOException;

public interface ConstantPoolEntryFactory {
    ConstantPoolEntry createConstantPoolEntry(ConstantPoolType type, DataInputStream stream)
            throws InvalidConstantPoolIndexException,
            NotEnoughDataException,
            IOException,
            InvalidReferenceKindException;
}
