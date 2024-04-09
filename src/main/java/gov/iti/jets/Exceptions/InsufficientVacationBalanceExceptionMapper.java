package gov.iti.jets.Exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class InsufficientVacationBalanceExceptionMapper implements ExceptionMapper<InsufficientVacationBalanceException> {
    @Override
    public Response toResponse(InsufficientVacationBalanceException e) {
        System.out.println("InsufficientVacationBalanceExceptionMapper");
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage(), 400, "Insufficient vacation balance");
        return Response.status(Response.Status.BAD_REQUEST).entity(errorMessage).build();
    }
}
