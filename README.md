# TwoplesF2020: A Study on Computer Algorithms
Two algorithms were coded in supplement to the reading: An example of DFS and the Gale-Shapley algorithm. 

To run the DFS search (Graph.java), the user will need to create the graph first in the main function by calling the constructor with the number of vertices desired and the addEdge() method. All nodes are of type int. Then run DFS with a starting vertex. 

To run the Gale-Shapley algorithm, Gale_Shapley.java and GSATester.java are needed. The user will need to create preference lists in GSATester.java for the men and women each in a 2D array, with each row being the ith man/woman and each column being the jth man/woman of preference for i, j < N, and N being the number of men and women. The individual in the 0th index is the one of highest preference, and the one in the (N-1)st index is the one of least preference. The algorithm assumes that there are the same number of men and women. To run the algorithm, call the stableMarraige() method. 
