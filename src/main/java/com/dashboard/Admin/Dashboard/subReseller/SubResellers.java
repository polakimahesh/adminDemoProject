package com.dashboard.Admin.Dashboard.subReseller;

import com.dashboard.Admin.Dashboard.reseller.Reseller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SubResellers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private String name;
    private String location;
    private String contact;
    private String products;
    @ManyToOne
    private Reseller reseller;
}
