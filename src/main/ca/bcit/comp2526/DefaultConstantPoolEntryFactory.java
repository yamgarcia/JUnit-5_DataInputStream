package ca.bcit.comp2526;

import ca.bcit.comp2526.constantpool.*;

import java.io.DataInputStream;
import java.io.IOException;

public class DefaultConstantPoolEntryFactory
        implements ConstantPoolEntryFactory {

    private ConstantPoolType constantPoolType;

    @Override
    public ConstantPoolEntry createConstantPoolEntry(ConstantPoolType type, DataInputStream stream)
            throws InvalidConstantPoolIndexException,
            NotEnoughDataException,
            IOException,
            InvalidReferenceKindException {

        final ConstantPoolEntry constantPoolEntry;
        switch (type) {
            case UTF8:
                constantPoolEntry = new ConstantPoolEntryUTF8(stream);
                break;
            case INTEGER:
                constantPoolEntry = new ConstantPoolEntryInteger(stream);
                break;
            case FLOAT:
                constantPoolEntry = new ConstantPoolEntryFloat(stream);
                break;
            case LONG:
                constantPoolEntry = new ConstantPoolEntryLong(stream);
                break;
            case DOUBLE:
                constantPoolEntry = new ConstantPoolEntryDouble(stream);
                break;
            case CLASS:
                constantPoolEntry = new ConstantPoolEntryClass(stream);
                break;
            case STRING:
                constantPoolEntry = new ConstantPoolEntryString(stream);
                break;
            case FIELD:
                constantPoolEntry = new ConstantPoolEntryField(stream);
                break;
            case METHOD:
                constantPoolEntry = new ConstantPoolEntryMethod(stream);
                break;
            case INTERFACE_METHOD:
                constantPoolEntry = new ConstantPoolEntryInterfaceMethod(stream);
                break;
            case NAME_AND_TYPE:
                constantPoolEntry = new ConstantPoolEntryNameAndType(stream);
                break;
            case METHOD_HANDLE:
                constantPoolEntry = new ConstantPoolEntryMethodHandle(stream);
                break;
            case METHOD_TYPE:
                constantPoolEntry = new ConstantPoolEntryMethodType(stream);
                break;
            case DYNAMIC:
                constantPoolEntry = new ConstantPoolEntryDynamic(stream);
                break;
            case INVOKE_DYNAMIC:
                constantPoolEntry = new ConstantPoolEntryInvokeDynamic(stream);
                break;
            case MODULE:
                constantPoolEntry = new ConstantPoolEntryModule(stream);
                break;
            case PACKAGE:
                constantPoolEntry = new ConstantPoolEntryPackage(stream);
                break;
            default:
                throw new IllegalArgumentException("Constant type not found: " + type);
        }
        this.constantPoolType = type;
        return constantPoolEntry;
    }

    public ConstantPoolType getType(){
        return this.constantPoolType;
    }

//    public ConstantPoolEntry createConstantPoolEntry(ConstantPoolType module, DataInputStream stream) {
//        return new ConstantPoolEntry(module);
//    }
//    private DataInputStream stream;


}
