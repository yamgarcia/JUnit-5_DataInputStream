package ca.bcit.comp2526.classes;

import java.util.List;

// https://dzone.com/articles/hacking-lambda-expressions-in-java
public class MHD
{
    public void printElements(final List<String> strings)
    {
        strings.forEach(item -> System.out.println(String.format("Item = %s", item)));
    }
}

