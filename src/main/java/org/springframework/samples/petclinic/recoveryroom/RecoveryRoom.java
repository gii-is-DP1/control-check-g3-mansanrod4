package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.samples.petclinic.model.NamedEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recovery_rooms")
public class RecoveryRoom extends NamedEntity{
    
    @NotNull
    @PositiveOrZero
    @Column(name = "size")
    double size;

    @NotNull
    @Column(name = "secure")
    boolean secure;

    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn(name = "rrtypes_id")
    RecoveryRoomType roomType;
}
