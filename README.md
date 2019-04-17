# electionManager
This is the implementation of the Election Manager module. This Module is responsible for creating, Editing and removing elections (of course, removing elections is possible, only if the election is not running). It is the implementation of a service comprising of RESTful APIs over HTTP that fulfill the aforementioned tasks.
An election model have the following columns; ID, Title, Start time, End time, listOfChoices, NumberOfVotes (only number of votes submitted and not the model itself).

A summary of APIs to Implement are:
 void CreateElection(Election election)
 void EditElection(Election election)
 void RemoveElection(int electionId)
 void IncremenetNumberOfVotes(int electionId)
 List getListOfChoices(int electionId)
 List getAllElections()
 void electionExists(int electionId)
 String getElectionDetails(int electionId)
