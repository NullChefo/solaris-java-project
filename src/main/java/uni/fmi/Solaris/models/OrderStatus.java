package uni.fmi.Solaris.models;

import lombok.Getter;

@Getter
public enum OrderStatus {
	PENDING("Pending"),
	PROCESSING("Processing"),
	SHIPPED("Shipped"),
	DELIVERED("Delivered"),
	CANCELLED("Cancelled");

	private final String status;

	private OrderStatus(String status) {
		this.status = status;
	}

}
