package dev.adafycheng.microservices.client.account.repository;

import java.util.List;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;
import org.springframework.stereotype.Repository;

import dev.adafycheng.microservices.client.account.model.CustomerAccount;

@Repository
public interface CustomerAccountRepository extends DatastoreRepository<CustomerAccount, Long> {

    List<CustomerAccount> findByLastName(String name);

}