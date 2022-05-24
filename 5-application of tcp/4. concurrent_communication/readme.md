# algorithm
## server
Step 1:  Create a socket and bind to the address. Leave socket unconnected.  
Step 2 : Leave socket in passive mode, making it ready for use by a server.  
Step 3:  Repeatedly call accept to receive the next request from a client to handle the response with the through socket.  
## client
Step 1: Begin with a connection passed from the server (i.e., a socket for the connection).  
Step 2: Use input streams; get the message from user to be given to the server.  
Step 3: Use input streams read message given by server and  print it.  
Step 4: Use output streams to write message to the server.  
Step 5: Close the connection and exit, i.e., slave terminates after handling all requests from one client.  

