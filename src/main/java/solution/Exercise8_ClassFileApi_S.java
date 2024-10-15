package solution;

import java.io.IOException;
import java.lang.classfile.ClassFile;
import java.lang.classfile.ClassModel;
import java.lang.classfile.FieldModel;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class Exercise8_ClassFileApi_S {
    private static String SOME_CONSTANT = "A";
    private static Integer ANOTHER_CONSTANT = 42;

    public static void main(String[] args) throws IOException, URISyntaxException {
        final var classModel = getClassModelOfThisClass();

        // TASK 1
        classModel.fields().stream().map(FieldModel::fieldName).forEach(System.out::println);

        /*https://medium.com/@benweidig/looking-at-java-22-class-file-api-a4cb241ff785
        for (ClassElement classElement : cm) {
            switch (cm) {
                case MethodModel mm -> System.out.printf("Method %s%n",
                        mm.methodName().stringValue());
                case FieldModel fm -> System.out.printf("Field %s%n",
                        fm.fieldName().stringValue());
                default -> { *//* NO-OP *//* }
            }
        }*/
    }

    private static ClassModel getClassModelOfThisClass() throws URISyntaxException, IOException {
        final var basePath = Paths.get(Exercise8_ClassFileApi_S.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        final var packagePath = Exercise8_ClassFileApi_S.class.getName().replace('.', '/') + ".class";
        final var fullPath = basePath.resolve(packagePath);

        return ClassFile.of().parse(fullPath);
    }
}


/*
ClassBuilder
 */
