package com.gl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gl.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {


    @Query(value = "SELECT id, title, description, content, created_on FROM ticket t WHERE t.title LIKE CONCAT('%',:keyword, '%') OR t.description LIKE CONCAT('%',:keyword, '%')", nativeQuery = true)
    List<Ticket> searchTicket(String keyword);

//	  @Query("SELECT id, title, description, content, createdOn FROM ticket t WHERE t.title = :keyword")
//	    List<Ticket> searchTicket(@Param("searchParam") String searchParam);

//	List<Ticket> searchTicket(String keyword);

//	@Query("SELECT id, title, description, content, createdOn FROM ticket t WHERE title LIKE '%?1%'"
//			+ "OR description LIKE '%?1%'")
//	public List<Ticket> searchTicket(String keyword);
}
