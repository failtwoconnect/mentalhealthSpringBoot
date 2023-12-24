package com.fail2connect.mentalhealthspringboot.models;

import jakarta.persistence.*;

@Entity
@Table(name= "numbers", schema = "therapy")
public class TherapyNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int numberId;

    @ManyToOne (cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "anxiety")
    private int anxietyScore;
    @Column(name = "depression")
    private int depressionScore;
    @Column(name = "self_harm")
    private int selfHarmScore;
    @Column(name = "energylevel")
    private int energyLevelScore;
    @Column(name = "craving")
    private int cravingScore;
    @Column(name = "impulse")
    private int impulseScore;
    @Column(name = "physical_harm")
    private boolean physicalSelfHarm;

    @Column(name = "datetime")
    private String datetime;

    public TherapyNumber() {

    }

    public int getNumberId() {
        return numberId;
    }

    public void setNumberId(int numberId) {
        this.numberId = numberId;
    }

    public int getAnxietyScore() {
        return anxietyScore;
    }

    public void setAnxietyScore(int anxietyScore) {
        this.anxietyScore = anxietyScore;
    }

    public int getDepressionScore() {
        return depressionScore;
    }

    public void setDepressionScore(int depressionScore) {
        this.depressionScore = depressionScore;
    }

    public int getSelfHarmScore() {
        return selfHarmScore;
    }

    public void setSelfHarmScore(int selfHarmScore) {
        this.selfHarmScore = selfHarmScore;
    }

    public int getEnergyLevelScore() {
        return energyLevelScore;
    }

    public void setEnergyLevelScore(int energyLevelScore) {
        this.energyLevelScore = energyLevelScore;
    }

    public int getCravingScore() {
        return cravingScore;
    }

    public void setCravingScore(int cravingScore) {
        this.cravingScore = cravingScore;
    }

    public int getImpulseScore() {
        return impulseScore;
    }

    public void setImpulseScore(int impulseScore) {
        this.impulseScore = impulseScore;
    }

    public boolean isPhysicalSelfHarm() {
        return physicalSelfHarm;
    }

    public void setPhysicalSelfHarm(boolean physicalSelfHarm) {
        this.physicalSelfHarm = physicalSelfHarm;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "TherapyNumber{" +
                "numberId=" + numberId +
                ", clientid=" + (client != null ? client.getClientID(): null) +
                ", anxietyScore=" + anxietyScore +
                ", depressionScore=" + depressionScore +
                ", selfHarmScore=" + selfHarmScore +
                ", energyLevelScore=" + energyLevelScore +
                ", cravingScore=" + cravingScore +
                ", impulseScore=" + impulseScore +
                ", physicalSelfHarm=" + physicalSelfHarm +
                ", datetime='" + datetime + '\'' +
                '}';
    }
}
