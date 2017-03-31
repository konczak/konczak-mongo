package pl.konczak.learn.mongo.web.rest;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.konczak.learn.mongo.domain.Domain;
import pl.konczak.learn.mongo.domain.DomainRepository;

@RestController
@RequestMapping("/domain")
public class DomainApi {

    private final DomainRepository domainRepository;

    public DomainApi(DomainRepository domainRepository) {
        this.domainRepository = domainRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Domain> list() {
        return domainRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,
                    value = "/{domain}")
    public HttpEntity<Domain> get(@PathVariable("domain") String domainName) {
        Domain domain = domainRepository.findFirstByDomain(domainName);

        if (domain == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(domain);
    }

    @RequestMapping(method = RequestMethod.POST)
    public HttpEntity<Domain> create(@RequestBody DomainCreateCommand domainCreateCommand) {
        Domain domain = new Domain(domainCreateCommand.getDomain(), domainCreateCommand.isDisplayAds());

        domain = domainRepository.save(domain);

        return ResponseEntity.ok(domain);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public HttpEntity update(@RequestBody DomainUpdateCommand domainUpdateCommand) {
        Domain domain = domainRepository.findOne(domainUpdateCommand.getId());

        if (domain == null) {
            return ResponseEntity.badRequest().build();
        }

        domain.setDomain(domainUpdateCommand.getDomain());
        domain.setDisplayAds(domainUpdateCommand.isDisplayAds());

        domainRepository.save(domain);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.DELETE,
                    value = "/{id}")
    public HttpEntity delete(@PathVariable("id") UUID id) {
        domainRepository.delete(id);

        return ResponseEntity.noContent().build();
    }

}
