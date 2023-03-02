package net.rest;

import net.model.KPI;
import net.service.KPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController
@RequestMapping("/rest")
public class KPIRestController {


    @Autowired
    private KPIService kpiService;

    @RequestMapping(value = "/kpi/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<KPI> getCustomer(@PathVariable("id") Long kpiId) {

        if (kpiId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        KPI kpi = this.kpiService.getById(kpiId);

        if (kpi == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(kpi, HttpStatus.OK);
    }

    @RequestMapping(value = "/kpi", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<KPI> saveCustomer(@RequestBody @Valid KPI kpi) {
        HttpHeaders headers = new HttpHeaders();

        if (kpi == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.kpiService.save(kpi);
        return new ResponseEntity<>(kpi, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/kpi/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<KPI> updateCustomer(@RequestBody @Valid KPI kpi) {
        HttpHeaders headers = new HttpHeaders();

        if (kpi == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.kpiService.save(kpi);

        return new ResponseEntity<>(kpi, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/kpi/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<KPI> deleteCustomer(@PathVariable("id") Long id) {
        KPI kpi = this.kpiService.getById(id);

        if (kpi == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.kpiService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/kpis", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<KPI>> getAllCustomers() {
        List<KPI> kpis = this.kpiService.getAll();

        if (kpis.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(kpis, HttpStatus.OK);
    }

    @RequestMapping(value = "/kpis", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<KPI> deleteAllCustomers() {

        this.kpiService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/kpis", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<KPI>> saveAllCustomers(@RequestBody @Valid List<KPI> kpis) {
        HttpHeaders headers = new HttpHeaders();

        if (kpis.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        for(KPI kpi :kpis)
        {
            this.kpiService.save(kpi);
        }

        return new ResponseEntity<>(kpis, headers, HttpStatus.OK);
    }
}
