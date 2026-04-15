# Data Structures and Algorithms Lab 2: Sorting & Linked Lists

## Student Information
- **Student Name:** Nguyen Nguyen Khoi / Tran Ngoc Bach
- **Student ID:** ITITWE24052 / ITCSIU24007

## Completed Exercises

1. **Problem 1: Sort Tickets by Priority and Time** (`problem1/`)
   - Files: `Ticket.java`, `SortTicketSort.java`
   - Implementation: Manual bubble sort without built-in `sort()` function
   - Sorts tickets by priority (ascending), then by creation time (ascending)

2. **Problem 3: Merge Two Sorted Linked Lists** (`problem3/`)
   - File: `mergeSortLinkList.java`
   - Implementation: Manual merge without built-in list utilities
   - Reuses existing nodes to merge two sorted singly linked lists
   - Input: `1 → 3 → 7 → null`, `2 → 3 → 9 → null`
   - Output: `1 → 2 → 3 → 3 → 7 → 9 → null`

3. **Problem 5: Split Playlist into Two Halves** (`Problem5/`)
   - File: `splitTwoHalves.java`
   - Implementation: Fast/slow pointer technique without built-in list utilities
   - For odd-length lists, the middle element belongs to the first half
   - Input: `1 → 2 → 3 → 4 → 5 → null`
   - Output: First half: `1 → 2 → 3 → null`, Second half: `4 → 5 → null`

4. **Problem 7: Sort a Linked List** (`Problem7/`)
   - File: `sortLinkList.java`
   - Implementation: Merge sort on singly linked lists without built-in sorting
   - Includes explanation of why array-based sorting is unsuitable for linked lists
   - Tests: unsorted data, duplicates, already sorted data, single element, empty list
   
5. **Problem 2: Compare Advanced Sorts on Different Inputs (problem2/)
Files: MergeSortCompare.java, QuickSortCompare.java, SortComparisonRunner.java
Implementation: Manual Merge Sort and Quick Sort with instrumentation, without built-in sorting
   - Compares Merge Sort and Quick Sort on multiple datasets:
 - random
 - already sorted
 - reverse sorted
 - many duplicates
Reports:
 - number of comparisons
 - number of swaps/moves
 - maximum recursion depth
 - Includes short analysis of why the algorithms behave differently on different input patterns
6. **Problem 4: De-duplicate a Contact List (problem4/)

File: RemoveDuplicateList.java
Implementation: Manual duplicate removal using HashSet, without built-in list utilities
- Removes duplicate values from an unsorted singly linked list
- Preserves the first occurrence of each value
- Preserves the original relative order of first appearances
Example:
- Input: 5 → 1 → 5 → 2 → 1 → null
- Output: 5 → 1 → 2 → null
  
7. ** Problem 6: Stable Partition Around Threshold x (problem6/)
File: StablePartitionList.java
Implementation: Manual stable partition using pointer rearrangement, without built-in list utilities
- Rearranges nodes so that:
 - all values < x come first
 - all values >= x come after
- Preserves the relative order inside each group
- Reuses existing nodes instead of creating a new data structure
Example:
- Input: 3 → 5 → 8 → 5 → 10 → 2 → 1 → null, x = 5
- Output: 3 → 2 → 1 → 5 → 8 → 5 → 10 → null

8. **Problem 8: Detect and Fix a Cycle (problem8/)

File: DetectAndFixCycle.java
Implementation: Manual cycle detection and removal without built-in list utilities
Detects whether a cycle exists in a linked list
Finds the entry node of the cycle
Fixes the list by removing the cycle and restoring a linear linked list
Includes two approaches:
HashSet-based approach using extra memory
Floyd’s cycle detection algorithm using no extra memory beyond a few pointers
Outputs:
whether a cycle exists
the cycle entry node value
the final linear list after repair

## Compilation Instructions

### Compile All Problems
```bash
javac -d bin src/problem1/*.java
javac -d bin src/problem2/*.java
javac -d bin src/problem3/*.java
javac -d bin src/problem4/*.java
javac -d bin src/Problem5/*.java
javac -d bin src/problem6/*.java
javac -d bin src/Problem7/*.java
javac -d bin src/problem8/*.java
```

### Compile Specific Problem
```bash
# Problem 1
javac -d bin src/problem1/Ticket.java src/problem1/SortTicketSort.java

# Problem 2
javac -d bin src/problem2/MergeSortCompare.java src/problem2/QuickSortCompare.java src/problem2/SortComparisonRunner.java

# Problem 3
javac -d bin src/problem3/mergeSortLinkList.java

# Problem 4
javac -d bin src/problem4/RemoveDuplicateList.java

# Problem 5
javac -d bin src/Problem5/splitTwoHalves.java

# Problem 6
javac -d bin src/problem6/StablePartitionList.java

# Problem 7
javac -d bin src/Problem7/sortLinkList.java

# Problem 8
javac -d bin src/problem8/DetectAndFixCycle.java
```

## Run Instructions

### Run from VS Code
1. Open the specific Java file (e.g., `SortTicketSort.java`)
2. Click the "Run" button in the editor or press `Ctrl+F5`

### Run from Command Line
```bash
cd Lab2

# Problem 1
java -cp bin problem1.SortTicketSort

# Problem 2
java -cp bin problem2.SortComparisonRunner

# Problem 3
java -cp bin problem3.mergeSortLinkList

# Problem 4
java -cp bin problem4.RemoveDuplicateList

# Problem 5
java -cp bin Problem5.splitTwoHalves

# Problem 6
java -cp bin problem6.StablePartitionList

# Problem 7
java -cp bin Problem7.sortLinkList

# Problem 8
java -cp bin problem8.DetectAndFixCycle
```

## Assumptions & Limitations

### Assumptions
- All input data is valid and within expected ranges
- Linked lists are singly linked (forward traversal only)
- No circular references in linked lists
- Null values represent end of list (denoted as `null`)
- Array-based input is pre-sorted where required (e.g., Problem 3 merge requires sorted input lists)

### Limitations
- **No Random Access:** Linked list operations require sequential traversal, making some operations (like binary search) inefficient
- **Manual Implementation:** All sorting and merging is done without Java's built-in `Collections.sort()`, `List.sort()`, or `Comparator` to better demonstrate algorithm mechanics
- **Memory:** Each node maintains a reference to the next node, using more memory than array-based storage
- **Duplicate Handling:** Duplicates are preserved in all operations
- **Complexity:** Manual sorting using merge sort on linked lists has O(n log n) time complexity but requires finding the middle node repeatedly

## Folder Structure
```
Lab2/
├── README.md
├── bin/                    (compiled output)
├── src/
│   ├── problem1/           (Ticket sorting)
│   ├── problem2/           (Compare advanced sorts)
│   ├── problem3/           (Merge sorted linked lists)
│   ├── problem4/           (De-duplicate contact list)
│   ├── Problem5/           (Split into halves)
│   ├── problem6/           (Stable partition around x)
│   ├── Problem7/           (Sort linked list)
│   └── problem8/           (Detect and fix cycle)
└── lib/                    (dependencies)
```
