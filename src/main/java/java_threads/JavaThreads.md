Threads allow multiple actions to be performed at the same time inside a single process.
In programming, a single process can have multiple threads working at the same time. Like a process, a thread is an 
independent path of execution that runs in isolation. Each thread has its own stack and its own local variables so when 
a method is running on a thread, the local variables in the method are only available within that thread.
Why not just use multiple processes instead of multiple threads? The answer is that threads are more closely connected 
to each other than separate processes.
But threads inside the same process are more closely connected, they share memory with other threads. All of the 
threads have the same access to global variables. This can sometimes lead to issues and mean that care should be taken
when using multiple threads
Deadlock describes a situation where two or more threads are blocked forever, waiting for each other. ...
A Java multithreaded program may suffer from the deadlock condition because the synchronized keyword causes the executing thread to block while waiting for the lock, or monitor, associated with the specified object.