package com.gl.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.dao.TicketRepository;
import com.gl.entity.Ticket;

@Service
public class TicketServiceImpl implements TicketService {
	
	private TicketRepository tktRepository;

	@Autowired
	public TicketServiceImpl(TicketRepository thetktRepository) {
		tktRepository = thetktRepository;
	}

	@Override
	public List<Ticket> findAll() {

		List<Ticket> theTkt = tktRepository.findAll();
		for(Ticket tkt : theTkt) {
			System.out.println("theTkt dt=>"+tkt.getCreatedOn());
		}
		
		return theTkt;
	}

	@Override
	public Ticket findById(int theId) {
		Optional<Ticket> result = tktRepository.findById(theId);

		Ticket theTkt = null;

		if (result.isPresent()) {
			theTkt = result.get();
		} else {
			// we didn't find the tkt
			throw new RuntimeException("Did not find ticket id - " + theId);
		}

		return theTkt;
	}

	@Override
	public void save(Ticket thetheTkt) {
//		java.sql.Date date = new java.sql.Date(System.currentTimeMillis());
//		thetheTkt.setCreatedOn(date);
//		LocalDate localDate = LocalDate.now();
//		thetheTkt.setCreatedOn(localDate);
		System.out.println("date=>"+thetheTkt.getCreatedOn());
		tktRepository.save(thetheTkt);
	}

	@Override
	public void deleteById(int theId) {
		tktRepository.deleteById(theId);
	}

	@Override
	public List<Ticket> searchTicket(String keyword) {
		List<Ticket> tickets = null;
		if (keyword != null) {
			System.out.println("keyword=>"+keyword);
			tickets = tktRepository.searchTicket(keyword);
			System.out.println("tickets=>"+tickets.size());
            return tickets;
        }
		
		System.out.println("tickets1=>"+tickets.size());
		return tickets;
	}
	     

}
