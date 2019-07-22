# libraryManagement

A school needs a mini library management system with the following facilities.
1. Register a new book.
Every book has a unique ID. In addition, it has few important details such as its title and author.
Assume each title has just one copy in the library.
2. Register a new student.
Every student has a unique ID along with the name.
3. Lend a book to the student.
Student can hold a maximum of 2 books at any point in time.
4. Receive a lent book back from the student and indicate the penalty to be paid, if any.
Students can retain the borrowed book for a maximum of 2 weeks. Any delay in returning the
book requires paying a penalty of 1 rupee per day for the first 3 days of delay, 2 rupees per day
for the next 3 days of delay, and 3 rupees per day thereafter. If the students return a book with
more than a month’s delay, they will be blacklisted forever. Blacklisted students can not borrow
books from the library.
5. Search a book based on its title -- Attempt this only if the time permits.
In addition to exact matching, prefix matching and fuzzy matching are few special cases to
consider.
Implement this mini library management system. Provide API for each of the operations listed above.
Core Java APIs are fine. However, if the time permits, feel free to use Spring or JEE, and develop REST
APIs.
Note:
1. Hold all the data in the memory. Persisting data into a db or a file system is not needed.
2. Handle corner cases appropriately.
3. Concurrency handling is a plus.
Imagine a case where different books are being registered at the same time. Managing a unique
ID for each book becomes crucial in such cases.
4. Use logging tools such as log4j or java.util.Logging instead of System.out.println()
5. Good code is appreciated!
