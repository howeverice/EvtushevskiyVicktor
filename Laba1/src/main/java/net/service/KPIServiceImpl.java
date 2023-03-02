package net.service;

import lombok.extern.slf4j.Slf4j;
import net.model.KPI;
import net.repository.KPIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Slf4j
@Service

public class KPIServiceImpl implements KPIService{

    @Autowired
    KPIRepository kpiRepository;

    @Override
    public KPI getById(Long id) {
        //    log.info("IN CustomerServiceImpl getById {}");
        return kpiRepository.findOne(id);
    }


    @Override
    public void save(KPI kpi) {
        //     log.info("IN CustomerServiceImpl save {}");
        kpiRepository.save(kpi);
    }

    @Override
    public void delete(Long id) {
        //  log.info("IN CustomerServiceImpl delete {}");
        kpiRepository.delete(id);
    }

    @Override
    public List<KPI> getAll() {
        //   log.info("IN CustomerServiceImpl getAll");
        return kpiRepository.findAll();
    }

    @Override
    public void deleteAll() {
        //   log.info("IN CustomerServiceImpl getAll");
        kpiRepository.deleteAll();
    }
}
