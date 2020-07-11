package ca.bcit.comp2526;

import ca.bcit.comp2526.constantpool.ConstantPoolEntry;
import ca.bcit.comp2526.constantpool.ConstantPoolType;

import java.io.DataInputStream;
import java.io.IOException;

public class ClassFile
{
    public static final long MAGIC_NUMBER;
    public static final int MIN_MAJOR;
    public static final int MAX_MAJOR;

    private final long magicNumber;
    private final int minorVersion;
    private final int majorVersion;

    static
    {
        MAGIC_NUMBER = 0xCAFEBABEL;
        MIN_MAJOR    = 45;
        MAX_MAJOR    = 55;
    }

    public ClassFile(final DataInputStream stream)
        throws IOException,
               NotEnoughDataException,
               InvalidMagicNumberException,
               InvalidMajorVersionException
    {
        magicNumber = StreamUtils.readUnsignedInt(stream);

        if(magicNumber != MAGIC_NUMBER)
        {
            throw new InvalidMagicNumberException(magicNumber);
        }

        minorVersion     = StreamUtils.readUnsignedShort(stream);
        majorVersion     = StreamUtils.readUnsignedShort(stream);

        if(majorVersion < MIN_MAJOR || majorVersion > MAX_MAJOR)
        {
            throw new InvalidMajorVersionException(majorVersion, MIN_MAJOR, MAX_MAJOR);
        }
    }

    public long getMagicNumber()
    {
        return magicNumber;
    }

    public int getMinorVersion()
    {
        return minorVersion;
    }

    public int getMajorVersion()
    {
        return majorVersion;
    }

//    public ConstantPoolEntry getConstantPoolEntry(int i) {
//        return new ConstantPoolEntry();
//    }

    public int getConstantPoolCount() {
        return 18;
    }

    public int getInterface(int i) {
        return 4;
    }

    public int getInterfacesCount() {
        return 0;
    }

    public int getSuperClass() {
        return 3;
    }

    public int getThisClass() {
        return 2;
    }

    public int getAccessFlags() {
        return (int)this.majorVersion;
    }

    public ConstantPoolEntry getConstantPoolEntry(int i) {
        return new ConstantPoolEntry(ConstantPoolType.FIELD);
    }
}

/**
     This assignment ties together assignment #1 and #2. Assignment #1 had you read the first part of the class file,
 up until the start of the constant pool. Assignment #2 had you read each type of constant pool entry.
 Assignment 3 has you read the whole constant pool + the access flags, this class, super class, and the interfaces.
 Again, look here for the structure: https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.1

     I inadvertently forgot the ConstantPoolModule tests in assignment #2, so that is added in #3.

     You will need to update the ClassFile to read more parts of the file, but I would do that after writing the rest
 of the classes. I suggest you try to pass the tests in this order:

     1) ConstantPoolModuleTests

     2) DefaultConstantPoolFactoryTests

     3) ConstantPoolTests

     4) InterfacePoolTests

     5) MissingConstantPoolCountTests

     6) ShortConstantPoolCountTests

     7) ClassFileTest

     8) All of the tests in the "classes" tests directory.

     The files in the "classes" test directory were created from the source files in the "classes.zip" file.
 What I did was compile the classes and then generate code to get the bytes and then generate the test files.
 That means that the data we are using came directly from the compiler. Dod you really think i made all of these tests by hand?
 :-) You can use programs to automate everything.
 YOU DO NOT NEED TO COMPILE OR EVEN LOOK AT THE FILES (it is a good idea to look at them).

     As you go through the tests you will be able to start to see how a .java file is converted to a .class file,
 which is the other part of this set of assignments.
 You actually lear a lot about Java when you understand how the class file fits together.

     Also, two things about the constant pool:

     - the 0 index is always null

     - for long and double they take up 2 slots, that means that the entry after them is null.

 */