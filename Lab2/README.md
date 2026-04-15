# Data Structures and Algorithms Lab 2: Sorting & Linked Lists

## Student Information
- **Student Name:** Nguyen Nguyen Khoi
- **Student ID:** ITITWE24052

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

## Compilation Instructions

### Compile All Problems
```bash
javac -d bin src/problem1/*.java
javac -d bin src/problem3/*.java
javac -d bin src/Problem5/*.java
javac -d bin src/Problem7/*.java
```

### Compile Specific Problem
```bash
# Problem 1
javac -d bin src/problem1/Ticket.java src/problem1/SortTicketSort.java

# Problem 3
javac -d bin src/problem3/mergeSortLinkList.java

# Problem 5
javac -d bin src/Problem5/splitTwoHalves.java

# Problem 7
javac -d bin src/Problem7/sortLinkList.java
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

# Problem 3
java -cp bin problem3.mergeSortLinkList

# Problem 5
java -cp bin Problem5.splitTwoHalves

# Problem 7
java -cp bin Problem7.sortLinkList
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
├── bin/              (compiled output)
├── src/
│   ├── problem1/     (Ticket sorting)
│   ├── problem3/     (Merge sorted lists)
│   ├── Problem5/     (Split into halves)
│   └── Problem7/     (Sort linked list)
└── lib/              (dependencies)
```
