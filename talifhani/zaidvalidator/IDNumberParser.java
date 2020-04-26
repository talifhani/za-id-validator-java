package talifhani.zaidvalidator;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

/**
 * @author Tali Luvhengo <tali@semicolon.co.za>
 */
enum Nationality {
    SOUTHAFRICAN,
    NONSOUTHAFRICAN,
    REFUGEE
}

/**
 * @author Tali Luvhengo <tali@semicolon.co.za>
 */
enum Gender {
    MALE,
    FEMALE
}

/**
 * @author Tali Luvhengo <tali@semicolon.co.za>
 */
public class IDNumberParser
{
    private LocalDate dateOfBirth;
    private int genderNum;
    private int citizenshipNum;
    private int checkBit;

    private String idNumber;

    public IDNumberParser(String idNumber) throws Exception
    {
        if (idNumber.length() != 13) {
            throw new Exception("ID Length invalid: ZA ID Number must be 13 digits long");
        }

        this.idNumber = idNumber;
    }

    public static final DateTimeFormatter TWO_YEAR_FORMATTER = new DateTimeFormatterBuilder()
    .appendValueReduced(ChronoField.YEAR, 2, 2, 1950)
    .toFormatter();

    private void breakDownIDNumber()
    {
        String birthDate = idNumber.substring(0, 6);

        int year = Year.parse(birthDate.substring(0, 2), TWO_YEAR_FORMATTER).getValue();
          
        this.dateOfBirth = LocalDate.of(
            year, 
            Month.of(Integer.parseInt(birthDate.substring(2, 4))), 
            Integer.parseInt(birthDate.substring(4))
        );

        this.genderNum       = Integer.parseInt(idNumber.substring(6, 10));
        this.citizenshipNum  = Integer.parseInt(idNumber.substring(10, 11));
        this.checkBit        = Integer.parseInt(idNumber.substring(12, 13));
    }

    public IDNumberData parse()
    {
        this.breakDownIDNumber();

        return new IDNumberData(
            this.idNumber,
            this.dateOfBirth,
            this.genderNum >= 5000 ? Gender.MALE : Gender.FEMALE,
            this.citizenshipNum == 0 ? Nationality.SOUTHAFRICAN : (this.citizenshipNum == 1 ? Nationality.NONSOUTHAFRICAN : Nationality.REFUGEE),
            this.checkBit == this.calculateCheckBit()
        );
    }

    private int calculateCheckBit()
    {
        String withoutChecksum = idNumber.substring(0, idNumber.length() - 1);
		return Luhn.generate(withoutChecksum);
    }
}