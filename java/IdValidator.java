
class IdentificationNumber {
  public String number;
  public String type;
  public String country;
  public static final String PERSONAL_ID_TYPE = "personalid";
  public static final String TAX_ID_TYPE = "taxid";
}

interface IdentificationValidator {
  public boolean isValid(IdentificationNumber idNumber);
}

class PersonalIdValidator implements IdentificationValidator {
  public boolean isValid(IdentificationNumber idNumber) {
    return false;
  }
}

class TaxIdValidator implements IdentificationValidator {
  public boolean isValid(IdentificationNumber idNumber) {
    return false;
  }
}

class EcuadoreanPersonalIdValidator implements IdentificationValidator {
  public boolean isValid(IdentificationNumber idNumber) {
    return false;
  }
}

class EcuadoreanTaxIdValidator implements IdentificationValidator {
  public boolean isValid(IdentificationNumber idNumber) {
    return false;
  }
}

class PeruvianPersonalIdValidator implements IdentificationValidator {
  public boolean isValid(IdentificationNumber idNumber) {
    return false;
  }
}

class PeruvianTaxIdValidator implements IdentificationValidator {
  public boolean isValid(IdentificationNumber idNumber) {
    return false;
  }
}

class IdentificationValidatorFactory {
  public static IdentificationValidator getValidator(IdentificationNumber id) {
    if (id.type.equals(IdentificationNumber.PERSONAL_ID_TYPE)) {
        return PersonalIdValidator();
    } else if (id.type.equals(IdentificationNumber.TAX_ID_TYPE)) {
      return TaxIdValidator();
    }
  }
}

class IdentificationValidatorFactory {
  public static IdentificationValidator getValidator(IdentificationNumber id) {

  }
}
