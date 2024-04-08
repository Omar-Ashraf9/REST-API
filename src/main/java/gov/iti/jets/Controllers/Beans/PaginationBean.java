package gov.iti.jets.Controllers.Beans;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.QueryParam;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PaginationBean {
    @QueryParam("offset")
    @DefaultValue("0")
    private int offset;

    @QueryParam("limit")
    @DefaultValue("10")
    private int limit;
}
