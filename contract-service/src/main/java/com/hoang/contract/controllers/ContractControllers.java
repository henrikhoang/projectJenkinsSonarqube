package com.hoang.contract.controllers;

	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.hoang.contract.dto.Contract;

	@RestController
	@RequestMapping(ContractControllers.CONTRACT_BASE_URI)
	public class ContractControllers {

		public static final String CONTRACT_BASE_URI = "svc/v1/contracts";
		
		@RequestMapping(value = "{contractNumber}")
		public Contract getContract(@PathVariable final int contractNumber) {
			Contract contract = new Contract();
			contract.setName("phillip");
			contract.setId(contractNumber);
			return contract;
			
		}
		
	

}
