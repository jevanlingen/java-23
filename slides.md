<style>
  ul { width: 80%; }
  #predefined-gatherers ~ ul { margin-left: 44% };
</style>

## Java 22 & 23

---slide---

# Goal

Discovery of new Java features!

---vertical---

https://github.com/jevanlingen/java-23

---slide---

# Implicit Declared Class

JEP 477

---vertical---

_“An implicitly declared classes is a class without explicit declarations, simplifying small or beginner-level program.”_

---vertical--- <!-- .element: data-transition="none" -->

```java
public class HelloWorld {
  public static void main(String[] args) {
    System.out.println("Hello, WWWWW!");
  }
}
 ```

---vertical--- <!-- .element: data-transition="none" -->

```java
//public class HelloWorld {
  /*public static*/ void main(/*String[] args*/) {
    System.out.println("Hello, World!");
  }
//}
 ```

---vertical--- <!-- .element: data-transition="none" -->

```java
void main() {
  System.out.println("Hello, World!");
}
 ```

---vertical---

# Exercises
Try your hand at the exercises in the _Exercise1_ImplicitDeclaredClass_ class now.

---slide---

# Unnamed Variable Patterns

JEP 456

---vertical---

_“Enhance the Java programming language with unnamed variables and unnamed patterns, which can be used when variable declarations or nested patterns are required but never used.”_

---vertical---

## Try-with-resource

```java
try (var _ = ScopedContext.acquire()) {
  // no use of acquired resource
}
 ```

---vertical---

## Lambda whose parameter is irrelevant

```java
...stream.collect(Collectors.toMap(String::toUpperCase, _ -> "NODATA"))
 ```

---vertical---

# Exercises
Try your hand at the exercises in the _Exercise2_UnnamedVariablesPatterns_ class now.

---slide---

# Scoped Value

JEP 429

---vertical---

_"Scoped values enable a method to share immutable data with its callees and child threads, making it easier to manage and reason about data flow compared to thread-local variables."_

---vertical---

# Exercises
Try your hand at the exercises in the _Exercise3_ScopedValue_ class now.

---slide---

# Locale-Dependent List Patterns

---vertical---

_“With the new ListFormat class, lists can be formatted as enumerations, just as we would formulate them in continuous text.”_

---vertical---

```java
var list = List.of("Earth", "Wind", "Fire");
var formatter = ListFormat.getInstance(Locale.US, Type.STANDARD, Style.FULL);

System.out.println(formatter.format(list)); // Earth, Wind, and Fire
 ```

---vertical---

# Exercises
Try your hand at the exercises in the _Exercise4_LocaleDependentListPatterns_ class now.

---slide---

# Statements before super

JEP 447

---vertical---

_“Allow statements in constructors that do not reference the instance being created, to appear before an explicit constructor invocation.”_

---vertical--- <!-- .element: data-transition="none" -->

```java
public class PositiveBigInteger extends BigInteger {
    public PositiveBigInteger(long value) {
        super(value);               // Potentially unnecessary work
        if (value <= 0)
            throw new IllegalArgumentException("non-positive value");
    }
}
 ```

---vertical--- <!-- .element: data-transition="none" -->

```java
public class PositiveBigInteger extends BigInteger {
    public PositiveBigInteger(long value) {
        if (value <= 0)
            throw new IllegalArgumentException("non-positive value");
        super(value);
    }
}
 ```

---vertical---

# Exercises
Try your hand at the exercises in the _Exercise5_StatementsBeforeSuper_Square_ class now.

---slide---

# Stream Gatherers

JEP 461

---vertical---

_“A gatherer represents a transform of the elements of a stream; it is an instance of the java.util.stream.Gatherer interface. Gatherers can transform elements in a one-to-one, one-to-many, many-to-one, or many-to-many fashion.”_

---vertical---

## Java Streaming API lacks features

```java
Stream.of("foo", "bar", "baz", "quux")
    .distinctBy(String::length)      // Hypothetical
    .toList();
 ```

---vertical---

## The Gatherer provides a generic solution

```java
Stream.of("foo", "bar", "baz", "quux")
    .gather(distinctBy(String::length)) // Could be
    .toList();
 ```
 
---vertical---

```java
/**
 * @param <T> the type of input elements to the gatherer operation
 * @param <A> the potentially mutable state type of the gatherer operation
 *            (often hidden as an implementation detail)
 * @param <R> the type of output elements from the gatherer operation
 */
public interface Gatherer<T, A, R> {
    
}
 ```

---vertical---

```java
public class TestGatherer implements Gatherer<Integer, List<Integer>, Integer> {
    @Override public Supplier<List<Integer>> initializer() {}

    @Override public Integrator<List<Integer>, Integer, Integer> integrator() {}

    @Override public BinaryOperator<List<Integer>> combiner() {}

    @Override public BiConsumer<List<Integer>, Downstream<? super Integer>> finisher() {}

    @Override public <RR> Gatherer<Integer, ?, RR> andThen(final Gatherer<? super Integer, ?, ? extends RR> that) {}
}
 ```

---vertical---

- **initializer**: Creates the gatherer's private state object.
- **integrator**: <span width="80%">Integrates a new element from the input stream, possibly inspects the private state object, and possibly emits elements to the output stream.</span>
- **combiner**: Combines two private state objects into one when the gatherer is processing the stream in parallel.
- **finisher**: Optionally performs an action after the gatherer has processed all input elements; it could inspect the private state object or emit additional output elements.

---vertical---

## Predefined gatherers

Java offers in the `java.util.stream.Gatherers` class:
- fold
- mapConcurrent
- scan
- windowFixed
- windowSliding

---vertical---

# Exercises
Try your hand at the exercises in the _Exercise6_StreamGatherers_ and _Exercise7_OwnStreamGatherers_ classes now.

---slide---

# Class-File API

JEP 457

---vertical---

_“Class files and the underlying Bytecode serve as the universal language within the Java ecosystem. There are libraries like ASM, BCEL or Javassist for parsing and generating Class. Now Java introduces a new native API to do just that.”_

---vertical---

# Exercises
Try your hand at the exercises in the _Exercise8_ClassFileApi_ class now.

---slide---

# Simplified Module Import

JEP 476

---vertical---

_“The ability to succinctly import all the packages exported by a module, with the goal of simplifying the reuse of modular libraries without requiring code to be in a module itself.”_

---vertical--- <!-- .element: data-transition="none" -->

```java
import java.time.Instant;
import java.util.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
// etc
 ```

---vertical--- <!-- .element: data-transition="none" -->

```java
import module M;
import module Y;
 ```
---vertical---

# Exercises
Try your hand at the exercises in the _Exercise9_SimplifiedModuleImports_ class now.

---slide---

# Primitive Types in Patterns

JEP 455

---vertical---

_“Enhance pattern matching by allowing primitive type patterns in all pattern contexts, and extend instanceof and switch to work with all primitive types.”_

---vertical---

```java
switch (x.getYearlyFlights()) {
    case 0 -> ...;
    case 1 -> ...;
    case 2 -> issueDiscount();
    case int i when i >= 100 -> issueGoldCard();
    default -> ...;
}
 ```

---vertical---

# Exercises
Try your hand at the exercises in the _Exercise10_PrimitiveTypesInPatterns_ class now.

---slide---

# Thank you
