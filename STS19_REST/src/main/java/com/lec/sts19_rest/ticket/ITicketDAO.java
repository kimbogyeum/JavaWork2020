package com.lec.sts19_rest.ticket;

public interface ITicketDAO {
	//아래 2개의 동작이 하나의 트렌잭션으로 처리되어야 한다 !
	int insertCard(String userId, int buyAmount);
	int insertTicket(String userId, int ticketCount);
}
