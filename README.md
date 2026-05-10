# gatech-oop-java

Coursework and reference code from **GTx CS1331x: Introduction to Object-Oriented Programming with Java** (Georgia Tech). Course completed; this repository is preserved as a personal reference.

## Topics covered

| Phase | Lectures | Topics |
|-------|----------|--------|
| 1 | lec00–lec03 | JDK setup (with a JavaFX-installation verifier), hello world, primitive types & casting, syntax-vs-semantics, strings (indexing, immutability) |
| 2 | lec05–lec08 | Scanner input; number formatting (`NumberFormat`/`DecimalFormat`); control flow (if/else, switch); string equality (`==` vs `.equals()`, interning); loops; 1D / 2D / ragged / sparse arrays; command-line args |
| 3 | lec09 | Static methods, parameters, return types, **method overloading** |
| 4 | lec10 | Classes, encapsulation, constructors, static members, multi-class programs |
| 5 | lec11 | Inheritance, interfaces, abstract classes, **constant interfaces (anti-pattern)**, the canonical `equals(Object)` override pattern, UML class diagram |
| 6 | lec12 | Searching and sorting algorithms |
| 7 | lec13 | Polymorphism — dynamic binding, is-a test, declared vs. object type. *Notes-only directory; the actual demonstrative code lives in `lec11/Puppy.java` (`equals` with `instanceof` + cast) and `lec11/GroomEverything.java` (interface-typed array iteration).* |
| 8 | lec14 | Exception handling: try/catch/finally, multi-catch, custom exceptions |
| 9 | lec15 | File I/O with Scanner and PrintWriter, checked exceptions, CSV parsing |
| 10 | lec16 | ArrayList with autoboxing, generic classes (single/multi/bounded type parameters), custom generic linked list with inner Node class |
| 11 | lec17 | Recursion: base case, reduction step, call-stack reasoning |
| 12 | lec18 | JavaFX GUIs: Application/Stage/Scene lifecycle, controls, HBox/VBox layouts, event handlers (inner class, anonymous class, lambda) |

*lec04 is intentionally absent from the repo.*

## Homework assignments

| # | Description |
|---|-------------|
| hw1 | Primitive operations, string operations, three short debugging exercises (`Bad1`/`Bad2`/`Bad3`) |
| hw2 | Procedural calculator with Scanner + switch + try/catch (paired with `CalculatorSol.java`) |
| hw3 | Battleship — 3D `char` array board, Scanner I/O, multi-method procedural design (no custom class) |
| hw4 | Static fields/methods, encapsulation, **constructor chaining** (`Frog`, `Pond`, and `Fly`, each with `*Sol` references) |
| hw5 | Multi-class inheritance and interfaces (Among Us–style game) |
| hw6 | OOP + exception handling + file I/O (veterinary clinic simulation) |
| hw7 | Generic singly-linked list with full CRUD and null-safe equality |
| hw8 | JavaFX dollars-to-pounds currency converter (lambda event handler + Alert dialog) |

## Repository layout

```
lecXX_topic/   Lecture examples, numbered sequentially
hwX/           Homework assignments (some include *Sol.java reference solutions)
exam1/         Mid-term exam materials (one exam, two files)
scripts/       Utility scripts (e.g. clean.ps1 to remove *.class files)
```

No build system, no packages — every `.java` file lives in the default package within its directory.

## Building and running

Compile and run any standalone file:

```bash
javac FileName.java
java  FileName
```

JavaFX directories (`lec00_jdk_install/`, `lec18_gui/`, `hw8/`) require the JavaFX SDK on the module path:

```bash
javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls FileName.java
java  --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls FileName
```

`lec00_jdk_install/JavaFXCheck.java` is itself a JavaFX-installation verifier — running it confirms the SDK is set up correctly.

## Conventions

- Reference solutions are named `*Sol.java` (e.g. `FrogSol.java`). Only `hw2`, `hw4`, and `hw6` include them — most other assignments do not.
- `*.class` files are excluded via `.gitignore` — recompile before running.
- Programs demonstrate behavior through `main()` methods; no test framework is used.
- Code style is governed by `.vscode/java-formatter.xml` (braces on a new line for type/method/constructor/anonymous-class declarations; end-of-line braces for blocks/switch/lambda; 4-space indent; 100-char code lines, 120-char comments).
