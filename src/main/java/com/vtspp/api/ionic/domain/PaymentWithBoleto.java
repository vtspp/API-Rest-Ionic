package com.vtspp.api.ionic.domain;

import com.vtspp.api.ionic.enums.StatusPayment;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class PaymentWithBoleto extends Payment{

     private LocalDate dueDate;

     private LocalDate paymentDate;

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
