package ca.bcit.comp2526;

import ca.bcit.comp2526.constantpool.*;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

public abstract class ClassFileTest
{
    protected ClassFile createClassFile(final byte[] bytes)
        throws IOException,
               NotEnoughDataException,
               ClassFileException
    {
        try(final DataInputStream stream = new DataInputStream(new ByteArrayInputStream(bytes)))
        {
            final ClassFile classFile;

            classFile = new ClassFile(stream);

            return classFile;
        }
    }

    protected void checkClass(final ConstantPoolEntry entry,
                              final int               nameIndex)
    {
        final ConstantPoolEntryClass classEntry;

        assertThat(entry, instanceOf(ConstantPoolEntryClass.class));
        classEntry = (ConstantPoolEntryClass)entry;
        assertThat(classEntry.getNameIndex(), equalTo(nameIndex));
    }

    protected void checkDouble(final ConstantPoolEntry entry,
                               final double            value)
    {
        final ConstantPoolEntryDouble doubleEntry;

        assertThat(entry, instanceOf(ConstantPoolEntryDouble.class));
        doubleEntry = (ConstantPoolEntryDouble) entry;
        assertThat(doubleEntry.getValue(), closeTo(value, 0.0001));
    }

    protected void checkDynamic(final ConstantPoolEntry entry,
                                final int               bootstrapMethodAttrIndex,
                                final int               nameAndTypeIndex)
    {
        final ConstantPoolEntryDynamic dynamicEntry;

        assertThat(entry, instanceOf(ConstantPoolEntryDynamic.class));
        dynamicEntry = (ConstantPoolEntryDynamic) entry;
        assertThat(dynamicEntry.getBootstrapMethodAttrIndex(), equalTo(bootstrapMethodAttrIndex));
        assertThat(dynamicEntry.getNameAndTypeIndex(), equalTo(nameAndTypeIndex));
    }

    protected void checkField(final ConstantPoolEntry entry,
                              final int               classIndex,
                              final int               nameAndTypeIndex)
    {
        final ConstantPoolEntryField fieldEntry;

        assertThat(entry, instanceOf(ConstantPoolEntryField.class));
        fieldEntry = (ConstantPoolEntryField) entry;
        assertThat(fieldEntry.getClassIndex(), equalTo(classIndex));
        assertThat(fieldEntry.getNameAndTypeIndex(), equalTo(nameAndTypeIndex));
    }

    protected void checkFloat(final ConstantPoolEntry entry,
                              final float             value)
    {
        final ConstantPoolEntryFloat floatEntry;

        assertThat(entry, instanceOf(ConstantPoolEntryFloat.class));
        floatEntry = (ConstantPoolEntryFloat) entry;
        assertThat((double)floatEntry.getValue(), closeTo((double)value, 0.0001f));
    }

    protected void checkInteger(final ConstantPoolEntry entry,
                                final int               value)
    {
        final ConstantPoolEntryInteger integerEntry;

        assertThat(entry, instanceOf(ConstantPoolEntryInteger.class));
        integerEntry = (ConstantPoolEntryInteger)entry;
        assertThat(integerEntry.getValue(), equalTo(value));
    }

    protected void checkInvokeDynamic(final ConstantPoolEntry entry,
                                      final int               bootstringMethodAttrInde,
                                      final int               nameAndTypeIndex)
    {
        final ConstantPoolEntryInvokeDynamic dynamicEntry;

        assertThat(entry, instanceOf(ConstantPoolEntryInvokeDynamic.class));
        dynamicEntry = (ConstantPoolEntryInvokeDynamic)entry;
        assertThat(dynamicEntry.getBootstrapMethodAttrIndex(), equalTo(bootstringMethodAttrInde));
        assertThat(dynamicEntry.getNameAndTypeIndex(), equalTo(nameAndTypeIndex));
    }

    protected void checkInterfaceMethod(final ConstantPoolEntry entry,
                                        final int               classIndex,
                                        final int               nameAndTypeIndex)
    {
        final ConstantPoolEntryInterfaceMethod methodEntry;

        assertThat(entry, instanceOf(ConstantPoolEntryInterfaceMethod.class));
        methodEntry = (ConstantPoolEntryInterfaceMethod)entry;
        assertThat(methodEntry.getClassIndex(), equalTo(classIndex));
        assertThat(methodEntry.getNameAndTypeIndex(), equalTo(nameAndTypeIndex));
    }

