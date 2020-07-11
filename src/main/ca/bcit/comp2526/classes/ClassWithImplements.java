package ca.bcit.comp2526.classes;

import java.io.Serializable;
import java.util.List;

public abstract class ClassWithImplements
    implements Comparable<ClassWithImplements>, Serializable, List<String>, Iterable<String>, AutoCloseable
{
}
