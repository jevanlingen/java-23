package solution;

import java.io.IOException;
import java.lang.classfile.*;
import java.lang.classfile.attribute.*;
import java.lang.constant.MethodTypeDesc;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.lang.classfile.ClassFile.ACC_PUBLIC;
import static java.lang.classfile.ClassFile.ACC_STATIC;
import static java.lang.constant.ClassDesc.of;
import static java.lang.constant.ConstantDescs.CD_void;
import static java.lang.constant.MethodTypeDesc.ofDescriptor;

public class Exercise8_ClassFileApi_S {
    private static String SOME_CONSTANT = "A";
    private static Integer ANOTHER_CONSTANT = 42;

    public static void main(String[] args) throws IOException, URISyntaxException {
        final var classModel = getClassModelOf(Exercise8_ClassFileApi_S.class);

        // TASK 1
        classModel.fields().stream().map(FieldModel::fieldName).forEach(System.out::println);

        System.out.println("------");

        // TASK 2
        classModel.forEach(element -> {
            switch (element) {
                case MethodModel it -> System.out.println(it);
                case FieldModel it -> System.out.println(it);
                case AccessFlags it -> System.out.println(it);
                case ClassFileVersion it -> System.out.println(it);
                case CustomAttribute it -> System.out.println(it);
                case Interfaces it -> System.out.println(it);
                case Superclass it -> System.out.println(it);
                case CompilationIDAttribute it -> System.out.println(it);
                case DeprecatedAttribute it -> System.out.println(it);
                case EnclosingMethodAttribute it -> System.out.println(it);
                case InnerClassesAttribute it -> System.out.println(it);
                case ModuleAttribute it -> System.out.println(it);
                case ModuleHashesAttribute it -> System.out.println(it);
                case ModuleMainClassAttribute it -> System.out.println(it);
                case ModulePackagesAttribute it -> System.out.println(it);
                case ModuleResolutionAttribute it -> System.out.println(it);
                case ModuleTargetAttribute it -> System.out.println(it);
                case NestHostAttribute it -> System.out.println(it);
                case NestMembersAttribute it -> System.out.println(it);
                case PermittedSubclassesAttribute it -> System.out.println(it);
                case RecordAttribute it -> System.out.println(it);
                case RuntimeInvisibleAnnotationsAttribute it -> System.out.println(it);
                case RuntimeInvisibleTypeAnnotationsAttribute it -> System.out.println(it);
                case RuntimeVisibleAnnotationsAttribute it -> System.out.println(it);
                case RuntimeVisibleTypeAnnotationsAttribute it -> System.out.println(it);
                case SignatureAttribute it -> System.out.println(it);
                case SourceDebugExtensionAttribute it -> System.out.println(it);
                case SourceFileAttribute it -> System.out.println(it);
                case SourceIDAttribute it -> System.out.println(it);
                case SyntheticAttribute it -> System.out.println(it);
                case UnknownAttribute it -> System.out.println(it);
            };
        });

        // TASK 3
        ClassFile.of().buildTo(Path.of("HelloWorld.class"), of("HelloWorld"), classBuilder -> classBuilder
                .withMethodBody("main", ofDescriptor("([Ljava/lang/String;)V"), ACC_PUBLIC | ACC_STATIC, codeBuilder -> codeBuilder
                        .getstatic(of("java.lang.System"), "out", of("java.io.PrintStream"))
                        .ldc("Hello World")
                        .invokevirtual(of("java.io.PrintStream"), "println", MethodTypeDesc.of(CD_void, of("java.lang.Object")))
                        .return_()));
    }

    private static ClassModel getClassModelOf(final Class<?> clazz) throws URISyntaxException, IOException {
        final var basePath = Paths.get(clazz.getProtectionDomain().getCodeSource().getLocation().toURI());
        final var packagePath = clazz.getName().replace('.', '/') + ".class";
        final var fullPath = basePath.resolve(packagePath);

        return ClassFile.of().parse(fullPath);
    }
}
