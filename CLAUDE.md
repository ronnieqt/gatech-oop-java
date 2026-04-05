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

Lectures build progressively: basics and procedural Java → OOP (classes, encapsulation, static members) → multi-class programs → inheritance and interfaces → algorithms. Homework assignments mirror this progression with increasingly complex multi-class designs.

## Utilities

- `scripts/clean.ps1` — Recursively removes `*.class` files. Dry-run by default; pass `-Run` to actually delete.

## Conventions

- Solution files are named `*Sol.java` (e.g., `FrogSol.java`, `CalculatorSol.java`)
- `*.class` files are excluded from git via `.gitignore`; always compile before running
- No test framework is used; programs demonstrate behavior via `main()` methods
