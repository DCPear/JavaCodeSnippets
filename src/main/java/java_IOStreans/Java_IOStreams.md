* Java I/O (Input and Output) is used to process the input and produce the output. Java uses the concept of a
* stream to make I/O operation fast. The java.io package contains all the classes required for input and output
* operations. We can perform file handling in Java by Java I/O API.
* usage -output stream to print out the text
*        reading (input streams) and writing files (output streams),
*        taking user inputs from the console
*        communicating through sockets
*        flow of data can go in one direction
*        Java IO streams are typically either byte based or character based.

An advantage of buffered reader is that it is synchronized, which means it can safely be
*  used in a multi-threaded application. It is also faster than a scanner.
*  better option for  reading in long sections of text.

###### important!
When using input and output resources, it is important to use try with resources whenever you can. Using try with 
resources makes sure that all resources are closed for me. I don't have to worry about manually closing all resources
which can be difficult. If resources aren't closed properly, it is easy to end up with code-leaking resources. This is
especially true if you are using multiple resources that interact with each other.