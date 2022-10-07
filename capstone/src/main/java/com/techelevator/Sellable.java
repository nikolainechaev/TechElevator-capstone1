package com.techelevator;

import java.math.BigDecimal;

public interface Sellable {

    public void setName(String name);
    public String getName();
    public void setSlotNumber(String slot);
    public String getSlotNumber();
    public void setPrice(BigDecimal price);
    public BigDecimal getPrice();
    public String getType();
    public void getNoise();

}
