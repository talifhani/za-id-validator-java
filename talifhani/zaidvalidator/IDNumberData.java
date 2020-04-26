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

    public IDNumberData(String idNumber, LocalDate dateOfBirth, Gender gender, Nationality citizenship, boolean valid)
    {
        this.idNumber         = idNumber;
        this.dateOfBirth      = dateOfBirth;
        this.gender           = gender;
        this.citizenship      = citizenship;
        this.valid            = valid;
    }

    public String getIdNumber()
    {
        return this.idNumber;
    }

    public LocalDate getBirthdate()
    {
        return this.dateOfBirth;
    }

    public int getAge()
    {
        LocalDate today = LocalDate.now();
        Period p = Period.between(this.dateOfBirth, today);
        return p.getYears();
    }

    public Gender getGender()
    {
        return this.gender;
    }

    public Nationality getCitizenShip()
    {
        return this.citizenship;
    }

    public boolean isValid()
    {
        return this.valid;
    }
}