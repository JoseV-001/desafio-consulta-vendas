package com.devsuperior.dsmeta.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public Page<SaleMinDTO> report(String minDate, String maxDate, String name, Pageable pageable) {

		LocalDate min = (minDate == null) ? null : LocalDate.parse(minDate);
		LocalDate max = (maxDate == null) ? null : LocalDate.parse(maxDate);

		LocalDate today = LocalDate.now();

		if (max == null) {
			max = today;
		}
		if (min == null) {
			min = max.minusYears(1);
		}
		if (name == null) {
			name = "";
		}
		Page<Sale> result = repository.findSalesBy(min, max, name, pageable);

		return result.map(x -> new SaleMinDTO(x));
	}


	public List<SaleSummaryDTO> summary(String minDate, String maxDate){

		LocalDate min = (minDate == null) ? null : LocalDate.parse(minDate);
		LocalDate max = (maxDate == null) ? null : LocalDate.parse(maxDate);

		LocalDate today = LocalDate.now();

		if (max == null) {
			max = today;
		}
		if (min == null) {
			min = max.minusYears(1);
		}

		return repository.amountGroupedBySeller(min, max);
	}

}
