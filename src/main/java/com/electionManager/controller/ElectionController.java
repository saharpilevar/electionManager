package com.electionManager.controller;

import java.util.List;
import javax.validation.Valid;
import com.electionManager.repository.ElectionRepository;
import com.electionManager.exception.ResourceNotFoundException;
import com.electionManager.model.Election;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class ElectionController {
			@Autowired
			private ElectionRepository electionRepository;
					    
		    //1
		    /**

		     * Create election elect.

		     *

		     * @param election the elect

		     * @return the election

		     */
		    @PostMapping("/CreateElection")
		    public void createElection(@Valid @RequestBody Election elect) {	
		    	 electionRepository.save(elect);		    	   
		    }
		    
		    
		    //2		    
		    /**
		     * Update election response entity.

		     *

		     * @param electionId the election id

		     * @param userDetails the user details

		     * @return the response entity

		     * @throws ResourceNotFoundException the resource not found exception

		     */

		    @PutMapping("/EditElection/{id}")

		    public void editElection(

		        @PathVariable(value = "id") Long electionId, @Valid @RequestBody Election electionDetails)

		        throws ResourceNotFoundException {

		      Election elect =

		          electionRepository

		              .findById(electionId)

		              .orElseThrow(() -> new ResourceNotFoundException("Election not found on :: " + electionId));

		      elect.setTitle(electionDetails.getTitle());

		      elect.setStartTime(electionDetails.getStartTime());
		      
		      elect.setEndTime(electionDetails.getEndTime());
		      
		      elect.setListOfChoices(electionDetails.getListOfChoices());
		      
		      elect.setNumberOfVotes(electionDetails.getNumberOfVotes());
		      electionRepository.save(elect);

		      //final election editedElection = electionRepository.save(elect);

		      //return ResponseEntity.ok(editedElection);

		    }
		   
		   //3
		    /**

			    * Delete election .

			    *

			    * @param electionId the election id

			    * @return the map

			    * @throws Exception the exception

			    */

			   @DeleteMapping("/RemoveElection/{id}")

			   public void removeElection(@PathVariable(value = "id") Long electionId) throws Exception {

			     Election elect =

			         electionRepository

			             .findById(electionId)

			             .orElseThrow(() -> new ResourceNotFoundException("Election not found on :: " + electionId));

			     electionRepository.delete(elect);

			     //Map<String, Boolean> response = new HashMap<>();

			     //response.put("deleted", Boolean.TRUE);

			     //return response;

			   }

		   //4
		   

		   @GetMapping("/GetAllElections")

		   public List<Election> getAllElections() {

		     return electionRepository.findAll();

		   }

	       //5
		   @GetMapping("/GetElectionDetails/{id}")
	        public String getElectionDetails(@PathVariable(value = "id") Long electionId)         	
	            
	        	throws ResourceNotFoundException {

	  		      Election elect =

	  		          electionRepository

	  		              .findById(electionId)

	  		              .orElseThrow(() -> new ResourceNotFoundException("Election not found on :: " + electionId));

	  		      
	  		      return elect.toString();
		    	
	       }
	        //6
	        @GetMapping("/ElectionExists/{id}")	        
	        public String electionExists(@PathVariable(value = "id") Long electionId)         	
            
		        	throws ResourceNotFoundException {

		  		      Election elect =

		  		          electionRepository

		  		              .findById(electionId)

		  		              .orElseThrow(() -> new ResourceNotFoundException("Election not found on :: " + electionId));

		  		      
		  		      return elect.toString();
			    	
		       }
	       
	     //7
	        @GetMapping("/GetListofChoices/{id}")
	       public List<String> GetListofChoices(@PathVariable(value = "id") Long electionId)         	
            
		        	throws ResourceNotFoundException {

		  		      Election elect =

		  		          electionRepository

		  		              .findById(electionId)

		  		              .orElseThrow(() -> new ResourceNotFoundException("Election not found on :: " + electionId));

		  		      
		  		      return elect.getListOfChoices();
			    	
		       }
	      
	     //8
		    @PutMapping("/IncremenetNumberOfVotes/{id}")

	      public String IncremenetNumberOfVotes(@PathVariable(value = "id") Long electionId)         	
          
		        	throws ResourceNotFoundException {

		  		      Election elect =

		  		          electionRepository

		  		              .findById(electionId)

		  		              .orElseThrow(() -> new ResourceNotFoundException("Election not found on :: " + electionId));

		  		      elect.setNumberOfVotes(elect.getNumberOfVotes()+1);

				      electionRepository.save(elect);
				      return "Number of votes incremented successfully";
				      //return ResponseEntity.ok(editedElection);

			    	
		       }

}

