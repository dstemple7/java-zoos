package com.lambdaschool.zoo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "zoo")
public class Zoo extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;
    private String zooname;

    @OneToMany(mappedBy = "zoo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "zoo", allowSetters = true)
    private List<Telephone>telephones = new ArrayList<>();

    public Zoo()
    {
    }

    public Zoo(
        long zooid,
        String zooname,
        List<Telephone> telephones)
    {
        this.zooid = zooid;
        this.zooname = zooname;
        this.telephones = telephones;
    }

    public long getZooid()
    {
        return zooid;
    }

    public void setZooid(long zooid)
    {
        this.zooid = zooid;
    }

    public String getZooname()
    {
        return zooname;
    }

    public void setZooname(String zooname)
    {
        this.zooname = zooname;
    }

    public List<Telephone> getTelephones()
    {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones)
    {
        this.telephones = telephones;
    }

    @OneToMany(mappedBy = "zoo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties(value = "zoo", allowSetters = true)
    private Set<Zooanimal> zooanimals = new HashSet<>();

    public Set<Zooanimal> getZooanimals()
    {
        return zooanimals;
    }

    public void setZooanimals(Set<Zooanimal> zooanimals)
    {
        this.zooanimals = zooanimals;
    }
}
