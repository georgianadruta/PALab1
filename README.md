# PALab1
## Introduction to Java Programming
This repository contains all the problems proposed for the second laboratory in Advanced Programming course solved by me.

# Essentials tools
You need to have Java RE or JDK >= 8 installed on your computer.

# Build and run the above programs
Launch IntelliJ IDEA and click ▶️ in the gutter and select Run 'Main()' in the popup. The IDE starts compiling your code. When the compilation is complete, the Run tool window opens at the bottom of the screen

# Tasks
# Compulsory
Write a Java application that implements the following operations:
- [x] Display on the screen the message "Hello World!". Run the application. If it works, go to step 2 :)
- [x] Define an array of strings languages, containing {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"}
- [x] Generate a random integer n: int n = (int) (Math.random() * 1_000_000);
- [x] Compute the result obtained after performing the following calculations:
  multiply n by 3;
  add the binary number 10101 to the result;
  add the hexadecimal number FF to the result;
  multiply the result by 6;
- [x] Compute the sum of the digits in the result obtained in the previous step. This is the new result. While the new result has more than one digit, continue to sum the digits of the result.
- [x] Display on the screen the message: "Willy-nilly, this semester I will learn " + languages[result].
## Output
```
Hello world
Willy-nilly, this semester I will learn Java.
```
# Optional
- [x] Let n be an integer given as a command line argument. Validate the argument!
- [x] Create a n x n matrix, representing the adjacency matrix of a random graph .
- [x] Display on the screen the generated matrix (you might want to use the geometric shapes from the Unicode chart to create a "pretty" representation of the matrix).
- [x] Verify if the generated graph is connected and display the connected components (if it is not).
- [x] Assuming that the generated graph is connected, implement an algorithm that creates a partial tree of the graph. Display the adjacency matrix of the tree.
- [x] For larger n display the running time of the application in nanoseconds (DO NOT display the matrices). Try n > 30_000. You might want to adjust the JVM Heap Space using the VM options -Xms4G -Xmx4G.
- [x] Launch the application from the command line, for example: java Lab1 100.
## Output
```
Enter a number.
6
Adjacency matrix:
0 0 1 1 1 1 
1 0 1 1 1 0 
0 1 0 1 0 1 
0 0 0 0 1 1 
1 1 1 0 0 1 
0 0 0 0 0 0 
Depth-first search:
0 2 1 3 4 5 
So... the graph is connected.
Partial tree:
root: 0 children: 2 
parent: 1 children: 3 
parent: 2 children: 1 
parent: 3 children: 4 
parent: 4 children: 5 
parent: 5 children: 
The adjacency matrix of the tree:
0 0 1 1 1 1 
1 0 1 1 1 0 
0 1 0 1 0 1 
0 0 0 0 1 1 
1 1 1 0 0 1 
0 0 0 0 0 0 
3226375400 nanoseconds
```
# Bonus
- [x] Implement an efficient algorithm that generates a random rooted tree. Create and display a textual representation of the tree, for example:
```
+node0
  +node1
    -node2
  +node3
    -node4
    -node5
```
## Output
```
Enter a number.
5
Adjacency matrix:
0 1 0 0 1 
0 0 1 1 0 
1 0 0 1 0 
1 0 0 0 0 
0 0 0 0 0 
Depth-first search:
0 1 2 3 4 
So... the graph is connected.
Adjacency lists: 

Adjacency list of vertex 0: 1 4 

Adjacency list of vertex 1: 2 

Adjacency list of vertex 2: 3 

Adjacency list of vertex 3: 

Adjacency list of vertex 4: 
Tree representation:
+node0
  +node1  -node4
  +node2
  -node3
```
