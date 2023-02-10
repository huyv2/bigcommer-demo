package bigcommer.apidemo.application.port.in.tax;

import bigcommer.apidemo.application.port.in.command.request.tax.TaxCreatingRequestCommand;
import bigcommer.apidemo.application.port.in.command.response.tax.TaxCreatingResponseCommand;

public interface TaxCreatingUseCase {
	TaxCreatingResponseCommand createTaxProperty(TaxCreatingRequestCommand taxCreatingRequestCommand);
}
