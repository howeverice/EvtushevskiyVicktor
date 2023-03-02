package net.rest;

import net.model.Support;
import net.service.SupportService;
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
public class SupportRestController {

    @Autowired
    private SupportService supportService;

    @RequestMapping(value = "/support/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Support> getCustomer(@PathVariable("id") Long supportId) {

        if (supportId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Support support = this.supportService.getById(supportId);

        if (support == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(support, HttpStatus.OK);
    }

    @RequestMapping(value = "/support", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Support> saveCustomer(@RequestBody @Valid Support support) {
        HttpHeaders headers = new HttpHeaders();

        if (support == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.supportService.save(support);
        return new ResponseEntity<>(support, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/support/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Support> updateCustomer(@RequestBody @Valid Support support) {
        HttpHeaders headers = new HttpHeaders();

        if (support == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.supportService.save(support);

        return new ResponseEntity<>(support, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/support/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Support> deleteCustomer(@PathVariable("id") Long id) {
        Support support = this.supportService.getById(id);

        if (support == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.supportService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/supports", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Support>> getAllCustomers() {
        List<Support> supports = this.supportService.getAll();

        if (supports.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(supports, HttpStatus.OK);
    }

    @RequestMapping(value = "/supports", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Support> deleteAllCustomers() {

        this.supportService.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/supports", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Support>> saveAllCustomers(@RequestBody @Valid List<Support> supports) {
        HttpHeaders headers = new HttpHeaders();

        if (supports.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        for(Support customer :supports)
        {
            this.supportService.save(customer);
        }

        return new ResponseEntity<>(supports, headers, HttpStatus.OK);
    }
}
