package com.personalprojects.artexico.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class PaymentMethod {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String method;

	public PaymentMethod() {
		super();
	}

	public PaymentMethod(int id, String method) {
		super();
		this.id = id;
		this.method = method;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentMethod other = (PaymentMethod) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "PaymentMethod [id=" + id + ", method=" + method + "]";
	}

}
