package dev.adafycheng.microservices.client.account.model;

import lombok.Builder;
import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@Builder
@AllArgsConstructor
@Entity
public class CustomerAccount {

    @Id
    private Long accountId;

    private String lastName;

    private String firstName;

}