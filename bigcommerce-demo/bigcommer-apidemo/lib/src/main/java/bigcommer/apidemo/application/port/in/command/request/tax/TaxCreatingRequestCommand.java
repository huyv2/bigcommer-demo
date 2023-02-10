package bigcommer.apidemo.application.port.in.command.request.tax;

import java.util.ArrayList;
import java.util.List;

import bigcommer.apidemo.application.port.in.command.request.tax.data.TaxCreatingRequestData;

public class TaxCreatingRequestCommand {
	private List<TaxCreatingRequestData> taxCreatingRequestCommandList = new ArrayList<>();

	public List<TaxCreatingRequestData> getTaxCreatingRequestCommandList() {
		return taxCreatingRequestCommandList;
	}
	public void setTaxCreatingRequestCommandList(List<TaxCreatingRequestData> taxCreatingRequestCommandList) {
		this.taxCreatingRequestCommandList = taxCreatingRequestCommandList;
	}
}
