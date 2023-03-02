package net.service;

import lombok.extern.slf4j.Slf4j;

import net.model.Support;
import net.repository.SupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SupportServiceImpl implements SupportService
{
    @Autowired
    SupportRepository supportRepository;

    @Override
    public Support getById(Long id) {
        //    log.info("IN CustomerServiceImpl getById {}");
        return supportRepository.findOne(id);
    }


    @Override
    public void save(Support support) {
        //     log.info("IN CustomerServiceImpl save {}");
        supportRepository.save(support);
    }

    @Override
    public void delete(Long id) {
        //  log.info("IN CustomerServiceImpl delete {}");
        supportRepository.delete(id);
    }

    @Override
    public List<Support> getAll() {
        //   log.info("IN CustomerServiceImpl getAll");
        return supportRepository.findAll();
    }

    @Override
    public void deleteAll() {
        //   log.info("IN CustomerServiceImpl getAll");
        supportRepository.deleteAll();
    }
}
