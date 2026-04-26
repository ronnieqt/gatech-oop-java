# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Course Context

This is **GTx CS1331x: Introduction to Object-Oriented Programming with Java** — an educational repository. Each directory is a standalone lesson or assignment, not a unified application.

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

## Repository Structure

```
lecXX_topic/   Lecture examples, numbered sequentially (lec00, lec01, …)
hwX/           Homework assignments (often paired with *Sol.java solution files)
examX/         Exam materials
scripts/       Utility scripts (e.g., clean.ps1 for removing *.class files)
```

No packages are used — all files are in the default package within their directory.

## Code Architecture Progression

Lectures build progressively:

1. **Basics & procedural Java** (lec00–lec03) — JDK setup, hello world, variables, types, control flow
2. **I/O & iteration** (lec05–lec08) — Scanner input, loops, arrays, command-line args *(lec04 not present in repo)*
3. **Methods** (lec09) — static methods, parameters, return types
4. **OOP** (lec10) — classes, encapsulation, constructors, static members, multi-class programs
5. **Inheritance & interfaces** (lec11) — extends, implements, abstract classes, UML
6. **Algorithms** (lec12) — searching and sorting
7. **Polymorphism** (lec13) — dynamic binding, is-a test, declared vs. object type
8. **Exception handling** (lec14) — try/catch/finally, multi-catch, custom exceptions
9. **File I/O** (lec15) — Scanner + PrintWriter on files, checked exceptions, CSV parsing

Homework assignments mirror this progression:
- hw1–hw3: procedural and basic OOP problems
- hw4: static fields/methods, encapsulation (Frog/Pond)
- hw5: multi-class inheritance and interfaces (Among Us–style game)
- hw6: full OOP + exception handling + file I/O (veterinary clinic simulation)

## Utilities

- `scripts/clean.ps1` — Recursively removes `*.class` files. Dry-run by default; pass `-Run` to actually delete.

## Conventions

- Solution files are named `*Sol.java` (e.g., `FrogSol.java`, `CalculatorSol.java`)
- `*.class` files are excluded from git via `.gitignore`; always compile before running
- No test framework is used; programs demonstrate behavior via `main()` methods
