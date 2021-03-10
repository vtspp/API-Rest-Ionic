package com.vtspp.api.ionic.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vtspp.api.ionic.enums.StatusPayment;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;

@Entity(name = "tb_payment_with_boleto")
public class PaymentWithBoleto extends Payment{

     @JsonFormat(pattern="dd/MM/yyyy")
     private LocalDate dueDate;

     @JsonFormat(pattern="dd/MM/yyyy")
     private LocalDate paymentDate;

     public PaymentWithBoleto() {
     }

     public PaymentWithBoleto(Integer id, StatusPayment status, Order order, LocalDate dueDate, LocalDate paymentDate) {
          super(id, status, order);
          this.dueDate = dueDate;
          this.paymentDate = paymentDate;
     }

     public LocalDate getDueDate() {
          return dueDate;
     }

     public void setDueDate(LocalDate dueDate) {
          this.dueDate = dueDate;
     }

     public LocalDate getPaymentDate() {
          return paymentDate;
     }

     public void setPaymentDate(LocalDate paymentDate) {
          this.paymentDate = paymentDate;
     }
}
