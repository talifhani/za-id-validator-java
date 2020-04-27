
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

## Contributing
You can contribute in one of three ways:

1. File bug reports using the [issue tracker]([[https://github.com/talifhani/za-id-validator-java/issues](https://github.com/talifhani/za-id-validator-java/issues)](https://github.com/talifhani/za-id-validator-java/issues)).
2. Answer questions or fix bugs on the [issue tracker]([https://github.com/talifhani/za-id-validator-java/issues](https://github.com/talifhani/za-id-validator-java/issues)).
3. Contribute new features or update the wiki.
