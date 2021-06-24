package com.ilyakor.lab2.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="subscription",schema = "public")
public class Subscription {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "client_id", referencedColumnName="id", nullable = false)
    private Client client;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "periodical_id", referencedColumnName="id", nullable = false)
    private Periodical periodical;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "period")
    private int period;

    @Column(name="status")
    private boolean status;

}
