package talifhani.zaidvalidator;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author Tali Luvhengo <tali@semicolon.co.za>
 */
public class IDNumberData{

    private String idNumber;
    private LocalDate dateOfBirth;
    private Gender gender;
    private Nationality citizenship;
    private boolean valid;

    /**
     * @param idNumber
     * @param dateOfBirth
     * @param gender
     * @param citizenship
     * @param valid
     */
    public IDNumberData(String idNumber, LocalDate dateOfBirth, Gender gender, Nationality citizenship, boolean valid)
    {
        this.idNumber         = idNumber;
        this.dateOfBirth      = dateOfBirth;
        this.gender           = gender;
        this.citizenship      = citizenship;
        this.valid            = valid;
    }

    /**
     * @return String
     */
    public String getIdNumber()
    {
        return this.idNumber;
    }

    /**
     * @return LocalDate
     */
    public LocalDate getBirthdate()
    {
        return this.dateOfBirth;
    }

    /**
     * @return int
     */
    public int getAge()
    {
        LocalDate today = LocalDate.now();
        Period p = Period.between(this.dateOfBirth, today);
        return p.getYears();
    }

    /**
     * @return Gender
     */
    public Gender getGender()
    {
        return this.gender;
    }

    /**
     * @return Nationality
     */
    public Nationality getCitizenShip()
    {
        return this.citizenship;
    }

    /**
     * @return boolean
     */
    public boolean isValid()
    {
        return this.valid;
    }
}