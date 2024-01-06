package com.example.restwithspringboot.data.vo.v2;

import java.io.Serializable;
import java.util.Date;

public class PersonVOV2 implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String firstName;
    private String lastName;
    private String adress;
    private String gender;

    private Date bithDay;

    public PersonVOV2(){

    }

    public Date getBithDay() {
        return bithDay;
    }

    public String getAdress() {
        return adress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender;
    }

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setBithDay(Date bithDay) {
        this.bithDay = bithDay;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((adress == null) ? 0 : adress.hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((bithDay == null) ? 0 : bithDay.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PersonVOV2 other = (PersonVOV2) obj;
        if (id != other.id)
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (adress == null) {
            if (other.adress != null)
                return false;
        } else if (!adress.equals(other.adress))
            return false;
        if (gender == null) {
            if (other.gender != null)
                return false;
        } else if (!gender.equals(other.gender))
            return false;
        if (bithDay == null) {
            if (other.bithDay != null)
                return false;
        } else if (!bithDay.equals(other.bithDay))
            return false;
        return true;
    }

    

}