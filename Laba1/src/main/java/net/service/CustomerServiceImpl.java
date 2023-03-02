package net.service;

import lombok.extern.slf4j.Slf4j;
import net.model.Customer;
import net.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {



    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer getById(Long id) {
        //    log.info("IN CustomerServiceImpl getById {}");
        return customerRepository.findOne(id);
    }


    @Override
    public void save(Customer customer) {
        //     log.info("IN CustomerServiceImpl save {}");
        customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        //  log.info("IN CustomerServiceImpl delete {}");
        customerRepository.delete(id);
    }

    @Override
    public List<Customer> getAll() {
        //   log.info("IN CustomerServiceImpl getAll");
        return customerRepository.findAll();
    }

    @Override
    public void deleteAll() {
        //   log.info("IN CustomerServiceImpl getAll");
        customerRepository.deleteAll();
    }

}
