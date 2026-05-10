# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Course Context

This is **GTx CS1331x: Introduction to Object-Oriented Programming with Java** — an educational repository. Each directory is a standalone lesson or assignment, not a unified application. The course has been completed; the repo is preserved as a reference.

## Running Code

There is no build system (no Maven, Gradle, or Makefile). Each `.java` file is compiled and run individually from its directory:

```bash
# Compile
javac FileName.java

# Run
java FileName

# Run with command-line args (e.g., lec08_arrays/CmdLineArgs.java)
java FileName arg1 arg2
```

To compile all files in a directory:
```bash
javac *.java
```

**JavaFX directories** (`lec00_jdk_install/`, `lec18_gui/`, `hw8/`) require the JavaFX SDK on the module path — plain `javac FileName.java` will not work. Compile and run with:

```bash
javac --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls FileName.java
java  --module-path /path/to/javafx-sdk/lib --add-modules javafx.controls FileName
```

`lec00_jdk_install/JavaFXCheck.java` is itself a JavaFX-installation verifier; if it runs, the SDK is set up correctly.

## Repository Structure

```
lecXX_topic/   Lecture examples, numbered sequentially (lec00, lec01, …)
hwX/           Homework assignments (some include *Sol.java reference solutions)
exam1/         Mid-term exam materials (only one exam exists; no examX/ pattern)
scripts/       Utility scripts (e.g., clean.ps1 for removing *.class files)
```

No packages are used — all files are in the default package within their directory.

## Code Architecture Progression

Lectures build progressively:

1. **Basics & primitives** (lec00–lec03) — JDK setup (incl. a JavaFX-installation verifier), hello world, primitive types and casting, syntax-vs-semantics, strings (indexing, immutability)
2. **I/O, control flow & arrays** (lec05–lec08) — Scanner input; number formatting (`NumberFormat`/`DecimalFormat`); control flow (if/else, switch); string equality (`==` vs `.equals()`, interning, `compareTo`); loops; 1D / 2D / ragged / sparse arrays; command-line args *(lec04 is not present in the repo)*
3. **Methods** (lec09) — static methods, parameters, return types, **method overloading** (same name, different signatures)
4. **OOP** (lec10) — classes, encapsulation, constructors, static members, multi-class programs
5. **Inheritance & interfaces** (lec11) — `extends`, `implements`, abstract classes, **constant interfaces (explicitly framed as an anti-pattern in `IChemistryConstants.java`)**, the canonical `equals(Object)` override pattern (`Puppy.java`), and a UML class diagram (`uml.png`)
6. **Algorithms** (lec12) — searching and sorting
7. **Polymorphism** (lec13) — dynamic binding, is-a test, declared vs. object type. **`lec13_polymorphism/` is notes-only — it contains only `notes.md` and no `.java` files. The actual demonstrative code lives in `lec11_inheritance/Puppy.java` (`equals` with `instanceof` + cast) and `lec11_inheritance/GroomEverything.java` (interface-typed array iterating over `Wolf`/`Poodle`/`Car`).**
8. **Exception handling** (lec14) — try/catch/finally, multi-catch, custom exceptions
9. **File I/O** (lec15) — Scanner + PrintWriter on files, checked exceptions, CSV parsing
10. **Lists & generics** (lec16) — ArrayList with autoboxing, generic classes (single/multi type parameters, bounded type parameters), custom generic linked list with inner Node class
11. **Recursion** (lec17) — base case, reduction step, recursive call; call-stack visualization
12. **GUI with JavaFX** (lec18) — Application/Stage/Scene lifecycle, Button/Label/TextField/ComboBox controls, HBox/VBox layouts, event handling via inner class, anonymous class, and lambda

Homework assignments:
- **hw1**: primitive operations, string operations, and three short debugging exercises (`Bad1`/`Bad2`/`Bad3`) — small programs the student is expected to inspect or fix
- **hw2**: procedural calculator with Scanner + switch + try/catch (paired with `CalculatorSol.java`)
- **hw3**: Battleship — a 140-line *purely procedural* program with 3D `char` arrays, Scanner I/O, and private static helper methods (no custom class — do not call this "OOP")
- **hw4**: static fields/methods, encapsulation, **constructor chaining** — three sub-classes: `Frog`, `Pond`, **and `Fly`**, each with a `*Sol` reference (`Fly` is often forgotten)
- **hw5**: multi-class inheritance and interfaces (Among Us–style game)
- **hw6**: full OOP + exception handling + file I/O (veterinary clinic simulation)
- **hw7**: generic singly-linked list with full CRUD, null-safe equality, and wildcard-typed `equals`
- **hw8**: JavaFX dollars-to-pounds currency converter with lambda event handler and Alert dialog

## Utilities

- `scripts/clean.ps1` — Recursively removes `*.class` files. Dry-run by default; pass `-Run` to actually delete.

## Conventions

- Solution files are named `*Sol.java` (e.g., `FrogSol.java`, `CalculatorSol.java`). Only `hw2`, `hw4`, and `hw6` include them — most other assignments do not.
- `*.class` files are excluded from git via `.gitignore`; always compile before running.
- No test framework is used; programs demonstrate behavior via `main()` methods.
- **Code style is governed by `.vscode/java-formatter.xml`** — generated Java code MUST follow these rules to avoid formatter churn:
  - Braces on a **new line** for type, method, constructor, and anonymous-class declarations
  - **End-of-line** braces for blocks, switch, and lambda bodies
  - `if`/`else`, `try`/`catch`/`finally` always split across lines (one keyword per line)
  - 4-space indentation (no tabs)
  - 100-char line width for code, 120-char line width for comments

## Known quirks

- **`exam1/CourseExam1.java` is intentionally incomplete/buggy** — its `stillRed` method always returns `true` (the second `return true;` should be `return false;`). It is exam scaffolding, not finished code; do not "fix" it without explicit instruction.
- **`lec13_polymorphism/` contains no `.java` files** (notes only). When asked to demonstrate or modify polymorphism examples, look in `lec11_inheritance/` instead.
- **JavaFX appears in three places, not just lec18 + hw8** — also in `lec00_jdk_install/JavaFXCheck.java`. Any "compile everything" workflow must account for the JavaFX module path in all three directories.
