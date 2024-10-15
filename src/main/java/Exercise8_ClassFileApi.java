import java.io.IOException;
import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassModel;
import java.lang.classfile.FieldModel;
import java.net.URISyntaxException;
import java.nio.file.Paths;

// TASK 1: Print the fields of this class with the help of the ClassModel.

public class Exercise8_ClassFileApi {
    private static String SOME_CONSTANT = "A";
    private static Integer ANOTHER_CONSTANT = 42;

    public static void main(String[] args) throws IOException, URISyntaxException {
        final var classModel = getClassModelOfThisClass();
    }

    private static ClassModel getClassModelOfThisClass() throws URISyntaxException, IOException {
        final var basePath = Paths.get(Exercise8_ClassFileApi.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        final var packagePath = Exercise8_ClassFileApi.class.getName().replace('.', '/') + ".class";
        final var fullPath = basePath.resolve(packagePath);

        return ClassFile.of().parse(fullPath);
    }
}


/*
ClassBuilder
 */