    protected void checkLong(final ConstantPoolEntry entry,
                             final long              value)
    {
        final ConstantPoolEntryLong longEntry;

        assertThat(entry, instanceOf(ConstantPoolEntryLong.class));
        longEntry = (ConstantPoolEntryLong)entry;
        assertThat(longEntry.getValue(), equalTo(value));
    }

    protected void checkMethod(final ConstantPoolEntry entry,
                               final int               classIndex,
                               final int               nameAndTypeIndex)
    {
        final ConstantPoolEntryMethod methodEntry;

        assertThat(entry, instanceOf(ConstantPoolEntryMethod.class));
        methodEntry = (ConstantPoolEntryMethod)entry;
        assertThat(methodEntry.getClassIndex(), equalTo(classIndex));
        assertThat(methodEntry.getNameAndTypeIndex(), equalTo(nameAndTypeIndex));
    }

    protected void checkMethodHandle(final ConstantPoolEntry entry,
                                     final MethodHandleKind  referenceKind,
                                     final int               referenceIndex)
    {
        final ConstantPoolEntryMethodHandle methodHandleEntry;

        assertThat(entry, instanceOf(ConstantPoolEntryMethodHandle.class));
        methodHandleEntry = (ConstantPoolEntryMethodHandle)entry;
        assertThat(methodHandleEntry.getReferenceKind(), equalTo(referenceKind));
        assertThat(methodHandleEntry.getReferenceIndex(), equalTo(referenceIndex));
    }

    protected void checkMethodType(final ConstantPoolEntry entry,
                                   final int              descriptorIndex)
    {
        final ConstantPoolEntryMethodType methodTypeEntry;

        assertThat(entry, instanceOf(ConstantPoolEntryMethodType.class));
        methodTypeEntry = (ConstantPoolEntryMethodType)entry;
        assertThat(methodTypeEntry.getDescriptorIndex(), equalTo(descriptorIndex));
    }

    protected void checkModule(final ConstantPoolEntry entry,
                               final int               nameIndex)
    {
        final ConstantPoolEntryModule moduleEntry;

        assertThat(entry, instanceOf(ConstantPoolEntryModule.class));
        moduleEntry = (ConstantPoolEntryModule)entry;
        assertThat(moduleEntry.getNameIndex(), equalTo(nameIndex));
    }

    protected void checkNameAndType(final ConstantPoolEntry entry,
                                    final int               nameIndex,
                                    final int               descriptorIndex)
    {
        final ConstantPoolEntryNameAndType nameAndType;

        assertThat(entry, instanceOf(ConstantPoolEntryNameAndType.class));
        nameAndType = (ConstantPoolEntryNameAndType) entry;
        assertThat(nameAndType.getNameIndex(), equalTo(nameIndex));
        assertThat(nameAndType.getDescriptorIndex(), equalTo(descriptorIndex));
    }

    protected void checkPackage(final ConstantPoolEntry entry,
                                final int               nameIndex)
    {
        final ConstantPoolEntryPackage packageEntry;

        assertThat(entry, instanceOf(ConstantPoolEntryPackage.class));
        packageEntry = (ConstantPoolEntryPackage)entry;
        assertThat(packageEntry.getNameIndex(), equalTo(nameIndex));
    }

    protected void checkString(final ConstantPoolEntry entry,
                               final int               stringIndex)
    {
        final ConstantPoolEntryString stringEntry;

        assertThat(entry, instanceOf(ConstantPoolEntryString.class));
        stringEntry = (ConstantPoolEntryString)entry;
        assertThat(stringEntry.getStringIndex(), equalTo(stringIndex));
    }

    protected void checkUTF8(final ConstantPoolEntry entry,
                             final String            str)
    {
        final ConstantPoolEntryUTF8 utf8;

        assertThat(entry, instanceOf(ConstantPoolEntryUTF8.class));
        utf8 = (ConstantPoolEntryUTF8)entry;
        assertThat(utf8.getString(), equalTo(str));
        assertThat(utf8.getBytes(), equalTo(str.getBytes()));
    }
}