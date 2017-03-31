package pl.konczak.learn.mongo.domain;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface DomainRepository
        extends MongoRepository<Domain, UUID>,
        DomainRepositoryCustom {

    Domain findFirstByDomain(String domain);

    Domain findByDomainAndDisplayAds(String domain, boolean displayAds);

    //Supports native JSON query string
    @Query("{domain:'?0'}")
    Domain findCustomByDomain(String domain);

    @Query("{domain: { $regex: ?0 } })")
    List<Domain> findCustomByRegExDomain(String domain);
}
