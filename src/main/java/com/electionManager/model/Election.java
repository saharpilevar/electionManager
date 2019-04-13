package com.electionManager.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;



/**
 * The type election.
 *
 */
@Entity
@Table(name = "election")
//@EntityListeners(AuditingEntityListener.class)
public class Election {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;    

    
    @Column(name = "start_time", nullable = false)
    private String startTime;

    
    @Column(name = "end_time", nullable = false)
    private String endTime;
    
    @Column(name = "list_of_choices", nullable = false)
    private List<String> listOfChoices=new ArrayList<String>(); 
    
    @Column(name = "number_of_votes", nullable = false)
    private int numberOfVotes;

 
 

}
