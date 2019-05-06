package hu.adam.nosmoke.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlignRequest {

    private long userId;
    private long itemId;

}
