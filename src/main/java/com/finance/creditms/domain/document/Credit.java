package com.finance.creditms.domain.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Document(collection = "credit")
@Data
public class Credit {
    @Id
    private String id;
    private String productId;
    private String clientId;
    private String account;
}
