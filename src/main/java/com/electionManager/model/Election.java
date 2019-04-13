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

  /**
   * Gets id.
   *
   * @return the id
   */
  public long getId() {
        return id;
    }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(long id) {
        this.id = id;
    }

  /**
   * Gets title.
   *
   * @return the title
   */
  public String getTitle() {
        return title;
    }

  /**
   * Sets title.
   *
   * @param title 
   */
  public void setTitle(String title) {
        this.title = title;
    }

  /**
   * Gets startTime
   *
   * @return the startTime
   */
  public String getStartTime() {
        return startTime;
    }

  /**
   * Sets startTime.
   *
   * @param startTime the startTime
   */
  public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

  /**
   * Gets endTime
   *
   * @return the endTime
   */
  public String getEndTime() {
        return endTime;
    }

  /**
   * Sets endTime.
   *
   * @param endTime the endTime
   */
  public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
  /**
   * Gets listOfChoices
   *
   * @return the listOfChoices
   */
  public List<String> getListOfChoices() {
        return listOfChoices;
    }

  /**
   * Sets listOfChoices.
   *
   * @param listOfChoices
   */
  public void setListOfChoices(List<String> listOfChoices) {
        this.listOfChoices = listOfChoices;
    }
  /**
   * Gets numberOfVotes
   *
   * @return the numberOfVotes
   */
  public int getNumberOfVotes() {
        return numberOfVotes;
    }

  /**
   * Sets numberOfVotes.
   *
   * @param numberOfVotes
   */
  public void setNumberOfVotes(int numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }
 

    @Override
    public String toString() {
        return "Election{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", listOfChoices=" + listOfChoices +
                ", numberOfVotes='" + numberOfVotes + '\'' +                
                '}';
    }


}
