
# ZA ID Number Validator Java Version
South African ID number validator written in Java.


## Usage
```java
IDNumberParser idNumberParser = new IDNumberParser();
IDNumberData idNumberData = idNumberParser.parse("7801014800084");

System.out.println("isValid: " + idNumberData.isValid());
System.out.println("Date Of Birth: " + idNumberData.getBirthdate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
System.out.println("Age: " + idNumberData.getAge());
System.out.println("Gender: " + idNumberData.getGender());
System.out.println("Citizenship: " + idNumberData.getCitizenShip());
```

The first 2 digits of the South African ID number are the year. The problem with parsing this is we dont know if 19 means 2019 or 1919. So the parse by default assumes the ID Number belongs to someone not older than 100 years. So if this year is 2020, any years less than 20 will be considered from this century. e.g `15 and 19 will translate to 2015 and 2019 respectively`. `While 20, 25 will translate to 1920, 1925 respectively`. This is the concept of a `pivotYear`. The `pivotYear` in the above cases defaulted to `1920`. You can specify your own pivotYear using the setPivotYear method on the parser.

## Example
```java
IDNumberParser idNumberParser = new IDNumberParser();
IDNumberData idNumberData = idNumberParser.setPivotYear(Year.of(1940)).parse("4001014800084");//Also not a valid ID FYI

System.out.println("Date Of Birth: " + idNumberData.getBirthdate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
//Date Of Birth: 01 January 1940

idNumberData = idNumberParser.parse("3901014800084");//Also not a valid ID FYI
System.out.println("Date Of Birth: " + idNumberData.getBirthdate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
//Date Of Birth: 01 January 2039
```


## Contributing
You can contribute in one of three ways:

1. File bug reports using the [issue tracker]([[https://github.com/talifhani/za-id-validator-java/issues](https://github.com/talifhani/za-id-validator-java/issues)](https://github.com/talifhani/za-id-validator-java/issues)).
2. Answer questions or fix bugs on the [issue tracker]([https://github.com/talifhani/za-id-validator-java/issues](https://github.com/talifhani/za-id-validator-java/issues)).
3. Contribute new features or update the wiki.
