package com.company.Group2GameStore.repository;

import com.company.Group2GameStore.model.ProcessingFees;
import com.company.Group2GameStore.model.Invoice;
import com.company.Group2GameStore.model.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceRepositoryTest {

    @Autowired
    InvoiceRepository invoiceRepo;

    @Autowired private EntityManager entityManager;


    @Before
    public void setUp() throws Exception {

        invoiceRepo.deleteAll();

    }

    @Test
    public void addGetDeleteInvoice() {

        Invoice invoice = new Invoice();
        invoice.setName("Bob");
        invoice.setStreet("Park Ave");
        invoice.setCity("Hartford");
        invoice.setState("CT");
        invoice.setZipCode("06106");
        invoice.setItemType("Games");
        invoice.setUnitPrice(new BigDecimal("20.00"));
        invoice.setItemId(1);
        invoice.setQuantity(5);
        invoice.setSubtotal(new BigDecimal(100.00));
        invoice.setTax(new BigDecimal("3.00"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("104.49"));

        //add to database
        invoiceRepo.save(invoice);

        assertEquals(true, invoiceRepo.existsById(invoice.getInvoiceId()));

        //delete
        invoiceRepo.deleteById(invoice.getInvoiceId());

        //check no longer exist
        assertEquals(false, invoiceRepo.existsById(invoice.getInvoiceId()));

    }

    //get all
    @Test
    public void shouldReturnAllInvoices() {

        Invoice invoice = new Invoice();
        invoice.setInvoiceId(0);
        invoice.setName("Bob");
        invoice.setStreet("Park Ave");
        invoice.setCity("Hartford");
        invoice.setState("CT");
        invoice.setZipCode("06106");
        invoice.setItemType("Games");
        invoice.setUnitPrice(new BigDecimal("20.00"));
        invoice.setItemId(1);
        invoice.setQuantity(5);
        invoice.setSubtotal(new BigDecimal(100.00));
        invoice.setTax(new BigDecimal("3.00"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("104.49"));


        Invoice invoice2 = new Invoice();
        invoice.setInvoiceId(0);
        invoice2.setName("Jill");
        invoice2.setStreet("Park Ave");
        invoice2.setCity("Hartford");
        invoice2.setState("CT");
        invoice2.setZipCode("06106");
        invoice2.setItemType("Games");
        invoice2.setUnitPrice(new BigDecimal("20.00"));
        invoice2.setItemId(1);
        invoice2.setQuantity(5);
        invoice2.setSubtotal(new BigDecimal(100.00));
        invoice2.setTax(new BigDecimal("3.00"));
        invoice2.setProcessingFee(new BigDecimal("1.49"));
        invoice2.setTotal(new BigDecimal("104.49"));

        // save new invoices
        invoiceRepo.save(invoice);
        invoiceRepo.save(invoice2);

        // find all invoices
        List<Invoice> list = invoiceRepo.findAll();

        assertEquals(2, list.size());
    }



  //update test
    @Test
    public void shouldUpdateInvoice() {

        Invoice invoice = new Invoice();
        invoice.setInvoiceId(0);
        invoice.setName("Bob");
        invoice.setStreet("Park Ave");
        invoice.setCity("Hartford");
        invoice.setState("CT");
        invoice.setZipCode("06106");
        invoice.setItemType("Games");
        invoice.setUnitPrice(new BigDecimal("20.00"));
        invoice.setItemId(1);
        invoice.setQuantity(5);
        invoice.setSubtotal(new BigDecimal(100.00));
        invoice.setTax(new BigDecimal("3.00"));
        invoice.setProcessingFee(new BigDecimal("1.49"));
        invoice.setTotal(new BigDecimal("104.49"));

        // set new name
        invoice.setName("Jill");

        // save to repo
        Invoice invoiceUpdate = invoiceRepo.save(invoice);

        assertEquals(invoiceUpdate.getName(), "Jill");

    }

}
