import java.io.IOException;
import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassModel;
import java.net.URISyntaxException;
import java.nio.file.Paths;

// TASK 1: Print the fields of this class with the help of the ClassModel.

// TASK 2: The ClassModel is also an Iterable. Iterate over it and print all different types.
// hint: Use pattern matching, let IntelliJ implement all branches

// TASK 3: Create a HelloWorld class, with a `main` method that prints "Hello World"
// hint: the bytecode looks like:
// public static main([Ljava/lang/String;)V
//    GETSTATIC java/lang/System.out : Ljava/io/PrintStream;
//    LDC "Hello World"
//    INVOKEVIRTUAL java/io/PrintStream.println (Ljava/lang/Object;)V
//    RETURN
public class Exercise8_ClassFileApi {
    private static String SOME_CONSTANT = "A";
    private static Integer ANOTHER_CONSTANT = 42;

    public static void main(String[] args) throws IOException, URISyntaxException {
        final var classModel = getClassModelOf(Exercise8_ClassFileApi.class);
    }

    private static ClassModel getClassModelOf(final Class<?> clazz) throws URISyntaxException, IOException {
        final var basePath = Paths.get(clazz.getProtectionDomain().getCodeSource().getLocation().toURI());
        final var packagePath = clazz.getName().replace('.', '/') + ".class";
        final var fullPath = basePath.resolve(packagePath);

        return ClassFile.of().parse(fullPath);
    }
}
