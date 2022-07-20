package com.company.Group2GameStore.repository;

import com.company.Group2GameStore.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
