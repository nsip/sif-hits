package sif3.hits.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "queue_data")
public class QueueData extends HitsEntity {
  private static final long serialVersionUID = -723836819967424379L;

  private String id;
  private Queue queue;
  private Subscription subscription;
  private Date eventDateTime;
  private String action;
  private String data;

  @Id
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @ManyToOne
  @JoinColumn(name = "queue_id", referencedColumnName = "id")
  public Queue getQueue() {
    return queue;
  }

  public void setQueue(Queue queue) {
    this.queue = queue;
  }

  @ManyToOne
  @JoinColumn(name = "subscription_id", referencedColumnName = "id")
  public Subscription getSubscription() {
    return subscription;
  }

  public void setSubscription(Subscription subscription) {
    this.subscription = subscription;
  }

  @Column(name = "event_datetime")
  public Date getEventDateTime() {
    return eventDateTime;
  }

  public void setEventDateTime(Date eventDateTime) {
    this.eventDateTime = eventDateTime;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }
}
