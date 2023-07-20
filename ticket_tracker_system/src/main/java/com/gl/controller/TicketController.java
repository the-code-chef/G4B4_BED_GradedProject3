package com.gl.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.entity.Ticket;
import com.gl.service.TicketService;

@Controller
@RequestMapping("/tkt")
public class TicketController {

	private TicketService tktService;
	
	public TicketController(TicketService ticketService) {
		tktService = ticketService;
	}
	
	// add mapping for "/list"
	@GetMapping("/tktList")
	public String listTicket(Model theModel) {
		
		// get Ticket from database
		List<Ticket> ticketList = tktService.findAll();
		
		// add to the spring model
		theModel.addAttribute("ticketList", ticketList);
		
		return "ticket/list-tkt";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Ticket tkt = new Ticket();
		String heading = "Create Ticket";
		theModel.addAttribute("heading", heading);
		theModel.addAttribute("tkt", tkt);
		
		return "ticket/tkt-form";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("tktId") int theId,
									Model theModel) {
		
		Ticket tkt = tktService.findById(theId);
		
		String heading = "Update Ticket";
		theModel.addAttribute("heading", heading);
		theModel.addAttribute("tkt", tkt);
		
		// send over to our form
		return "ticket/tkt-form";			
	}
	
	
	@PostMapping("/save")
	public String saveEmp(@ModelAttribute("tkt") Ticket theTkt) {
		System.out.println("theTkt=>"+theTkt.getCreatedOn());
		tktService.save(theTkt);
		
		return "redirect:/tkt/tktList";
	}
	
	
	@PostMapping("/delete")
	public String delete(@RequestParam("tktId") int theId) {
		
		// delete the ticket
		tktService.deleteById(theId);
		
		return "redirect:/tkt/tktList";
	}
	
	@GetMapping("/search")
	public String searchMethod(Model theModel,String keyword) {
		
		// search Ticket from database
		List<Ticket> ticketList = tktService.searchTicket(keyword);
		
		// add to the spring model
		theModel.addAttribute("ticketList", ticketList);
		
		return "ticket/list-tkt";
	}
}


















